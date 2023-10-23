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


package ca.uhn.hl7v2.model.v27.segment;

// import ca.uhn.hl7v2.model.v27.group.*;
import ca.uhn.hl7v2.model.v27.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 QAK message segment (Query Acknowledgment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>QAK-1: Query Tag (ST) <b>optional </b>
     * <li>QAK-2: Query Response Status (ID) <b>optional </b>
     * <li>QAK-3: Message Query Name (CWE) <b>optional </b>
     * <li>QAK-4: Hit Count Total (NM) <b>optional </b>
     * <li>QAK-5: This payload (NM) <b>optional </b>
     * <li>QAK-6: Hits remaining (NM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class QAK extends AbstractSegment {

    /** 
     * Creates a new QAK segment
     */
    public QAK(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Query Tag");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(208) }, "Query Response Status");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Message Query Name");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Hit Count Total");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "This payload");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Hits remaining");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating QAK - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * QAK-1: "Query Tag" - creates it if necessary
     */
    public ST getQueryTag() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QAK-1: "Query Tag" - creates it if necessary
     */
    public ST getQak1_QueryTag() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * QAK-2: "Query Response Status" - creates it if necessary
     */
    public ID getQueryResponseStatus() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QAK-2: "Query Response Status" - creates it if necessary
     */
    public ID getQak2_QueryResponseStatus() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * QAK-3: "Message Query Name" - creates it if necessary
     */
    public CWE getMessageQueryName() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QAK-3: "Message Query Name" - creates it if necessary
     */
    public CWE getQak3_MessageQueryName() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * QAK-4: "Hit Count Total" - creates it if necessary
     */
    public NM getHitCountTotal() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QAK-4: "Hit Count Total" - creates it if necessary
     */
    public NM getQak4_HitCountTotal() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * QAK-5: "This payload" - creates it if necessary
     */
    public NM getThisPayload() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QAK-5: "This payload" - creates it if necessary
     */
    public NM getQak5_ThisPayload() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * QAK-6: "Hits remaining" - creates it if necessary
     */
    public NM getHitsRemaining() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QAK-6: "Hits remaining" - creates it if necessary
     */
    public NM getQak6_HitsRemaining() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new ID(getMessage(), new Integer( 208 ));
          case 2: return new CWE(getMessage());
          case 3: return new NM(getMessage());
          case 4: return new NM(getMessage());
          case 5: return new NM(getMessage());
          default: return null;
       }
   }


}

