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
/*
 * Created on October 17, 2001, 11:44 AM
 */
package ca.uhn.hl7v2.testpanel.tmp;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListSelectionModel;
import javax.swing.Icon;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.tree.AbstractLayoutCache;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import org.apache.commons.lang.Validate;
import org.netbeans.swing.outline.DefaultOutlineModel;
import org.netbeans.swing.outline.Outline;
import org.netbeans.swing.outline.OutlineModel;
import org.netbeans.swing.outline.RenderDataProvider;
import org.netbeans.swing.outline.RowModel;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageBase;
import ca.uhn.hl7v2.testpanel.ui.IDestroyable;
import ca.uhn.hl7v2.testpanel.util.SegmentAndComponentPath;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * This is a Swing panel that displays the contents of a Message object in a
 * JTree. The tree currently only expands to the field level (components shown
 * as one node).
 * 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public class Hl7V2MessageTree extends Outline /*implements IDestroyable*/ {

//	private static final HapiLog log = HapiLogFactory.getHapiLog(Hl7V2MessageTree.class);
//
//	private PropertyChangeListener myHighlitedPathListener;
//	private Hl7V2MessageImpl myMessage;
//	private PropertyChangeListener myParsedMessageListener;
//	private PipeParser myPipeParser;
//	private boolean mySelectionHandlingDisabled;
//
//	private boolean myShowEmpty;
//
//	private TreeNodeMessage myTop;
//
//	private DefaultTreeModel myTreeModel;
//
//	/** Creates new TreePanel */
//	public Hl7V2MessageTree() {
//
//		myPipeParser = new PipeParser();
//		myPipeParser.setValidationContext(new ValidationContextImpl());
//
//		setRenderDataProvider(new TreeRenderDataProvider());
//		setShowGrid(true);
//		setGridColor(new Color(0.8f, 0.8f, 0.8f));
//
//		setRowSelectionAllowed(true);
//
//		setSelectionModel(new MySelectionModel());
//
//		DefaultCellEditor singleclick = new DefaultCellEditor(new JTextField());
//		singleclick.setClickCountToStart(1);
//		setDefaultEditor(String.class, singleclick);
//
//		myParsedMessageListener = new PropertyChangeListener() {
//
//			public void propertyChange(PropertyChangeEvent theEvt) {
//				Message parsedMessage = myMessage.getParsedMessage();
//
//				try {
//					System.out.println(parsedMessage.printStructure());
//				} catch (HL7Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//				addChildren(parsedMessage, myTop, "");
//				myTreeModel.nodeStructureChanged(myTop);
//			}
//		};
//
//		myHighlitedPathListener = new PropertyChangeListener() {
//
//			public void propertyChange(PropertyChangeEvent theEvt) {
//				synchronizeTreeWithHighlitedPath();
//			}
//
//		};
//
//		getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//	}
//
//	private void addChildren() {
//		if (myMessage != null) {
//			addChildren(myMessage.getParsedMessage(), myTop, "");
//			myTreeModel.nodeStructureChanged(myTop);
//		}
//	}
//
//	/**
//	 * Adds the children of the given group under the given tree node.
//	 */
//	void addChildren(Group messParent, MutableTreeNode treeParent, String theTerserPath) {
//
//		String[] childNames = messParent.getNames();
//		int currChild = 0;
//		for (int i = 0; i < childNames.length; i++) {
//
//			try {
//				String nextName = childNames[i];
//
//				if (myShowEmpty) {
//					messParent.get(nextName);
//				}
//
//				Structure[] childReps = messParent.getAll(nextName);
//				boolean repeating = messParent.isRepeating(nextName);
//				boolean required = messParent.isRequired(nextName);
//
//				for (int j = 0; j < childReps.length; j++) {
//
//					DefaultMutableTreeNode newNode = null;
//					Structure nextStructure = childReps[j];
//					String groupName = nextStructure.getName();
//
//					String nextTerserPath = theTerserPath + "/" + groupName + (j > 0 ? "-" + (j + 1) : "");
//
//					if (nextStructure instanceof Group) {
//
//						newNode = new TreeNodeGroup((Group) nextStructure, groupName, j, repeating, required, nextTerserPath);
//						newNode = insertOrReplaceWithExisting(treeParent, currChild, newNode);
//
//						addChildren((Group) nextStructure, newNode, nextTerserPath);
//
//					} else if (nextStructure instanceof Segment) {
//
//						newNode = new TreeNodeSegment((Segment) nextStructure, groupName, j, repeating, required, nextTerserPath);
//						newNode = insertOrReplaceWithExisting(treeParent, currChild, newNode);
//
//						addChildren((Segment) nextStructure, newNode, nextTerserPath);
//
//					}
//
//					currChild++;
//					// treeParent.insert(newNode, currChild++);
//				}
//			} catch (HL7Exception e) {
//				log.error("Failed to add group to tree", e);
//			}
//		}
//	}
//
//	/**
//	 * Add fields of a segment to the tree ...
//	 */
//	void addChildren(Segment messParent, MutableTreeNode treeParent, String theTerserPath) {
//		// EncodingCharacters encChars;
//		// try {
//		// encChars =
//		// EncodingCharacters.getInstance(myMessage.getParsedMessage());
//		// } catch (HL7Exception e1) {
//		// log.error("Failed to obtain encoding chars: ", e1);
//		// return;
//		// }
//
//		int n = messParent.numFields();
//		String[] names = messParent.getNames();
//		int index = 0;
//		for (int i = 1; i <= n; i++) {
//			try {
//
//				List<Integer> components = new ArrayList<Integer>();
//				components.add(Integer.valueOf(i));
//
//				if (myShowEmpty) {
//					messParent.getField(i, 0);
//				}
//
//				Type[] reps = messParent.getField(i);
//				boolean repeating = messParent.getMaxCardinality(i) != 1;
//				boolean required = messParent.isRequired(i);
//				String name = i <= names.length ? names[i - 1] : "Unknown";
//
//				for (int j = 0; j < reps.length; j++) {
//
//					// String field = PipeParser.encode(reps[j], encChars);
//
//					Type type = reps[j];
//					String parentName = messParent.getName() + "-" + (i);
//
//					StringBuilder b = new StringBuilder();
//					b.append(theTerserPath);
//					b.append("-");
//					b.append((i));
//					if (j > 0) {
//						b.append('(');
//						b.append(j + 1);
//						b.append(')');
//					}
//					String terserPath = b.toString();
//
//					addChildren(parentName, treeParent, repeating, required, name, j, type, messParent, components, index, terserPath);
//
//					index++;
//				}
//
//			} catch (HL7Exception e) {
//				log.error("Failed to add child to tree", e);
//			}
//		}
//	}
//
//	/**
//	 * Adds components of a composite to the tree ...
//	 */
//	void addChildren(String theParentName, Composite messParent, MutableTreeNode treeParent, Segment theSegment, List<Integer> theComponentPath, String theTerserPath) {
//		Type[] components = messParent.getComponents();
//
//		int cpIndex = theComponentPath.size();
//		theComponentPath.add(null);
//
//		for (int i = 0; i < components.length; i++) {
//			Type nextType = components[i];
//			String nextParentName = theParentName + "-" + (i + 1);
//
//			theComponentPath.set(cpIndex, Integer.valueOf(i + 1));
//			String terserPath = theTerserPath + "-" + (i + 1);
//
//			addChildren(nextParentName, treeParent, false, false, null, i, nextType, theSegment, theComponentPath, i, terserPath);
//		}
//
//		theComponentPath.remove(cpIndex);
//
//	}
//
//	void addChildren(String theParentName, MutableTreeNode theTreeParent, boolean theRepeating, boolean theRequired, String theName, int theRepNum, Type theType, Segment theParent,
//			List<Integer> theComponentNumbers, int theIndex, String theTerserPath) {
//		if (theType instanceof Varies) {
//			theType = ((Varies) theType).getData();
//		}
//
//		if (theType instanceof Composite) {
//			Composite composite = (Composite) theType;
//			TreeNodeType newNode = new TreeNodeType(theParentName, composite, theName, theRepNum, theRepeating, theRequired, theParent, theComponentNumbers, theTerserPath);
//			newNode = (TreeNodeType) insertOrReplaceWithExisting(theTreeParent, theIndex, newNode);
//
//			addChildren(theParentName, composite, newNode, theParent, theComponentNumbers, theTerserPath);
//		} else {
//			Primitive primitive = (Primitive) theType;
//			TreeNodeType newNode = new TreeNodePrimitive(theParentName, primitive, theName, theRepNum, theRepeating, theRequired, theParent, theComponentNumbers, theTerserPath);
//			newNode = (TreeNodeType) insertOrReplaceWithExisting(theTreeParent, theIndex, newNode);
//		}
//	}
//
//	public void destroy() {
//		removeMessageListeners();
//	}
//
//	private void doSynchronizeTreeWithHighlitedPath() {
//		String highlitedPath = myMessage.getHighlitedPath();
//
//		final AbstractLayoutCache layout = ((OutlineModel) getModel()).getLayout();
//		int lastSegmentRow = -1;
//		int currentSegmentRow = -1;
//		int currentSelectedRow = -1;
//		for (int row = 0; row < layout.getRowCount(); row++) {
//
//			TreePath path = layout.getPathForRow(row);
//			Object component = path.getLastPathComponent();
//			if (component instanceof TreeNodeMessage) {
//				continue;
//			}
//
//			if (component instanceof TreeNodeSegment) {
//				lastSegmentRow = row;
//			}
//
//			TreeNodeBase node = (TreeNodeBase) component;
//
//			String terserPath = node.getTerserPath();
//			if (highlitedPath != null && highlitedPath.startsWith(terserPath)) {
//				expandPath(path);
//				if (highlitedPath.equals(terserPath)) {
//					currentSelectedRow = row;
//					getSelectionModel().setSelectionInterval(row, row);
//					currentSegmentRow = lastSegmentRow;
//				}
//			} else {
//				collapsePath(path);
//			}
//
//		}
//
//		// Adjust the tree scrollpane's scroll position so that the newly
//		// selected row is visible
//		if (currentSegmentRow != -1 && currentSelectedRow != -1) {
//			JViewport viewPort = (JViewport) getParent();
//			final JScrollPane scrollPane = (JScrollPane) viewPort.getParent();
//
//			int tableHeaderHeight = getTableHeader().getHeight();
//
//			int numRowsVisible = ((scrollPane.getHeight() - tableHeaderHeight) / layout.getRowHeight()) - 1;
//			int segmentDelta = currentSelectedRow - currentSegmentRow;
//			if (segmentDelta > numRowsVisible) {
//				currentSegmentRow = currentSegmentRow + (segmentDelta - numRowsVisible);
//			}
//
//			final int scrollToRow = currentSegmentRow;
//			SwingUtilities.invokeLater(new Runnable() {
//				public void run() {
//					scrollPane.getVerticalScrollBar().setValue(layout.getRowHeight() * scrollToRow);
//				}
//			});
//
//		}
//	}
//
//	private void handleNewSelectedIndex(int theNewIndex) {
//		if (mySelectionHandlingDisabled) {
//			return;
//		}
//		log.info("New selection index: " + theNewIndex);
//
//		AbstractLayoutCache layout = ((OutlineModel) getModel()).getLayout();
//		TreePath path = layout.getPathForRow(theNewIndex);
//
//		DefaultMutableTreeNode lead = (DefaultMutableTreeNode) path.getLastPathComponent();
//		if (lead instanceof TreeNodeSegment) {
//			myMessage.setHighlitedSegment(((TreeNodeSegment) lead).getSegment());
//		} else if (lead instanceof TreeNodeType) {
//			TreeNodeType type = (TreeNodeType) lead;
//			myMessage.setHighlitedField(type.getSegmentAndComponentPath());
//		} else {
//			myMessage.clearHighlight();
//		}
//
//	}
//
//	/**
//	 * @return the showEmpty
//	 */
//	public boolean isShowEmpty() {
//		return myShowEmpty;
//	}
//
//	private void removeMessageListeners() {
//		if (myMessage != null) {
//			myMessage.removePropertyChangeListener(Hl7V2MessageImpl.PARSED_MESSAGE_PROPERTY, myParsedMessageListener);
//			myMessage.removePropertyChangeListener(Hl7V2MessageImpl.PROP_HIGHLITED_PATH, myHighlitedPathListener);
//		}
//	}
//
//	/**
//	 * Updates the panel with a new Message.
//	 */
//	public void setMessage(Hl7V2MessageImpl theMessage) {
//
//		removeMessageListeners();
//
//		myMessage = theMessage;
//
//		myMessage.addPropertyChangeListener(Hl7V2MessageImpl.PARSED_MESSAGE_PROPERTY, myParsedMessageListener);
//		myMessage.addPropertyChangeListener(Hl7V2MessageImpl.PROP_HIGHLITED_PATH, myHighlitedPathListener);
//
//		myTop = new TreeNodeMessage(myMessage);
//		myTreeModel = new DefaultTreeModel(myTop, false);
//
//		RowModel rowModel = new TreeRowModel(myTreeModel);
//		OutlineModel outlineModel = DefaultOutlineModel.createOutlineModel(myTreeModel, rowModel);
//		setModel(outlineModel);
//		setRootVisible(false);
//		
//		updateUI();
//
//		addChildren();
//
//		SwingUtilities.invokeLater(new Runnable() {
//
//			public void run() {
//				// getColumnModel().getColumn(0).setWidth(100);
//				// getColumnModel().getColumn(0).setPreferredWidth(100);
//				// getColumnModel().getColumn(0).setMinWidth(100);
//				// getColumnModel().getColumn(0).setMaxWidth(100);
//
//				getColumnModel().getColumn(1).setWidth(100);
//				getColumnModel().getColumn(1).setPreferredWidth(100);
//
//				int editWidth = getWidth() - 300;
//				// log.info("Edit width: " + editWidth);
//				getColumnModel().getColumn(2).setWidth(editWidth);
//				getColumnModel().getColumn(2).setPreferredWidth(editWidth);
//			}
//		});
//
//	}
//
//	public void setShowEmpty(boolean theShowEmpty) {
//		boolean oldValue = myShowEmpty;
//		myShowEmpty = theShowEmpty;
//		if (myShowEmpty != oldValue) {
//			addChildren();
//		}
//	}
//
//	private void synchronizeTreeWithHighlitedPath() {
//		try {
//			mySelectionHandlingDisabled = true;
//			doSynchronizeTreeWithHighlitedPath();
//		} finally {
//			mySelectionHandlingDisabled = false;
//		}
//	}
//
//	// /**
//	// * Adds children to the tree. If the Type is a Varies, the Varies data are
//	// * added under a new node called "Varies". If there are extra components,
//	// * these are added under a new node called "ExtraComponents"
//	// */
//	// private void addChildren(Type messParent, MutableTreeNode treeParent) {
//	// if (Varies.class.isAssignableFrom(messParent.getClass())) {
//	// // DefaultMutableTreeNode variesNode = new
//	// // DefaultMutableTreeNode("Varies");
//	// // treeParent.insert(variesNode, treeParent.getChildCount());
//	// Type data = ((Varies) messParent).getData();
//	// DefaultMutableTreeNode dataNode = new
//	// DefaultMutableTreeNode(getLabel(data));
//	// treeParent.insert(dataNode, 0);
//	// addChildren(data, dataNode);
//	// } else {
//	// if (Composite.class.isAssignableFrom(messParent.getClass())) {
//	// addChildren((Composite) messParent, treeParent);
//	// } else if (Primitive.class.isAssignableFrom(messParent.getClass())) {
//	// addChildren((Primitive) messParent, treeParent);
//	// }
//	//
//	// if (messParent.getExtraComponents().numComponents() > 0) {
//	// DefaultMutableTreeNode newNode = new
//	// DefaultMutableTreeNode("ExtraComponents");
//	// treeParent.insert(newNode, treeParent.getChildCount());
//	// for (int i = 0; i < messParent.getExtraComponents().numComponents(); i++)
//	// {
//	// DefaultMutableTreeNode variesNode = new DefaultMutableTreeNode("Varies");
//	// newNode.insert(variesNode, i);
//	// addChildren(messParent.getExtraComponents().getComponent(i), variesNode);
//	// }
//	// }
//	// }
//	// }
//
//	private static DefaultMutableTreeNode insertOrReplaceWithExisting(MutableTreeNode theTreeParent, int theIndex, DefaultMutableTreeNode theNewNode) {
//
//		if (theTreeParent.getChildCount() <= theIndex) {
//			theTreeParent.insert(theNewNode, theIndex);
//			return theNewNode;
//		}
//
//		if (theTreeParent.getChildAt(theIndex).equals(theNewNode)) {
//			return (DefaultMutableTreeNode) theTreeParent.getChildAt(theIndex);
//		}
//
//		while (theTreeParent.getChildCount() > (theIndex)) {
//			theTreeParent.remove(theIndex);
//
//			if (theTreeParent.getChildCount() > (theIndex) && theTreeParent.getChildAt(theIndex).equals(theNewNode)) {
//				return (DefaultMutableTreeNode) theTreeParent.getChildAt(theIndex);
//			}
//		}
//
//		theTreeParent.insert(theNewNode, theIndex);
//		return theNewNode;
//	}
//
//	/**
//	 * Not sure if it's a bug in outline or what, but this seems to be the only
//	 * way to reliably know what row is selected
//	 */
//	public class MySelectionModel extends DefaultListSelectionModel {
//
//		public void addSelectionInterval(int theIndex0, int theIndex1) {
//			// ignore
//		}
//
//		public void removeSelectionInterval(int theIndex0, int theIndex1) {
//			// ignore
//		}
//
//		public void setSelectionInterval(int theIndex0, int theIndex1) {
//			handleNewSelectedIndex(theIndex0);
//			super.setSelectionInterval(theIndex0, theIndex1);
//		}
//
//	}
//
//	public static class TreeNodeBase extends DefaultMutableTreeNode {
//		private Boolean myHasContent;
//
//		private final String myName;
//		private final boolean myRepeating;
//		private final int myRepNum;
//		private final boolean myRequired;
//		private final String myTerserPath;
//
//		public TreeNodeBase(Object theStructure, String theName, int theRepNum, boolean theRepeating, boolean theRequired, String theTerserPath) {
//			super(theStructure);
//			assert theStructure != null;
//
//			myName = theName;
//			myRepNum = theRepNum;
//			myRepeating = theRepeating;
//			myRequired = theRequired;
//			myTerserPath = theTerserPath;
//		}
//
//		@Override
//		public boolean equals(Object theObj) {
//			if (theObj == null || !getClass().equals(theObj.getClass())) {
//				return false;
//			}
//			return ((TreeNodeBase) theObj).getUserObject() == getUserObject();
//		}
//
//		/**
//		 * @return the groupName
//		 */
//		public String getName() {
//			return myName;
//		}
//
//		public String getNodeText() {
//			StringBuilder b = new StringBuilder();
//
//			b.append(myName);
//
//			if (myRepeating) {
//				b.append(" (rep ").append(myRepNum).append(")");
//			}
//
//			return b.toString();
//		}
//
//		/**
//		 * @return the repNum
//		 */
//		public int getRepNum() {
//			return myRepNum;
//		}
//
//		/**
//		 * @return the terserPath
//		 */
//		public String getTerserPath() {
//			return myTerserPath;
//		}
//
//		@Override
//		public int hashCode() {
//			return getUserObject().hashCode();
//		}
//
//		public Boolean isHasContent() {
//			if (myHasContent == null) {
//				for (int i = 0; i < getChildCount(); i++) {
//					TreeNodeBase next = (TreeNodeBase) getChildAt(i);
//					if (next.isHasContent() == Boolean.TRUE) {
//						myHasContent = Boolean.TRUE;
//						break;
//					}
//				}
//
//				if (myHasContent == null) {
//					myHasContent = Boolean.FALSE;
//				}
//			}
//			return myHasContent;
//		}
//
//		/**
//		 * @return the repeating
//		 */
//		public boolean isRepeating() {
//			return myRepeating;
//		}
//
//		/**
//		 * @return the required
//		 */
//		public boolean isRequired() {
//			return myRequired;
//		}
//
//	}
//
//	public static class TreeNodeGroup extends TreeNodeBase {
//
//		public TreeNodeGroup(Group theGroup, String theGroupName, int theRepNum, boolean theRepeating, boolean theRequired, String theTerserPath) {
//			super(theGroup, theGroupName, theRepNum, theRepeating, theRequired, theTerserPath);
//		}
//
//	}
//
//	public static class TreeNodeMessage extends DefaultMutableTreeNode {
//		public TreeNodeMessage(Hl7V2MessageImpl theMessage) {
//			super(theMessage);
//		}
//
//		public Hl7V2MessageImpl getMessage() {
//			return (Hl7V2MessageImpl) getUserObject();
//		}
//	}
//
//	public static class TreeNodeSegment extends TreeNodeBase {
//		public TreeNodeSegment(Segment theSegment, String theGroupName, int theRepNum, boolean theRepeating, boolean theRequired, String theTerserPath) {
//			super(theSegment, theGroupName, theRepNum, theRepeating, theRequired, theTerserPath);
//		}
//
//		public Segment getSegment() {
//			return (Segment) getUserObject();
//		}
//	}
//
//	public static class TreeNodePrimitive extends TreeNodeType {
//
//		public TreeNodePrimitive(String theParentName, Primitive theGroup, String theGroupName, int theRepNum, boolean theRepeating, boolean theRequired, Segment theParent, List<Integer> theComponentPath,
//				String theTerserPath) {
//			super(theParentName, theGroup, theGroupName, theRepNum, theRepeating, theRequired, theParent, theComponentPath, theTerserPath);
//		}
//
//		@Override
//		public Boolean isHasContent() {
//			Primitive p = (Primitive) getUserObject();
//			String value = p.getValue();
//			return value != null && value.length() > 0;
//		}
//
//		
//	}
//	
//	public static class TreeNodeType extends TreeNodeBase {
//		private ArrayList<Integer> myComponentPath;
//		private String myParentName;
//		private Segment mySegment;
//
//		public TreeNodeType(String theParentName, Type theGroup, String theGroupName, int theRepNum, boolean theRepeating, boolean theRequired, Segment theParent, List<Integer> theComponentPath,
//				String theTerserPath) {
//			super(theGroup, theGroupName, theRepNum, theRepeating, theRequired, theTerserPath);
//
//			Validate.notNull(theParent);
//			Validate.notNull(theComponentPath);
//			Validate.notEmpty(theComponentPath);
//
//			mySegment = theParent;
//			myParentName = theParentName;
//			myComponentPath = new ArrayList<Integer>(theComponentPath);
//		}
//
//		public String getNodeText() {
//			StringBuilder b = new StringBuilder();
//
//			b.append(myParentName);
//			// b.append(" ");
//			// b.append(getName());
//
//			if (isRepeating()) {
//				b.append(" (rep ").append(getRepNum()).append(")");
//			}
//
//			return b.toString();
//		}
//
//		public SegmentAndComponentPath getSegmentAndComponentPath() {
//			return new SegmentAndComponentPath(mySegment, myComponentPath);
//		}
//
//		public Type getType() {
//			return (Type) getUserObject();
//		}
//
//		public boolean isMsh1orMsh2() {
//			return "MSH-1".equals(myParentName) || "MSH-2".equals(myParentName);
//		}
//
//	}
//
//	public static class TreeRenderDataProvider implements RenderDataProvider {
//
//		private static final Color ourFgEmpty = new Color(0.5f, 0.5f, 0.5f);
//		private static final Color ourFgNormal = new Color(0.0f, 0.0f, 0.0f);
//		private static final Color ourFgSegment = new Color(0.2f, 0.2f, 0.8f);
//
//		public Color getBackground(Object theArg0) {
//			return Color.white;
//		}
//
//		public String getDisplayName(Object theObject) {
//			if (theObject instanceof TreeNodeMessage) {
//
//				TreeNodeMessage tnm = (TreeNodeMessage) theObject;
//				return (tnm.getMessage().getMessageDescription());
//
//			} else if (theObject instanceof TreeNodeBase) {
//
//				TreeNodeBase base = (TreeNodeBase) theObject;
//				return (base.getNodeText());
//
//			} else {
//
//				return "Unknown: " + theObject.getClass().getName();
//
//			}
//		}
//
//		public Color getForeground(Object theArg0) {
//			if (theArg0 instanceof TreeNodeBase) {
//				if (Boolean.FALSE == ((TreeNodeBase) theArg0).isHasContent()) {
//					return ourFgEmpty;
//				}
//			}
//			if (theArg0 instanceof TreeNodeSegment) {
//				return ourFgSegment;
//			}
//			return ourFgNormal;
//		}
//
//		public Icon getIcon(Object theArg0) {
//			return null;
//		}
//
//		public String getTooltipText(Object theArg0) {
//			return null;
//		}
//
//		public boolean isHtmlDisplayName(Object theArg0) {
//			return false;
//		}
//
//	}
//
//	public class TreeRowModel implements RowModel {
//
//		private static final int COL_NAME = 0;
//		private static final int COL_VALUE = 1;
//
//		private static final int NUM_COLS = 2;
//
//		private DefaultTreeModel myTreeModel;
//
//		public TreeRowModel(DefaultTreeModel theModel) {
//			myTreeModel = theModel;
//		}
//
//		private String encode(Segment theSegment) {
//			EncodingCharacters enc;
//			try {
//				enc = EncodingCharacters.getInstance(theSegment.getMessage());
//			} catch (HL7Exception e) {
//				log.error("Could not get encoding chars", e);
//				enc = new EncodingCharacters('|', null);
//			}
//
//			return PipeParser.encode(theSegment, enc);
//		}
//
//		private Object encode(Type theType) {
//			EncodingCharacters enc;
//			try {
//				enc = EncodingCharacters.getInstance(theType.getMessage());
//			} catch (HL7Exception e) {
//				log.error("Could not get encoding chars", e);
//				enc = new EncodingCharacters('|', null);
//			}
//
//			return PipeParser.encode(theType, enc);
//		}
//
//		public Class<?> getColumnClass(int theArg0) {
//			return String.class;
//		}
//
//		public int getColumnCount() {
//			return NUM_COLS;
//		}
//
//		public String getColumnName(int theArg0) {
//			switch (theArg0) {
//			case COL_NAME:
//				return "Name";
//			case COL_VALUE:
//			default:
//				return "Value";
//			}
//		}
//
//		public Object getValueFor(Object theObject, int theCol) {
//			if (theObject instanceof TreeNodeSegment) {
//
//				switch (theCol) {
//				case COL_NAME:
//					return null;
//				case COL_VALUE:
//				default:
//					return encode(((TreeNodeSegment) theObject).getSegment());
//				}
//
//			} else if (theObject instanceof TreeNodeType) {
//
//				TreeNodeType type = (TreeNodeType) theObject;
//				switch (theCol) {
//				case COL_NAME:
//					return type.getName();
//				case COL_VALUE:
//				default:
//					if (type.isMsh1orMsh2()) {
//						return ((Primitive) (type.getType())).getValue();
//					} else {
//						return encode(type.getType());
//					}
//				}
//
//			}
//
//			return null;
//		}
//
//		public boolean isCellEditable(Object theArg0, int theArg1) {
//			if (theArg1 == COL_VALUE) {
//				if (theArg0 instanceof TreeNodeSegment) {
//					return true;
//				}
//				if (theArg0 instanceof TreeNodeType) {
//					return true;
//				}
//			}
//			return false;
//		}
//
//		private void parse(Segment theSegment, String theNewValue) throws HL7Exception {
//			EncodingCharacters enc;
//			try {
//				enc = EncodingCharacters.getInstance(theSegment.getMessage());
//			} catch (HL7Exception e) {
//				log.error("Could not get encoding chars", e);
//				enc = new EncodingCharacters('|', null);
//			}
//
//			myPipeParser.parse(theSegment, theNewValue, enc);
//		}
//
//		private void parse(Type theType, String theNewValue) throws HL7Exception {
//			EncodingCharacters enc;
//			try {
//				enc = EncodingCharacters.getInstance(theType.getMessage());
//			} catch (HL7Exception e) {
//				log.error("Could not get encoding chars", e);
//				enc = new EncodingCharacters('|', null);
//			}
//
//			myPipeParser.parse(theType, theNewValue, enc);
//
//		}
//
//		public void setValueFor(Object theObject, int theCol, Object theNewValue) {
//			if (theCol != COL_VALUE) {
//				return;
//			}
//
//			if (theObject instanceof TreeNodeSegment) {
//				try {
//					parse(((TreeNodeSegment) theObject).getSegment(), (String) theNewValue);
//				} catch (HL7Exception e) {
//					log.error("Could not set value: " + theNewValue, e);
//					return;
//				}
//			} else if (theObject instanceof TreeNodeType) {
//				try {
//					TreeNodeType type = ((TreeNodeType) theObject);
//
//					if (type.isMsh1orMsh2()) {
//						((Primitive) type.getType()).setValue((String) theNewValue);
//					} else {
//						parse(type.getType(), (String) theNewValue);
//					}
//
//				} catch (HL7Exception e) {
//					log.error("Could not set value: " + theNewValue, e);
//					return;
//				}
//			} else {
//				return;
//			}
//
//			myMessage.updateSourceMessageBasedOnParsedMessage();
//
//		}
//
//	}

}
