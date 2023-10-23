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


package ca.uhn.hl7v2.model.v281.segment;

// import ca.uhn.hl7v2.model.v281.group.*;
import ca.uhn.hl7v2.model.v281.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 IPC message segment (Imaging Procedure Control Segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IPC-1: Accession Identifier (EI) <b> </b>
     * <li>IPC-2: Requested Procedure ID (EI) <b> </b>
     * <li>IPC-3: Study Instance UID (EI) <b> </b>
     * <li>IPC-4: Scheduled Procedure Step ID (EI) <b> </b>
     * <li>IPC-5: Modality (CWE) <b>optional </b>
     * <li>IPC-6: Protocol Code (CWE) <b>optional repeating</b>
     * <li>IPC-7: Scheduled Station Name (EI) <b>optional </b>
     * <li>IPC-8: Scheduled Procedure Step Location (CWE) <b>optional repeating</b>
     * <li>IPC-9: Scheduled Station AE Title (ST) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class IPC extends AbstractSegment {

    /** 
     * Creates a new IPC segment
     */
    public IPC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Accession Identifier");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Requested Procedure ID");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Study Instance UID");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Scheduled Procedure Step ID");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Modality");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Protocol Code");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Scheduled Station Name");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Scheduled Procedure Step Location");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Scheduled Station AE Title");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating IPC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * IPC-1: "Accession Identifier" - creates it if necessary
     */
    public EI getAccessionIdentifier() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPC-1: "Accession Identifier" - creates it if necessary
     */
    public EI getIpc1_AccessionIdentifier() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * IPC-2: "Requested Procedure ID" - creates it if necessary
     */
    public EI getRequestedProcedureID() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPC-2: "Requested Procedure ID" - creates it if necessary
     */
    public EI getIpc2_RequestedProcedureID() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * IPC-3: "Study Instance UID" - creates it if necessary
     */
    public EI getStudyInstanceUID() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPC-3: "Study Instance UID" - creates it if necessary
     */
    public EI getIpc3_StudyInstanceUID() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * IPC-4: "Scheduled Procedure Step ID" - creates it if necessary
     */
    public EI getScheduledProcedureStepID() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPC-4: "Scheduled Procedure Step ID" - creates it if necessary
     */
    public EI getIpc4_ScheduledProcedureStepID() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * IPC-5: "Modality" - creates it if necessary
     */
    public CWE getModality() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPC-5: "Modality" - creates it if necessary
     */
    public CWE getIpc5_Modality() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Protocol Code (IPC-6).
     */
    public CWE[] getProtocolCode() {
    	CWE[] retVal = this.getTypedField(6, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Protocol Code (IPC-6).
     */
    public CWE[] getIpc6_ProtocolCode() {
    	CWE[] retVal = this.getTypedField(6, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Protocol Code (IPC-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProtocolCodeReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * IPC-6: "Protocol Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getProtocolCode(int rep) { 
		CWE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IPC-6: "Protocol Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getIpc6_ProtocolCode(int rep) { 
		CWE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Protocol Code (IPC-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIpc6_ProtocolCodeReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * IPC-6: "Protocol Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertProtocolCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * IPC-6: "Protocol Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertIpc6_ProtocolCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * IPC-6: "Protocol Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeProtocolCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * IPC-6: "Protocol Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeIpc6_ProtocolCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(6, rep);
    }




    /**
     * Returns
     * IPC-7: "Scheduled Station Name" - creates it if necessary
     */
    public EI getScheduledStationName() { 
		EI retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPC-7: "Scheduled Station Name" - creates it if necessary
     */
    public EI getIpc7_ScheduledStationName() { 
		EI retVal = this.getTypedField(7, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Scheduled Procedure Step Location (IPC-8).
     */
    public CWE[] getScheduledProcedureStepLocation() {
    	CWE[] retVal = this.getTypedField(8, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Scheduled Procedure Step Location (IPC-8).
     */
    public CWE[] getIpc8_ScheduledProcedureStepLocation() {
    	CWE[] retVal = this.getTypedField(8, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Scheduled Procedure Step Location (IPC-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getScheduledProcedureStepLocationReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * IPC-8: "Scheduled Procedure Step Location" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getScheduledProcedureStepLocation(int rep) { 
		CWE retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IPC-8: "Scheduled Procedure Step Location" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getIpc8_ScheduledProcedureStepLocation(int rep) { 
		CWE retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Scheduled Procedure Step Location (IPC-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIpc8_ScheduledProcedureStepLocationReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * IPC-8: "Scheduled Procedure Step Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertScheduledProcedureStepLocation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * IPC-8: "Scheduled Procedure Step Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertIpc8_ScheduledProcedureStepLocation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * IPC-8: "Scheduled Procedure Step Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeScheduledProcedureStepLocation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * IPC-8: "Scheduled Procedure Step Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeIpc8_ScheduledProcedureStepLocation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(8, rep);
    }




    /**
     * Returns
     * IPC-9: "Scheduled Station AE Title" - creates it if necessary
     */
    public ST getScheduledStationAETitle() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPC-9: "Scheduled Station AE Title" - creates it if necessary
     */
    public ST getIpc9_ScheduledStationAETitle() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new EI(getMessage());
          case 3: return new EI(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new EI(getMessage());
          case 7: return new CWE(getMessage());
          case 8: return new ST(getMessage());
          default: return null;
       }
   }


}

