/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "SegmentElement.java".  Description: 
"A structure for storing a single data element of a segment .." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.sourcegen;

/**
 * A structure for storing a single data element of a segment ... 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public class SegmentElement  {

    public int field;
    public String rep;
    public int repetitions;
    public String desc;
    public int length;
    public int table;
    public String opt;
    public String type;
    private String myVersion;
    private String mySegmentName;
    private int myIndexWithinSegment;

    /** Creates new SegmentElement */
    public SegmentElement(String theSegmentName, String theVersion, int theIndexWithinSegment) {
        mySegmentName = theSegmentName;
        myVersion = theVersion;
        myIndexWithinSegment = theIndexWithinSegment;
    }

    public boolean isRequired() {
        return "R".equalsIgnoreCase(opt);
    }
    
    public boolean isRepeating() {
        return repetitions != 1;
    }
    
    public String getType() {
        return type;
    }

    public String getAlternateType() {
        return SourceGenerator.getAlternateType(type, myVersion);
    }
    
    public boolean isIdType() {
        return (type.equals("ID") || type.equals("IS"));
    }
    
    public int getField() {
        return field;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public String getDesc() {
        return desc;
    }

    public int getLength() {
        return length;
    }

    public int getTable() {
        return table;
    }

    public String getAccessorName() {
        return SourceGenerator.makeAccessorName(desc, mySegmentName);
    }

    public String getAlternateAccessorName() {
        return SourceGenerator.makeAlternateAccessorName(desc, mySegmentName, myIndexWithinSegment);
    }
}
