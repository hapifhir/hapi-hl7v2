/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "TestPanel.java".  Description: 
"A user interface for testing communications with an HL7 server." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

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
package ca.uhn.hl7v2.app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Layout;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.apache.log4j.spi.LoggingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;
import ca.uhn.hl7v2.view.TreePanel;

/**
 * <p>
 * A user interface for testing communications with an HL7 server. The UI
 * contains a window with 4 main panels. One can enter message text into the
 * first panel, press a "parse" button so that the message is displayed in a
 * tree in the second panel, press "send" to send the message to a remote server
 * and display the response in a tree in the third panel, and press "encode" to
 * write the inbound message as text in the fourth panel. To use, run from the
 * command line with no arguments, like this:
 * </p>
 * <p>
 * <code>java -classpath . ca.uhn.hl7v2.app.TestPanel</code>
 * </p>
 * <p>
 * Exceptions generated during parsing or server communication are logged in the
 * working directory and displayed in a dialog box.
 * </p>
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 * @deprecated use new TestPanel
 */
@SuppressWarnings("serial")
public class TestPanel extends JPanel implements ConnectionListener {

	private static final Logger log = LoggerFactory.getLogger(TestPanel.class);

	private static HL7Service service;

	private GenericParser parser;
	private JTextArea outboundText;
	private TreePanel outboundTree;
	private JTextArea inboundText;
	private TreePanel inboundTree;
	private JSplitPane messages;
	private JList connList = null;
	private MessageTypeRouter router;
	private JCheckBox xmlCheckBox;
	private JFileChooser fc;
	private JLabel connectionListening;
	private JTextArea events;
	private SwingLogAppender appender;
	private boolean started;
	private ConnectionHub connectionHub;

	/** Creates a new instance of TestPanel */
	public TestPanel() throws HL7Exception {

		this.parser = new GenericParser();
		// Relax all validation
		this.parser.setValidationContext(ValidationContextFactory.noValidation());
		connectionHub = ConnectionHub.getInstance();
		router = new MessageTypeRouter();
		initUI();
		BasicConfigurator.configure(appender);
	}

	/**
	 * Creates and lays out UI components
	 */
	private void initUI() {
		// main part of panel shows grid of 4 message areas: outbound on top;
		// inbound on bottom
		// and plain text on left, tree on right
		this.setLayout(new BorderLayout());
		outboundText = new JTextArea(10, 10);
		JScrollPane outTextScroll = new JScrollPane(outboundText);
		outboundTree = new TreePanel();
		JScrollPane outTreeScroll = new JScrollPane(outboundTree);
		inboundText = new JTextArea(10, 10);
		JScrollPane inTextScroll = new JScrollPane(inboundText);
		inboundTree = new TreePanel();
		JScrollPane inTreeScroll = new JScrollPane(inboundTree);

		JSplitPane outbound = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
				addTitle(outTextScroll, " Outbound Message Text "), addTitle(
						outTreeScroll, " Outbound Message Tree "));
		JSplitPane inbound = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
				addTitle(inTextScroll, " Inbound Message Text "), addTitle(
						inTreeScroll, " Inbound Message Tree "));
		messages = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, outbound,
				inbound);

		events = new JTextArea(10, 10);
		JScrollPane eventsScroll = new JScrollPane(events);
		appender = new SwingLogAppender(events);
		JSplitPane messagesAndLog = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				true, messages, eventsScroll);
		this.add(messagesAndLog, BorderLayout.CENTER);

		// controls arranged along top for now
		JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		final JComboBox charsetChooser = new JComboBox(Charset
				.availableCharsets().keySet().toArray(new String[0]));
		charsetChooser.setSelectedItem(Charset.defaultCharset().displayName());
		charsetChooser.setMaximumRowCount(15);
		JButton loadButton = new JButton(" Load ");
		JButton clearButton = new JButton(" Clear ");
		JButton parseButton = new JButton(" Parse ");
		JButton sendButton = new JButton(" Send ");
		JButton encodeButton = new JButton(" Encode Inbound ");
		JButton encodeOriginalButton = new JButton(" Encode Outbound ");
		// JButton xmlEncodeButton = new JButton(" Encode XML ");
		xmlCheckBox = new JCheckBox("Use XML", false);
		JButton connectButton = new JButton(" Connect ");
		JButton disconnectButton = new JButton(" Disconnect ");
		controlPanel.add(charsetChooser);
		controlPanel.add(loadButton);
		controlPanel.add(clearButton);
		controlPanel.add(parseButton);
		controlPanel.add(encodeButton);
		controlPanel.add(encodeOriginalButton);
		controlPanel.add(xmlCheckBox);
		controlPanel.add(connectButton);
		controlPanel.add(sendButton);
		controlPanel.add(disconnectButton);
		this.add(controlPanel, BorderLayout.NORTH);

		// connection selector on right side
		connList = new JList();
		connList.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
		connList.setSelectionMode(0); // found through trial & error - don't
		// know where constants are defined
		JPanel connPanel = new JPanel(new BorderLayout());
		connPanel.add(new JScrollPane(connList), BorderLayout.CENTER);
		connectionListening = new JLabel(" Connections ");
		connPanel.add(connectionListening, BorderLayout.NORTH);
		this.add(connPanel, BorderLayout.EAST);

		fc = new JFileChooser();

		// set up event handlers for buttons
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					int returnVal = fc.showOpenDialog(getThis());
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						// This is where a real application would open the file.
						String input = readFile(file, Charset
								.forName((String) charsetChooser
										.getSelectedItem()));
						outboundText.setText(input);
						outboundText.setCaretPosition(0);
					}

				} catch (Exception e) {
					showException(e);
				}
			}
		});

		// set up event handlers for buttons
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					outboundText.setText("");
					inboundText.setText("");
					inboundTree.setMessage(null);
					outboundTree.setMessage(null);
					events.setText("");

				} catch (Exception e) {
					showException(e);
				}
			}
		});

		// set up event handlers for buttons
		parseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					parseOutbound();
				} catch (Exception e) {
					showException(e);
				}
			}
		});

		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					new ConnectionDialog(getThis());
				} catch (Exception e) {
					log.error(e.getMessage());
					showException(e);
				}
			}
		});

		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					sendAndRecieve();
				} catch (Exception e) {
					showException(e);
				}
			}
		});

		encodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					encodeInbound();
				} catch (Exception e) {
					showException(e);
				}
			}
		});

		encodeOriginalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					encodeOutbound();
				} catch (Exception e) {
					showException(e);
				}
			}
		});

		xmlCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (xmlCheckBox.isSelected()) {
					parser.setXMLParserAsPrimary();
				} else {
					parser.setPipeParserAsPrimary();
				}
			}
		});

		disconnectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					disconnect(getCurrentConnection());
				} catch (Exception e) {
					showException(e);
				}
			}
		});

	}

	private String readFile(File file, Charset charset) throws IOException {
		byte[] buffer = new byte[4 * 1024];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		InputStream in = null;
		try {
			in = new FileInputStream(file);
			int len = in.read(buffer);
			while (len >= 0) {
				baos.write(buffer, 0, len);
				len = in.read(buffer);
			}
			return new String(baos.toString(charset.name()));
		} catch (IOException e) {
			log.error("Failed reading file {}", file.getAbsolutePath(), e);
			throw e;
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// left empty
				}
		}

	}

	/** Used in connect button handler ... got a better idea? */
	private TestPanel getThis() {
		return this;
	}

	/**
	 * Returns this TestPanel's underlying GenericParser. This method is needed
	 * by the HL7Service that the panel uses, so that it can share the parser
	 * and use whatever encoding it is using.
	 */
	protected Parser getParser() {
		return this.parser;
	}

	/**
	 * Adds a title to a component by putting it in another panel, adding the '
	 * title, and returning the new panel.
	 */
	private static JPanel addTitle(Component toBeTitled, String title) {
		JPanel newPanel = new JPanel(new BorderLayout());
		newPanel.add(toBeTitled, BorderLayout.CENTER);
		newPanel.add(new JLabel(title), BorderLayout.NORTH);
		return newPanel;
	}

	/**
	 * Displays an exception in a standard way. All exceptions for TestPanel are
	 * routed here. Currently this prints to std err, and displays an error
	 * dialog, but it could be changed.
	 */
	public void showException(Exception e) {
		JOptionPane.showMessageDialog(this, e.getMessage(), e.getClass()
				.getName(), JOptionPane.ERROR_MESSAGE);
		log.error("showException: ", e);
	}

	/**
	 * Attempts to parse the contents of the outbound message text box into a
	 * message object and display in the outbound message tree.
	 */
	public void parseOutbound() throws HL7Exception,
			EncodingNotSupportedException {
		// replace all the line feeds in the text area with carriage returns ...
		String messageString = this.outboundText.getText().replace('\n', '\r');
		Message out = parser.parse(messageString);
		this.outboundTree.setMessage(out);

		if (messages.getDividerLocation() < 0)
			messages.setDividerLocation(0.5);
		this.validate();
	}

	/**
	 * Returns the Connection that is currently selected. If the connection has
	 * been closed by the remote peer, the method attempts to reopen it.
	 * 
	 * @throws LLPException
	 * @throws IOException
	 */
	private ConnectionData getCurrentConnection() throws Exception {
		ConnectionData ce = null;
		Object o = connList.getSelectedValue();
		if (o != null) {
			ce = (ConnectionData) o;
			if (!connectionHub.isOpen(ce)) {
				disconnect(ce);
				connect(ce);
			}
		}
		return ce;
	}

	/**
	 * Sets up a connection to a remote server that uses the minimal lower layer
	 * protocol, and this TestPanel's GenericParser.
	 */
	public void connect(String host, int port) throws Exception {
		connect(host, port, false);
	}

	/**
	 * Sets up a connection to a remote server that uses the minimal lower layer
	 * protocol, and this TestPanel's GenericParser. // TODO ConnectionHub?
	 */
	public void connect(String host, int port, boolean tls) throws Exception {
		Connection c = connectionHub.attach(host, port, parser,
				MinLowerLayerProtocol.class, tls);
		c.getResponder().registerApplication(this.router);
		connList.setListData(connectionHub.allConnections().toArray(
				new ConnectionData[0]));
	}

	/**
	 * Sets up a connection to a remote server that uses the minimal lower layer
	 * protocol, and this TestPanel's GenericParser.
	 */
	public void connect(String host, int inboundPort, int outboundPort)
			throws Exception {
		connect(host, inboundPort, outboundPort, false);
	}

	/**
	 * Sets up a connection to a remote server that uses the minimal lower layer
	 * protocol, and this TestPanel's GenericParser.
	 */
	public void connect(String host, int inboundPort, int outboundPort,
			boolean tls) throws Exception {
		Connection c = connectionHub.attach(host, outboundPort, inboundPort,
				parser, MinLowerLayerProtocol.class, tls);
		c.getResponder().registerApplication(this.router);
		connList.setListData(connectionHub.allConnections().toArray(
				new ConnectionData[0]));
	}

	/**
	 * Sets up a connection to a remote server that uses the minimal lower layer
	 * protocol, and this TestPanel's GenericParser.
	 */
	public void connect(ConnectionData cf) throws Exception {
		Connection c = connectionHub.attach(cf);
		c.getResponder().registerApplication(this.router);
		connList.setListData(connectionHub.allConnections().toArray(
				new ConnectionData[0]));
	}

	/** Notification that a new Connection has arrived at an HL7Service. */
	public void connectionReceived(ca.uhn.hl7v2.app.Connection connection) {
		connection.getResponder().registerApplication(this.router);
	}

	public void connectionDiscarded(Connection connection) {
	}

	private void disconnect(ConnectionData c) {
		if (c != null) {
			connectionHub.detach(connectionHub.getKnownConnection(c));
			connList.setListData(connectionHub.allConnections().toArray(
					new ConnectionData[0]));
		}
	}

	/**
	 * Returns the MessageTypeRouter associated with this TestPanel. Every
	 * Connection that a TestPanel uses routes unsolicited messages through this
	 * MessageTypeRouter. Applications can be registered with the router using
	 * registerApplication().
	 */
	public MessageTypeRouter getRouter() {
		return this.router;
	}

	/**
	 * Sends the message that is currently displayed in the outbound tree to the
	 * remote system that is currently connected.
	 */
	public void sendAndRecieve() throws Exception {
		Message outbound = this.outboundTree.getMessage();
		Message inbound;
		try {
			inbound = connectionHub.getKnownConnection(getCurrentConnection())
					.getInitiator().sendAndReceive(outbound);
		} catch (NullPointerException e) {
			throw new IOException("Please select a Connection.");
		}
		this.inboundTree.setMessage(inbound);
		this.validate();
	}

	/**
	 * Encodes the message that is currently displayed in the tree into a
	 * traditionally encoded message string and displays in the inbound message
	 * text box.
	 */
	public void encodeInbound() throws HL7Exception {
		String inbound = this.parser.encode(this.inboundTree.getMessage());
		inbound = inbound.replace('\r', '\n');
		this.inboundText.setText(inbound);
	}

	/**
	 * Encodes the message that is currently displayed in the outbound tree into
	 * a traditionally encoded message string and displays in a new window.
	 */
	public void encodeOutbound() throws HL7Exception {
		String outbound = this.parser.encode(this.outboundTree.getMessage());
		outbound = outbound.replace('\r', '\n');
		TestPanel.openTextWindow("Outbound Message", outbound);
	}

	/**
	 * Encodes the message that is currently displayed in the tree into an XML
	 * encoded message string and displays in the inbound message text box.
	 */
	/*
	 * public void xmlEncodeInbound() throws HL7Exception { String inbound =
	 * this.xparser.encode(this.inboundTree.getMessage());
	 * this.inboundText.setText(inbound); }
	 */

	/**
	 * Opens a new window for displaying text (intended for displaying encoded
	 * messages.
	 */
	public static void openTextWindow(String title, String text) {
		JFrame frame = new JFrame(title);

		try {
			frame.getContentPane().setLayout(new BorderLayout());
			JTextArea textArea = new JTextArea(text);
			JScrollPane scroll = new JScrollPane(textArea);
			frame.getContentPane().add(scroll, BorderLayout.CENTER);

			frame.pack();
			frame.setVisible(true);
		} catch (Exception e) {
			System.err.println("Can't display text in new window: "
					+ e.getMessage());
		}
	}

	class SwingLogAppender extends WriterAppender {

		private final JTextArea area;
		private ConcurrentLinkedQueue<String> buf;

		public SwingLogAppender(JTextArea area) {
			super();
			this.area = area;
			this.buf = new ConcurrentLinkedQueue<String>();
			setLayout(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN));
		}

		@Override
		public void append(LoggingEvent event) {
			buf.offer(getLayout().format(event));

			if (getLayout().ignoresThrowable()) {
				String[] exception = event.getThrowableStrRep();
				if (exception != null) {
					for (String line : exception) {
						buf.offer(line);
						buf.offer(Layout.LINE_SEP);
					}
				}
			}
			display();
		}

		void display() {
			if (TestPanel.this.started && !buf.isEmpty()) {
				SwingUtilities.invokeLater(new Runnable() {

					public void run() {
						while (!buf.isEmpty()) {
							area.append(buf.poll());
						}
						buf.clear();
					}

				});
			}
		}

	}

	public static void main(String args[]) {

		// BasicConfigurator.configure();
		if (args.length > 3) {
			System.out
					.println("Usage: ca.uhn.hl7v2.app.TestPanel [tls] [inbound_port [outbound_port] ]");
			System.out
					.println("    If port numbers are provided, an HL7Server will be started, to listen for incoming connections.");
			System.out
					.println("    If outbound port is not provided, inbound and outbound messages will use the same port.");
			System.out
					.println("    If tls is provided, inbound and outbound messages will be received/sent over TLS.");
			System.exit(1);
		}

		// show a TestPanel in a window
		JFrame frame = new JFrame("Message Tester");

		try {
			TestPanel panel = new TestPanel();
			boolean tls = false;
			int i = 0;

			try {
				if (args.length > 0) {
					LowerLayerProtocol llp = LowerLayerProtocol.makeLLP();

					if ("tls".equals(args[i]) || "ssl".equals(args[i])) {
						tls = true;
						i++;
					}

					int inPort = Integer.parseInt(args[i++]);
					if (args.length > i) {
						int outPort = Integer.parseInt(args[i]);
						service = new TwoPortService(panel.getParser(), llp,
								inPort, outPort, tls);
					} else {
						service = new SimpleServer(inPort, llp,
								panel.getParser(), tls);
					}
					service.registerConnectionListener(panel);
					service.start();
				}

			} catch (NumberFormatException nfe) {
				System.out
						.println("The given port number(s) are not valid integers");
				System.exit(1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			frame.getContentPane().add(panel, BorderLayout.CENTER);

			// Finish setting up the frame
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});

			frame.pack();
			frame.setVisible(true);
			panel.started = true;
			panel.appender.display();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}