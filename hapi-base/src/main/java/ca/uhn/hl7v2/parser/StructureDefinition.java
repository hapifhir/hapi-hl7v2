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

	private IStructureDefinition myParent;

	private String myName;
	private boolean myIsSegment;
	private boolean myIsRepeating;
	private boolean myIsRequired;
	private int myPosition;
	private Boolean myIsFinalChildOfParent;
	private ArrayList<StructureDefinition> myChildren = new ArrayList<StructureDefinition>();
	private HashSet<String> myAllChildrenNames;
	private HashSet<String> myAllFirstLeafNames;
	private IStructureDefinition myNextSibling;
	private IStructureDefinition myFirstSibling;
	private IStructureDefinition myNextLeaf;
	private boolean myFirstSiblingIsSet;

	private Set<String> myNamesOfAllPossibleFollowingLeaves;

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#getFirstSibling()
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

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#getNextLeaf()
	 */
	public IStructureDefinition getNextLeaf() {
		return myNextLeaf;
	}

	public void setNextLeaf(IStructureDefinition theNextLeaf) {
		myNextLeaf = theNextLeaf;
	}

	/**
	 * Constructor
	 */
	public StructureDefinition() {
	}

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#getName()
	 */
	public String getName() {
		return myName;
	}

	public void setName(String theName) {
		myName = theName;
	}

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#isSegment()
	 */
	public boolean isSegment() {
		return myIsSegment;
	}

	public void setSegment(boolean theIsSegment) {
		myIsSegment = theIsSegment;
	}

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#isRepeating()
	 */
	public boolean isRepeating() {
		return myIsRepeating;
	}

	public void setRepeating(boolean theIsRepeating) {
		myIsRepeating = theIsRepeating;
	}

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#getChildren()
	 */
	public ArrayList<StructureDefinition> getChildren() {
		return myChildren;
	}

	public void addChild(StructureDefinition theChild) {
		myChildren.add(theChild);
	}

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#getPosition()
	 */
	public int getPosition() {
		return myPosition;
	}

	public void setPosition(int thePosition) {
		myPosition = thePosition;
	}

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#getParent()
	 */
	public IStructureDefinition getParent() {
		return myParent;
	}

	public void setParent(IStructureDefinition theParent) {
		myParent = theParent;
	}

	@Override
	public boolean equals(Object theObj) {
		if (theObj == null || !(theObj instanceof StructureDefinition)) {
			return false;
		}
		StructureDefinition o = (StructureDefinition) theObj;
		return o.myName.equals(myName) && o.myPosition == myPosition;
	}

	@Override
	public int hashCode() {
		return 17 * myName.hashCode() * myPosition;
	}

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#isFinalChildOfParent()
	 */
	public boolean isFinalChildOfParent() {
		if (myIsFinalChildOfParent != null) {
			return myIsFinalChildOfParent;
		}

		if (myParent == null) {
			myIsFinalChildOfParent = true;
		} else {
			myIsFinalChildOfParent = (myPosition == (myParent.getChildren()
					.size() - 1));
		}

		return myIsFinalChildOfParent;
	}

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#getNextSibling()
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

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#hasChildren()
	 */
	public boolean hasChildren() {
		return myChildren.isEmpty() == false;
	}
	
	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#getNamesOfAllPossibleFollowingLeaves()
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

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#getFirstChild()
	 */
	public IStructureDefinition getFirstChild() {
		return myChildren.get(0);
	}

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#getAllPossibleFirstChildren()
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

	@Override
	public String toString() {
		return getName();
	}

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#getAllChildNames()
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

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.parser.ng.IStructureDefinition#isRequired()
	 */
	public boolean isRequired() {
		return myIsRequired;
	}

	public void setRequired(boolean theIsRequired) {
		myIsRequired = theIsRequired;
	}
}
