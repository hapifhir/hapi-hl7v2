/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "".  Description:
 * ""
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2005.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.model.primitive;

import ca.uhn.hl7v2.model.AbstractPrimitive;
import ca.uhn.hl7v2.model.Message;

/**
 * Base class for a textual datatype such as FT, TX, ST.
 * 
 * @author James Agnew
 */
public abstract class AbstractTextPrimitive extends AbstractPrimitive {

	/**
	 * Constructor
	 */
	public AbstractTextPrimitive(Message theMessage) {
		super(theMessage);
	}

	/**
	 * <p>
	 * Returns the value of this type with HL7 defined formatting codes replaced
	 * by their HTML equivalent.
	 * </p>
	 * <p>
	 * For example, if this type contained the string:<br>
	 * 
	 * <pre>
	 * ABC \.ce\MIDDLE\.br\
	 * </pre>
	 * 
	 * <br>
	 * This would be returned as:<br>
	 * 
	 * <pre>
	 * ABC &lt;center&gt;MIDDLE&lt;center&gt;&lt;br&gt;
	 * </pre>
	 * 
	 * </p>
	 * <p>
	 * The following codes are handled (note that contrary to the HL7
	 * specification, codes are interpreted in a case-insensitive manner):
	 * <ul>
	 * <li><b>\.br\</b> (converted to &lt;br&gt;)
	 * <li><b>\.ce\</b> (converted to &lt;center&gt;)
	 * <li><b>\.sk\</b> (converted to &amp;nbsp;)
	 * <li><b>\.sp\</b> (converted to &lt;br&gt; and then multiple &amp;nbsp;)
	 * <li><b>\.sp ###\</b> (converted to multiple &lt;br&gt; and then multiple
	 * &amp;nbsp;)
	 * <li><b>\.fi\</b> (cancels \.nf\)
	 * <li><b>\.nf\</b> (converted to &lt;nobr&gt; ... &lt;/nobr&gt; around each line)
	 * <li><b>\.in ###\</b> (converted to &lt;div style="margin-left: ###em;"&gt; ...
	 * &lt;/div&gt; around each line)
	 * <li><b>\.ti ###\</b> (treated the same as \.in ###\ but only affects the current
	 * line, and the numeric value is added to the value provided by \.in ###\.
	 * See section 2.7 of the HL7 specification for more details.)
	 * <li><b>\H\</b> (converted to &lt;b&gt;)
	 * <li><b>\N\</b> (converted to &lt;/b&gt;)
	 * <li><b>Ampersands (&amp;)</b> are converted to their HTML equivalent (&amp;amp;)
	 * <li><b>Chars over ASCII 160</b> are HTML encoded (e.g. &amp;#199;)
	 * </ul>
	 * </p>
	 * <p>
	 * Note that the returned value from this method is an HTML snippet, not a
	 * complete HTML document.
	 * </p>
	 */
	public String getValueAsHtml() {
		return FormattedTextEncoder.getInstanceHtml().encode(getValue());
	}

}
