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


package ca.uhn.hl7v2.model.v21.segment;

// import ca.uhn.hl7v2.model.v21.group.*;
import ca.uhn.hl7v2.model.v21.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 ORO message segment (ORDER OTHER). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ORO-1: ORDER ITEM ID (CE) <b>optional </b>
     * <li>ORO-2: SUBSTITUTE ALLOWED (ID) <b>optional </b>
     * <li>ORO-3: RESULTS COPIES TO (CN) <b>optional repeating</b>
     * <li>ORO-4: STOCK LOCATION (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ORO extends AbstractSegment {

    /** 
     * Creates a new ORO segment
     */
    public ORO(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CE.class, false, 1, 200, new Object[]{ getMessage() }, "ORDER ITEM ID");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(0) }, "SUBSTITUTE ALLOWED");
                                  this.add(CN.class, false, 0, 80, new Object[]{ getMessage() }, "RESULTS COPIES TO");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(12) }, "STOCK LOCATION");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORO - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ORO-1: "ORDER ITEM ID" - creates it if necessary
     */
    public CE getORDERITEMID() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORO-1: "ORDER ITEM ID" - creates it if necessary
     */
    public CE getOro1_ORDERITEMID() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * ORO-2: "SUBSTITUTE ALLOWED" - creates it if necessary
     */
    public ID getSUBSTITUTEALLOWED() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORO-2: "SUBSTITUTE ALLOWED" - creates it if necessary
     */
    public ID getOro2_SUBSTITUTEALLOWED() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of RESULTS COPIES TO (ORO-3).
     */
    public CN[] getRESULTSCOPIESTO() {
    	CN[] retVal = this.getTypedField(3, new CN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of RESULTS COPIES TO (ORO-3).
     */
    public CN[] getOro3_RESULTSCOPIESTO() {
    	CN[] retVal = this.getTypedField(3, new CN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of RESULTS COPIES TO (ORO-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRESULTSCOPIESTOReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * ORO-3: "RESULTS COPIES TO" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CN getRESULTSCOPIESTO(int rep) { 
		CN retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORO-3: "RESULTS COPIES TO" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CN getOro3_RESULTSCOPIESTO(int rep) { 
		CN retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of RESULTS COPIES TO (ORO-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOro3_RESULTSCOPIESTOReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * ORO-3: "RESULTS COPIES TO" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN insertRESULTSCOPIESTO(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * ORO-3: "RESULTS COPIES TO" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN insertOro3_RESULTSCOPIESTO(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * ORO-3: "RESULTS COPIES TO" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removeRESULTSCOPIESTO(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * ORO-3: "RESULTS COPIES TO" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removeOro3_RESULTSCOPIESTO(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * ORO-4: "STOCK LOCATION" - creates it if necessary
     */
    public ID getSTOCKLOCATION() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORO-4: "STOCK LOCATION" - creates it if necessary
     */
    public ID getOro4_STOCKLOCATION() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CE(getMessage());
          case 1: return new ID(getMessage(), new Integer( 0 ));
          case 2: return new CN(getMessage());
          case 3: return new ID(getMessage(), new Integer( 12 ));
          default: return null;
       }
   }


}

