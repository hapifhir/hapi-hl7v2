/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ConnectionDialog.java".  Description: 
"A dialog box for opening a new Connection (used with TestPanel)." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.app;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * A dialog box for opening a new Connection (used with TestPanel). 
 * @author Bryan Tripp
 * @deprecated
 */
@SuppressWarnings("serial")
public class ConnectionDialog extends JDialog {

    private JTextField port;
    private JTextField inPort;
    private JTextField outPort;
    private JTextField host;
    private JRadioButton onePort;
    private JCheckBox tls;  
    private TestPanel testPanel;
    
    /** Creates a new instance of ConnectionDialog */
    public ConnectionDialog(TestPanel testPanel) {
        super();
        this.testPanel = testPanel;
        initUI();
    }

    /** Initialize UI */
    private void initUI() {
        Box box = new Box(BoxLayout.Y_AXIS);
        getContentPane().add(box);
        
        host = new JTextField(20);        
        JPanel hostPanel = new JPanel();
        ((FlowLayout) hostPanel.getLayout()).setAlignment(FlowLayout.LEFT);
        hostPanel.add(new JLabel(" Host:  "));
        hostPanel.add(host);
        box.add(hostPanel);


        onePort = new JRadioButton(" Single Port ");
        onePort.setSelected(true);
        port = new JTextField(5);
        JPanel onePortPanel = new JPanel();
        ((FlowLayout) onePortPanel.getLayout()).setAlignment(FlowLayout.LEFT);
        onePortPanel.add(onePort, FlowLayout.LEFT);       
        onePortPanel.add(port);
        box.add(onePortPanel);

        
        JRadioButton twoPort = new JRadioButton(" Separate Inbound & Outbound Ports ");
        JPanel twoPortPanel = new JPanel();
        ((FlowLayout) twoPortPanel.getLayout()).setAlignment(FlowLayout.LEFT);
        twoPortPanel.add(twoPort);
        box.add(twoPortPanel);
        
        JPanel twoPortPanel2 = new JPanel();
        ((FlowLayout) twoPortPanel2.getLayout()).setAlignment(FlowLayout.LEFT);
        twoPortPanel2.add(new JLabel(" Inbound: "));
        inPort = new JTextField(5);
        inPort.setEnabled(false);
        twoPortPanel2.add(inPort);
        twoPortPanel2.add(new JLabel(" Outbound: "));
        outPort = new JTextField(5);
        outPort.setEnabled(false);
        twoPortPanel2.add(outPort);
        box.add(twoPortPanel2);

        
        tls = new JCheckBox("use TLS");
        tls.setSelected(false);
        box.add(tls);
        JPanel tlsPanel = new JPanel();
        ((FlowLayout) tlsPanel.getLayout()).setAlignment(FlowLayout.LEFT);
        tlsPanel.add(tls, FlowLayout.LEFT);     
        box.add(tlsPanel);
        
        JPanel buttonPanel = new JPanel();
        JButton OK = new JButton("  OK  ");
        JButton cancel = new JButton(" Cancel ");
        buttonPanel.add(OK);
        buttonPanel.add(cancel);
        box.add(buttonPanel);
        
        ButtonGroup portSelect = new ButtonGroup();
        portSelect.add(twoPort);
        portSelect.add(onePort);
        
        OK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connect();
            }
        });
        
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        
        onePort.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				inPort.setEnabled(false);
				outPort.setEnabled(false);
				port.setEnabled(true);
			}

        });
        twoPort.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				inPort.setEnabled(true);
				outPort.setEnabled(true);
				port.setEnabled(false);
			}

        });        
        
        pack();
        setVisible(true);
    }
    
	private void connect() {
        try {
            if (onePort.isSelected()) {
                testPanel.connect(host.getText(), Integer.parseInt(port.getText()));
            } else {
                testPanel.connect(host.getText(), Integer.parseInt(inPort.getText()), Integer.parseInt(outPort.getText()));
            }
            close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid port number", "", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE);            
        }
    }
    
    private void close() {
        this.dispose();
    }
    

}