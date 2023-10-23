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


package ca.uhn.hl7v2.model.v28.segment;

// import ca.uhn.hl7v2.model.v28.group.*;
import ca.uhn.hl7v2.model.v28.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 SFT message segment (Software Segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>SFT-1: Software Vendor Organization (XON) <b> </b>
     * <li>SFT-2: Software Certified Version or Release Number (ST) <b> </b>
     * <li>SFT-3: Software Product Name (ST) <b> </b>
     * <li>SFT-4: Software Binary ID (ST) <b> </b>
     * <li>SFT-5: Software Product Information (TX) <b>optional </b>
     * <li>SFT-6: Software Install Date (DTM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class SFT extends AbstractSegment {

    /** 
     * Creates a new SFT segment
     */
    public SFT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(XON.class, true, 1, 0, new Object[]{ getMessage() }, "Software Vendor Organization");
                                  this.add(ST.class, true, 1, 0, new Object[]{ getMessage() }, "Software Certified Version or Release Number");
                                  this.add(ST.class, true, 1, 0, new Object[]{ getMessage() }, "Software Product Name");
                                  this.add(ST.class, true, 1, 0, new Object[]{ getMessage() }, "Software Binary ID");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "Software Product Information");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Software Install Date");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SFT - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * SFT-1: "Software Vendor Organization" - creates it if necessary
     */
    public XON getSoftwareVendorOrganization() { 
		XON retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SFT-1: "Software Vendor Organization" - creates it if necessary
     */
    public XON getSft1_SoftwareVendorOrganization() { 
		XON retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * SFT-2: "Software Certified Version or Release Number" - creates it if necessary
     */
    public ST getSoftwareCertifiedVersionOrReleaseNumber() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SFT-2: "Software Certified Version or Release Number" - creates it if necessary
     */
    public ST getSft2_SoftwareCertifiedVersionOrReleaseNumber() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * SFT-3: "Software Product Name" - creates it if necessary
     */
    public ST getSoftwareProductName() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SFT-3: "Software Product Name" - creates it if necessary
     */
    public ST getSft3_SoftwareProductName() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * SFT-4: "Software Binary ID" - creates it if necessary
     */
    public ST getSoftwareBinaryID() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SFT-4: "Software Binary ID" - creates it if necessary
     */
    public ST getSft4_SoftwareBinaryID() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * SFT-5: "Software Product Information" - creates it if necessary
     */
    public TX getSoftwareProductInformation() { 
		TX retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SFT-5: "Software Product Information" - creates it if necessary
     */
    public TX getSft5_SoftwareProductInformation() { 
		TX retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * SFT-6: "Software Install Date" - creates it if necessary
     */
    public DTM getSoftwareInstallDate() { 
		DTM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SFT-6: "Software Install Date" - creates it if necessary
     */
    public DTM getSft6_SoftwareInstallDate() { 
		DTM retVal = this.getTypedField(6, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new XON(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new TX(getMessage());
          case 5: return new DTM(getMessage());
          default: return null;
       }
   }


}

