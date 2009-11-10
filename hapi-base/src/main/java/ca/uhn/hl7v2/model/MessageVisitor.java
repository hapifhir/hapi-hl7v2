/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uhn.hl7v2.model;

import java.util.List;

/**
 *
 * @author t3903uhn
 */
public interface MessageVisitor {

	void startGroup(List<Structure> thePathToGroup, AbstractGroup theGroup);

	void endGroup(List<Structure> thePathToGroup, AbstractGroup theGroup);

	void startSegment(List<Structure> thePathToGroup, AbstractSegment theSegment);

	void endSegment(List<Structure> thePathToGroup, AbstractSegment theSegment);

	void value(AbstractSegment theSegment, int theFieldNum, Type theDataType);

}
