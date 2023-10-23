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


package ca.uhn.hl7v2.model.v23.segment;

// import ca.uhn.hl7v2.model.v23.group.*;
import ca.uhn.hl7v2.model.v23.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 SPR message segment (Stored Procedure Request Definition). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>SPR-1: Query tag (ST) <b>optional </b>
     * <li>SPR-2: Query/ Response Format Code (ID) <b> </b>
     * <li>SPR-3: Stored procedure name (CE) <b> </b>
     * <li>SPR-4: Input parameter list (QIP) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class SPR extends AbstractSegment {

    /** 
     * Creates a new SPR segment
     */
    public SPR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, false, 1, 32, new Object[]{ getMessage() }, "Query tag");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(106) }, "Query/ Response Format Code");
                                  this.add(CE.class, true, 1, 60, new Object[]{ getMessage() }, "Stored procedure name");
                                  this.add(QIP.class, false, 0, 256, new Object[]{ getMessage() }, "Input parameter list");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SPR - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * SPR-1: "Query tag" - creates it if necessary
     */
    public ST getQueryTag() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPR-1: "Query tag" - creates it if necessary
     */
    public ST getSpr1_QueryTag() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * SPR-2: "Query/ Response Format Code" - creates it if necessary
     */
    public ID getQueryResponseFormatCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPR-2: "Query/ Response Format Code" - creates it if necessary
     */
    public ID getSpr2_QueryResponseFormatCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * SPR-3: "Stored procedure name" - creates it if necessary
     */
    public CE getStoredProcedureName() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPR-3: "Stored procedure name" - creates it if necessary
     */
    public CE getSpr3_StoredProcedureName() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Input parameter list (SPR-4).
     */
    public QIP[] getInputParameterList() {
    	QIP[] retVal = this.getTypedField(4, new QIP[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Input parameter list (SPR-4).
     */
    public QIP[] getSpr4_InputParameterList() {
    	QIP[] retVal = this.getTypedField(4, new QIP[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Input parameter list (SPR-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInputParameterListReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * SPR-4: "Input parameter list" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public QIP getInputParameterList(int rep) { 
		QIP retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SPR-4: "Input parameter list" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public QIP getSpr4_InputParameterList(int rep) { 
		QIP retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Input parameter list (SPR-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpr4_InputParameterListReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * SPR-4: "Input parameter list" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public QIP insertInputParameterList(int rep) throws HL7Exception { 
        return (QIP) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * SPR-4: "Input parameter list" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public QIP insertSpr4_InputParameterList(int rep) throws HL7Exception { 
        return (QIP) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * SPR-4: "Input parameter list" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public QIP removeInputParameterList(int rep) throws HL7Exception { 
        return (QIP) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * SPR-4: "Input parameter list" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public QIP removeSpr4_InputParameterList(int rep) throws HL7Exception { 
        return (QIP) super.removeRepetition(4, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new ID(getMessage(), new Integer( 106 ));
          case 2: return new CE(getMessage());
          case 3: return new QIP(getMessage());
          default: return null;
       }
   }


}

