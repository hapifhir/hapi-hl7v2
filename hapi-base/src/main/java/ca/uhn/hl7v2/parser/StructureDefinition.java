/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "StructureDefinition.java".  Description: 
"A definition element" 

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
package ca.uhn.hl7v2.parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Defines
 * 
 * @author James
 * 
 */
public class StructureDefinition implements IStructureDefinition {

    private HashSet<String> myAllChildrenNames;
    private HashSet<String> myAllFirstLeafNames;
    private ArrayList<StructureDefinition> myChildren = new ArrayList<StructureDefinition>();
    private IStructureDefinition myFirstSibling;
    private boolean myFirstSiblingIsSet;
    private Boolean myIsFinalChildOfParent;
    private boolean myIsRepeating;
    private boolean myIsRequired;
    private boolean myIsSegment;
    private String myName;
    private String myNameAsItAppearsInParent;
    private Set<String> myNamesOfAllPossibleFollowingLeaves;
    private IStructureDefinition myNextLeaf;
    private IStructureDefinition myNextSibling;
    private IStructureDefinition myParent;
    private int myPosition;


    /**
     * Constructor
     */
    public StructureDefinition() {
    }


    /**
     * Setter
     */
    void addChild(StructureDefinition theChild) {
        myChildren.add(theChild);
    }


    /**
     * {@inheritDoc }
     */
    @Override
    public boolean equals(Object theObj) {
        if (theObj == null || !(theObj instanceof StructureDefinition)) {
            return false;
        }
        StructureDefinition o = (StructureDefinition) theObj;
        return o.myName.equals(myName) && o.myPosition == myPosition;
    }


    /**
     * {@inheritDoc }
     */
    public HashSet<String> getAllChildNames() {
        if (myAllChildrenNames == null) {
            myAllChildrenNames = new HashSet<String>();
            for (IStructureDefinition next : myChildren) {
                myAllChildrenNames.add(next.getName());
                myAllChildrenNames.addAll(next.getAllChildNames());
            }
        }

        return myAllChildrenNames;
    }


    /**
     * {@inheritDoc }
     */
    public HashSet<String> getAllPossibleFirstChildren() {
        if (myAllFirstLeafNames == null) {
            myAllFirstLeafNames = new HashSet<String>();
            for (IStructureDefinition next : myChildren) {
                myAllFirstLeafNames.addAll(next.getAllPossibleFirstChildren());
                if (next.isRequired()) {
                    break;
                }
            }

            myAllFirstLeafNames.add(getName());
        }

        return myAllFirstLeafNames;
    }


    /**
     * {@inheritDoc }
     */
    public ArrayList<StructureDefinition> getChildren() {
        return myChildren;
    }


    /**
     * {@inheritDoc }
     */
    public IStructureDefinition getFirstChild() {
        return myChildren.get(0);
    }


    /**
     * {@inheritDoc }
     */
    public IStructureDefinition getFirstSibling() {
        if (!myFirstSiblingIsSet) {
            if (myParent == null) {
                myFirstSibling = null;
            } else if (myParent.getChildren().get(0) == this) {
                myFirstSibling = null;
            } else {
                myFirstSibling = myParent.getChildren().get(0);
            }
            myFirstSiblingIsSet = true;
        }

        return myFirstSibling;
    }


    /**
     * {@inheritDoc }
     */
    public String getName() {
        return myName;
    }


    /**
     * {@inheritDoc}
     */
    public String getNameAsItAppearsInParent() {
        return myNameAsItAppearsInParent;
    }


    /**
     * {@inheritDoc }
     */
    public Set<String> getNamesOfAllPossibleFollowingLeaves() {
        if (myNamesOfAllPossibleFollowingLeaves != null) {
            return myNamesOfAllPossibleFollowingLeaves;
        }

        myNamesOfAllPossibleFollowingLeaves = new HashSet<String>();

        IStructureDefinition nextLeaf = getNextLeaf();
        if (nextLeaf != null) {
            myNamesOfAllPossibleFollowingLeaves.add(nextLeaf.getName());
            myNamesOfAllPossibleFollowingLeaves.addAll(nextLeaf.getNamesOfAllPossibleFollowingLeaves());
        }

        IStructureDefinition parent = myParent;
        while (parent != null) {
            if (parent.isRepeating()) {
                myNamesOfAllPossibleFollowingLeaves.addAll(parent.getAllPossibleFirstChildren());
            }
            parent = parent.getParent();
        }

        return myNamesOfAllPossibleFollowingLeaves;

    }


    /**
     * {@inheritDoc }
     */
    public IStructureDefinition getNextLeaf() {
        return myNextLeaf;
    }


    /**
     * {@inheritDoc }
     */
    public IStructureDefinition getNextSibling() {
        if (myNextSibling != null) {
            return myNextSibling;
        }

        if (isFinalChildOfParent()) {
            throw new IllegalStateException("Final child");
        }

        myNextSibling = myParent.getChildren().get(myPosition + 1);
        return myNextSibling;
    }


    /**
     * {@inheritDoc }
     */
    public IStructureDefinition getParent() {
        return myParent;
    }


    /**
     * {@inheritDoc }
     */
    public int getPosition() {
        return myPosition;
    }


    /**
     * {@inheritDoc }
     */
    public boolean hasChildren() {
        return myChildren.isEmpty() == false;
    }


    /**
     * {@inheritDoc }
     */
    @Override
    public int hashCode() {
        return 17 * myName.hashCode() * myPosition;
    }


    /**
     * {@inheritDoc }
     */
    public boolean isFinalChildOfParent() {
        if (myIsFinalChildOfParent != null) {
            return myIsFinalChildOfParent;
        }

        if (myParent == null) {
            myIsFinalChildOfParent = true;
        } else {
            myIsFinalChildOfParent = (myPosition == (myParent.getChildren().size() - 1));
        }

        return myIsFinalChildOfParent;
    }


    /**
     * {@inheritDoc }
     */
    public boolean isRepeating() {
        return myIsRepeating;
    }


    /**
     * {@inheritDoc }
     */
    public boolean isRequired() {
        return myIsRequired;
    }


    /**
     * {@inheritDoc }
     */
    public boolean isSegment() {
        return myIsSegment;
    }


    /**
     * Setter
     */
    void setName(String theName) {
        myName = theName;
    }


    /**
     * Setter
     */
    void setNameAsItAppearsInParent(String theName) {
        myNameAsItAppearsInParent = theName;
    }


    /**
     * Setter
     */
    void setNextLeaf(IStructureDefinition theNextLeaf) {
        myNextLeaf = theNextLeaf;
    }


    /**
     * Setter
     */
    void setParent(IStructureDefinition theParent) {
        myParent = theParent;
    }


    /**
     * Setter
     */
    void setPosition(int thePosition) {
        myPosition = thePosition;
    }


    /**
     * Setter
     */
    void setRepeating(boolean theIsRepeating) {
        myIsRepeating = theIsRepeating;
    }


    /**
     * Setter
     */
    void setRequired(boolean theIsRequired) {
        myIsRequired = theIsRequired;
    }


    /**
     * Setter
     */
    void setSegment(boolean theIsSegment) {
        myIsSegment = theIsSegment;
    }


    /**
     * {@inheritDoc }
     */
    @Override
    public String toString() {
        return "StructureDefinition[" + getName() + "]";
    }

}
