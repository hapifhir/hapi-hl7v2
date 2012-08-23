package ca.uhn.hl7v2.testpanel.ui.conn;

import static org.apache.commons.lang.StringUtils.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JGraph extends JComponent {

	private List<Integer> myValues;
	private float myMax;
	private Color myLineColor;
	private String myText;
	private Color myTextColor;

	public JGraph() {
		setBackground(new Color(0.2f, 0.2f, 0.7f));
		myLineColor = new Color(0.9f, 0.9f, 1.0f);
		myTextColor = new Color(0.3f, 0.6f, 1.0f);
	}

	/**
	 * @param theValues
	 *            the values to set
	 */
	public void setValues(List<Integer> theValues) {
		myValues = theValues;
		myMax = -1;
		repaint();
	}

	public void setText(String theText) {
		myText = theText;
		repaint();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics theG) {

		Graphics2D g = (Graphics2D) getGraphics().create();

		if (myValues == null || myValues.size() == 0) {
			 myValues = new ArrayList<Integer>();
			 myValues.add(0);
		}

		if (myMax <= 0) {
			for (Integer next : myValues) {
				myMax = Math.max(myMax, next);
			}
		}
		myMax = Math.max(myMax, 1);

		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());

		if (isNotBlank(myText)) {
			FontMetrics metrics = g.getFontMetrics();
			int hgt = metrics.getHeight();
			int adv = metrics.stringWidth(myText);
			g.setColor(myTextColor);
			int x = (getWidth() / 2) - (adv / 2);
			x = Math.max(0, x);
			int y = (getHeight() / 2) - (hgt / 2);
			y = Math.max(0, y);
			y = getHeight() - y;
			g.drawString(myText, x, y);
		}

		int nextLeft = 0;
		int prevY = -1;
		int width = getWidth() / myValues.size();
		for (int i = 0; i < myValues.size(); i++) {
			int nextValue = myValues.get(i);
			float heightProp = ((float) nextValue / myMax);
			int componentHeight = getHeight();
			int top = (int) (componentHeight - (getHeight() * heightProp));

			g.setColor(myLineColor);

			if (prevY == -1) {
				prevY = top;
			}

			g.drawLine(nextLeft, prevY, nextLeft + width, top);

			nextLeft += width;
			prevY = top;
		}

		g.dispose();
	}

	public void setValues(Integer... theValues) {
		setValues(Arrays.asList(theValues));
	}

	public static void main(String[] args) {

		JFrame jfr = new JFrame();
		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfr.setSize(200, 100);

		JPanel cpanel = new JPanel(new BorderLayout());
		jfr.add(cpanel);

		cpanel.add(new JLabel("West"), BorderLayout.WEST);
		cpanel.add(new JLabel("East"), BorderLayout.EAST);
		cpanel.add(new JLabel("North"), BorderLayout.NORTH);
		cpanel.add(new JLabel("South"), BorderLayout.SOUTH);

		JGraph graph = new JGraph();
		cpanel.add(graph);

		graph.setValues(1, 2, 3);
		graph.setText("some teXT");

		jfr.setVisible(true);

	}

}
