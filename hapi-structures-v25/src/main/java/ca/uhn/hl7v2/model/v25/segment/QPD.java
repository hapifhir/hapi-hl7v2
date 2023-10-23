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


package ca.uhn.hl7v2.model.v25.segment;

// import ca.uhn.hl7v2.model.v25.group.*;
import ca.uhn.hl7v2.model.v25.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 QPD message segment (Query Parameter Definition). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>QPD-1: Message Query Name (CE) <b> </b>
     * <li>QPD-2: Query Tag (ST) <b>optional </b>
     * <li>QPD-3: User Parameters (in successive fields) (Varies) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class QPD extends AbstractSegment {

    /** 
     * Creates a new QPD segment
     */
    public QPD(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Message Query Name");
                                  this.add(ST.class, false, 1, 32, new Object[]{ getMessage() }, "Query Tag");
                                  this.add(Varies.class, false, 1, 256, new Object[]{ getMessage() }, "User Parameters (in successive fields)");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating QPD - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * QPD-1: "Message Query Name" - creates it if necessary
     */
    public CE getMessageQueryName() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QPD-1: "Message Query Name" - creates it if necessary
     */
    public CE getQpd1_MessageQueryName() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * QPD-2: "Query Tag" - creates it if necessary
     */
    public ST getQueryTag() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QPD-2: "Query Tag" - creates it if necessary
     */
    public ST getQpd2_QueryTag() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * QPD-3: "User Parameters (in successive fields)" - creates it if necessary
     */
    public Varies getUserParametersInsuccessivefields() { 
		Varies retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QPD-3: "User Parameters (in successive fields)" - creates it if necessary
     */
    public Varies getQpd3_UserParametersInsuccessivefields() { 
		Varies retVal = this.getTypedField(3, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CE(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new Varies(getMessage());
          default: return null;
       }
   }


}

