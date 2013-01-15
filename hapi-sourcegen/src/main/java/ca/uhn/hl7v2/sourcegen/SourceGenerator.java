/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "SourceGenerator.java".  Description:
 * "Manages automatic generation of HL7 API source code for all data types,
 * segments, groups, and message structures"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */

package ca.uhn.hl7v2.sourcegen;

import java.util.StringTokenizer;
import java.io.File;
import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import org.apache.commons.lang.StringUtils;

/**
 * <p>Manages automatic generation of HL7 API source code for all data types,
 * segments, groups, and message structures. </p>
 * <p>Note: should put a nice UI on this</p>
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public class SourceGenerator extends Object {
    
	public static final String ENCODING = "UTF-8";
	
    /** Creates new SourceGenerator */
    public SourceGenerator() {
    }
    
    /**
     * Generates source code for all data types, segments, groups, and messages.
     * @param baseDirectory the directory where source should be written
     * @param theJdbcUrl The JDBC URL
     * @throws HL7Exception - 
     */
    public static void makeAll(String baseDirectory, String version, boolean failOnError, String theTemplatePackage, String theFileExt) throws HL7Exception  {
        //load driver and set DB URL
        /*if (System.getProperty("ca.on.uhn.hl7.database.url") == null) {
            System.setProperty("ca.on.uhn.hl7.database.url", "jdbc:odbc:hl7");
        }*/
        
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            MessageGenerator.makeAll(baseDirectory, version, failOnError, theTemplatePackage, theFileExt);
            SegmentGenerator.makeAll(baseDirectory, version, theTemplatePackage, theFileExt);
            DataTypeGenerator.makeAll(baseDirectory, version, theTemplatePackage, theFileExt);
            // group and message not implemented
        } catch (Exception e) {
        	throw new HL7Exception(e);
        }
        
    }
    
    /**
     * Make a Java-ish accessor method name out of a field or component description
     * by removing non-letters and adding "get".  One complication is that some description
     * entries in the DB have their data types in brackets, and these should not be
     * part of the method name.  On the other hand, sometimes critical distinguishing
     * information is in brackets, so we can't omit everything in brackets.  The approach
     * taken here is to eliminate bracketed text if a it looks like a data type.
     */
    public static String makeAccessorName(String fieldDesc, String parentName) {
        StringBuffer aName = new StringBuffer();
        char[] chars = fieldDesc.toCharArray();
        boolean lastCharWasNotLetter = true;
        int inBrackets = 0;
        StringBuffer bracketContents = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' ) inBrackets++;
            if (chars[i] == ')' ) inBrackets--;
            
            if (Character.isLetterOrDigit(chars[i])) {
                if (inBrackets > 0) {
                    //buffer everthing in brackets
                    bracketContents.append(chars[i]);
                } else {
                    //add capitalized bracketed text if appropriate 
                    if (bracketContents.length() > 0) {
                        aName.append(capitalize(filterBracketedText(bracketContents.toString())));
                        bracketContents = new StringBuffer();
                    }
                    if (lastCharWasNotLetter) {
                        //first letter of each word is upper-case
                        aName.append(Character.toUpperCase(chars[i]));
                    } else {
                        aName.append(chars[i]);
                    }
                    lastCharWasNotLetter = false;
                }
            } else {
                lastCharWasNotLetter = true;
            }
        }
        aName.append(capitalize(filterBracketedText(bracketContents.toString())));        
        String retVal = aName.toString();

        // Accessors with these two names conflict with existing superclass accessor names
        if (retVal.equals("Parent")) {
            retVal = parentName + "Parent";
        }
        if (retVal.equals("Name")) {
            retVal = parentName + "Name";
        }
        
        return retVal;
    }
    
    /**
     * Bracketed text in a field description should be included in the accessor 
     * name unless it corresponds to a data type name. Given the text that appears in 
     * brackets in a field description, this method returns an empty string if it 
     * corresponds to a data type name, or returns original text if not.  It isn't 
     * convenient to actually check (e.g. with DataTypeGenerator) whether the given 
     * text actually corresponds to a data type name, so we are going to conclude that 
     * it is a data type if and only if it is all caps and has 2 or 3 characters.  
     */
    private static String filterBracketedText(String text) {
        String filtered = "";
        boolean isDataType = true;
        if (!text.equals(text.toUpperCase())) isDataType = false;
        if (text.length() < 2 || text.length() > 3) isDataType = false;

        if (!isDataType) filtered = text;
        return filtered;
    }
    
    /** Capitalizes first character of the given text. */
    private static String capitalize(String text) {
        StringBuffer cap = new StringBuffer();
        if (text.length() > 0) {
            cap.append(Character.toUpperCase(text.charAt(0)));
            cap.append(text.substring(1, text.length()));
        }
        return cap.toString();
    }
    
    /**
     * Creates the given directory if it does not exist.
     */
    public static File makeDirectory(String directory) throws IOException {
        StringTokenizer tok = new StringTokenizer(directory, "\\/", false);
        
        File currDir = directory.startsWith("/") ? new File("/") : null;
        while (tok.hasMoreTokens()) {
            String thisDirName = tok.nextToken();
            
            currDir = new File(currDir, thisDirName); //if currDir null, defaults to 1 arg call
            
            if (!currDir.exists()) {
                //create
                currDir.mkdir();;
            } else if (currDir.isFile()) {
                throw new IOException("Can't create directory " + thisDirName +
                " - file with same name exists.");
            }
        }
        
        return currDir;
    }
    
    /**
     * <p>Returns either the given data type name or an alternate data type that Composites
     * and Segments should use in place of the given Type.  </p>
     * <p>As currently implemented, substitutions
     * may be desired if there is a validating subclass of the given Type.
     * By convention such classes would be named ValidX (where X is the Type name).  This
     * method checks the classpath for classes of this name in the datatype package and
     * returns this name if one is found.</p>
     * <p>Also converts "varies" to Varies which is an implementation of Type that contains
     * a Type that can be set at run-time.</p>
     */
    public static String getAlternateType(String dataTypeName, String version) {
        String ret = dataTypeName;
        
        //convert to varies to Varies
        if (ret.equals("varies")) ret = "Varies";
        
        // Null/withdrawn
        if (ret.equals("NUL")) ret = "NULLDT";
        if (ret.equals("-")) ret = "NULLDT";
        
        //Valid.. classes are removed as of HAPI 0.3 (validating code implemented directly in Primitive classes
        /*try {
            Class.forName(getVersionPackageName(version) + "datatype.Valid" + dataTypeName);
            ret = "Valid" + dataTypeName;
        } catch (Exception e) {
            // fine ... there isn't a ValidX implementation
            // I don't like using Class.forName here but I don't know a better way to
            // search for the class 
        }*/
        
        return ret;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, HL7Exception {
    	Class.forName("com.mysql.jdbc.Driver");
    	System.setProperty("ca.on.uhn.hl7.database.url", "jdbc:mysql://localhost:3306/hl7v65");
        System.setProperty("ca.on.uhn.hl7.database.user", "hl7");
        System.setProperty("ca.on.uhn.hl7.database.password", "hl7");
        makeAll("tmp", "2.5.1", true, "", "java");
    }

	public static String makeAlternateAccessorName(String fieldDesc, String parentName, int index) {
        StringBuffer aName = new StringBuffer();
        
        aName.append(StringUtils.capitalize(parentName.toLowerCase())).append(index).append("_");
        
        char[] chars = fieldDesc.toCharArray();
        boolean lastCharWasNotLetter = true;
        int inBrackets = 0;
        StringBuffer bracketContents = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' ) inBrackets++;
            if (chars[i] == ')' ) inBrackets--;
            
            if (Character.isLetterOrDigit(chars[i])) {
                if (inBrackets > 0) {
                    //buffer everthing in brackets
                    bracketContents.append(chars[i]);
                } else {
                    //add capitalized bracketed text if appropriate 
                    if (bracketContents.length() > 0) {
                        aName.append(capitalize(filterBracketedText(bracketContents.toString())));
                        bracketContents = new StringBuffer();
                    }
                    if (lastCharWasNotLetter) {
                        //first letter of each word is upper-case
                        aName.append(Character.toUpperCase(chars[i]));
                    } else {
                        aName.append(chars[i]);
                    }
                    lastCharWasNotLetter = false;
                }
            } else {
                lastCharWasNotLetter = true;
            }
        }
        aName.append(capitalize(filterBracketedText(bracketContents.toString())));        
        String retVal = aName.toString();

        
        return retVal;
	}
    
}
