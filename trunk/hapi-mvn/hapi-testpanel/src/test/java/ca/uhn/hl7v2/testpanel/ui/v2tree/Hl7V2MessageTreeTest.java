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
package ca.uhn.hl7v2.testpanel.ui.v2tree;

import static org.junit.Assert.*;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.tree.TreeNode;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v23.message.ORU_R01;
import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageCollection;
import ca.uhn.hl7v2.testpanel.ui.ShowEnum;
import ca.uhn.hl7v2.testpanel.ui.v2tree.Hl7V2MessageTree.TreeNodeRoot;
import ca.uhn.hl7v2.testpanel.ui.v2tree.Hl7V2MessageTree.TreeNodeSegment;
import ca.uhn.hl7v2.testpanel.ui.v2tree.Hl7V2MessageTree.TreeNodeType;
import ca.uhn.hl7v2.testpanel.util.Range;

public class Hl7V2MessageTreeTest {

	private String testMessageString;
	private ORU_R01 msg;
	private Hl7V2MessageCollection messageModel;
	private ArrayList<Integer> startIndexes;

	@Before
	public void setUp() throws HL7Exception, PropertyVetoException {
		System.setProperty("java.awt.headless", "true"); 
		
		testMessageString = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + 
				"ZPI|||7005728^^^TML^MR~123^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" + 
				"PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" + 
				"PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r" + 
				"ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r" + 
				"OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r" + 
				"OBX|1|IS|Z114099^Erc^L||ABC||||||F|||200905011111|PMH\r" +
				"\r" +
				"MSH|^~\\&|AAA|BBB|CCC|DDD|200905011130||ORU^R01|9999|T|2.3";
		msg = new ORU_R01();
		msg.parse(testMessageString);
		
		messageModel = new Hl7V2MessageCollection();
		messageModel.setSourceMessage(testMessageString);
		
		startIndexes = new ArrayList<Integer>();
		int offset = 0;
		String[] lines = testMessageString.split("\\r");
		startIndexes.add(0);
		for (String string : lines) {
			offset++;
			startIndexes.add(string.length() + offset);
		}
		
	}
	
	private Hl7V2MessageTree myTree;
	private TreeNodeRoot myTreeNodeRoot;
	
	
	@Test
	public void testMessageTreeTerserPaths() throws HL7Exception, PropertyVetoException, InterruptedException, InvocationTargetException {
		Runnable r = new Runnable() {


			public void run() {
				myTree = new Hl7V2MessageTree(null);
				myTreeNodeRoot = myTree.new TreeNodeRoot();
				myTree.setEditorShowModeAndUpdateAccordingly(ShowEnum.POPULATED);
			}};
			invoke(r);
				
				try {
					myTree.addChildren(messageModel.getMessages(), myTreeNodeRoot, "");
				} catch (InterruptedException e) {
					throw new Error(e);
				} catch (InvocationTargetException e) {
					throw new Error(e);
				}
				
				TreeNode treeNodeMsg = myTreeNodeRoot.getChildAt(0);
				TreeNodeSegment zpiNode = (TreeNodeSegment) treeNodeMsg.getChildAt(1);
				assertEquals("/ZPI", zpiNode.getTerserPath());
				TreeNodeType zpi3 = (TreeNodeType)zpiNode.getChildAt(0);
				assertEquals("/ZPI-3", zpi3.getTerserPath());
				TreeNodeType zpi3_1 = (TreeNodeType)zpi3.getChildAt(0);
				assertEquals("/ZPI-3-1", zpi3_1.getTerserPath()); 
				zpi3 = (TreeNodeType)zpiNode.getChildAt(1); // Second rep
				assertEquals("/ZPI-3(2)", zpi3.getTerserPath());
				zpi3_1 = (TreeNodeType)zpi3.getChildAt(0);
				assertEquals("/ZPI-3(2)-1", zpi3_1.getTerserPath());
			
			
	}
	
	private void invoke(Runnable theR) throws InterruptedException, InvocationTargetException {
		if (EventQueue.isDispatchThread()) {
			theR.run();
		} else {
			EventQueue.invokeAndWait(theR);
		}
	}



	@Test
	public void testModelTerserPaths() {
		
		int point = startIndexes.get(1) + 6;
		messageModel.setHighlitedPathBasedOnRange(new Range(point, point));
		assertEquals("0/ZPI-3-1", messageModel.getHighlitedPath());
		
		point = startIndexes.get(1) + 23;
		messageModel.setHighlitedPathBasedOnRange(new Range(point, point));
		assertEquals("0/ZPI-3(2)-1", messageModel.getHighlitedPath());
		
		point = testMessageString.length() - 59;
		messageModel.setHighlitedPathBasedOnRange(new Range(point, point));
		assertEquals("0/RESPONSE/ORDER_OBSERVATION/OBSERVATION/OBX-15-1", messageModel.getHighlitedPath());
		
	}
	
}
