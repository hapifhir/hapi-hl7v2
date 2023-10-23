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


package ca.uhn.hl7v2.model.v26.segment;

// import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 LCH message segment (Location Characteristic). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>LCH-1: Primary Key Value - LCH (PL) <b> </b>
     * <li>LCH-2: Segment Action Code (ID) <b>optional </b>
     * <li>LCH-3: Segment Unique Key (EI) <b>optional </b>
     * <li>LCH-4: Location Characteristic ID (CWE) <b> </b>
     * <li>LCH-5: Location Characteristic Value - LCH (CWE) <b> </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class LCH extends AbstractSegment {

    /** 
     * Creates a new LCH segment
     */
    public LCH(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PL.class, true, 1, 200, new Object[]{ getMessage() }, "Primary Key Value - LCH");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(206) }, "Segment Action Code");
                                  this.add(EI.class, false, 1, 80, new Object[]{ getMessage() }, "Segment Unique Key");
                                  this.add(CWE.class, true, 1, 250, new Object[]{ getMessage() }, "Location Characteristic ID");
                                  this.add(CWE.class, true, 1, 250, new Object[]{ getMessage() }, "Location Characteristic Value - LCH");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating LCH - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * LCH-1: "Primary Key Value - LCH" - creates it if necessary
     */
    public PL getPrimaryKeyValueLCH() { 
		PL retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LCH-1: "Primary Key Value - LCH" - creates it if necessary
     */
    public PL getLch1_PrimaryKeyValueLCH() { 
		PL retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * LCH-2: "Segment Action Code" - creates it if necessary
     */
    public ID getSegmentActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LCH-2: "Segment Action Code" - creates it if necessary
     */
    public ID getLch2_SegmentActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * LCH-3: "Segment Unique Key" - creates it if necessary
     */
    public EI getSegmentUniqueKey() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LCH-3: "Segment Unique Key" - creates it if necessary
     */
    public EI getLch3_SegmentUniqueKey() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * LCH-4: "Location Characteristic ID" - creates it if necessary
     */
    public CWE getLocationCharacteristicID() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LCH-4: "Location Characteristic ID" - creates it if necessary
     */
    public CWE getLch4_LocationCharacteristicID() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * LCH-5: "Location Characteristic Value - LCH" - creates it if necessary
     */
    public CWE getLocationCharacteristicValueLCH() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LCH-5: "Location Characteristic Value - LCH" - creates it if necessary
     */
    public CWE getLch5_LocationCharacteristicValueLCH() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new PL(getMessage());
          case 1: return new ID(getMessage(), new Integer( 206 ));
          case 2: return new EI(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new CWE(getMessage());
          default: return null;
       }
   }


}

