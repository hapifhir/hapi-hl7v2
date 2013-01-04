package ca.uhn.hl7v2.testpanel.ui.v2tree;

import java.awt.EventQueue;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.netbeans.swing.outline.DefaultOutlineModel;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.check.DefaultValidator;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup;
import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageCollection;
import ca.uhn.hl7v2.testpanel.ui.ShowEnum;
import ca.uhn.hl7v2.testpanel.ui.v2tree.Hl7V2MessageTree.TreeNodeMessageConf;
import ca.uhn.hl7v2.testpanel.ui.v2tree.Hl7V2MessageTree.TreeNodeRoot;
import ca.uhn.hl7v2.testpanel.ui.v2tree.Hl7V2MessageTree.TreeNodeSegmentConf;
import ca.uhn.hl7v2.testpanel.util.FileUtils;


public class ConfProfileTest {

	
	
	private Hl7V2MessageTree tree;
	private TreeNodeRoot treeNodeRoot;

	@Ignore
	@Test
	public void testValidateConfProfile() throws HL7Exception, ProfileException, IOException, InterruptedException, InvocationTargetException {
        
		String testMessageString = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ADT^A01^ADT_A01|20169838|T|2.5\r"; 
		
		Hl7V2MessageCollection messageModel = new Hl7V2MessageCollection();
		messageModel.setSourceMessage(testMessageString);
		ProfileGroup pg = ProfileGroup.createFromRuntimeProfile(FileUtils.loadResourceFromClasspath("ADT_A01_reqsft.xml"));
		messageModel.setRuntimeProfile(pg);
		
		initTree();

		tree.setUnitTestShowMode(ShowEnum.ALL);
		DefaultValidator validator = new DefaultValidator();
		validator.setValidateChildren(false);
		tree.setRuntimeProfileValidator(validator);
		tree.setMessageForUnitTest(messageModel);
		
		tree.addChildren(messageModel.getMessages(), treeNodeRoot, "");
		treeNodeRoot.validate();

		TreeNodeMessageConf messageNode = (TreeNodeMessageConf) treeNodeRoot.getChildAt(0);
		TreeNodeSegmentConf sftNode = (TreeNodeSegmentConf)messageNode.getChildAt(1);
		
		Assert.assertTrue(messageNode.getErrorDescription(), messageNode.getErrorDescription().contains("SFT"));
		Assert.assertFalse(sftNode.getErrorDescription(), (sftNode.getErrorDescription() + "").contains("Software Vendor Organization"));
		
	}
	
	@Ignore
	@Test
	public void testValidateSegNotSupported() throws HL7Exception, ProfileException, IOException, InterruptedException, InvocationTargetException {
        
		String testMessageString = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ADT^A01^ADT_A01|20169838|T|2.5\r"; 
		
		Hl7V2MessageCollection messageModel = new Hl7V2MessageCollection();
		messageModel.setSourceMessage(testMessageString);
		ProfileGroup pg = ProfileGroup.createFromRuntimeProfile(FileUtils.loadResourceFromClasspath("ADT_A01_segnotsup.xml"));
		messageModel.setRuntimeProfile(pg);
		
		initTree();
		
		tree.setUnitTestShowMode(ShowEnum.ALL);
		DefaultValidator validator = new DefaultValidator();
		validator.setValidateChildren(false);
		tree.setRuntimeProfileValidator(validator);
		tree.setMessageForUnitTest(messageModel);
		
		tree.addChildren(messageModel.getMessages(), treeNodeRoot, "");
		treeNodeRoot.validate();

		TreeNodeMessageConf messageNode = (TreeNodeMessageConf) treeNodeRoot.getChildAt(0);
		TreeNodeSegmentConf sftNode = (TreeNodeSegmentConf)messageNode.getChildAt(1);
		
		Assert.assertFalse(messageNode.getErrorDescription(), (messageNode.getErrorDescription()+"").contains("SFT"));
		Assert.assertFalse(sftNode.getErrorDescription(), (sftNode.getErrorDescription() + "").contains("Software Vendor Organization"));

		
		
		
		testMessageString = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ADT^A01^ADT_A01|20169838|T|2.5\r" +
				"SFT|111"; 
		
		messageModel = new Hl7V2MessageCollection();
		messageModel.setSourceMessage(testMessageString);
		pg = ProfileGroup.createFromRuntimeProfile(FileUtils.loadResourceFromClasspath("ADT_A01_segnotsup.xml"));
		messageModel.setRuntimeProfile(pg);
		
		initTree();
		tree.setUnitTestShowMode(ShowEnum.ALL);
		validator = new DefaultValidator();
		validator.setValidateChildren(false);
		tree.setRuntimeProfileValidator(validator);
		tree.setMessageForUnitTest(messageModel);
		
		tree.addChildren(messageModel.getMessages(), treeNodeRoot, "");
		treeNodeRoot.validate();

		messageNode = (TreeNodeMessageConf) treeNodeRoot.getChildAt(0);
		sftNode = (TreeNodeSegmentConf)messageNode.getChildAt(1);
		
		Assert.assertTrue(messageNode.getErrorDescription(), messageNode.getErrorDescription().contains("SFT"));
		Assert.assertFalse(sftNode.getErrorDescription(), (sftNode.getErrorDescription() + "").contains("Software Vendor Organization"));

	}

	private void initTree() throws InterruptedException, InvocationTargetException {
		EventQueue.invokeAndWait(new Runnable() {

			public void run() {
				tree = new Hl7V2MessageTree(null);
				treeNodeRoot = tree.new TreeNodeRoot();
				tree.setModel(new DefaultOutlineModel(new DefaultTreeModel(treeNodeRoot), new DefaultTableModel(), false, null) {});
			}});
	}
	
	
	
}
