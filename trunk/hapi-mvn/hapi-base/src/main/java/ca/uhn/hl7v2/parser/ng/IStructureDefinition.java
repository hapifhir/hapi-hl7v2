package ca.uhn.hl7v2.parser.ng;

import java.util.List;
import java.util.Set;

public interface IStructureDefinition {

	/**
	 * @return Returns this structure's first sibling (in other words, its
	 *         parent's first child). Returns
	 *         <code>null<code> if this is the first sibling, or if this has no parent
	 */
	public abstract IStructureDefinition getFirstSibling();

	public abstract IStructureDefinition getNextLeaf();

	public abstract String getName();

	public abstract boolean isSegment();

	public abstract boolean isRepeating();

	public abstract List<StructureDefinition> getChildren();

	public abstract int getPosition();

	public abstract IStructureDefinition getParent();

	public abstract boolean isFinalChildOfParent();

	public abstract IStructureDefinition getNextSibling();

	public abstract boolean hasChildren();

	/**
	 * Should only be called on a leaf node (segment). Returns the names 
	 * of all valid children which may follow this one, at any level in the 
	 * hierarchy (including as later siblings of parent structures to 
	 * this one) 
	 */
	public abstract Set<String> getNamesOfAllPossibleFollowingLeaves();

	/**
	 * May return null
	 * @return
	 */
	public abstract IStructureDefinition getFirstChild();

	/**
	 * Returns the names of any possible children that could be the first
	 * required child of this group.
	 * 
	 * For instance, for the group below "ORC" and "OBR" would both be 
	 * returned, as they are both potential first children of this group.
	 * 
	 * Note that the name returned by {@link #getName() this.getName()} 
	 * is also returned.
	 *   
	 * <code>
	 *               ORDER_OBSERVATION
	 *	  {
	 *	  [ ORC ]
	 *	  OBR
	 *	  [ { NTE } ]
	 *	  [ CTD ]
	 *	                OBSERVATION
	 *	     {
	 *	     [ OBX ]
	 *	     [ { NTE } ]
	 *	     }
	 *	                OBSERVATION
	 *	  [ { FT1 } ]
	 *	  [ { CTI } ]
	 *	  }
	 *	                ORDER_OBSERVATION
	 *	   </code>
	 * 
	 */
	public abstract Set<String> getAllPossibleFirstChildren();

	public abstract Set<String> getAllChildNames();

	public abstract boolean isRequired();

}