/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "TerserMessageRule.java".  Description: 
"Validation rule for checking values extracted by a Terser" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2012.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */
package ca.uhn.hl7v2.validation.builder.support;

import java.util.StringTokenizer;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.Location;
import ca.uhn.hl7v2.validation.builder.Expression;
import ca.uhn.hl7v2.validation.builder.Predicate;
import ca.uhn.hl7v2.validation.builder.PredicateMessageRule;

/**
 * Validation rule for checking values extracted by a {@link Terser}.
 * 
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class TerserMessageRule extends PredicateMessageRule {

	public TerserMessageRule(String terserExpression, Predicate predicate) {
		super(predicate, new TerserExpression(terserExpression));
	}

	private static class TerserExpression implements Expression<Message> {

		private String expression;

		public TerserExpression(String expression) {
			super();
			this.expression = expression;
		}

		public Object evaluate(Message msg) throws HL7Exception {
			return new Terser(msg).get(expression);
		}

		public String getDescription() {
			// Terser Expression is equivalent with Location
			return "";
		}

		public Location getLocation(Message msg) throws HL7Exception {
			Terser t = new Terser(msg);
			StringTokenizer tok = new StringTokenizer(expression, "-", false);
			Segment segment = t.getSegment(tok.nextToken());
			Location location = new Location();
			location.setSegmentName(segment.getName());
			location.setFieldIndizes(Terser.getIndices(expression));
			return location;
		}

	}
}