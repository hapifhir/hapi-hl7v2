/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "FiniteList.java".  Description: 
"Holds a group of repetitions for a given Profile and exercises cardinality constraints" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): James Agnew
                Paul Brohman
                Mitch Delachevrotiere
                Shawn Dyck
  				Cory Metcalf 
  				
Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/
package ca.uhn.hl7v2.conf.classes.abs;

import ca.uhn.hl7v2.conf.classes.exceptions.*;
import java.lang.reflect.*;
import java.util.ArrayList;

/** Holds a group of repetitions for a given Profile and exercises cardinality constraints
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public class FiniteList {

	private ArrayList<Repeatable> reps; // Stores the reps
	private int maxReps; // The maximum allowable number of reps	
//	private int minReps; // The minimum allowable number of reps	
	private Class<? extends Repeatable> repType; // The type of repetition being stored here
	private Object underlyingObject; // The underlying HAPI object

	/** Constructor for FiniteList
	 * @param repType the Class which is repeating
	 * @param underlyingObject the underlying object that the extending class represents
	 */
	public FiniteList(Class<? extends Repeatable> repType, Object underlyingObject) {
		this.repType = repType;
		this.underlyingObject = underlyingObject;

		Repeatable firstRep = createRep(0);
		this.maxReps = firstRep.getMaxReps();
//		this.minReps = firstRep.getMinReps();

		reps = new ArrayList<Repeatable>();
		reps.add(firstRep);
		createNewReps(maxReps);
	}

	/** Creates a new repetition
	 * @param rep the number representing the number of repetitions
	 */
	private void createNewReps(int rep) {
		while (reps.size() <= rep)
			reps.add(createRep(reps.size()));
	}

	/** Creates the repition
	 * @param rep the number representing which repition
	 */
	private Repeatable createRep(int rep) {
		try {
			Constructor<?> theCon = repType.getConstructors()[0];
			Repeatable thisRep = (Repeatable) theCon.newInstance(new Object[] { underlyingObject, new Integer(rep)});
			return thisRep;
		} catch (InvocationTargetException e) {
			throw new ConformanceError("Error creating underlying repetition. This is a bug.\nError is: " + e.toString() + "\n" + e.getCause().toString());
		} catch (Exception e) {
			throw new ConformanceError("Error creating underlying repetition. This is a bug. Error is: " + e.toString());
		}
	}

	/**
	 * Returns the desired repetition
	 * @param rep The desired repetition number. Note that in accordance with the HL7 standard
	 * @return The desired repetition
	 * @throws ConformanceException if repetition is not accessible
	 */
	public Repeatable getRep(int rep) throws ConfRepException {
		if (rep < 1 || (maxReps != -1 && maxReps < rep))
			throw new ConfRepException(maxReps, rep);

		rep--; // Decremented because HL7 standard wants 1-offset arrays
		createNewReps(rep); // Create new reps if needed

		return reps.get(rep);
	}

}
