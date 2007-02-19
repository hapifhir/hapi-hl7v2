/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DBTableRepository.java".  Description: 
"Implements TableRepository by looking up values from the default HL7
  normative database" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): James Agnew
				Paul Brohman
				Mitch Delachevrotiere
				Shawn Dyck
				Cory Metcalf
  				
Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  ?GPL?), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/
package ca.uhn.hl7v2.conf.classes.generator.builders;

import java.util.regex.Pattern;

import ca.uhn.hl7v2.conf.spec.message.*;
import ca.uhn.hl7v2.conf.classes.generator.genclasses.*;
import ca.uhn.hl7v2.conf.spec.*;

/** This Class contains some of the Documentation for the Class to be generated
 * @author <table><tr>James Agnew</tr>
 *                 <tr>Paul Brohman</tr>
 *                 <tr>Mitch Delachevrotiere</tr>
 *                 <tr>Shawn Dyck</tr>
 * 				   <tr>Cory Metcalf</tr></table>
 */
public final class DocumentationBuilder {

	private static DocumentationBuilder documentationBuilder;

	/** Returns the singleton instance of the DocumentationBuilder
	 * @return the singleton instance of the DocumentationBuilder
	 */
	public static DocumentationBuilder getDocumentationBuilder() {
		if (documentationBuilder == null)
			documentationBuilder = new DocumentationBuilder();

		return documentationBuilder;
	}

	/** Default Constructor */
	private DocumentationBuilder() {
	}

	/** Adds a label and it data value to GeneratedClass Comments in a table format
	 * @param genClass a GeneratedConformanceContainer
	 * @param label optional comment label to add to the class header document table
	 * @param data the data value to add to the class header document table
	 */
	private void addOptionalComment(
		GeneratedConformanceContainer genClass,
		String label,
		String data) {
		if (data != null && data != "")
			genClass.addClassComment(
				"   <tr><td>" + label + "</td><td>" + data + "</td></tr>");
	}

	/** Adds a label and it data value to Primitive GeneratedClass Comments in a table format
	 * @param genClass a GeneratedPrimitive
	 * @param label optional comment label to add to the class header document table
	 * @param data the data value to add to the class header document table
	 */
	private void addOptionalComment(
		GeneratedPrimitive genClass,
		String label,
		String data) {
		if (data != null && data != "")
			genClass.addClassComment(
				"   <tr><td>" + label + "</td><td>" + data + "</td></tr>");
	}

	/** Adds a table of comments to a Generated Component Class
	 * @param genClass a GeneratedConformanceContainer
	 * @param comp the component for which the comments are being added to
	 */
	public void decorateComponent(
		GeneratedConformanceContainer genClass,
		Component comp) {
		genClass.addClassComment(
			"This class contains and provides access to all SubComponents");
		genClass.addClassComment("<table>");
		addOptionalComment(genClass, "Name", comp.getName());
		addOptionalComment(genClass, "Usage", comp.getUsage());
		addOptionalComment(genClass, "Data Type", comp.getDatatype());
		addOptionalComment(genClass, "Constant Value", comp.getConstantValue());
		addOptionalComment(genClass, "Description", comp.getDescription());
		addOptionalComment(genClass, "Implementation Note", comp.getImpNote());
		addOptionalComment(genClass, "Predicate", comp.getPredicate());
		addOptionalComment(genClass, "Reference", comp.getReference());
		addOptionalComment(genClass, "Length", comp.getLength() + "");
		if (comp.getLength() != 0)
			addOptionalComment(genClass, "Table", comp.getTable() + "");
		genClass.addClassComment("</table>");
	}

	/** Adds a table of comments to a Conformance Message Class
	 * @param genClass a GeneratedConformanceMessage
	 * @param runtimeProfile the runtimeProfile for which the comments are being added to
	 */
	public void decorateConformanceMessage(
		GeneratedConformanceMessage genClass,
		RuntimeProfile runtimeProfile) {
		genClass.addToClassComments(
			"This class is the primary access class for the HL7 "
				+ runtimeProfile.getHL7Version()
				+ " "
				+ runtimeProfile.getMessage().getMsgType()
				+ " Conformance");
		genClass.addToClassComments(
			"Class Set. This message has the following attributes:<br>");
		genClass.addToClassComments("<table>");
		genClass.addToClassComments(
			"<tr><td>Message Type</td><td>"
				+ runtimeProfile.getMessage().getMsgType()
				+ "</td></tr>");
		genClass.addToClassComments(
			"<tr><td>Event Type</td><td>"
				+ runtimeProfile.getMessage().getEventType()
				+ "</td></tr>");
		genClass.addToClassComments(
			"<tr><td>HL7 Version</td><td>"
				+ runtimeProfile.getHL7Version()
				+ "</td></tr>");
		genClass.addToClassComments("</table><br><br>");
		genClass.addToClassComments("<b>Purpose</b><br>");
		genClass.addToClassComments(runtimeProfile.getMessage().getEventDesc());
	}

	/** Adds Class Comments to a getMaxLength method
	 * @param genMethod the Generated Method to add the constant value comments to
	 */
	public void decorateConstantValue(GeneratedMethod genMethod) {
		genMethod.addToDescription(
			"Returns the constant value associated with this Data Type");
		genMethod.addToComments(
			"@return the constant value associated with this Data Type, or <code>null</code> if there is none");

	}

	/** Adds comments to a generated constructor
	 * @param constructor a constructor to add comments to
	 * @param msg the message
	 */
	public void decorateConstructor(GeneratedMethod constructor, String className) {
		constructor.addToDescription("Default constructor for Conformance_HL7_" + className + ". Has the");
		constructor.addToDescription("following functions:");
		constructor.addToDescription("<ul><li>Instantiating all required Conformance Classes in the structure");
		constructor.addToDescription("    <li>Instantiating the underlying HAPI Message object");
		constructor.addToDescription("    <li>Populating any constant values");
		constructor.addToDescription("</ul>");

	}

	/** Adds Class Comments to a Generated Field Class
	 * @param genClass a GeneratedConformanceContainer
	 * @param field the field for which the comments are being added to
	 */
	public void decorateField(
		GeneratedConformanceContainer genClass,
		Field field) {
		genClass.addClassComment(
			"This represents a constrained "
				+ field.getName()
				+ " field, with the following proerties:");
		genClass.addClassComment("<table>");
		addOptionalComment(genClass, "Name", field.getName());
		addOptionalComment(genClass, "Usage", field.getUsage());
		addOptionalComment(genClass, "Description", field.getDescription());
		addOptionalComment(genClass, "Implementation Note", field.getImpNote());
		addOptionalComment(genClass, "Predicate", field.getPredicate());
		addOptionalComment(genClass, "Reference", field.getReference());
		addOptionalComment(
			genClass,
			"Minimum Repetitions ",
			field.getMin() + "");
		addOptionalComment(
			genClass,
			"Maximum Repetitions ",
			field.getMax() + "");
		genClass.addClassComment("</table>");
	}

	/** Adds Class Comments to a getMaxLength method
	 * @param genMethod a GeneratedMethod
	 */
	public void decorateMaxLength(GeneratedMethod genMethod) {
		genMethod.addToDescription(
			"Returns the Maximum allowable length for the Data Type");
		genMethod.addToComments(
			"@return the maximum allowable length of the Data Type");

	}

	/** Adds Class Comments to a Maximum Repition Method
	 * @param genClass a GeneratedConformanceContainer
	 * @param genMethod the GeneratedMethod for which the comments are being added to
	 */
	public void decorateMaxReps(GeneratedMethod genMethod) {

		genMethod.addToDescription("This method returns the maximum allowable");
		genMethod.addToComments("repetitions of this object.");
		genMethod.addToComments("@return maximum allowable repetitions");

	}

	/** Adds Class Comments to a Minimum Repition Method
	 * @param genClass a GeneratedConformanceContainer
	 * @param genMethod the GeneratedMethod for which the comments are being added to
	 */
	public void decorateMinReps(GeneratedMethod genMethod) {

		genMethod.addToDescription("This method returns the minimum allowable");
		genMethod.addToComments("repetitions of this object.");
		genMethod.addToComments("@return minimum allowable repetitions");

	}

	/** Adds Class Comments to a Generated Primitive Class
	 * @param genClass a GeneratedConformanceContainer
	 * @param ac the AbstractComponent for which the comments are being added to
	 */
	public void decoratePrimitive(
		GeneratedPrimitive genClass,
		AbstractComponent ac) {
		genClass.addClassComment(
			"This represents a constrained "
				+ ac.getName()
				+ " field, with the following properties:");
		genClass.addClassComment("<table>");
		addOptionalComment(genClass, "Name", ac.getName());
		addOptionalComment(genClass, "Usage", ac.getUsage());
		addOptionalComment(genClass, "Data Type", ac.getDatatype());
		addOptionalComment(genClass, "Constant Value", ac.getConstantValue());
		addOptionalComment(genClass, "Description", ac.getDescription());
		addOptionalComment(genClass, "Implementation Note", ac.getImpNote());
		addOptionalComment(genClass, "Predicate", ac.getPredicate());
		addOptionalComment(genClass, "Reference", ac.getReference());
		addOptionalComment(genClass, "Length", ac.getLength() + "");
		if (ac.getTable() != null && Pattern.matches("[^0]", ac.getTable()))
			addOptionalComment(genClass, "Table", ac.getTable() + "");
		genClass.addClassComment("</table>");
	}

	/** Adds Class Comments to a Generated Class
	 * @param genClass a GeneratedConformanceContainer
	 * @param ps the Profile Structure for which the comments are being added to
	 */
	public void decorateProfileStructure(
		GeneratedConformanceContainer genClass,
		ProfileStructure ps) {
		genClass.addClassComment(
			"This represents a constrained "
				+ ps.getName()
				+ " segment, with the following properties:");
		genClass.addClassComment("<table>");
		addOptionalComment(genClass, "Name", ps.getName());
		addOptionalComment(genClass, "Usage", ps.getUsage());
		addOptionalComment(genClass, "Description", ps.getDescription());
		addOptionalComment(genClass, "Implementation Note", ps.getImpNote());
		addOptionalComment(genClass, "Predicate", ps.getPredicate());
		addOptionalComment(genClass, "Reference", ps.getReference());
		addOptionalComment(genClass, "Minimum Repetitions ", ps.getMin() + "");
		addOptionalComment(genClass, "Maximum Repetitions ", ps.getMax() + "");
		genClass.addClassComment("</table>");
	}

	/** Adds Class Comments to a Generated Method
	 * @param genMethod a GeneratedRepGetter
	 * @param field the field for which the comments are being added to
	 * @param repType the repetition Type
	 */
	public void decorateRepGetter(
		GeneratedRepGetter genMethod,
		Field field,
		String repType) {

		genMethod.addToDescription(
			"This method returns a reference to the "
				+ field.getName()
				+ " field belonging to this segment.");
		genMethod.addToComments("Min Repetitions " + field.getMin());
		genMethod.addToComments("Max Repetitions " + field.getMax());
		if (field.getMax() == -1)
			genMethod.addToComments("@param rep The desired repetition number");
		genMethod.addToComments(
			"@return the child object reference. <b>rep must fall between "
				+ field.getMin()
				+ " and "
				+ field.getMax()
				+ "</b>");
		genMethod.addToComments(
			"@throws ca.uhn.hl7v2.conf.classes.exceptions.ConfRepException");

	}

	/** Adds Class Comments to a Generated Method
	 * @param genMethod a GeneratedRepGetter
	 * @param profileStructure the Profile Structure for which the comments are being added to
	 * @param repType the repetition Type
	 */
	public void decorateRepGetter(
		GeneratedRepGetter genMethod,
		ProfileStructure profileStructure,
		String repType) {

		genMethod.addToDescription(
			"This method returns a reference to the "
				+ profileStructure.getName()
				+ " child.");
		genMethod.addToComments("Min Repetitions" + profileStructure.getMin());
		genMethod.addToComments("Max Repetitions" + profileStructure.getMax());
		if (profileStructure.getMax() == -1)
			genMethod.addToComments("@param rep The desired repetition number");
		genMethod.addToComments(
			"@return the child object reference. <b>rep must fall between "
				+ profileStructure.getMin()
				+ " and "
				+ profileStructure.getMax()
				+ "</b>");
		genMethod.addToComments(
			"@throws ca.uhn.hl7v2.conf.classes.exceptions.ConfRepException");

	}

	/** Adds Class Comments to a Generated SegGroup Class
	 * @param genClass a GeneratedConformanceContainer
	 * @param segGroup the SegGroup for which the comments are being added to
	 */
	public void decorateSegGroup(
		GeneratedConformanceContainer genClass,
		SegGroup segGroup) {
		this.decorateProfileStructure(genClass, segGroup);
	}

	/** Adds Class Comments to a Generated Segment Class
	 * @param genClass a GeneratedConformanceContainer
	 * @param seg the Segment for which the comments are being added to
	 */
	public void decorateSegment(
		GeneratedConformanceContainer genClass,
		Seg seg) {
		this.decorateProfileStructure(genClass, seg);
	}

	public void decorateSetValue(GeneratedMethod genMethod, long maxLength) {
		genMethod.addToDescription(
			"This method validates the <code>String</code> value passed in to be no greater then the");
		genMethod.addToDescription(
			"maximum allowable length for the extending class.  If the <code>String</code> value is valid, this");
		genMethod.addToDescription(
			"method will set the underlying HAPI class's value. If the data passed in is invalid for the given");
		genMethod.addToDescription(
			"data type, a ConformanceException is thrown.");
		genMethod.addToDescription(
			"@throws ConfDataException if the data is invalid for the given datatype");
		//TODO: this probably isn't the right exception type
		genMethod.addToDescription("@param value The value to be set.");
		if (maxLength > 0)
			genMethod.addToDescription(
				"Note: The value has a maximum length of " + maxLength);
	}

	/** Contains the License agreement for the Generated Classes
	 * @return Generated Class Lincense agreement
	 */
	public String getGeneratedClassHeader() {
		return (
			"/**\n"
				+ "The following code was automatically genearated by the Conformance Class Generation System\n"
				+ "Contributor(s):The Conformance Class Generation System was developed by\n"
				+ "                --------------.:JH6 Solutions:.--------------\n"
				+ "                James Agnew - jait214@yahoo.ca\n"
				+ "                Paul Brohman - pbrohman@rogers.com\n"
				+ "                Mitch Delachevrotiere - hapimgd@hotmail.com\n"
				+ "                Shawn Dyck - sdyck613@yahoo.ca\n"
				+ "                Cory Metcalf - cory_metcalf@hotmail.com\n"
				+ "\n"
				+ "*/");
	}

}