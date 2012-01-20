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
package ca.uhn.hl7v2.testpanel.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.LayeredHighlighter;
import javax.swing.text.Position;
import javax.swing.text.View;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageCollection;
import ca.uhn.hl7v2.testpanel.ui.UnderlineHighlighter.UnderlineHighlightPainter;
import ca.uhn.hl7v2.testpanel.util.Range;

public class Hl7V2MessageEditorHighlighter implements IDestroyable {

	private static final Logger ourLog = LoggerFactory.getLogger(Hl7V2MessageEditorHighlighter.class);
	
	protected JTextComponent myComp;

	protected UnderlineHighlightPainter myPainter;

	private Hl7V2MessageCollection myMessage;

	private PropertyChangeListener myRangeListener;

	public Hl7V2MessageEditorHighlighter(final JTextComponent comp, Hl7V2MessageCollection theMessage) {
		myComp = comp;
		myPainter = new UnderlineHighlighter.UnderlineHighlightPainter();
		myMessage = theMessage;
		
		myRangeListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				removeExistingHighlights();
				if (theEvt.getNewValue() != null) {
					Range newRange = (Range) theEvt.getNewValue();
					Highlighter highlighter = myComp.getHighlighter();
					try {
						highlighter.addHighlight(newRange.getStart(), newRange.getEnd(), myPainter);
					} catch (BadLocationException e) {
						ourLog.error("Failed to add highliter", e);
					}

					if (ourLog.isDebugEnabled()) {
						try {
							ourLog.info("Range is now: " + comp.getDocument().getText(newRange.getStart(), newRange.getEnd() - newRange.getStart()));
						} catch (BadLocationException e) {
							ourLog.error("Failed to add highliter", e);
						}
					}
					
				}
			}
		};
//		myMessage.addPropertyChangeListener(Hl7V2MessageCollection.PROP_HIGHLITED_RANGE, myRangeListener);
		
	}

	// Search for a word and return the offset of the
	// first occurrence. Highlights are added for all
	// occurrences found.
	public int search(String word) {
		int firstOffset = -1;
		Highlighter highlighter = myComp.getHighlighter();

		removeExistingHighlights();

		if (word == null || word.equals("")) {
			return -1;
		}

		// Look for the word we are given - insensitive search
		String content = null;
		try {
			Document d = myComp.getDocument();
			content = d.getText(0, d.getLength()).toLowerCase();
		} catch (BadLocationException e) {
			// Cannot happen
			return -1;
		}

		word = word.toLowerCase();
		int lastIndex = 0;
		int wordSize = word.length();

		while ((lastIndex = content.indexOf(word, lastIndex)) != -1) {
			int endIndex = lastIndex + wordSize;
			try {
				highlighter.addHighlight(lastIndex, endIndex, myPainter);
			} catch (BadLocationException e) {
				// Nothing to do
			}
			if (firstOffset == -1) {
				firstOffset = lastIndex;
			}
			lastIndex = endIndex;
		}

		return firstOffset;
	}

	private void removeExistingHighlights() {
		DefaultHighlighter highlighter = (DefaultHighlighter) myComp.getHighlighter();
		Highlighter.Highlight[] highlights = highlighter.getHighlights();
		for (int i = 0; i < highlights.length; i++) {
			Highlighter.Highlight h = highlights[i];
			if (h.getPainter() instanceof UnderlineHighlighter.UnderlineHighlightPainter) {
				highlighter.removeHighlight(h);
			}
		}
	}

	public void destroy() {
		myMessage.removePropertyChangeListener(Hl7V2MessageCollection.PROP_HIGHLITED_RANGE, myRangeListener);
	}

}

class UnderlineHighlighter extends DefaultHighlighter {
	protected static final Highlighter.HighlightPainter sharedPainter = new UnderlineHighlightPainter();

	public UnderlineHighlighter() {
	}

	// Convenience method to add a highlight with
	// the default painter.
	public Object addHighlight(int p0, int p1) throws BadLocationException {
		return addHighlight(p0, p1, sharedPainter);
	}

	public void setDrawsLayeredHighlights(boolean newValue) {
		// Illegal if false - we only support layered highlights
		if (newValue == false) {
			throw new IllegalArgumentException("UnderlineHighlighter only draws layered highlights");
		}
		super.setDrawsLayeredHighlights(true);
	}

	// Painter for underlined highlights
	public static class UnderlineHighlightPainter extends LayeredHighlighter.LayerPainter {
//		protected Color fillColour = new Color(0.8f, 0.8f, 1.0f);
//		protected Color lineColour = new Color(0.6f, 0.6f, 1.0f);
		protected Color lineColour = new Color(0.0f, 0.5f, 0.0f);
		protected Color fillColour = new Color(0.6f, 1.0f, 0.6f);

		public UnderlineHighlightPainter() {
		}

		public void paint(Graphics g, int offs0, int offs1, Shape bounds, JTextComponent c) {
			// Do nothing: this method will never be called
		}

		public Shape paintLayer(Graphics g, int offs0, int offs1, Shape bounds, JTextComponent c, View view) {

			Rectangle alloc = null;
			if (offs0 == view.getStartOffset() && offs1 == view.getEndOffset()) {
				if (bounds instanceof Rectangle) {
					alloc = (Rectangle) bounds;
				} else {
					alloc = bounds.getBounds();
				}
			} else {
				try {
					Shape shape = view.modelToView(offs0, Position.Bias.Forward, offs1, Position.Bias.Backward, bounds);
					alloc = (shape instanceof Rectangle) ? (Rectangle) shape : shape.getBounds();
				} catch (BadLocationException e) {
					return null;
				}
			}

//			FontMetrics fm = c.getFontMetrics(c.getFont());
//			int baseline = alloc.y + alloc.height - fm.getDescent() + 1;
			
//			g.drawLine(alloc.x, baseline, alloc.x + alloc.width, baseline);
//			g.drawLine(alloc.x, baseline + 1, alloc.x + alloc.width, baseline + 1);

//			g.setColor(fillColour);
//			g.fillRect(alloc.x + 1, alloc.y + 1, alloc.width - 1, alloc.height - 1);

			g.setColor(lineColour);
//			g.drawRect(alloc.x, alloc.y, alloc.width, alloc.height - 2);
//			g.drawRect(alloc.x, alloc.y, alloc.width - 1, alloc.height - 3);
			
			int y = alloc.y + alloc.height - 2;
			g.drawLine(alloc.x, y, alloc.x + alloc.width, y);
			y++;
			g.drawLine(alloc.x, y, alloc.x + alloc.width, y);
			
			return alloc;
		}
	}
}
