package ca.uhn.hl7v2.parser;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class NonStandardStructureDefinition implements IStructureDefinition {

	private IStructureDefinition myParent;
	private String myName;
	private IStructureDefinition myPreviousSibling;
	private int myPosition;

	public NonStandardStructureDefinition(IStructureDefinition theParent, IStructureDefinition thePreviousSibling, String theName, int thePosition) {
		myParent = theParent;
		myName = theName;
		myPreviousSibling = thePreviousSibling;
		myPosition = thePosition;
	}
	
//	public IStructureDefinition getLastStandardSibling() {
//		if (myPreviousSibling instanceof NonStandardStructureDefinition) {
//			return ((NonStandardStructureDefinition)myPreviousSibling).getLastStandardSibling();
//		}
//		return myPreviousSibling;
//	}
//	
	
	public Set<String> getAllChildNames() {
		return Collections.emptySet();
	}

	
	public Set<String> getAllPossibleFirstChildren() {
		return Collections.emptySet();
	}

	
	public List<StructureDefinition> getChildren() {
		return Collections.emptyList();
	}

	
	public IStructureDefinition getFirstChild() {
		return null;
	}

	
	public IStructureDefinition getFirstSibling() {
		return null;
	}

	
	public String getName() {
		return myName;
	}

	
	public Set<String> getNamesOfAllPossibleFollowingLeaves() {
		return myPreviousSibling.getNamesOfAllPossibleFollowingLeaves();
	}

	
	public IStructureDefinition getNextLeaf() {
		return myPreviousSibling.getNextLeaf();
	}

	
	public IStructureDefinition getNextSibling() {
		return myPreviousSibling.getNextSibling();
	}

	
	public IStructureDefinition getParent() {
		return myParent;
	}

	
	public int getPosition() {
		return myPosition;
	}

	
	public boolean hasChildren() {
		return false;
	}

	
	public boolean isFinalChildOfParent() {
		return myPreviousSibling.isFinalChildOfParent();
	}

	
	public boolean isRepeating() {
		return true;
	}

	
	public boolean isRequired() {
		return false;
	}

	
	public boolean isSegment() {
		return true;
	}

}
