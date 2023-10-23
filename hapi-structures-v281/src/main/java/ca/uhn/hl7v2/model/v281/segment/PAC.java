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
 *<p>Represents an HL7 PAC message segment (Shipment Package). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PAC-1: Set Id - PAC (SI) <b> </b>
     * <li>PAC-2: Package ID (EI) <b>optional </b>
     * <li>PAC-3: Parent Package ID (EI) <b>optional </b>
     * <li>PAC-4: Position in Parent Package (NA) <b>optional </b>
     * <li>PAC-5: Package Type (CWE) <b> </b>
     * <li>PAC-6: Package Condition (CWE) <b>optional repeating</b>
     * <li>PAC-7: Package Handling Code (CWE) <b>optional repeating</b>
     * <li>PAC-8: Package Risk Code (CWE) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PAC extends AbstractSegment {

    /** 
     * Creates a new PAC segment
     */
    public PAC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 0, new Object[]{ getMessage() }, "Set Id - PAC");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Package ID");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Parent Package ID");
                                  this.add(NA.class, false, 1, 0, new Object[]{ getMessage() }, "Position in Parent Package");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Package Type");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Package Condition");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Package Handling Code");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Package Risk Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PAC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PAC-1: "Set Id - PAC" - creates it if necessary
     */
    public SI getSetIdPAC() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PAC-1: "Set Id - PAC" - creates it if necessary
     */
    public SI getPac1_SetIdPAC() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PAC-2: "Package ID" - creates it if necessary
     */
    public EI getPackageID() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PAC-2: "Package ID" - creates it if necessary
     */
    public EI getPac2_PackageID() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PAC-3: "Parent Package ID" - creates it if necessary
     */
    public EI getParentPackageID() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PAC-3: "Parent Package ID" - creates it if necessary
     */
    public EI getPac3_ParentPackageID() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PAC-4: "Position in Parent Package" - creates it if necessary
     */
    public NA getPositionInParentPackage() { 
		NA retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PAC-4: "Position in Parent Package" - creates it if necessary
     */
    public NA getPac4_PositionInParentPackage() { 
		NA retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PAC-5: "Package Type" - creates it if necessary
     */
    public CWE getPackageType() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PAC-5: "Package Type" - creates it if necessary
     */
    public CWE getPac5_PackageType() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Package Condition (PAC-6).
     */
    public CWE[] getPackageCondition() {
    	CWE[] retVal = this.getTypedField(6, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Package Condition (PAC-6).
     */
    public CWE[] getPac6_PackageCondition() {
    	CWE[] retVal = this.getTypedField(6, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Package Condition (PAC-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPackageConditionReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * PAC-6: "Package Condition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPackageCondition(int rep) { 
		CWE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PAC-6: "Package Condition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPac6_PackageCondition(int rep) { 
		CWE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Package Condition (PAC-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPac6_PackageConditionReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * PAC-6: "Package Condition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPackageCondition(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * PAC-6: "Package Condition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPac6_PackageCondition(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * PAC-6: "Package Condition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePackageCondition(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * PAC-6: "Package Condition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePac6_PackageCondition(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Package Handling Code (PAC-7).
     */
    public CWE[] getPackageHandlingCode() {
    	CWE[] retVal = this.getTypedField(7, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Package Handling Code (PAC-7).
     */
    public CWE[] getPac7_PackageHandlingCode() {
    	CWE[] retVal = this.getTypedField(7, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Package Handling Code (PAC-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPackageHandlingCodeReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * PAC-7: "Package Handling Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPackageHandlingCode(int rep) { 
		CWE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PAC-7: "Package Handling Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPac7_PackageHandlingCode(int rep) { 
		CWE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Package Handling Code (PAC-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPac7_PackageHandlingCodeReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * PAC-7: "Package Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPackageHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * PAC-7: "Package Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPac7_PackageHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PAC-7: "Package Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePackageHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PAC-7: "Package Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePac7_PackageHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(7, rep);
    }



    /**
     * Returns all repetitions of Package Risk Code (PAC-8).
     */
    public CWE[] getPackageRiskCode() {
    	CWE[] retVal = this.getTypedField(8, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Package Risk Code (PAC-8).
     */
    public CWE[] getPac8_PackageRiskCode() {
    	CWE[] retVal = this.getTypedField(8, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Package Risk Code (PAC-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPackageRiskCodeReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * PAC-8: "Package Risk Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPackageRiskCode(int rep) { 
		CWE retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PAC-8: "Package Risk Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPac8_PackageRiskCode(int rep) { 
		CWE retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Package Risk Code (PAC-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPac8_PackageRiskCodeReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * PAC-8: "Package Risk Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPackageRiskCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * PAC-8: "Package Risk Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPac8_PackageRiskCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * PAC-8: "Package Risk Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePackageRiskCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * PAC-8: "Package Risk Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePac8_PackageRiskCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(8, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new EI(getMessage());
          case 3: return new NA(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new CWE(getMessage());
          default: return null;
       }
   }


}

