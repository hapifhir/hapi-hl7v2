/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is ""  Description:
 * ""
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */
package ca.uhn.hl7v2.testpanel.util;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FontUtil {

	/**
	 * @see http://stackoverflow.com/questions/922052/testing-whether-a-font-is-monospaced-in-java
	 */
	public static List<String> getMonospacedFontNames() {
		
		List<String> monospaceFontFamilyNames = new ArrayList<String>();

		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontFamilyNames = graphicsEnvironment.getAvailableFontFamilyNames();

		BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics graphics = bufferedImage.createGraphics();

		for (String fontFamilyName : fontFamilyNames) {
		    boolean isMonospaced = true;

		    int fontStyle = Font.PLAIN;
		    int fontSize = 12;
		    Font font = new Font(fontFamilyName, fontStyle, fontSize);
		    FontMetrics fontMetrics = graphics.getFontMetrics(font);

		    int firstCharacterWidth = 0;
		    boolean hasFirstCharacterWidth = false;
		    for (int codePoint = 0; codePoint < 128; codePoint++) { 
		        if (Character.isValidCodePoint(codePoint) && (Character.isLetter(codePoint) || Character.isDigit(codePoint))) {
		            char character = (char) codePoint;
		            int characterWidth = fontMetrics.charWidth(character);
		            if (hasFirstCharacterWidth) {
		                if (characterWidth != firstCharacterWidth) {
		                    isMonospaced = false;
		                    break;
		                }
		            } else {
		                firstCharacterWidth = characterWidth;
		                hasFirstCharacterWidth = true;
		            }
		        }
		    }

		    if (isMonospaced) {
		        monospaceFontFamilyNames.add(fontFamilyName);
		    }
		}

		graphics.dispose();
		
		Collections.sort(monospaceFontFamilyNames);
		return monospaceFontFamilyNames;
		
	}

}
