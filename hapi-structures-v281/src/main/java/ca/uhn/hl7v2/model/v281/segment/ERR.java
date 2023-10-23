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
 *<p>Represents an HL7 ERR message segment (Error). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ERR-1: Error Code and Location (NULLDT) <b>optional </b>
     * <li>ERR-2: Error Location (ERL) <b>optional repeating</b>
     * <li>ERR-3: HL7 Error Code (CWE) <b> </b>
     * <li>ERR-4: Severity (ID) <b> </b>
     * <li>ERR-5: Application Error Code (CWE) <b>optional </b>
     * <li>ERR-6: Application Error Parameter (ST) <b>optional repeating</b>
     * <li>ERR-7: Diagnostic Information (TX) <b>optional </b>
     * <li>ERR-8: User Message (TX) <b>optional </b>
     * <li>ERR-9: Inform Person Indicator (CWE) <b>optional repeating</b>
     * <li>ERR-10: Override Type (CWE) <b>optional </b>
     * <li>ERR-11: Override Reason Code (CWE) <b>optional repeating</b>
     * <li>ERR-12: Help Desk Contact Point (XTN) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ERR extends AbstractSegment {

    /** 
     * Creates a new ERR segment
     */
    public ERR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Error Code and Location");
                                  this.add(ERL.class, false, 0, 0, new Object[]{ getMessage() }, "Error Location");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "HL7 Error Code");
                                              this.add(ID.class, true, 1, 0, new Object[]{ getMessage(), new Integer(516) }, "Severity");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Application Error Code");
                                  this.add(ST.class, false, 10, 0, new Object[]{ getMessage() }, "Application Error Parameter");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "Diagnostic Information");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "User Message");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Inform Person Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Override Type");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Override Reason Code");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Help Desk Contact Point");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ERR - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ERR-1: "Error Code and Location" - creates it if necessary
     */
    public NULLDT getErrorCodeAndLocation() { 
		NULLDT retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ERR-1: "Error Code and Location" - creates it if necessary
     */
    public NULLDT getErr1_ErrorCodeAndLocation() { 
		NULLDT retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Error Location (ERR-2).
     */
    public ERL[] getErrorLocation() {
    	ERL[] retVal = this.getTypedField(2, new ERL[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Error Location (ERR-2).
     */
    public ERL[] getErr2_ErrorLocation() {
    	ERL[] retVal = this.getTypedField(2, new ERL[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Error Location (ERR-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getErrorLocationReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * ERR-2: "Error Location" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ERL getErrorLocation(int rep) { 
		ERL retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ERR-2: "Error Location" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ERL getErr2_ErrorLocation(int rep) { 
		ERL retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Error Location (ERR-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getErr2_ErrorLocationReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * ERR-2: "Error Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ERL insertErrorLocation(int rep) throws HL7Exception { 
        return (ERL) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * ERR-2: "Error Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ERL insertErr2_ErrorLocation(int rep) throws HL7Exception { 
        return (ERL) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * ERR-2: "Error Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ERL removeErrorLocation(int rep) throws HL7Exception { 
        return (ERL) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * ERR-2: "Error Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ERL removeErr2_ErrorLocation(int rep) throws HL7Exception { 
        return (ERL) super.removeRepetition(2, rep);
    }




    /**
     * Returns
     * ERR-3: "HL7 Error Code" - creates it if necessary
     */
    public CWE getHL7ErrorCode() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ERR-3: "HL7 Error Code" - creates it if necessary
     */
    public CWE getErr3_HL7ErrorCode() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * ERR-4: "Severity" - creates it if necessary
     */
    public ID getSeverity() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ERR-4: "Severity" - creates it if necessary
     */
    public ID getErr4_Severity() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * ERR-5: "Application Error Code" - creates it if necessary
     */
    public CWE getApplicationErrorCode() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ERR-5: "Application Error Code" - creates it if necessary
     */
    public CWE getErr5_ApplicationErrorCode() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Application Error Parameter (ERR-6).
     */
    public ST[] getApplicationErrorParameter() {
    	ST[] retVal = this.getTypedField(6, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Application Error Parameter (ERR-6).
     */
    public ST[] getErr6_ApplicationErrorParameter() {
    	ST[] retVal = this.getTypedField(6, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Application Error Parameter (ERR-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getApplicationErrorParameterReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * ERR-6: "Application Error Parameter" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getApplicationErrorParameter(int rep) { 
		ST retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ERR-6: "Application Error Parameter" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getErr6_ApplicationErrorParameter(int rep) { 
		ST retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Application Error Parameter (ERR-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getErr6_ApplicationErrorParameterReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * ERR-6: "Application Error Parameter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertApplicationErrorParameter(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * ERR-6: "Application Error Parameter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertErr6_ApplicationErrorParameter(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * ERR-6: "Application Error Parameter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeApplicationErrorParameter(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * ERR-6: "Application Error Parameter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeErr6_ApplicationErrorParameter(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(6, rep);
    }




    /**
     * Returns
     * ERR-7: "Diagnostic Information" - creates it if necessary
     */
    public TX getDiagnosticInformation() { 
		TX retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ERR-7: "Diagnostic Information" - creates it if necessary
     */
    public TX getErr7_DiagnosticInformation() { 
		TX retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * ERR-8: "User Message" - creates it if necessary
     */
    public TX getUserMessage() { 
		TX retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ERR-8: "User Message" - creates it if necessary
     */
    public TX getErr8_UserMessage() { 
		TX retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Inform Person Indicator (ERR-9).
     */
    public CWE[] getInformPersonIndicator() {
    	CWE[] retVal = this.getTypedField(9, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Inform Person Indicator (ERR-9).
     */
    public CWE[] getErr9_InformPersonIndicator() {
    	CWE[] retVal = this.getTypedField(9, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Inform Person Indicator (ERR-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInformPersonIndicatorReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * ERR-9: "Inform Person Indicator" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getInformPersonIndicator(int rep) { 
		CWE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ERR-9: "Inform Person Indicator" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getErr9_InformPersonIndicator(int rep) { 
		CWE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Inform Person Indicator (ERR-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getErr9_InformPersonIndicatorReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * ERR-9: "Inform Person Indicator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertInformPersonIndicator(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * ERR-9: "Inform Person Indicator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertErr9_InformPersonIndicator(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * ERR-9: "Inform Person Indicator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeInformPersonIndicator(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * ERR-9: "Inform Person Indicator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeErr9_InformPersonIndicator(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * ERR-10: "Override Type" - creates it if necessary
     */
    public CWE getOverrideType() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ERR-10: "Override Type" - creates it if necessary
     */
    public CWE getErr10_OverrideType() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Override Reason Code (ERR-11).
     */
    public CWE[] getOverrideReasonCode() {
    	CWE[] retVal = this.getTypedField(11, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Override Reason Code (ERR-11).
     */
    public CWE[] getErr11_OverrideReasonCode() {
    	CWE[] retVal = this.getTypedField(11, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Override Reason Code (ERR-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOverrideReasonCodeReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * ERR-11: "Override Reason Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOverrideReasonCode(int rep) { 
		CWE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ERR-11: "Override Reason Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getErr11_OverrideReasonCode(int rep) { 
		CWE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Override Reason Code (ERR-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getErr11_OverrideReasonCodeReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * ERR-11: "Override Reason Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOverrideReasonCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * ERR-11: "Override Reason Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertErr11_OverrideReasonCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * ERR-11: "Override Reason Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOverrideReasonCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * ERR-11: "Override Reason Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeErr11_OverrideReasonCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(11, rep);
    }



    /**
     * Returns all repetitions of Help Desk Contact Point (ERR-12).
     */
    public XTN[] getHelpDeskContactPoint() {
    	XTN[] retVal = this.getTypedField(12, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Help Desk Contact Point (ERR-12).
     */
    public XTN[] getErr12_HelpDeskContactPoint() {
    	XTN[] retVal = this.getTypedField(12, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Help Desk Contact Point (ERR-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getHelpDeskContactPointReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * ERR-12: "Help Desk Contact Point" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getHelpDeskContactPoint(int rep) { 
		XTN retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ERR-12: "Help Desk Contact Point" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getErr12_HelpDeskContactPoint(int rep) { 
		XTN retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Help Desk Contact Point (ERR-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getErr12_HelpDeskContactPointReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * ERR-12: "Help Desk Contact Point" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertHelpDeskContactPoint(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * ERR-12: "Help Desk Contact Point" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertErr12_HelpDeskContactPoint(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * ERR-12: "Help Desk Contact Point" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeHelpDeskContactPoint(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * ERR-12: "Help Desk Contact Point" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeErr12_HelpDeskContactPoint(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(12, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NULLDT(getMessage());
          case 1: return new ERL(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new ID(getMessage(), new Integer( 516 ));
          case 4: return new CWE(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new TX(getMessage());
          case 7: return new TX(getMessage());
          case 8: return new CWE(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new CWE(getMessage());
          case 11: return new XTN(getMessage());
          default: return null;
       }
   }


}

