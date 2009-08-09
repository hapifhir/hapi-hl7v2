package ca.uhn.hl7v2.parser.ng;

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
	@Override
	public Set<String> getAllChildNames() {
		return Collections.emptySet();
	}

	@Override
	public Set<String> getAllPossibleFirstChildren() {
		return Collections.emptySet();
	}

	@Override
	public List<StructureDefinition> getChildren() {
		return Collections.emptyList();
	}

	@Override
	public IStructureDefinition getFirstChild() {
		return null;
	}

	@Override
	public IStructureDefinition getFirstSibling() {
		return null;
	}

	@Override
	public String getName() {
		return myName;
	}

	@Override
	public Set<String> getNamesOfAllPossibleFollowingLeaves() {
		return myPreviousSibling.getNamesOfAllPossibleFollowingLeaves();
	}

	@Override
	public IStructureDefinition getNextLeaf() {
		return myPreviousSibling.getNextLeaf();
	}

	@Override
	public IStructureDefinition getNextSibling() {
		return myPreviousSibling.getNextSibling();
	}

	@Override
	public IStructureDefinition getParent() {
		return myParent;
	}

	@Override
	public int getPosition() {
		return myPosition;
	}

	@Override
	public boolean hasChildren() {
		return false;
	}

	@Override
	public boolean isFinalChildOfParent() {
		return myPreviousSibling.isFinalChildOfParent();
	}

	@Override
	public boolean isRepeating() {
		return true;
	}

	@Override
	public boolean isRequired() {
		return false;
	}

	@Override
	public boolean isSegment() {
		return true;
	}

}
