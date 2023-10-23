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


package ca.uhn.hl7v2.model.v251.segment;

// import ca.uhn.hl7v2.model.v251.group.*;
import ca.uhn.hl7v2.model.v251.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 EDU message segment (Educational Detail). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>EDU-1: Set ID - EDU (SI) <b> </b>
     * <li>EDU-2: Academic Degree (IS) <b>optional </b>
     * <li>EDU-3: Academic Degree Program Date Range (DR) <b>optional </b>
     * <li>EDU-4: Academic Degree Program Participation Date Range (DR) <b>optional </b>
     * <li>EDU-5: Academic Degree Granted Date (DT) <b>optional </b>
     * <li>EDU-6: School (XON) <b>optional </b>
     * <li>EDU-7: School Type Code (CE) <b>optional </b>
     * <li>EDU-8: School Address (XAD) <b>optional </b>
     * <li>EDU-9: Major Field of Study (CWE) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class EDU extends AbstractSegment {

    /** 
     * Creates a new EDU segment
     */
    public EDU(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 60, new Object[]{ getMessage() }, "Set ID - EDU");
                                              this.add(IS.class, false, 1, 10, new Object[]{ getMessage(), new Integer(360) }, "Academic Degree");
                                  this.add(DR.class, false, 1, 52, new Object[]{ getMessage() }, "Academic Degree Program Date Range");
                                  this.add(DR.class, false, 1, 52, new Object[]{ getMessage() }, "Academic Degree Program Participation Date Range");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Academic Degree Granted Date");
                                  this.add(XON.class, false, 1, 250, new Object[]{ getMessage() }, "School");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "School Type Code");
                                  this.add(XAD.class, false, 1, 250, new Object[]{ getMessage() }, "School Address");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "Major Field of Study");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating EDU - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * EDU-1: "Set ID - EDU" - creates it if necessary
     */
    public SI getSetIDEDU() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EDU-1: "Set ID - EDU" - creates it if necessary
     */
    public SI getEdu1_SetIDEDU() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * EDU-2: "Academic Degree" - creates it if necessary
     */
    public IS getAcademicDegree() { 
		IS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EDU-2: "Academic Degree" - creates it if necessary
     */
    public IS getEdu2_AcademicDegree() { 
		IS retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * EDU-3: "Academic Degree Program Date Range" - creates it if necessary
     */
    public DR getAcademicDegreeProgramDateRange() { 
		DR retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EDU-3: "Academic Degree Program Date Range" - creates it if necessary
     */
    public DR getEdu3_AcademicDegreeProgramDateRange() { 
		DR retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * EDU-4: "Academic Degree Program Participation Date Range" - creates it if necessary
     */
    public DR getAcademicDegreeProgramParticipationDateRange() { 
		DR retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EDU-4: "Academic Degree Program Participation Date Range" - creates it if necessary
     */
    public DR getEdu4_AcademicDegreeProgramParticipationDateRange() { 
		DR retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * EDU-5: "Academic Degree Granted Date" - creates it if necessary
     */
    public DT getAcademicDegreeGrantedDate() { 
		DT retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EDU-5: "Academic Degree Granted Date" - creates it if necessary
     */
    public DT getEdu5_AcademicDegreeGrantedDate() { 
		DT retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * EDU-6: "School" - creates it if necessary
     */
    public XON getSchool() { 
		XON retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EDU-6: "School" - creates it if necessary
     */
    public XON getEdu6_School() { 
		XON retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * EDU-7: "School Type Code" - creates it if necessary
     */
    public CE getSchoolTypeCode() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EDU-7: "School Type Code" - creates it if necessary
     */
    public CE getEdu7_SchoolTypeCode() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * EDU-8: "School Address" - creates it if necessary
     */
    public XAD getSchoolAddress() { 
		XAD retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EDU-8: "School Address" - creates it if necessary
     */
    public XAD getEdu8_SchoolAddress() { 
		XAD retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Major Field of Study (EDU-9).
     */
    public CWE[] getMajorFieldOfStudy() {
    	CWE[] retVal = this.getTypedField(9, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Major Field of Study (EDU-9).
     */
    public CWE[] getEdu9_MajorFieldOfStudy() {
    	CWE[] retVal = this.getTypedField(9, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Major Field of Study (EDU-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMajorFieldOfStudyReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * EDU-9: "Major Field of Study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getMajorFieldOfStudy(int rep) { 
		CWE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * EDU-9: "Major Field of Study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getEdu9_MajorFieldOfStudy(int rep) { 
		CWE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Major Field of Study (EDU-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEdu9_MajorFieldOfStudyReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * EDU-9: "Major Field of Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertMajorFieldOfStudy(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * EDU-9: "Major Field of Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertEdu9_MajorFieldOfStudy(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * EDU-9: "Major Field of Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeMajorFieldOfStudy(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * EDU-9: "Major Field of Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeEdu9_MajorFieldOfStudy(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(9, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new IS(getMessage(), new Integer( 360 ));
          case 2: return new DR(getMessage());
          case 3: return new DR(getMessage());
          case 4: return new DT(getMessage());
          case 5: return new XON(getMessage());
          case 6: return new CE(getMessage());
          case 7: return new XAD(getMessage());
          case 8: return new CWE(getMessage());
          default: return null;
       }
   }


}

