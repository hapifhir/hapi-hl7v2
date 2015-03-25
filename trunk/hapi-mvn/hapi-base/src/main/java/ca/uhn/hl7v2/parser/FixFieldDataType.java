/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "FixOBX5.java".  Description:
 ""

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2015.  All Rights Reserved.

 Contributor(s): ______________________________________.

 Alternatively, the contents of this file may be used under the terms of the
 GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 applicable instead of those above.  If you wish to allow use of your version of this
 file only under the terms of the GPL and not to allow others to use your version
 of this file under the MPL, indicate your decision by deleting  the provisions above
 and replace  them with the notice and other provisions required by the GPL License.
 If you do not delete the provisions above, a recipient may use your version of
 this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.parser;

import java.lang.reflect.Constructor;

import ca.uhn.hl7v2.ErrorCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class that provides methods for fixing OBX-5 data type. This has been refactored out
 * of {@link ca.uhn.hl7v2.model.Varies}.
 */
public final class FixFieldDataType {

    private FixFieldDataType() {}

    /**
     * System property key: The value may be set to provide a default
     * datatype ("ST", "NM", etc) for an OBX segment with a missing
     * OBX-2 value.
     */
    public static final String DEFAULT_OBX2_TYPE_PROP = "ca.uhn.hl7v2.model.varies.default_obx2_type";

    /**
     * System property key: The value may be set to provide a default
     * datatype ("ST", "NM", etc) for an OBX segment with an invalid
     * OBX-2 value type. In other words, if OBX-2 has a value of "ZYZYZ",
     * which is not a valid value, but this property is set to "ST", then
     * OBX-5 will be parsed as an ST.
     */
    public static final String INVALID_OBX2_TYPE_PROP = "ca.uhn.hl7v2.model.varies.invalid_obx2_type";

    /**
     * <p>
     * System property key: If this is not set, or set to "true", and a subcomponent delimiter is found within the
     * value of a Varies of a primitive type, this subcomponent delimiter will be treated as a literal
     * character instead of a subcomponent delimiter, and will therefore be escaped if the message is
     * re-encoded. This is handy when dealing with non-conformant sending systems which do not correctly
     * escape ampersands in OBX-5 values.
     * </p>
     * <p>
     * For example, consider the following OBX-5 segment:
     * <pre>
     *    OBX||ST|||Apples, Pears &amp; Bananas|||
     * </pre>
     * In this example, the data type is a primitive ST and does not support subcomponents, and the
     * ampersand is obviously not intended to represent a subcomponent delimiter. If this
     * property is set to <code>true</code>, the entire string will be treated as the
     * value of OBX-5, and if the message is re-encoded the string will appear
     * as "Apples, Pears \T\ Bananas".
     * </p>
     * <p>
     * If this property is set to anything other than "true", the subcomponent delimiter is treated as a component delimiter,
     * so the value after the ampersand is placed into an {@link ExtraComponents extra component}.
     * </p>
     */
    public static final String ESCAPE_SUBCOMPONENT_DELIM_IN_PRIMITIVE = "ca.uhn.hl7v2.model.varies.escape_subcomponent_delim_in_primitive";


    private static final Logger LOG = LoggerFactory.getLogger(Varies.class);


    /**
     * <p>
     * Sets the data type of field 5 in the given OBX segment to the value of OBX-2.  The argument
     * is a Segment as opposed to a particular OBX because it is meant to work with any version.
     * </p>
     * <p>
     * Note that if no value is present in OBX-2, or an invalid value is present in
     * OBX-2, this method will throw an error. This behaviour can be corrected by using the
     * following system properties: {@link #DEFAULT_OBX2_TYPE_PROP} and {@link #INVALID_OBX2_TYPE_PROP}
     * or by using configuration in {@link ParserConfiguration}
     * </p>
     *
     * @param segment OBX segment instance to be modified
     * @param factory ModelClassFactory to be used
     * @param parserConfiguration configuration that influences setting OBX-5
     * @throws ca.uhn.hl7v2.HL7Exception if the operation fails
     */
    public static void fixOBX5(Segment segment, ModelClassFactory factory, ParserConfiguration parserConfiguration)
            throws HL7Exception {
        if (!segment.getName().contains("OBX")) {
            throw new IllegalArgumentException("Expected OBX segment, but was: " + segment.getName());
        }
        String defaultOBX2Type = parserConfiguration.getDefaultObx2Type();
        if (defaultOBX2Type == null) {
            defaultOBX2Type = System.getProperty(DEFAULT_OBX2_TYPE_PROP);
        }
        String invalidOBX2Type = parserConfiguration.getInvalidObx2Type();
        if (invalidOBX2Type == null) {
            invalidOBX2Type = System.getProperty(INVALID_OBX2_TYPE_PROP);
        }

        fix(segment, 2, 5, defaultOBX2Type, invalidOBX2Type, factory, parserConfiguration);
    }

    public static void fixMFE3(Segment segment, ModelClassFactory factory, ParserConfiguration parserConfiguration)
            throws HL7Exception {
        if (!(segment.getName().contains("MFE")) &&
                Version.versionOf(segment.getMessage().getVersion()).isGreaterThan(Version.V23)) {
            throw new IllegalArgumentException("Expected MFE segment, but was: " + segment.getName());
        }
        fix(segment, 4, 3, null, null, factory, parserConfiguration);
    }

    /**
     * A more generic version of the task of adapting a varies field to a given type
     *
     * @param segment segment instance
     * @param typeField field number of the specified data type
     * @param dataField field number of the varies data field
     * @param defaultType default type if the typeField is empty
     * @param invalidType default type if the typeField is invalid
     * @param factory ModelClassFactory to be used
     * @param parserConfiguration parser config
     * @throws HL7Exception if the operation fails
     */
    public static void fix(Segment segment, int typeField, int dataField, String defaultType, String invalidType, ModelClassFactory factory, ParserConfiguration parserConfiguration)
        throws HL7Exception {
        try {
            //get unqualified class name
            Primitive type = (Primitive) segment.getField(typeField, 0);
            Type[] reps = segment.getField(dataField);
            for (Type rep : reps) {
                Varies v = (Varies)rep;
                if (type.getValue() == null) {
                    if (defaultType != null) {
                        LOG.debug("setting default {}-{} type to {}", segment.getName(), typeField, defaultType);
                        type.setValue(defaultType);
                    }
                } // if

                if (type.getValue() == null) {
                    if (v.getData() != null) {
                        if (!(v.getData() instanceof Primitive) || ((Primitive) v.getData()).getValue() != null) {
                            throw new HL7Exception(String.format(
                                    "A datatype for %s-%n must be specified in %s-%n.", segment.getName(), dataField, segment.getName(), typeField),
                                    ErrorCode.REQUIRED_FIELD_MISSING);
                        }
                    }
                }
                else {
                    //set class
                    String version = segment.getMessage().getVersion();
                    String typeValue = type.getValue();
                    Class<? extends Type> c = factory.getTypeClass(typeValue, version);
                    if (c == null) {
                        if (invalidType != null) {
                            c = factory.getTypeClass(invalidType, version);
                        }

                        if (c == null) {
                            Primitive obx1 = (Primitive) segment.getField(1, 0);
                            HL7Exception h = new HL7Exception("\'" +
                                    type.getValue() + "\' in record " +
                                    obx1.getValue() + " is invalid for version " + version,
                                    ErrorCode.DATA_TYPE_ERROR);
                            h.setSegmentName(segment.getName());
                            h.setFieldPosition(typeField);
                            throw h;
                        }
                    }

                    Type newTypeInstance;
                    try {
                        Constructor<? extends Type> constr = c.getConstructor(new Class[]{Message.class});
                        newTypeInstance = constr.newInstance(v.getMessage());
                    } catch (NoSuchMethodException e) {
                        Constructor<? extends Type> constr = c.getConstructor(new Class[]{Message.class, Integer.class});
                        newTypeInstance = constr.newInstance(v.getMessage(), 0);
                    }

                    boolean escapeSubcomponentDelimInPrimitive =
                            parserConfiguration.isEscapeSubcomponentDelimiterInPrimitive() ||
                                    escapeSubcomponentDelimInPrimitive();


                    if (newTypeInstance instanceof Primitive) {
                        Type[] subComponentsInFirstField = getFirstComponentSubcomponentsOnlyIfMoreThanOne(v);
                        if (subComponentsInFirstField != null) {

                            if (escapeSubcomponentDelimInPrimitive) {

                                StringBuilder firstComponentValue = new StringBuilder();
                                for (Type stype : subComponentsInFirstField) {
                                    if (firstComponentValue.length() != 0) {
                                        char subComponentSeparator = EncodingCharacters.getInstance(segment.getMessage()).getSubcomponentSeparator();
                                        firstComponentValue.append(subComponentSeparator);
                                    }
                                    firstComponentValue.append(stype.encode());
                                }

                                setFirstComponentPrimitiveValue(v, firstComponentValue.toString());

                            }

                        }
                    }

                    v.setData(newTypeInstance);
                }

            } // for reps

        }
        catch (HL7Exception e) {
            throw e;
        }
        catch (Exception e) {
            throw new HL7Exception(
                    e.getClass().getName() + " trying to set data type of " + segment.getName() + "-" + dataField, e);
        }
    }

    private static boolean escapeSubcomponentDelimInPrimitive() {
        String property = System.getProperty(ESCAPE_SUBCOMPONENT_DELIM_IN_PRIMITIVE);
        return property == null || "true".equalsIgnoreCase(property);
    }

    private static void setFirstComponentPrimitiveValue(Varies v, String theValue) throws DataTypeException {
        Composite c = (Composite) v.getData();
        Type firstComponent = c.getComponent(0);
        setFirstComponentPrimitiveValue(firstComponent, theValue);
    }


    private static void setFirstComponentPrimitiveValue(Type theFirstComponent, String theValue)
            throws DataTypeException {

        if (theFirstComponent instanceof Varies) {
            Varies firstComponentVaries = (Varies)theFirstComponent;
            if (((Varies) theFirstComponent).getData() instanceof Composite) {
                Type[] subComponents = ((Composite)firstComponentVaries.getData()).getComponents();
                setFirstComponentPrimitiveValue(subComponents[0], theValue);
                for (int i = 1; i < subComponents.length; i++) {
                    setFirstComponentPrimitiveValue(subComponents[i], "");
                }
            } else {
                Primitive p = (Primitive) firstComponentVaries.getData();
                p.setValue(theValue);
            }
        } else if (theFirstComponent instanceof Composite) {
            Type[] subComponents = ((Composite)theFirstComponent).getComponents();
            setFirstComponentPrimitiveValue(subComponents[0], theValue);
            for (int i = 1; i < subComponents.length; i++) {
                setFirstComponentPrimitiveValue(subComponents[i], "");
            }
        } else {
            ((Primitive)theFirstComponent).setValue(theValue);
        }
    }

    /**
     * Returns an array containing the subcomponents within the first component of this Varies
     * object only if there are more than one of them. Otherwise, returns null.
     */
    private static Type[] getFirstComponentSubcomponentsOnlyIfMoreThanOne(Varies v) throws DataTypeException {
        if (v.getData() instanceof Composite) {
            Composite c = (Composite) v.getData();
            Type firstComponent = c.getComponent(0);
            if (firstComponent instanceof Varies) {
                Varies firstComponentVaries = (Varies) firstComponent;
                if (firstComponentVaries.getData() instanceof Composite) {
                    return ((Composite)firstComponentVaries.getData()).getComponents();
                }
            }
        }
        return null;
    }
}
