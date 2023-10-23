/*
 * This class is an auto-generated source file for a HAPI
 * HL7 v2.x standard structure class.
 *
 * For more information, visit: http://hl7api.sourceforge.net/
 * 
 * The contents of this file are subject to the Mozilla Public License Version 1.1 
 * (the "License"); you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
 * Software distributed under the License is distributed on an "AS IS" basis, 
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
 * specific language governing rights and limitations under the License. 
 * 
 * The Original Code is "[file_name]".  Description: 
 * "[one_line_description]" 
 * 
 * The Initial Developer of the Original Code is University Health Network. Copyright (C) 
 * 2012.  All Rights Reserved. 
 * 
 * Contributor(s): ______________________________________. 
 * 
 * Alternatively, the contents of this file may be used under the terms of the 
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
 * applicable instead of those above.  If you wish to allow use of your version of this 
 * file only under the terms of the GPL and not to allow others to use your version 
 * of this file under the MPL, indicate your decision by deleting  the provisions above 
 * and replace  them with the notice and other provisions required by the GPL License.  
 * If you do not delete the provisions above, a recipient may use your version of 
 * this file under either the MPL or the GPL. 
 * 
 */


package ca.uhn.hl7v2.model.v27.segment;

// import ca.uhn.hl7v2.model.v27.group.*;
import ca.uhn.hl7v2.model.v27.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 SID message segment (Substance Identifier). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>SID-1: Application/Method Identifier (CWE) <b>optional </b>
     * <li>SID-2: Substance Lot Number (ST) <b>optional </b>
     * <li>SID-3: Substance Container Identifier (ST) <b>optional </b>
     * <li>SID-4: Substance Manufacturer Identifier (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class SID extends AbstractSegment {

    /** 
     * Creates a new SID segment
     */
    public SID(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Application/Method Identifier");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Substance Lot Number");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Substance Container Identifier");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Substance Manufacturer Identifier");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SID - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * SID-1: "Application/Method Identifier" - creates it if necessary
     */
    public CWE getApplicationMethodIdentifier() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SID-1: "Application/Method Identifier" - creates it if necessary
     */
    public CWE getSid1_ApplicationMethodIdentifier() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * SID-2: "Substance Lot Number" - creates it if necessary
     */
    public ST getSubstanceLotNumber() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SID-2: "Substance Lot Number" - creates it if necessary
     */
    public ST getSid2_SubstanceLotNumber() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * SID-3: "Substance Container Identifier" - creates it if necessary
     */
    public ST getSubstanceContainerIdentifier() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SID-3: "Substance Container Identifier" - creates it if necessary
     */
    public ST getSid3_SubstanceContainerIdentifier() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * SID-4: "Substance Manufacturer Identifier" - creates it if necessary
     */
    public CWE getSubstanceManufacturerIdentifier() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SID-4: "Substance Manufacturer Identifier" - creates it if necessary
     */
    public CWE getSid4_SubstanceManufacturerIdentifier() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new CWE(getMessage());
          default: return null;
       }
   }


}

