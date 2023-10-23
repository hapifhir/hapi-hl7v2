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
 *<p>Represents an HL7 SAC message segment (Specimen Container detail). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>SAC-1: External Accession Identifier (EI) <b>optional </b>
     * <li>SAC-2: Accession Identifier (EI) <b>optional </b>
     * <li>SAC-3: Container Identifier (EI) <b>optional </b>
     * <li>SAC-4: Primary (Parent) Container Identifier (EI) <b>optional </b>
     * <li>SAC-5: Equipment Container Identifier (EI) <b>optional </b>
     * <li>SAC-6: Specimen Source (SPS) <b>optional </b>
     * <li>SAC-7: Registration Date/Time (DTM) <b>optional </b>
     * <li>SAC-8: Container Status (CWE) <b>optional </b>
     * <li>SAC-9: Carrier Type (CWE) <b>optional </b>
     * <li>SAC-10: Carrier Identifier (EI) <b>optional </b>
     * <li>SAC-11: Position in Carrier (NA) <b>optional </b>
     * <li>SAC-12: Tray Type - SAC (CWE) <b>optional </b>
     * <li>SAC-13: Tray Identifier (EI) <b>optional </b>
     * <li>SAC-14: Position in Tray (NA) <b>optional </b>
     * <li>SAC-15: Location (CWE) <b>optional repeating</b>
     * <li>SAC-16: Container Height (NM) <b>optional </b>
     * <li>SAC-17: Container Diameter (NM) <b>optional </b>
     * <li>SAC-18: Barrier Delta (NM) <b>optional </b>
     * <li>SAC-19: Bottom Delta (NM) <b>optional </b>
     * <li>SAC-20: Container Height/Diameter/Delta Units (CWE) <b>optional </b>
     * <li>SAC-21: Container Volume (NM) <b>optional </b>
     * <li>SAC-22: Available Specimen Volume (NM) <b>optional </b>
     * <li>SAC-23: Initial Specimen Volume (NM) <b>optional </b>
     * <li>SAC-24: Volume Units (CWE) <b>optional </b>
     * <li>SAC-25: Separator Type (CWE) <b>optional </b>
     * <li>SAC-26: Cap Type (CWE) <b>optional </b>
     * <li>SAC-27: Additive (CWE) <b>optional repeating</b>
     * <li>SAC-28: Specimen Component (CWE) <b>optional </b>
     * <li>SAC-29: Dilution Factor (SN) <b>optional </b>
     * <li>SAC-30: Treatment (CWE) <b>optional </b>
     * <li>SAC-31: Temperature (SN) <b>optional </b>
     * <li>SAC-32: Hemolysis Index (NM) <b>optional </b>
     * <li>SAC-33: Hemolysis Index Units (CWE) <b>optional </b>
     * <li>SAC-34: Lipemia Index (NM) <b>optional </b>
     * <li>SAC-35: Lipemia Index Units (CWE) <b>optional </b>
     * <li>SAC-36: Icterus Index (NM) <b>optional </b>
     * <li>SAC-37: Icterus Index Units (CWE) <b>optional </b>
     * <li>SAC-38: Fibrin Index (NM) <b>optional </b>
     * <li>SAC-39: Fibrin Index Units (CWE) <b>optional </b>
     * <li>SAC-40: System Induced Contaminants (CWE) <b>optional repeating</b>
     * <li>SAC-41: Drug Interference (CWE) <b>optional repeating</b>
     * <li>SAC-42: Artificial Blood (CWE) <b>optional </b>
     * <li>SAC-43: Special Handling Code (CWE) <b>optional repeating</b>
     * <li>SAC-44: Other Environmental Factors (CWE) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class SAC extends AbstractSegment {

    /** 
     * Creates a new SAC segment
     */
    public SAC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, false, 1, 427, new Object[]{ getMessage() }, "External Accession Identifier");
                                  this.add(EI.class, false, 1, 427, new Object[]{ getMessage() }, "Accession Identifier");
                                  this.add(EI.class, false, 1, 427, new Object[]{ getMessage() }, "Container Identifier");
                                  this.add(EI.class, false, 1, 427, new Object[]{ getMessage() }, "Primary (Parent) Container Identifier");
                                  this.add(EI.class, false, 1, 427, new Object[]{ getMessage() }, "Equipment Container Identifier");
                                  this.add(SPS.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Source");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Registration Date/Time");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Container Status");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Carrier Type");
                                  this.add(EI.class, false, 1, 705, new Object[]{ getMessage() }, "Carrier Identifier");
                                  this.add(NA.class, false, 1, 80, new Object[]{ getMessage() }, "Position in Carrier");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Tray Type - SAC");
                                  this.add(EI.class, false, 1, 427, new Object[]{ getMessage() }, "Tray Identifier");
                                  this.add(NA.class, false, 1, 80, new Object[]{ getMessage() }, "Position in Tray");
                                  this.add(CWE.class, false, 0, 705, new Object[]{ getMessage() }, "Location");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Container Height");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Container Diameter");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Barrier Delta");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Bottom Delta");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Container Height/Diameter/Delta Units");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Container Volume");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Available Specimen Volume");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Initial Specimen Volume");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Volume Units");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Separator Type");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Cap Type");
                                  this.add(CWE.class, false, 0, 705, new Object[]{ getMessage() }, "Additive");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Specimen Component");
                                  this.add(SN.class, false, 1, 36, new Object[]{ getMessage() }, "Dilution Factor");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Treatment");
                                  this.add(SN.class, false, 1, 36, new Object[]{ getMessage() }, "Temperature");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Hemolysis Index");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Hemolysis Index Units");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Lipemia Index");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Lipemia Index Units");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Icterus Index");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Icterus Index Units");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Fibrin Index");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Fibrin Index Units");
                                  this.add(CWE.class, false, 0, 705, new Object[]{ getMessage() }, "System Induced Contaminants");
                                  this.add(CWE.class, false, 0, 705, new Object[]{ getMessage() }, "Drug Interference");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Artificial Blood");
                                  this.add(CWE.class, false, 0, 705, new Object[]{ getMessage() }, "Special Handling Code");
                                  this.add(CWE.class, false, 0, 705, new Object[]{ getMessage() }, "Other Environmental Factors");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SAC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * SAC-1: "External Accession Identifier" - creates it if necessary
     */
    public EI getExternalAccessionIdentifier() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-1: "External Accession Identifier" - creates it if necessary
     */
    public EI getSac1_ExternalAccessionIdentifier() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-2: "Accession Identifier" - creates it if necessary
     */
    public EI getAccessionIdentifier() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-2: "Accession Identifier" - creates it if necessary
     */
    public EI getSac2_AccessionIdentifier() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-3: "Container Identifier" - creates it if necessary
     */
    public EI getContainerIdentifier() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-3: "Container Identifier" - creates it if necessary
     */
    public EI getSac3_ContainerIdentifier() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-4: "Primary (Parent) Container Identifier" - creates it if necessary
     */
    public EI getPrimaryParentContainerIdentifier() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-4: "Primary (Parent) Container Identifier" - creates it if necessary
     */
    public EI getSac4_PrimaryParentContainerIdentifier() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-5: "Equipment Container Identifier" - creates it if necessary
     */
    public EI getEquipmentContainerIdentifier() { 
		EI retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-5: "Equipment Container Identifier" - creates it if necessary
     */
    public EI getSac5_EquipmentContainerIdentifier() { 
		EI retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-6: "Specimen Source" - creates it if necessary
     */
    public SPS getSpecimenSource() { 
		SPS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-6: "Specimen Source" - creates it if necessary
     */
    public SPS getSac6_SpecimenSource() { 
		SPS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-7: "Registration Date/Time" - creates it if necessary
     */
    public DTM getRegistrationDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-7: "Registration Date/Time" - creates it if necessary
     */
    public DTM getSac7_RegistrationDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-8: "Container Status" - creates it if necessary
     */
    public CWE getContainerStatus() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-8: "Container Status" - creates it if necessary
     */
    public CWE getSac8_ContainerStatus() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-9: "Carrier Type" - creates it if necessary
     */
    public CWE getCarrierType() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-9: "Carrier Type" - creates it if necessary
     */
    public CWE getSac9_CarrierType() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-10: "Carrier Identifier" - creates it if necessary
     */
    public EI getCarrierIdentifier() { 
		EI retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-10: "Carrier Identifier" - creates it if necessary
     */
    public EI getSac10_CarrierIdentifier() { 
		EI retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-11: "Position in Carrier" - creates it if necessary
     */
    public NA getPositionInCarrier() { 
		NA retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-11: "Position in Carrier" - creates it if necessary
     */
    public NA getSac11_PositionInCarrier() { 
		NA retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-12: "Tray Type - SAC" - creates it if necessary
     */
    public CWE getTrayTypeSAC() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-12: "Tray Type - SAC" - creates it if necessary
     */
    public CWE getSac12_TrayTypeSAC() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-13: "Tray Identifier" - creates it if necessary
     */
    public EI getTrayIdentifier() { 
		EI retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-13: "Tray Identifier" - creates it if necessary
     */
    public EI getSac13_TrayIdentifier() { 
		EI retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-14: "Position in Tray" - creates it if necessary
     */
    public NA getPositionInTray() { 
		NA retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-14: "Position in Tray" - creates it if necessary
     */
    public NA getSac14_PositionInTray() { 
		NA retVal = this.getTypedField(14, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Location (SAC-15).
     */
    public CWE[] getLocation() {
    	CWE[] retVal = this.getTypedField(15, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Location (SAC-15).
     */
    public CWE[] getSac15_Location() {
    	CWE[] retVal = this.getTypedField(15, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Location (SAC-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLocationReps() {
    	return this.getReps(15);
    }


    /**
     * Returns a specific repetition of
     * SAC-15: "Location" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getLocation(int rep) { 
		CWE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SAC-15: "Location" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSac15_Location(int rep) { 
		CWE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Location (SAC-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSac15_LocationReps() {
    	return this.getReps(15);
    }


    /**
     * Inserts a repetition of
     * SAC-15: "Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertLocation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * SAC-15: "Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSac15_Location(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * SAC-15: "Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeLocation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * SAC-15: "Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSac15_Location(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(15, rep);
    }




    /**
     * Returns
     * SAC-16: "Container Height" - creates it if necessary
     */
    public NM getContainerHeight() { 
		NM retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-16: "Container Height" - creates it if necessary
     */
    public NM getSac16_ContainerHeight() { 
		NM retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-17: "Container Diameter" - creates it if necessary
     */
    public NM getContainerDiameter() { 
		NM retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-17: "Container Diameter" - creates it if necessary
     */
    public NM getSac17_ContainerDiameter() { 
		NM retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-18: "Barrier Delta" - creates it if necessary
     */
    public NM getBarrierDelta() { 
		NM retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-18: "Barrier Delta" - creates it if necessary
     */
    public NM getSac18_BarrierDelta() { 
		NM retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-19: "Bottom Delta" - creates it if necessary
     */
    public NM getBottomDelta() { 
		NM retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-19: "Bottom Delta" - creates it if necessary
     */
    public NM getSac19_BottomDelta() { 
		NM retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-20: "Container Height/Diameter/Delta Units" - creates it if necessary
     */
    public CWE getContainerHeightDiameterDeltaUnits() { 
		CWE retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-20: "Container Height/Diameter/Delta Units" - creates it if necessary
     */
    public CWE getSac20_ContainerHeightDiameterDeltaUnits() { 
		CWE retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-21: "Container Volume" - creates it if necessary
     */
    public NM getContainerVolume() { 
		NM retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-21: "Container Volume" - creates it if necessary
     */
    public NM getSac21_ContainerVolume() { 
		NM retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-22: "Available Specimen Volume" - creates it if necessary
     */
    public NM getAvailableSpecimenVolume() { 
		NM retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-22: "Available Specimen Volume" - creates it if necessary
     */
    public NM getSac22_AvailableSpecimenVolume() { 
		NM retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-23: "Initial Specimen Volume" - creates it if necessary
     */
    public NM getInitialSpecimenVolume() { 
		NM retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-23: "Initial Specimen Volume" - creates it if necessary
     */
    public NM getSac23_InitialSpecimenVolume() { 
		NM retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-24: "Volume Units" - creates it if necessary
     */
    public CWE getVolumeUnits() { 
		CWE retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-24: "Volume Units" - creates it if necessary
     */
    public CWE getSac24_VolumeUnits() { 
		CWE retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-25: "Separator Type" - creates it if necessary
     */
    public CWE getSeparatorType() { 
		CWE retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-25: "Separator Type" - creates it if necessary
     */
    public CWE getSac25_SeparatorType() { 
		CWE retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-26: "Cap Type" - creates it if necessary
     */
    public CWE getCapType() { 
		CWE retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-26: "Cap Type" - creates it if necessary
     */
    public CWE getSac26_CapType() { 
		CWE retVal = this.getTypedField(26, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Additive (SAC-27).
     */
    public CWE[] getAdditive() {
    	CWE[] retVal = this.getTypedField(27, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Additive (SAC-27).
     */
    public CWE[] getSac27_Additive() {
    	CWE[] retVal = this.getTypedField(27, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Additive (SAC-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAdditiveReps() {
    	return this.getReps(27);
    }


    /**
     * Returns a specific repetition of
     * SAC-27: "Additive" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAdditive(int rep) { 
		CWE retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SAC-27: "Additive" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSac27_Additive(int rep) { 
		CWE retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Additive (SAC-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSac27_AdditiveReps() {
    	return this.getReps(27);
    }


    /**
     * Inserts a repetition of
     * SAC-27: "Additive" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAdditive(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(27, rep);
    }


    /**
     * Inserts a repetition of
     * SAC-27: "Additive" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSac27_Additive(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * SAC-27: "Additive" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAdditive(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * SAC-27: "Additive" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSac27_Additive(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(27, rep);
    }




    /**
     * Returns
     * SAC-28: "Specimen Component" - creates it if necessary
     */
    public CWE getSpecimenComponent() { 
		CWE retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-28: "Specimen Component" - creates it if necessary
     */
    public CWE getSac28_SpecimenComponent() { 
		CWE retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-29: "Dilution Factor" - creates it if necessary
     */
    public SN getDilutionFactor() { 
		SN retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-29: "Dilution Factor" - creates it if necessary
     */
    public SN getSac29_DilutionFactor() { 
		SN retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-30: "Treatment" - creates it if necessary
     */
    public CWE getTreatment() { 
		CWE retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-30: "Treatment" - creates it if necessary
     */
    public CWE getSac30_Treatment() { 
		CWE retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-31: "Temperature" - creates it if necessary
     */
    public SN getTemperature() { 
		SN retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-31: "Temperature" - creates it if necessary
     */
    public SN getSac31_Temperature() { 
		SN retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-32: "Hemolysis Index" - creates it if necessary
     */
    public NM getHemolysisIndex() { 
		NM retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-32: "Hemolysis Index" - creates it if necessary
     */
    public NM getSac32_HemolysisIndex() { 
		NM retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-33: "Hemolysis Index Units" - creates it if necessary
     */
    public CWE getHemolysisIndexUnits() { 
		CWE retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-33: "Hemolysis Index Units" - creates it if necessary
     */
    public CWE getSac33_HemolysisIndexUnits() { 
		CWE retVal = this.getTypedField(33, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-34: "Lipemia Index" - creates it if necessary
     */
    public NM getLipemiaIndex() { 
		NM retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-34: "Lipemia Index" - creates it if necessary
     */
    public NM getSac34_LipemiaIndex() { 
		NM retVal = this.getTypedField(34, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-35: "Lipemia Index Units" - creates it if necessary
     */
    public CWE getLipemiaIndexUnits() { 
		CWE retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-35: "Lipemia Index Units" - creates it if necessary
     */
    public CWE getSac35_LipemiaIndexUnits() { 
		CWE retVal = this.getTypedField(35, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-36: "Icterus Index" - creates it if necessary
     */
    public NM getIcterusIndex() { 
		NM retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-36: "Icterus Index" - creates it if necessary
     */
    public NM getSac36_IcterusIndex() { 
		NM retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-37: "Icterus Index Units" - creates it if necessary
     */
    public CWE getIcterusIndexUnits() { 
		CWE retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-37: "Icterus Index Units" - creates it if necessary
     */
    public CWE getSac37_IcterusIndexUnits() { 
		CWE retVal = this.getTypedField(37, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-38: "Fibrin Index" - creates it if necessary
     */
    public NM getFibrinIndex() { 
		NM retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-38: "Fibrin Index" - creates it if necessary
     */
    public NM getSac38_FibrinIndex() { 
		NM retVal = this.getTypedField(38, 0);
		return retVal;
    }



    /**
     * Returns
     * SAC-39: "Fibrin Index Units" - creates it if necessary
     */
    public CWE getFibrinIndexUnits() { 
		CWE retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-39: "Fibrin Index Units" - creates it if necessary
     */
    public CWE getSac39_FibrinIndexUnits() { 
		CWE retVal = this.getTypedField(39, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of System Induced Contaminants (SAC-40).
     */
    public CWE[] getSystemInducedContaminants() {
    	CWE[] retVal = this.getTypedField(40, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of System Induced Contaminants (SAC-40).
     */
    public CWE[] getSac40_SystemInducedContaminants() {
    	CWE[] retVal = this.getTypedField(40, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of System Induced Contaminants (SAC-40).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSystemInducedContaminantsReps() {
    	return this.getReps(40);
    }


    /**
     * Returns a specific repetition of
     * SAC-40: "System Induced Contaminants" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSystemInducedContaminants(int rep) { 
		CWE retVal = this.getTypedField(40, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SAC-40: "System Induced Contaminants" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSac40_SystemInducedContaminants(int rep) { 
		CWE retVal = this.getTypedField(40, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of System Induced Contaminants (SAC-40).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSac40_SystemInducedContaminantsReps() {
    	return this.getReps(40);
    }


    /**
     * Inserts a repetition of
     * SAC-40: "System Induced Contaminants" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSystemInducedContaminants(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(40, rep);
    }


    /**
     * Inserts a repetition of
     * SAC-40: "System Induced Contaminants" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSac40_SystemInducedContaminants(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(40, rep);
    }


    /**
     * Removes a repetition of
     * SAC-40: "System Induced Contaminants" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSystemInducedContaminants(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(40, rep);
    }


    /**
     * Removes a repetition of
     * SAC-40: "System Induced Contaminants" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSac40_SystemInducedContaminants(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(40, rep);
    }



    /**
     * Returns all repetitions of Drug Interference (SAC-41).
     */
    public CWE[] getDrugInterference() {
    	CWE[] retVal = this.getTypedField(41, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Drug Interference (SAC-41).
     */
    public CWE[] getSac41_DrugInterference() {
    	CWE[] retVal = this.getTypedField(41, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Drug Interference (SAC-41).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDrugInterferenceReps() {
    	return this.getReps(41);
    }


    /**
     * Returns a specific repetition of
     * SAC-41: "Drug Interference" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getDrugInterference(int rep) { 
		CWE retVal = this.getTypedField(41, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SAC-41: "Drug Interference" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSac41_DrugInterference(int rep) { 
		CWE retVal = this.getTypedField(41, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Drug Interference (SAC-41).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSac41_DrugInterferenceReps() {
    	return this.getReps(41);
    }


    /**
     * Inserts a repetition of
     * SAC-41: "Drug Interference" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertDrugInterference(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(41, rep);
    }


    /**
     * Inserts a repetition of
     * SAC-41: "Drug Interference" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSac41_DrugInterference(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(41, rep);
    }


    /**
     * Removes a repetition of
     * SAC-41: "Drug Interference" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeDrugInterference(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(41, rep);
    }


    /**
     * Removes a repetition of
     * SAC-41: "Drug Interference" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSac41_DrugInterference(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(41, rep);
    }




    /**
     * Returns
     * SAC-42: "Artificial Blood" - creates it if necessary
     */
    public CWE getArtificialBlood() { 
		CWE retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SAC-42: "Artificial Blood" - creates it if necessary
     */
    public CWE getSac42_ArtificialBlood() { 
		CWE retVal = this.getTypedField(42, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Special Handling Code (SAC-43).
     */
    public CWE[] getSpecialHandlingCode() {
    	CWE[] retVal = this.getTypedField(43, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Special Handling Code (SAC-43).
     */
    public CWE[] getSac43_SpecialHandlingCode() {
    	CWE[] retVal = this.getTypedField(43, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Special Handling Code (SAC-43).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecialHandlingCodeReps() {
    	return this.getReps(43);
    }


    /**
     * Returns a specific repetition of
     * SAC-43: "Special Handling Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpecialHandlingCode(int rep) { 
		CWE retVal = this.getTypedField(43, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SAC-43: "Special Handling Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSac43_SpecialHandlingCode(int rep) { 
		CWE retVal = this.getTypedField(43, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Special Handling Code (SAC-43).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSac43_SpecialHandlingCodeReps() {
    	return this.getReps(43);
    }


    /**
     * Inserts a repetition of
     * SAC-43: "Special Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpecialHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(43, rep);
    }


    /**
     * Inserts a repetition of
     * SAC-43: "Special Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSac43_SpecialHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(43, rep);
    }


    /**
     * Removes a repetition of
     * SAC-43: "Special Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpecialHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(43, rep);
    }


    /**
     * Removes a repetition of
     * SAC-43: "Special Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSac43_SpecialHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(43, rep);
    }



    /**
     * Returns all repetitions of Other Environmental Factors (SAC-44).
     */
    public CWE[] getOtherEnvironmentalFactors() {
    	CWE[] retVal = this.getTypedField(44, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Other Environmental Factors (SAC-44).
     */
    public CWE[] getSac44_OtherEnvironmentalFactors() {
    	CWE[] retVal = this.getTypedField(44, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Other Environmental Factors (SAC-44).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOtherEnvironmentalFactorsReps() {
    	return this.getReps(44);
    }


    /**
     * Returns a specific repetition of
     * SAC-44: "Other Environmental Factors" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOtherEnvironmentalFactors(int rep) { 
		CWE retVal = this.getTypedField(44, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SAC-44: "Other Environmental Factors" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSac44_OtherEnvironmentalFactors(int rep) { 
		CWE retVal = this.getTypedField(44, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Other Environmental Factors (SAC-44).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSac44_OtherEnvironmentalFactorsReps() {
    	return this.getReps(44);
    }


    /**
     * Inserts a repetition of
     * SAC-44: "Other Environmental Factors" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOtherEnvironmentalFactors(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(44, rep);
    }


    /**
     * Inserts a repetition of
     * SAC-44: "Other Environmental Factors" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSac44_OtherEnvironmentalFactors(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(44, rep);
    }


    /**
     * Removes a repetition of
     * SAC-44: "Other Environmental Factors" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOtherEnvironmentalFactors(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(44, rep);
    }


    /**
     * Removes a repetition of
     * SAC-44: "Other Environmental Factors" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSac44_OtherEnvironmentalFactors(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(44, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new EI(getMessage());
          case 3: return new EI(getMessage());
          case 4: return new EI(getMessage());
          case 5: return new SPS(getMessage());
          case 6: return new DTM(getMessage());
          case 7: return new CWE(getMessage());
          case 8: return new CWE(getMessage());
          case 9: return new EI(getMessage());
          case 10: return new NA(getMessage());
          case 11: return new CWE(getMessage());
          case 12: return new EI(getMessage());
          case 13: return new NA(getMessage());
          case 14: return new CWE(getMessage());
          case 15: return new NM(getMessage());
          case 16: return new NM(getMessage());
          case 17: return new NM(getMessage());
          case 18: return new NM(getMessage());
          case 19: return new CWE(getMessage());
          case 20: return new NM(getMessage());
          case 21: return new NM(getMessage());
          case 22: return new NM(getMessage());
          case 23: return new CWE(getMessage());
          case 24: return new CWE(getMessage());
          case 25: return new CWE(getMessage());
          case 26: return new CWE(getMessage());
          case 27: return new CWE(getMessage());
          case 28: return new SN(getMessage());
          case 29: return new CWE(getMessage());
          case 30: return new SN(getMessage());
          case 31: return new NM(getMessage());
          case 32: return new CWE(getMessage());
          case 33: return new NM(getMessage());
          case 34: return new CWE(getMessage());
          case 35: return new NM(getMessage());
          case 36: return new CWE(getMessage());
          case 37: return new NM(getMessage());
          case 38: return new CWE(getMessage());
          case 39: return new CWE(getMessage());
          case 40: return new CWE(getMessage());
          case 41: return new CWE(getMessage());
          case 42: return new CWE(getMessage());
          case 43: return new CWE(getMessage());
          default: return null;
       }
   }


}

