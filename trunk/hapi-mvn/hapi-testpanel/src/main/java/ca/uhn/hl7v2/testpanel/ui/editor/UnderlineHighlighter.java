package ca.uhn.hl7v2.testpanel.ui.editor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.LayeredHighlighter;
import javax.swing.text.Position;
import javax.swing.text.View;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnderlineHighlighter extends DefaultHighlighter {
	protected static final Highlighter.HighlightPainter sharedPainter = new UnderlineHighlightPainter();
	
	private static final Logger ourLog = LoggerFactory.getLogger(UnderlineHighlighter.class);
	
	public UnderlineHighlighter() {
		setDrawsLayeredHighlights(true);
	}

	/**
     * {@inheritDoc}
     */
    @Override
    public void paint(Graphics theG) {
		ourLog.debug("Repainting");
	    super.paint(theG);
    }

	/**
     * {@inheritDoc}
     */
    @Override
    public void paintLayeredHighlights(Graphics theG, int theP0, int theP1, Shape theViewBounds, JTextComponent theEditor, View theView) {
		ourLog.debug("Paintlayeredhighlights");
	    super.paintLayeredHighlights(theG, theP0, theP1, theViewBounds, theEditor, theView);
    }

	@Override
	public Object addHighlight(int theP0, int theP1, HighlightPainter theP) throws BadLocationException {
		ourLog.debug("Adding highlight");
		return addHighlight(theP0, theP1);
	}

	public Object addHighlight(int p0, int p1) throws BadLocationException {
		return super.addHighlight(p0, p1, sharedPainter);
	}

	public void setDrawsLayeredHighlights(boolean newValue) {
		if (newValue == false) {
			throw new IllegalArgumentException("UnderlineHighlighter only draws layered highlights");
		}
		super.setDrawsLayeredHighlights(true);
	}

	// Painter for underlined highlights
	public static class UnderlineHighlightPainter extends LayeredHighlighter.LayerPainter {
		protected Color lineColour = new Color(0.2f, 0.6f, 0.2f);
		protected Color fillColour = new Color(0.75f, 1.0f, 0.75f);

		public UnderlineHighlightPainter() {
		}

		public void paint(Graphics g, int offs0, int offs1, Shape bounds, JTextComponent c) {
			System.out.println("Paint called");
		}

		public Shape paintLayer(Graphics g, int offs0, int offs1, Shape bounds, JTextComponent c, View view) {
			
			ourLog.debug("Repainting");
			
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

			g.setColor(fillColour);
			g.fillRect(alloc.x + 1, alloc.y + 1, alloc.width - 1, alloc.height - 1);

			if (!c.hasFocus()) {
				int y = alloc.y + alloc.height - 2;

				ourLog.debug("Repainting highlight at {}, {}", alloc.x, y);
				
				g.setColor(lineColour);
	//			g.drawRect(alloc.x, alloc.y, alloc.width, alloc.height - 2);
	//			g.drawRect(alloc.x, alloc.y, alloc.width - 1, alloc.height - 3);
				
				g.drawLine(alloc.x, y, alloc.x + alloc.width, y);
				y++;
				g.drawLine(alloc.x, y, alloc.x + alloc.width, y);
			}
			
			return alloc;
		}
	}
}