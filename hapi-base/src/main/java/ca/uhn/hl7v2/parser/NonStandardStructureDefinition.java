/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "IStructureDefinition.java"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s):
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */

package ca.uhn.hl7v2.parser;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Structure definition which defines a non-standard structure within a parent
 * structure.
 * 
 * This class is used more as a runtime placeholder than as something that would
 * be produced by the structure parser.
 */
public class NonStandardStructureDefinition implements IStructureDefinition {

	private final String myName;
	private final IStructureDefinition myParent;
	private final int myPosition;
	private final IStructureDefinition myPreviousSibling;

	/**
	 * Constructor
	 */
	public NonStandardStructureDefinition(IStructureDefinition theParent, IStructureDefinition thePreviousSibling, String theName, int thePosition) {
		if (theName == null || theName.length() == 0) {
			throw new IllegalArgumentException("theName is missing");
		}
		
		myParent = theParent;
		myName = theName;
		myPreviousSibling = thePreviousSibling;
		myPosition = thePosition;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public Set<String> getAllChildNames() {
		return Collections.emptySet();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
    public Set<String> getAllPossibleFirstChildren() {
		return Collections.emptySet();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public List<StructureDefinition> getChildren() {
		return Collections.emptyList();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public IStructureDefinition getFirstChild() {
		return null;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public IStructureDefinition getFirstSibling() {
		return null;
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
	@Override
	public String getNameAsItAppearsInParent() {
		return getName();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public Set<String> getNamesOfAllPossibleFollowingLeaves() {
		return myPreviousSibling.getNamesOfAllPossibleFollowingLeaves();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public IStructureDefinition getNextLeaf() {
		return myPreviousSibling.getNextLeaf();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public IStructureDefinition getNextSibling() {
		return myPreviousSibling.getNextSibling();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public IStructureDefinition getParent() {
		return myParent;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public int getPosition() {
		return myPosition;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public boolean hasChildren() {
		return false;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public boolean isFinalChildOfParent() {
		return myPreviousSibling.isFinalChildOfParent();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public boolean isRepeating() {
		return true;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public boolean isRequired() {
		return false;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public boolean isSegment() {
		return true;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public boolean isChoiceElement() {
		return false;
	}

}
