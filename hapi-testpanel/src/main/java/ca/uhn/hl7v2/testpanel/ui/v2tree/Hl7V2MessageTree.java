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
package ca.uhn.hl7v2.testpanel.ui.v2tree;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListSelectionModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.tree.AbstractLayoutCache;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.netbeans.swing.outline.DefaultOutlineModel;
import org.netbeans.swing.outline.Outline;
import org.netbeans.swing.outline.OutlineModel;
import org.netbeans.swing.outline.RenderDataProvider;
import org.netbeans.swing.outline.RowModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.check.DefaultValidator;
import ca.uhn.hl7v2.model.AbstractGroup;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.primitive.AbstractNumericPrimitive;
import ca.uhn.hl7v2.model.primitive.ID;
import ca.uhn.hl7v2.model.primitive.IS;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.testpanel.controller.Controller;
import ca.uhn.hl7v2.testpanel.model.UnknownMessage;
import ca.uhn.hl7v2.testpanel.model.conf.ConformanceComposite;
import ca.uhn.hl7v2.testpanel.model.conf.ConformanceGroup;
import ca.uhn.hl7v2.testpanel.model.conf.ConformanceMessage;
import ca.uhn.hl7v2.testpanel.model.conf.ConformancePrimitive;
import ca.uhn.hl7v2.testpanel.model.conf.ConformanceSegment;
import ca.uhn.hl7v2.testpanel.model.conf.TableFile;
import ca.uhn.hl7v2.testpanel.model.msg.AbstractMessage;
import ca.uhn.hl7v2.testpanel.model.msg.Comment;
import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageBase;
import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageCollection;
import ca.uhn.hl7v2.testpanel.ui.IDestroyable;
import ca.uhn.hl7v2.testpanel.ui.ImageFactory;
import ca.uhn.hl7v2.testpanel.ui.ShowEnum;
import ca.uhn.hl7v2.testpanel.util.SegmentAndComponentPath;
import ca.uhn.hl7v2.util.StringUtil;
import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;

/**
 * This is a Swing panel that displays the contents of a Message object in a
 * JTree. The tree currently only expands to the field level (components shown
 * as one node).
 * 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public class Hl7V2MessageTree extends Outline implements IDestroyable {
	private static final DefaultValidation ourDefaultValidation = new DefaultValidation();

	private static final Logger ourLog = LoggerFactory.getLogger(Hl7V2MessageTree.class);
	private static final String TABLE_NAMESPACE_HL7 = "HL7";
	private static final String TBL = " ";
	private Controller myController;
	private boolean myCurrentlyEditing;
	private PropertyChangeListener myHighlitedPathListener;
	private PropertyChangeListener myMessageEncodingListener;
	private Hl7V2MessageCollection myMessages;
	private PropertyChangeListener myParsedMessagesListener;
	private PipeParser myPipeParser;
	private boolean myRespondingToManualRangeChange;
	private DefaultValidator myRuntimeProfileValidator;
	private boolean mySelectionHandlingDisabled;
	private boolean myShouldOpenDefaultPaths = true;

	private boolean myShowRep0 = true;

	private TreeRowModel myTableModel;

	private TreeNodeRoot myTop;

	private DefaultTreeModel myTreeModel;

	private ShowEnum myUnitTestShowMode;

	private UpdaterThread myUpdaterThread;

	private PropertyChangeListener myValidationContextListener;

	private IWorkingListener myWorkingListener;

	/** Creates new TreePanel */
	public Hl7V2MessageTree(Controller theController) {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				handleKeyPress(e);
			}
		});

		setFont(new Font("LUCIDA", Font.PLAIN, 9));

		myController = theController;

		myPipeParser = new PipeParser();
		myPipeParser.setValidationContext(new ValidationContextImpl());

		setRenderDataProvider(new TreeRenderDataProvider());

		setShowGrid(true);
		setGridColor(new Color(0.9f, 0.9f, 0.9f));
		setRowHeight(16);

		setRowSelectionAllowed(true);

		setSelectionModel(new MySelectionModel());

		ValueCellEditor valueCellEditor = new ValueCellEditor(getFont());
		setDefaultEditor(String.class, valueCellEditor);

		valueCellEditor.addCellEditorListener(new CellEditorListener() {

			public void editingCanceled(ChangeEvent theE) {
				ourLog.info("No longer editing");
				myCurrentlyEditing = false;
			}

			public void editingStopped(ChangeEvent theE) {
				ourLog.info("No longer editing");
				myCurrentlyEditing = false;
			}
		});

		myHighlitedPathListener = new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent theEvt) {
				if (myController.isMessageEditorInFollowMode()) {
					if (Hl7V2MessageTree.this.hasFocus() == false) {
						synchronizeTreeWithHighlitedPath();
					}
				}
			}

		};

		myParsedMessagesListener = new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent theEvt) {
				myUpdaterThread.scheduleUpdate();
			}
		};

		myValidationContextListener = new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent theEvt) {
				myUpdaterThread.scheduleUpdate();
			}
		};

		myMessageEncodingListener = new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent theEvt) {
				myUpdaterThread.scheduleUpdate();
			}
		};

		getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		myUpdaterThread = new UpdaterThread();
		myUpdaterThread.start();
	}

	private int addChidrenExtra(String theParentName, Type thePrimitive, TreeNodeBase treeParent, Segment theSegment, List<Integer> theComponentPath, String theTerserPath, int cpIndex, int index) throws InterruptedException, InvocationTargetException {
		// Extra components
		for (int i = 0; i < thePrimitive.getExtraComponents().numComponents(); i++) {
			Type nextType = thePrimitive.getExtraComponents().getComponent(i);
			String nextParentName = theParentName + "-" + (i + 1);

			// theComponentPath.set(cpIndex, Integer.valueOf(i + 1));
			String terserPath = theTerserPath + "-" + (i + 1);

			index = addChildren(nextParentName, treeParent, false, false, null, i, nextType, theSegment, theComponentPath, index, terserPath);
		}
		return index;
	}

	void addChildren() throws InterruptedException, InvocationTargetException {
		if (myMessages != null && myMessages.getRuntimeProfile() != null) {
			myRuntimeProfileValidator = new DefaultValidator();
			myRuntimeProfileValidator.setValidateChildren(false);
		}

		final Set<String> openPaths = getOpenPaths();

		int selectedRow = getSelectedRow();
		final String selectedPath = getPathAtRow(selectedRow);

		if (myMessages != null) {
			try {
				addChildren(myMessages.getMessages(), myTop, "");
			} catch (InterruptedException e) {
				ourLog.info("Interrupted during an update loop, going to schedule another pass");
				myUpdaterThread.scheduleUpdate();
			} catch (InvocationTargetException e) {
				ourLog.error("Failed up update message tree", e);
			}

			myTop.validate();

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					myTreeModel.nodeStructureChanged(myTop);
				}
			});

		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mySelectionHandlingDisabled = true;
					ourLog.debug("Open paths are: {}", openPaths);
					if (openPaths.isEmpty() && myShouldOpenDefaultPaths) {
						ourLog.info("Opening default paths");
						final AbstractLayoutCache layout = ((OutlineModel) getModel()).getLayout();
						for (int row = 0; row < layout.getRowCount(); row++) {
							TreePath path = layout.getPathForRow(row);
							Object component = path.getLastPathComponent();
							if (component instanceof TreeNodeMessage || component instanceof TreeNodeUnknown || component instanceof TreeNodeGroup) {
								expandPath(path);
							}
						}
						myShouldOpenDefaultPaths = false;
					} else {
						ourLog.info("Opening pre-existing paths: {} and selected path: {}", openPaths, selectedPath);
						expandPaths(openPaths, selectedPath);
					}
				} finally {
					mySelectionHandlingDisabled = false;
				}
			}
		});
		// if (selectedRow != -1) {
		// getSelectionModel().setSelectionInterval(selectedRow, selectedRow);
		// handleNewSelectedIndex(selectedRow);
		// }

	}

	/**
	 * Adds the children of the given group under the given tree node.
	 */
	void addChildren(Group messParent, TreeNodeBase treeParent, String theTerserPath) throws InterruptedException, InvocationTargetException {

		String[] childNames = messParent.getNames();
		int currChild = 0;
		for (int i = 0; i < childNames.length; i++) {

			try {
				String nextName = childNames[i];

				switch (getShowMode()) {
				case ALL:
				case ERROR:
					// case POPULATED:
					/*
					 * this creates at least one rep if there are none, since
					 * these modes want to show the node in the tree regardless
					 * of whether or not it has content
					 */
					messParent.get(nextName);
				default:
					// nothing
				}

				Structure[] childReps = messParent.getAll(nextName);
				boolean repeating = messParent.isRepeating(nextName);
				boolean required = messParent.isRequired(nextName);

				for (int j = 0; j < childReps.length; j++) {

					TreeNodeBase newNode = null;
					Structure nextStructure = childReps[j];
					String groupName = nextStructure.getName();

					String nextTerserPath = theTerserPath + "/" + groupName + (j > 0 ? ("(" + (j + 1) + ")") : "");

					if (nextStructure instanceof Group) {

						if (nextStructure instanceof ConformanceGroup) {
							newNode = new TreeNodeGroupConf((ConformanceGroup) nextStructure, groupName, j, repeating, required, nextTerserPath);
						} else {
							newNode = new TreeNodeGroup((Group) nextStructure, groupName, j, repeating, required, nextTerserPath);
						}

						addChildren((Group) nextStructure, newNode, nextTerserPath);

						newNode = insertOrReplaceWithExisting(treeParent, currChild, newNode);

					} else if (nextStructure instanceof Segment) {

						if (nextStructure instanceof ConformanceSegment) {
							newNode = new TreeNodeSegmentConf((ConformanceSegment) nextStructure, groupName, j, repeating, required, nextTerserPath);
						} else {
							newNode = new TreeNodeSegment((Segment) nextStructure, groupName, j, repeating, required, nextTerserPath);
						}

						addChildren((Segment) nextStructure, newNode, nextTerserPath);

						newNode = insertOrReplaceWithExisting(treeParent, currChild, newNode);

					}

					currChild++;
					// treeParent.insert(newNode, currChild++);
				}
			} catch (HL7Exception e) {
				ourLog.error("Failed to add group to tree", e);
			}
		}
	}

	void addChildren(List<AbstractMessage<?>> theMessages, TreeNodeRoot theTop, String theTerserPath) throws InterruptedException, InvocationTargetException {
		int index = 0;
		for (AbstractMessage<?> abstractMessage : theMessages) {

			if (abstractMessage instanceof Hl7V2MessageBase) {

				Hl7V2MessageBase message = (Hl7V2MessageBase) abstractMessage;
				TreeNodeMessage node;
				if (message.getParsedMessage() instanceof ConformanceMessage) {
					node = new TreeNodeMessageConf(index, message);
				} else {
					node = new TreeNodeMessage(index, message);
				}
				insertOrReplaceWithExisting(theTop, index, node);

				addChildren(node.getMessage().getParsedMessage(), node, "");

			} else if (abstractMessage instanceof UnknownMessage) {

				UnknownMessage unknownMessage = (UnknownMessage) abstractMessage;
				TreeNodeUnknown node = new TreeNodeUnknown(unknownMessage);
				insertOrReplaceWithExisting(theTop, index, node);

				String message = unknownMessage.getParsedMessage();
				for (String line : message.split("(\\n|\\r)+")) {
					line = StringUtil.chomp(line);
					node.add(new TreeNodeUnknownLine(line));
				}

			} else if (abstractMessage instanceof Comment) {

				TreeNodeComment node = new TreeNodeComment((Comment) abstractMessage);
				insertOrReplaceWithExisting(theTop, index, node);

			} else {

				throw new IllegalStateException("Unknown type: " + abstractMessage.getClass());

			}

			index++;
		}
	}

	/**
	 * Add fields of a segment to the tree ...
	 */
	void addChildren(Segment messParent, TreeNodeBase treeParent, String theTerserPath) throws InterruptedException, InvocationTargetException {

		int n = messParent.numFields();
		String[] names = messParent.getNames();
		int index = 0;
		for (int i = 1; i <= n; i++) {
			try {

				List<Integer> components = new ArrayList<Integer>();
				components.add(Integer.valueOf(i));

				switch (getShowMode()) {
				case ALL:
				case ERROR:
					// case POPULATED:
					/*
					 * this creates at least one rep if there are none, since
					 * these modes want to show the node in the tree regardless
					 * of whether or not it has content
					 */
					messParent.getField(i, 0);
				default:
					// nothing
				}

				Type[] reps = messParent.getField(i);
				boolean repeating = messParent.getMaxCardinality(i) != 1;
				boolean required = messParent.isRequired(i);
				String name = i <= names.length ? names[i - 1] : "Unknown";

				for (int j = 0; j < reps.length; j++) {

					// String field = PipeParser.encode(reps[j], encChars);

					Type type = reps[j];
					String parentName = messParent.getName() + "-" + (i);

					StringBuilder b = new StringBuilder();
					b.append(theTerserPath);
					b.append("-");
					b.append((i));
					if (repeating) {
						b.append('(');
						b.append(j + 1);
						b.append(')');
					}
					String terserPath = b.toString();

					index = addChildren(parentName, treeParent, repeating, required, name, j, type, messParent, components, index, terserPath);

				}

			} catch (HL7Exception e) {
				ourLog.error("Failed to add child to tree", e);
			}
		}
	}

	/**
	 * Adds components of a composite to the tree ...
	 * 
	 */
	void addChildren(String theParentName, Composite messParent, TreeNodeBase treeParent, Segment theSegment, List<Integer> theComponentPath, String theTerserPath) throws InterruptedException, InvocationTargetException {
		Type[] components = messParent.getComponents();

		int cpIndex = theComponentPath.size();
		theComponentPath.add(null);

		int index = 0;
		for (int i = 0; i < components.length; i++) {
			Type nextType = components[i];
			String nextParentName = theParentName + "-" + (i + 1);

			theComponentPath.set(cpIndex, Integer.valueOf(i + 1));
			String terserPath = theTerserPath + "-" + (i + 1);

			index = addChildren(nextParentName, treeParent, false, false, null, i, nextType, theSegment, theComponentPath, index, terserPath);
		}

		index = addChidrenExtra(theParentName, messParent, treeParent, theSegment, theComponentPath, theTerserPath, cpIndex, index);

		theComponentPath.remove(cpIndex);

	}

	int addChildren(String theParentName, TreeNodeBase theTreeParent, boolean theRepeating, boolean theRequired, String theName, int theRepNum, Type theType, Segment theParent, List<Integer> theComponentNumbers, int theIndex, String theTerserPath) throws InterruptedException,
			InvocationTargetException {
		if (theType instanceof Varies) {
			theType = ((Varies) theType).getData();
		}

		if (theType instanceof Composite) {
			Composite composite = (Composite) theType;
			TreeNodeType newNode;
			if (composite instanceof ConformanceComposite) {
				newNode = new TreeNodeCompositeConf(theParentName, composite, theName, theRepNum, theRepeating, theRequired, theParent, theComponentNumbers, theTerserPath);
			} else {
				newNode = new TreeNodeType(theParentName, composite, theName, theRepNum, theRepeating, theRequired, theParent, theComponentNumbers, theTerserPath);
			}

			addChildren(theParentName, composite, newNode, theParent, theComponentNumbers, theTerserPath);

			newNode = (TreeNodeType) insertOrReplaceWithExisting(theTreeParent, theIndex, newNode);

		} else {

			Primitive primitive = (Primitive) theType;
			TreeNodeType newNode;
			if (primitive instanceof ConformancePrimitive) {
				newNode = new TreeNodePrimitiveConf(theParentName, (ConformancePrimitive) primitive, theName, theRepNum, theRepeating, theRequired, theParent, theComponentNumbers, theTerserPath);
			} else {
				newNode = new TreeNodePrimitive(theParentName, primitive, theName, theRepNum, theRepeating, theRequired, theParent, theComponentNumbers, theTerserPath);
			}

			addChidrenExtra(theParentName, primitive, newNode, theParent, theComponentNumbers, theTerserPath, theComponentNumbers.size(), 0);

			newNode = (TreeNodeType) insertOrReplaceWithExisting(theTreeParent, theIndex, newNode);

		}

		return theIndex + 1;
	}


	public void collapseAll() {
		AbstractLayoutCache layout = ((OutlineModel) getModel()).getLayout();
		for (int i = 0; i < layout.getRowCount(); i++) {
			TreePath path = layout.getPathForRow(i);
			collapsePath(path);
		}
	}

	public void destroy() {
		removeMessageListeners();

		myTop.destroy();
		myUpdaterThread.stopThread();
	}

	private void doSynchronizeTreeWithHighlitedPath() {
		String highlitedPath = myMessages.getHighlitedPath();
		if (highlitedPath == null) {
			return;
		}

		final AbstractLayoutCache layout = ((OutlineModel) getModel()).getLayout();
		int lastSegmentRow = -1;
		int currentSegmentRow = -1;
		int currentSelectedRow = -1;
		int currentMessageIndex = -1;
		for (int row = 0; row < layout.getRowCount(); row++) {

			TreePath path = layout.getPathForRow(row);
			Object component = path.getLastPathComponent();
			if (component instanceof TreeNodeMessage) {
				currentMessageIndex = ((TreeNodeMessage) component).getMessageIndex();
				if (highlitedPath.startsWith(currentMessageIndex + "/")) {
					expandPath(path);
				} else {
					// collapsePath(path);
				}
				continue;
			}

			if (component instanceof TreeNodeUnknown) {
				continue;
			}

			if (component instanceof TreeNodeSegment) {
				lastSegmentRow = row;
			}

			TreeNodeBase node = (TreeNodeBase) component;

			String terserPath = (currentMessageIndex) + node.getTerserPath();
			if (highlitedPath != null && highlitedPath.startsWith(terserPath) && !highlitedPath.startsWith(terserPath + "(")) {
				expandPath(path);
				if (highlitedPath.equals(terserPath)) {
					currentSelectedRow = row;
					getSelectionModel().setSelectionInterval(row, row);
					currentSegmentRow = lastSegmentRow;
				}
			} else {
				// collapsePath(path);
			}

		}

		// Adjust the tree scrollpane's scroll position so that the newly
		// selected row is visible
		if (currentSegmentRow != -1 && currentSelectedRow != -1 && !myRespondingToManualRangeChange) {
			JViewport viewPort = (JViewport) getParent();
			final JScrollPane scrollPane = (JScrollPane) viewPort.getParent();

			int tableHeaderHeight = getTableHeader().getHeight();

			int numRowsVisible = ((scrollPane.getHeight() - tableHeaderHeight) / layout.getRowHeight()) - 1;
			int segmentDelta = currentSelectedRow - currentSegmentRow;
			if (segmentDelta > numRowsVisible) {
				currentSegmentRow = currentSegmentRow + (segmentDelta - numRowsVisible);
			}

			final int scrollToRow = currentSegmentRow;
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					scrollPane.getVerticalScrollBar().setValue(layout.getRowHeight() * scrollToRow);
				}
			});

		}
	}

	public void expandAll() {
		AbstractLayoutCache layout = ((OutlineModel) getModel()).getLayout();
		for (int i = 0; i < layout.getRowCount(); i++) {
			TreePath path = layout.getPathForRow(i);
			expandPath(path);
		}
	}

	private void expandPaths(Set<String> theOpenPaths, String theSelectedPath) {
		AbstractLayoutCache layout = ((OutlineModel) getModel()).getLayout();
		int messageIndex = -1;
		for (int i = 0; i < layout.getRowCount(); i++) {
			TreePath path = layout.getPathForRow(i);

			Object baseObj = path.getLastPathComponent();
			String pathString = null;
			if (baseObj instanceof TreeNodeMessage || baseObj instanceof TreeNodeUnknown) {
				messageIndex++;
				pathString = Integer.toString(messageIndex);
			} else if (baseObj instanceof TreeNodeBase) {
				pathString = (Integer.toString(messageIndex) + ((TreeNodeBase) baseObj).getTerserPath());
			}

			if (pathString != null) {
				if (theOpenPaths.contains(pathString)) {
					expandPath(path);
				} else {
					collapsePath(path);
				}
				if (pathString.equals(theSelectedPath)) {
					getSelectionModel().setSelectionInterval(i, i);
				}
			}

		}

	}

	private Set<String> getOpenPaths() {
		Set<String> retVal = new HashSet<String>();

		TableModel model = getModel();
		AbstractLayoutCache layout = ((OutlineModel) model).getLayout();
		int messageIndex = -1;
		for (int i = 0; i < layout.getRowCount(); i++) {
			TreePath path = layout.getPathForRow(i);

			Object baseObj = path.getLastPathComponent();
			if (baseObj instanceof TreeNodeMessage || baseObj instanceof TreeNodeUnknown) {

				messageIndex++;

				if (layout.getExpandedState(path)) {
					retVal.add(Integer.toString(messageIndex));
				}

			} else {

				baseObj = path.getPathComponent(path.getPathCount() - 2);
				if (baseObj instanceof TreeNodeBase) {
					retVal.add(Integer.toString(messageIndex) + ((TreeNodeBase) baseObj).getTerserPath());
				}
			}

		}

		return retVal;
	}

	private String getPathAtRow(int theRowIndex) {

		AbstractLayoutCache layout = ((OutlineModel) getModel()).getLayout();
		int messageIndex = -1;
		for (int i = 0; i < layout.getRowCount(); i++) {
			TreePath path = layout.getPathForRow(i);

			Object baseObj = path.getLastPathComponent();
			if (baseObj instanceof TreeNodeMessage || baseObj instanceof TreeNodeUnknown) {

				messageIndex++;
				if (i == theRowIndex) {
					return Integer.toString(messageIndex);
				}

			} else {

				if (i == theRowIndex && baseObj instanceof TreeNodeBase) {
					return (Integer.toString(messageIndex) + ((TreeNodeBase) baseObj).getTerserPath());
				}

			}

		}

		return null;
	}

	private ShowEnum getShowMode() {
		if (myUnitTestShowMode != null) {
			return myUnitTestShowMode;
		}
		ShowEnum showMode = myMessages != null ? myMessages.getEditorShowMode() : ShowEnum.POPULATED;
		return showMode;
	}

	private void handleKeyPress(KeyEvent theE) {
		int row = getSelectedRow();
		if (row == -1) {
			return;
		}

		if (theE.getKeyCode() == KeyEvent.VK_ENTER || theE.getKeyCode() == KeyEvent.VK_F2) {
			AbstractLayoutCache layout = ((OutlineModel) getModel()).getLayout();
			TreePath path = layout.getPathForRow(row);
			TreeNodeBase baseObj = (TreeNodeBase) path.getLastPathComponent();
			if (myTableModel.isCellEditable(baseObj, TreeRowModel.COL_VALUE)) {
				editCellAt(row, TreeRowModel.COL_VALUE + 1);
				theE.consume();
			}
		}
	}

	private void handleNewSelectedIndex(int theNewIndex) {
		if (mySelectionHandlingDisabled) {
			return;
		}
		ourLog.info("New selection index: " + theNewIndex);

		if (myCurrentlyEditing) {
			ourLog.info("Not responding to new selection index because we are marked as editing right now");
			return;
		}

		AbstractLayoutCache layout = ((OutlineModel) getModel()).getLayout();
		TreePath path = layout.getPathForRow(theNewIndex);

		DefaultMutableTreeNode lead = (DefaultMutableTreeNode) path.getLastPathComponent();
		if (lead instanceof TreeNodeSegment) {
			TreeNodeSegment segmentNode = (TreeNodeSegment) lead;
			myMessages.setHighlitedRangeBasedOnSegment(segmentNode.getSegment());
		} else if (lead instanceof TreeNodeGroup) {
			TreeNodeGroup type = (TreeNodeGroup) lead;
			try {
				List<Segment> segments = type.getSegments();
				myMessages.setHighlitedRangeBasedOnSegment(segments.toArray(new Segment[segments.size()]));
			} catch (HL7Exception e) {
				e.printStackTrace();
			}
		} else if (lead instanceof TreeNodeType) {
			TreeNodeType type = (TreeNodeType) lead;
			myMessages.setHighlitedRangeBasedOnField(type.getSegmentAndComponentPath());
		} else {
			myMessages.clearHighlight();
		}

	}

	private void removeMessageListeners() {
		if (myMessages != null) {
			myMessages.removePropertyChangeListener(Hl7V2MessageCollection.PROP_HIGHLITED_PATH, myHighlitedPathListener);
			myMessages.removePropertyChangeListener(Hl7V2MessageCollection.PARSED_MESSAGES_PROPERTY, myParsedMessagesListener);
			myMessages.removePropertyChangeListener(Hl7V2MessageCollection.PROP_VALIDATIONCONTEXT_OR_PROFILE, myValidationContextListener);
			myMessages.removePropertyChangeListener(Hl7V2MessageCollection.PROP_ENCODING, myMessageEncodingListener);
		}
	}

	public void scheduleNewValidationPass() {
		myUpdaterThread.scheduleUpdate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEditingRow(int theARow) {
		if (theARow == -1) {
			myCurrentlyEditing = false;
		} else {
			ourLog.info("Beginning editing row " + theARow);
			myCurrentlyEditing = true;
		}
		super.setEditingRow(theARow);
	}

	public void setEditorShowModeAndUpdateAccordingly(ShowEnum theValue) {
		if (myMessages != null && theValue != myMessages.getEditorShowMode()) {
			myMessages.setEditorShowMode(theValue);
			myUpdaterThread.scheduleUpdateNow();
		}
	}

	/**
	 * Updates the panel with a new Message.
	 */
	public void setMessage(Hl7V2MessageCollection theMessage) {

		removeMessageListeners();

		myMessages = theMessage;

		myMessages.addPropertyChangeListener(Hl7V2MessageCollection.PROP_HIGHLITED_PATH, myHighlitedPathListener);
		myMessages.addPropertyChangeListener(Hl7V2MessageCollection.PARSED_MESSAGES_PROPERTY, myParsedMessagesListener);
		myMessages.addPropertyChangeListener(Hl7V2MessageCollection.PROP_VALIDATIONCONTEXT_OR_PROFILE, myValidationContextListener);
		myMessages.addPropertyChangeListener(Hl7V2MessageCollection.PROP_ENCODING, myMessageEncodingListener);

		myTop = new TreeNodeRoot();
		myTreeModel = new DefaultTreeModel(myTop, false);

		myTableModel = new TreeRowModel(myTreeModel);
		OutlineModel outlineModel = DefaultOutlineModel.createOutlineModel(myTreeModel, myTableModel);
		setModel(outlineModel);

		setRootVisible(false);

		setDefaultRenderer(NodeValidationFailure.class, new ValidationTreeCellRenderer());

		// Volumn index is off by one because of the tree
		getColumnModel().getColumn(TreeRowModel.COL_VALUE + 1).setCellRenderer(new ValueCellRenderer(this));

		updateUI();

		myUpdaterThread.scheduleUpdateNow();

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				int width = getWidth() - 140;

				getColumnModel().getColumn(0).setPreferredWidth(width / 2);

				// Min
				getColumnModel().getColumn(1).setPreferredWidth(35);
				getColumnModel().getColumn(1).setMinWidth(35);
				getColumnModel().getColumn(1).setMaxWidth(35);

				// Max
				getColumnModel().getColumn(2).setPreferredWidth(35);
				getColumnModel().getColumn(2).setMinWidth(35);
				getColumnModel().getColumn(2).setMaxWidth(35);

				// Length
				getColumnModel().getColumn(3).setPreferredWidth(50);
				getColumnModel().getColumn(3).setMinWidth(50);
				getColumnModel().getColumn(3).setMaxWidth(50);

				// Validated
				getColumnModel().getColumn(4).setPreferredWidth(20);
				getColumnModel().getColumn(4).setMinWidth(20);
				getColumnModel().getColumn(4).setMaxWidth(20);

				getColumnModel().getColumn(5).setPreferredWidth(width / 2);
			}
		});

	}

	void setMessageForUnitTest(Hl7V2MessageCollection theMessageModel) {
		myMessages = theMessageModel;
	}

	void setRuntimeProfileValidator(DefaultValidator theRuntimeProfileValidator) {
		myRuntimeProfileValidator = theRuntimeProfileValidator;
	}

	public void setUnitTestShowMode(ShowEnum theUnitTestShowMode) {
		myUnitTestShowMode = theUnitTestShowMode;
		myUpdaterThread.scheduleUpdateNow();
	}

	/**
	 * @param theWorkingListener
	 *            the workingListener to set
	 */
	public void setWorkingListener(IWorkingListener theWorkingListener) {
		myWorkingListener = theWorkingListener;
	}

	private void synchronizeTreeWithHighlitedPath() {
		try {
			mySelectionHandlingDisabled = true;
			doSynchronizeTreeWithHighlitedPath();
		} finally {
			mySelectionHandlingDisabled = false;
		}
	}

	private String xmlEncode(String theValue) {
		if (theValue == null) {
			return null;
		}

		StringBuilder b = new StringBuilder();
		for (int i = 0; i < theValue.length(); i++) {
			char nextChar = theValue.charAt(i);
			switch (nextChar) {
			case '\r':
			case '\n':
				b.append("<br>");
				break;
			case ' ':
				b.append("&nbsp;");
				break;
			case '&':
				b.append("&amp;");
				break;
			case '<':
				b.append("&lt;");
				break;
			case '>':
				b.append("&gt;");
				break;
			default:
				b.append(nextChar);
			}
		}
		return b.toString();
	}

	private static TreeNodeBase insertOrReplaceWithExisting(final TreeNodeBase theTreeParent, final int theIndex, final TreeNodeBase theNewNode) throws InterruptedException, InvocationTargetException {

		if (theTreeParent.getChildCount() <= theIndex) {
			EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					theTreeParent.insert(theNewNode, theIndex);
				}
			});
			return theNewNode;
		}

		// if (theTreeParent.getChildAt(theIndex).equals(theNewNode)) {
		// return (TreeNodeBase) theTreeParent.getChildAt(theIndex);
		// }

		while (theTreeParent.getChildCount() > (theIndex)) {
			TreeNode node = theTreeParent.getChildAt(theIndex);
			if (node instanceof IDestroyable) {
				((IDestroyable) node).destroy();
			}

			EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					theTreeParent.remove(theIndex);
				}
			});
			if (theTreeParent.getChildCount() > (theIndex) && theTreeParent.getChildAt(theIndex).equals(theNewNode)) {
				return (TreeNodeBase) theTreeParent.getChildAt(theIndex);
			}
		}

		EventQueue.invokeAndWait(new Runnable() {
			public void run() {
				theTreeParent.insert(theNewNode, theIndex);
			}
		});

		return theNewNode;
	}

	/**
	 * Left pads a string representation of the integer to make it 4 digits long
	 */
	public static String toHl7Table(int theTable) {
		return StringUtils.leftPad(Integer.toString(theTable), 4, '0');
	}

	public interface IWorkingListener {
		void finishedWorking(String theStatus);

		void startedWorking();

	}

	/**
	 * Not sure if it's a bug in outline or what, but this seems to be the only
	 * way to reliably know what row is selected
	 */
	public class MySelectionModel extends DefaultListSelectionModel {

		public void addSelectionInterval(int theIndex0, int theIndex1) {
			// ignore
		}

		public void removeSelectionInterval(int theIndex0, int theIndex1) {
			// ignore
		}

		public void setSelectionInterval(int theIndex0, int theIndex1) {
			myRespondingToManualRangeChange = true;
			try {
				handleNewSelectedIndex(theIndex0);
				super.setSelectionInterval(theIndex0, theIndex1);
			} finally {
				myRespondingToManualRangeChange = false;
			}
		}

	}

	private class NodeValidationFailure {
		private Icon myIcon;
		private String myMessage;

		public NodeValidationFailure(Icon theIcon, String theMessage) {
			super();
			myIcon = theIcon;
			myMessage = theMessage;
		}

		/**
		 * @return the icon
		 */
		public Icon getIcon() {
			return myIcon;
		}

		/**
		 * @return the message
		 */
		public String getMessage() {
			return myMessage;
		}
	}

	public abstract class TreeNodeBase extends DefaultMutableTreeNode {
		protected static final String COLOR_REPNUM = "#808000";

		private Boolean myContainError;
		private String myErrorDescription;
		private Boolean myHasContent;
		private final String myName;
		private final Boolean myRepeating;
		private final int myRepNum;
		private final Boolean myRequired;
		private final String myTerserPath;
		private List<HL7Exception> myValidationExceptions = new ArrayList<HL7Exception>();

		public TreeNodeBase(Object theStructure) {
			super(theStructure);
			assert theStructure != null || this instanceof TreeNodeRoot;

			myName = null;
			myTerserPath = null;
			myRepNum = 0;
			myRepeating = null;
			myRequired = null;
		}

		public TreeNodeBase(Object theStructure, String theName, int theRepNum, Boolean theRepeating, Boolean theRequired, String theTerserPath) {
			super(theStructure);
			assert theStructure != null;

			myName = theName;
			myRepNum = theRepNum;
			myRepeating = theRepeating;
			myRequired = theRequired;
			myTerserPath = theTerserPath;
		}

		public void addValidationExceptions(List<HL7Exception> theProblems) {
			addValidationExceptions(theProblems.toArray(new HL7Exception[theProblems.size()]));
		}

		public void addValidationExceptions(HL7Exception... theExceptions) {
			for (HL7Exception hl7Exception : theExceptions) {
				myValidationExceptions.add(hl7Exception);
			}
		}

		public int countExceptions() {
			int retVal = 0;

			for (int i = 0; i < getChildCount(); i++) {
				TreeNodeBase next = (TreeNodeBase) getChildAt(i);
				retVal += next.countExceptions();
			}

			retVal += myValidationExceptions.size();
			return retVal;
		}

		/**
		 * Subclasses may override if validation is possible
		 */
		public void doValidate() {
			// nothing
		}

		@Override
		public boolean equals(Object theObj) {
			if (theObj == null || !getClass().equals(theObj.getClass())) {
				return false;
			}
			return ((TreeNodeBase) theObj).getUserObject() == getUserObject();
		}

		public String getDisplayName() {
			return null;
		}

		/**
		 * @return the errorDescription
		 */
		public String getErrorDescription() {
			if (myErrorDescription == null && myValidationExceptions.size() > 0) {
				StringBuilder b = new StringBuilder();
				b.append("<html><ul>");
				for (HL7Exception next : myValidationExceptions) {
					b.append("<li>");
					b.append(next.getMessage());
				}
				b.append("</ul></html>");

				myErrorDescription = b.toString();
			}
			return myErrorDescription;
		}

		public Integer getMaxLength() {
			return null;
		}

		public Short getMaxReps() {
			if (isRepeating() == null) {
				return null;
			} else if (isRepeating()) {
				return -1;
			} else {
				return 1;
			}
		}

		public Short getMinReps() {
			if (isRequired() == null) {
				return null;
			} else if (isRequired()) {
				return 1;
			} else {
				return 0;
			}
		}

		/**
		 * @return the groupName
		 */
		public String getName() {
			return myName;
		}

		public StringBuilder getNodeText() {
			StringBuilder b = new StringBuilder();

			b.append("<font color=\"" + getNodeTextColor() + "\">");
			b.append(myName);
			b.append("</font>");

			if (myRepeating != null && myRepeating && (myShowRep0 || getRepNum() > 0)) {
				b.append("<font color=\"" + COLOR_REPNUM + "\">");
				b.append(" (rep");
				if (myRepNum > 0) {
					b.append(' ');
					b.append(myRepNum + 1);
				}
				b.append(")");
				b.append("</font>");
			}

			if (StringUtils.isNotBlank(getDisplayName())) {
				b.append("<font color=\"#00A000\">");
				b.append(" - ");
				b.append(getDisplayName());
				b.append("</font>");
			}

			return b;
		}

		public String getNodeTextColor() {
			return "#000000";
		}

		public String getPipeEncodedValue() {
			return null;
		}

		/**
		 * @return the repNum
		 */
		public int getRepNum() {
			return myRepNum;
		}

		/**
		 * @return the terserPath
		 */
		public String getTerserPath() {
			return myTerserPath;
		}

		@Override
		public int hashCode() {
			Object object = getUserObject();
			if (object != null) {
				return object.hashCode();
			} else {
				return super.hashCode();
			}
		}

		/**
		 * @return the containError
		 */
		public boolean isContainError() {
			if (myContainError == null) {
				if (isHasContent() == false) {
					myContainError = false;
				} else if (getErrorDescription() != null) {
					myContainError = true;
				} else {
					for (int i = 0; i < getChildCount(); i++) {
						TreeNodeBase nextChild = (TreeNodeBase) getChildAt(i);
						if (nextChild.isHasContent() && nextChild.isContainError()) {
							myContainError = true;
							break;
						}
					}
					if (myContainError == null) {
						myContainError = false;
					}
				}
			}
			return myContainError;
		}

		public Boolean isHasContent() {
			if (myHasContent == null) {
				for (int i = 0; i < getChildCount(); i++) {
					TreeNodeBase next = (TreeNodeBase) getChildAt(i);
					if (next.isHasContent() == Boolean.TRUE) {
						myHasContent = Boolean.TRUE;
						break;
					}
				}

				if (myHasContent == null) {
					myHasContent = Boolean.FALSE;
				}
			}
			return myHasContent;
		}

		/**
		 * @return the repeating
		 */
		public Boolean isRepeating() {
			return myRepeating;
		}

		/**
		 * @return the required
		 */
		public Boolean isRequired() {
			return myRequired;
		}

		/**
		 * Subclasses may override
		 */
		protected boolean isSupported() {
			return true;
		}

		/**
		 * @param theErrorDescription
		 *            the errorDescription to set
		 */
		public void setErrorDescription(String theErrorDescription) {
			myErrorDescription = theErrorDescription;
		}

		public final void validate() throws InterruptedException, InvocationTargetException {
			for (int i = 0; i < getChildCount(); i++) {
				TreeNodeBase next = (TreeNodeBase) getChildAt(i);

				if (next.isHasContent()) {
					next.validate();
				}

				ShowEnum showMode = myMessages.getEditorShowMode();
				if ((next.getErrorDescription() == null && showMode == ShowEnum.ERROR) || (next.isHasContent() == false && showMode == ShowEnum.POPULATED) || (next.isSupported() == false && next.getErrorDescription() == null && showMode == ShowEnum.SUPPORTED)) {
					final int index = i;
					EventQueue.invokeAndWait(new Runnable() {
						public void run() {
							remove(index);
						}
					});
					i--;
					continue;
				}

			}

			doValidate();
		}
	}

	public class TreeNodeComment extends TreeNodeBase implements IDestroyable {
		private PropertyChangeListener myListener;
		private Comment myMessage;

		public TreeNodeComment(Comment theMessage) {
			super(theMessage);

			myMessage = theMessage;

			myListener = new PropertyChangeListener() {

				public void propertyChange(PropertyChangeEvent theEvt) {
					myTreeModel.nodeStructureChanged(myTop);
				}
			};
			myMessage.addPropertyChangeListener(UnknownMessage.PARSED_MESSAGE_PROPERTY, myListener);

		}

		/**
		 * {@inheritDoc}
		 */
		public void destroy() {
			myMessage.addPropertyChangeListener(UnknownMessage.PARSED_MESSAGE_PROPERTY, myListener);
		}

		@Override
		public void doValidate() {
			// nothing
		}

		@Override
		public StringBuilder getNodeText() {
			StringBuilder retVal = new StringBuilder();
			retVal.append("<html><font color=\"#00FF00\">");
			retVal.append(myMessage.getSourceMessage());
			retVal.append("</font></html>");
			return retVal;
		}

	}

	public class TreeNodeCompositeConf extends TreeNodeType {

		public TreeNodeCompositeConf(String theParentName, Type theComposite, String theGroupName, int theRepNum, boolean theRepeating, boolean theRequired, Segment theParent, List<Integer> theComponentPath, String theTerserPath) {
			super(theParentName, theComposite, theGroupName, theRepNum, theRepeating, theRequired, theParent, theComponentPath, theTerserPath);
		}

		@Override
		public void doValidate() {
			EncodingCharacters enc;
			try {
				enc = EncodingCharacters.getInstance(getComposite().getMessage());
			} catch (HL7Exception e) {
				ourLog.error("Could not get encoding chars", e);
				enc = new EncodingCharacters('|', null);
			}

			String encoded = PipeParser.encode(getComposite(), enc);
			List<HL7Exception> problems = myRuntimeProfileValidator.testType(getComposite(), getComposite().getConfDefinition(), encoded, "");
			addValidationExceptions(problems);
		}

		public ConformanceComposite getComposite() {
			return (ConformanceComposite) super.getUserObject();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected String getDataTypeDescription() {
			String retVal = getComposite().getConfDefinition().getDatatype();
			return retVal;
		}

		@Override
		public String getDisplayName() {
			return getComposite().getConfDefinition().getName();
		}

		@Override
		public Integer getMaxLength() {
			return (int) getComposite().getConfDefinition().getLength();
		}

		protected boolean isSupported() {
			return !"X".equals(getComposite().getConfDefinition().getUsage());
		}

	}

	public class TreeNodeGroup extends TreeNodeGroupBase {

		public TreeNodeGroup(Group theGroup, String theGroupName, int theRepNum, boolean theRepeating, boolean theRequired, String theTerserPath) {
			super(theGroup, theGroupName, theRepNum, theRepeating, theRequired, theTerserPath);
		}

		private void addToSegList(List<Segment> retVal, Group group) throws HL7Exception {
			for (String next : group.getNames()) {
				for (Structure nextStructure : group.getAll(next)) {
					if (nextStructure instanceof Segment) {
						retVal.add((Segment) nextStructure);
					} else {
						addToSegList(retVal, (Group) nextStructure);
					}
				}
			}
		}

		public Group getGroup() {
			return (Group) getUserObject();
		}

		@Override
		public String getNodeTextColor() {
			return "#404000";
		}

		public List<Segment> getSegments() throws HL7Exception {

			List<Segment> retVal = new ArrayList<Segment>();

			Group group = getGroup();
			addToSegList(retVal, group);

			return retVal;
		}

	}

	public class TreeNodeGroupBase extends TreeNodeBase {
		public TreeNodeGroupBase(Group theGroup, String theGroupName, int theRepNum, boolean theRepeating, boolean theRequired, String theTerserPath) {
			super(theGroup, theGroupName, theRepNum, theRepeating, theRequired, theTerserPath);
		}

		public TreeNodeGroupBase(Hl7V2MessageBase theMessage) {
			super(theMessage);
		}

		public int countPopulatedSegments() {
			int retVal = 0;

			for (int i = 0; i < getChildCount(); i++) {
				TreeNode nextStructure = getChildAt(i);
				if (nextStructure instanceof TreeNodeSegment) {
					if (((TreeNodeSegment) nextStructure).isHasContent()) {
						retVal++;
					}
				} else if (nextStructure instanceof TreeNodeGroup) {
					retVal += ((TreeNodeGroup) nextStructure).countPopulatedSegments();
				}
			}

			return retVal;
		}

	}

	public class TreeNodeGroupConf extends TreeNodeGroup {

		public TreeNodeGroupConf(ConformanceGroup theGroup, String theGroupName, int theRepNum, boolean theRepeating, boolean theRequired, String theTerserPath) {
			super(theGroup, theGroupName, theRepNum, theRepeating, theRequired, theTerserPath);
		}

		@Override
		public void doValidate() {
			try {
				List<HL7Exception> problems = myRuntimeProfileValidator.testGroup(getGroup(), getGroup().getConfDefinition(), "");
				addValidationExceptions(problems);
			} catch (ProfileException e) {
				addValidationExceptions(new HL7Exception(e));
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getDisplayName() {
			return getGroup().getConfDefinition().getLongName();
		}

		public ConformanceGroup getGroup() {
			return (ConformanceGroup) super.getGroup();
		}

		protected boolean isSupported() {
			return !"X".equals(getGroup().getConfDefinition().getUsage());
		}

	}

	public class TreeNodeMessage extends TreeNodeGroupBase implements IDestroyable {
		private int myMessageIndex;
		private PropertyChangeListener myParsedMessageListener;

		public TreeNodeMessage(int theMessageIndex, final Hl7V2MessageBase theMessage) {
			super(theMessage);

			myMessageIndex = theMessageIndex;

			myParsedMessageListener = new PropertyChangeListener() {

				public void propertyChange(PropertyChangeEvent theEvt) {
					myUpdaterThread.scheduleUpdate();
				}
			};
			theMessage.addPropertyChangeListener(Hl7V2MessageBase.PARSED_MESSAGE_PROPERTY, myParsedMessageListener);

		}

		public void destroy() {
			((Hl7V2MessageBase) getUserObject()).removePropertyChangeListener(Hl7V2MessageBase.PARSED_MESSAGE_PROPERTY, myParsedMessageListener);
		}

		public Hl7V2MessageBase getMessage() {
			return (Hl7V2MessageBase) getUserObject();
		}

		/**
		 * @return the messageIndex
		 */
		public int getMessageIndex() {
			return myMessageIndex;
		}

		public Message getParsedMessage() {
			return getMessage().getParsedMessage();
		}
	}

	public class TreeNodeMessageConf extends TreeNodeMessage {

		public TreeNodeMessageConf(int theIndex, Hl7V2MessageBase theMessage) {
			super(theIndex, theMessage);
		}

		@Override
		public void doValidate() {
			try {
				HL7Exception[] problems = myRuntimeProfileValidator.validate(getParsedMessage(), getParsedMessage().getConfDefinition());
				addValidationExceptions(problems);
			} catch (ProfileException e) {
				addValidationExceptions(new HL7Exception(e));
			} catch (HL7Exception e) {
				addValidationExceptions(e);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getDisplayName() {
			return getParsedMessage().getConfDefinition().getDescription();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ConformanceMessage getParsedMessage() {
			return (ConformanceMessage) super.getParsedMessage();
		}

	}

	public class TreeNodePrimitive extends TreeNodeType {

		public TreeNodePrimitive(String theParentName, Primitive theGroup, String theGroupName, int theRepNum, boolean theRepeating, boolean theRequired, Segment theParent, List<Integer> theComponentPath, String theTerserPath) {
			super(theParentName, theGroup, theGroupName, theRepNum, theRepeating, theRequired, theParent, theComponentPath, theTerserPath);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void doValidate() {
			super.doValidate();

			Primitive primitive = getPrimitive();
			if (myMessages != null) {
				if (myMessages.getRuntimeProfile() != null) {

					// If we're using a conformance profile, also
					// use datatype validation as well
					String version = primitive.getMessage().getVersion();
					String typeName = primitive.getName();
					Collection<PrimitiveTypeRule> rules = ourDefaultValidation.getPrimitiveRules(version, typeName, primitive);
					for (PrimitiveTypeRule rule : rules) {
						if (!rule.test(primitive.getValue())) {
							addValidationExceptions(new HL7Exception(rule.getDescription()));
						}
					}

				} else if (myMessages.getValidationContext() != null) {

					String version = primitive.getMessage().getVersion();
					String type = primitive.getName();
					Collection<PrimitiveTypeRule> rules = myMessages.getValidationContext().getPrimitiveRules(version, type, primitive);
					for (PrimitiveTypeRule primitiveTypeRule : rules) {
						boolean test = primitiveTypeRule.test(primitive.getValue());
						if (!test) {
							// setErrorDescription(primitiveTypeRule.getDescription());
							addValidationExceptions(new HL7Exception(primitiveTypeRule.getDescription()));
						}
					}

				}

			}

		}

		@Override
		protected String getDataTypeDescription() {
			Primitive primitive = getPrimitive();
			if (primitive instanceof ID) {
				return super.getDataTypeDescription() + TBL + toHl7Table(((ID) primitive).getTable());
			}
			if (primitive instanceof IS) {
				return super.getDataTypeDescription() + TBL + toHl7Table(((IS) primitive).getTable());
			}
			return super.getDataTypeDescription();
		}

		public Primitive getPrimitive() {
			return (Primitive) getUserObject();
		}

		protected String getTable() {
			Primitive prim = getPrimitive();
			String namespace = TABLE_NAMESPACE_HL7;
			int retVal = 0;
			if (prim instanceof IS) {
				retVal = (((IS) prim).getTable());
			} else if (prim instanceof ID) {
				retVal = (((ID) prim).getTable());
			}
			return retVal > 0 ? namespace + toHl7Table(retVal) : null;
		}

		@Override
		public Boolean isHasContent() {
			Primitive p = (Primitive) getUserObject();
			String value = p.getValue();
			boolean retVal = value != null && value.length() > 0;
			if (retVal) {
				return retVal;
			}

			for (int i = 0; i < p.getExtraComponents().numComponents(); i++) {
				try {
					value = p.getExtraComponents().getComponent(i).encode();
				} catch (HL7Exception e) {
					return false;
				}
				retVal = value != null && value.length() > 0;
				if (retVal) {
					return retVal;
				}
			}

			return false;
		}

	}

	public class TreeNodePrimitiveConf extends TreeNodePrimitive {

		public TreeNodePrimitiveConf(String theParentName, ConformancePrimitive thePrimitive, String theGroupName, int theRepNum, boolean theRepeating, boolean theRequired, Segment theParent, List<Integer> theComponentPath, String theTerserPath) {
			super(theParentName, thePrimitive, theGroupName, theRepNum, theRepeating, theRequired, theParent, theComponentPath, theTerserPath);

		}

		@Override
		public void doValidate() {
			ConformancePrimitive primitive = getPrimitive();
			String tp = getTerserPath();

			EncodingCharacters enc;
			try {
				enc = EncodingCharacters.getInstance(primitive.getMessage());
			} catch (HL7Exception e) {
				ourLog.error("Could not get encoding chars", e);
				enc = new EncodingCharacters('|', null);
			}

			String encoded = PipeParser.encode(primitive, enc);
			if (tp.endsWith("MSH-1") || tp.endsWith("MSH-2")) {
				encoded = primitive.getValue();
			}

			List<HL7Exception> problems = myRuntimeProfileValidator.testType(getPrimitive(), getPrimitive().getConfDefinition(), encoded, "");
			addValidationExceptions(problems);

			if (myMessages.getRuntimeProfile() != null) {
				String table = getTable();
				if (table != null) {

					ConformanceMessage msg = getPrimitive().getMessage();
					String tablesId = msg.getTablesId();
					if (StringUtils.isNotBlank(tablesId)) {
						TableFile tableFile = myController.getTableFileList().getTableFile(tablesId);
						if (tableFile != null) {
							if (tableFile.knowsCodes(table)) {
								String value = StringUtils.defaultString(primitive.getValue());
								if (!tableFile.isValidCode(table, value)) {
									addValidationExceptions(new HL7Exception("Not a valid value in table '" + table + "': " + value));
								}
							}
						}
					}
				}
			}

			super.doValidate();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected String getDataTypeDescription() {
			String retVal = getPrimitive().getConfDefinition().getDatatype();
			String table = getPrimitive().getConfDefinition().getTable();
			if (StringUtils.isNotBlank(table)) {
				return retVal + TBL + table;
			} else {
				return retVal;
			}
		}

		@Override
		public String getDisplayName() {
			return getPrimitive().getConfDefinition().getName();
		}

		@Override
		public Integer getMaxLength() {
			return (int) getPrimitive().getConfDefinition().getLength();
		}

		public ConformancePrimitive getPrimitive() {
			return (ConformancePrimitive) super.getPrimitive();
		}

		@Override
		protected String getTable() {
			String retVal = getPrimitive().getConfDefinition().getTable();
			if (StringUtils.isBlank(retVal)) {
				return null;
			} else {
				if (AbstractNumericPrimitive.isInteger(retVal)) {
					return TABLE_NAMESPACE_HL7 + retVal;
				} else {
					return retVal;
				}
			}
		}

		protected boolean isSupported() {
			return !"X".equals(getPrimitive().getConfDefinition().getUsage());
		}

	}

	public class TreeNodeRoot extends TreeNodeBase implements IDestroyable {

		public TreeNodeRoot() {
			super(null);
		}

		public int countMessages() {
			int retVal = 0;
			for (int i = 0; i < getChildCount(); i++) {
				if (getChildAt(i) instanceof TreeNodeMessage) {
					retVal++;
				}
			}
			return retVal;
		}

		public void destroy() {
			for (int i = 0; i < getChildCount(); i++) {
				TreeNode next = getChildAt(i);
				if (next instanceof IDestroyable) {
					((IDestroyable) next).destroy();
				}
			}
		}

	}

	public class TreeNodeSegment extends TreeNodeBase {
		public TreeNodeSegment(Segment theSegment, String theGroupName, int theRepNum, boolean theRepeating, boolean theRequired, String theTerserPath) {
			super(theSegment, theGroupName, theRepNum, theRepeating, theRequired, theTerserPath);

			Validate.notNull(theTerserPath);
			Validate.isTrue(theTerserPath.startsWith("/"));
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public StringBuilder getNodeText() {
			StringBuilder retVal = super.getNodeText();

			if (isNonStandard()) {
				retVal.append("<font color=\"#A0A000\">");
				retVal.append(" (non standard)");
				retVal.append("</font>");
			}

			return retVal;
		}

		@Override
		public String getNodeTextColor() {
			return "#006000";
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getPipeEncodedValue() {
			EncodingCharacters enc;
			try {
				enc = EncodingCharacters.getInstance(getSegment().getMessage());
			} catch (HL7Exception e) {
				ourLog.error("Could not get encoding chars", e);
				enc = new EncodingCharacters('|', null);
			}
			return PipeParser.encode(getSegment(), enc);
		}

		public Segment getSegment() {
			return (Segment) getUserObject();
		}

		@Override
		public Boolean isHasContent() {
			return getPipeEncodedValue().length() > 3;
		}

		public boolean isNonStandard() {
			AbstractGroup parent = (AbstractGroup) getSegment().getParent();
			Set<String> nonStandardNames = parent.getNonStandardNames();
			String segmentName = getSegment().getName();
			return nonStandardNames.contains(segmentName);
		}

	}

	public class TreeNodeSegmentConf extends TreeNodeSegment {
		public TreeNodeSegmentConf(ConformanceSegment theSegment, String theGroupName, int theRepNum, boolean theRepeating, boolean theRequired, String theTerserPath) {
			super(theSegment, theGroupName, theRepNum, theRepeating, theRequired, theTerserPath);
		}

		@Override
		public void doValidate() {
			try {
				List<HL7Exception> problems = myRuntimeProfileValidator.testSegment(getSegment(), getSegment().getConfDefinition(), "");
				addValidationExceptions(problems);
			} catch (ProfileException e) {
				addValidationExceptions(new HL7Exception(e));
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getDisplayName() {
			return getSegment().getConfDefinition().getLongName();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Short getMaxReps() {
			return getSegment().getMaxReps();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Short getMinReps() {
			return getSegment().getMinReps();
		}

		public ConformanceSegment getSegment() {
			return (ConformanceSegment) getUserObject();
		}

		protected boolean isSupported() {
			return !"X".equals(getSegment().getConfDefinition().getUsage());
		}
	}

	public class TreeNodeType extends TreeNodeBase {
		private ArrayList<Integer> myComponentPath;
		private String myParentName;
		private Segment mySegment;

		public TreeNodeType(String theParentName, Type theGroup, String theGroupName, int theRepNum, boolean theRepeating, boolean theRequired, Segment theParent, List<Integer> theComponentPath, String theTerserPath) {
			super(theGroup, theGroupName, theRepNum, theRepeating, theRequired, theTerserPath);

			Validate.notNull(theParent);
			Validate.notNull(theComponentPath);
			Validate.notEmpty(theComponentPath);

			mySegment = theParent;
			myParentName = theParentName;
			myComponentPath = new ArrayList<Integer>(theComponentPath);
		}

		protected String getDataTypeDescription() {
			return getType().getClass().getSimpleName();
		}

		public StringBuilder getNodeText() {
			StringBuilder b = new StringBuilder();

			b.append(myParentName);
			// b.append(" ");
			// b.append(getName());

			if (isRepeating() && (myShowRep0 || getRepNum() > 0)) {
				b.append("<font color=\"" + COLOR_REPNUM + "\">");
				b.append(" (rep");
				if (getRepNum() > 0) {
					b.append(' ');
					b.append(getRepNum() + 1);
				}
				b.append(")");
				b.append("</font>");
			}

			b.append("<font color=\"#00A000\">");
			if (StringUtils.isNotBlank(getDisplayName())) {
				b.append(" - ");
				b.append(getDisplayName());
				b.append(" ");
			}
			b.append(" (");
			b.append(getDataTypeDescription());
			b.append(")");
			b.append("</font>");

			return b;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getPipeEncodedValue() {
			// Don't encode MSH-1 or 2 since this will escape them
			if (isMsh1orMsh2()) {
				return ((Primitive) getType()).getValue();
			}

			EncodingCharacters enc;
			try {
				enc = EncodingCharacters.getInstance(getType().getMessage());
			} catch (HL7Exception e) {
				ourLog.error("Could not get encoding chars", e);
				enc = new EncodingCharacters('|', null);
			}
			return PipeParser.encode(getType(), enc);
		}

		public SegmentAndComponentPath getSegmentAndComponentPath() {
			return new SegmentAndComponentPath(mySegment, myComponentPath, getRepNum() + 1);
		}

		public Type getType() {
			return (Type) getUserObject();
		}

		public boolean isMsh1orMsh2() {
			return "MSH-1".equals(myParentName) || "MSH-2".equals(myParentName);
		}

	}

	public class TreeNodeUnknown extends TreeNodeBase implements IDestroyable {
		private PropertyChangeListener myListener;
		private UnknownMessage myMessage;

		public TreeNodeUnknown(UnknownMessage theMessage) {
			super(theMessage);

			myMessage = theMessage;

			myListener = new PropertyChangeListener() {

				public void propertyChange(PropertyChangeEvent theEvt) {
					myTreeModel.nodeStructureChanged(myTop);
				}
			};
			myMessage.addPropertyChangeListener(UnknownMessage.PARSED_MESSAGE_PROPERTY, myListener);

		}

		/**
		 * {@inheritDoc}
		 */
		public void destroy() {
			myMessage.addPropertyChangeListener(UnknownMessage.PARSED_MESSAGE_PROPERTY, myListener);
		}

		@Override
		public StringBuilder getNodeText() {
			StringBuilder retVal = new StringBuilder();
			retVal.append("<html><font color=\"#FF0000\">Unknown</font><font color=\"#A0A0A0\"> ");

			int countLines = StringUtil.countLines(myMessage.getSourceMessage().trim());
			retVal.append(countLines);
			retVal.append(" Line");

			if (countLines != 1) {
				retVal.append("s");
			}

			retVal.append("</font></html>");
			return retVal;
		}

	}

	public class TreeNodeUnknownLine extends TreeNodeBase {
		public TreeNodeUnknownLine(Object theLine) {
			super(theLine);
		}

		@Override
		public StringBuilder getNodeText() {
			StringBuilder retVal = new StringBuilder();
			retVal.append("<html><font color=\"#4040A0\">");

			Object object = getUserObject();
			if (object != null) {
				retVal.append(xmlEncode(object.toString()));
			}

			retVal.append("</font></html>");
			return retVal;
		}

	}

	private static class TreeRenderDataProvider implements RenderDataProvider {

		private static final Color ourFgEmpty = new Color(0.5f, 0.5f, 0.5f);
		private static final Color ourFgGroup = new Color(0.4f, 0.4f, 0.0f);
		private static final Color ourFgNormal = new Color(0.0f, 0.0f, 0.0f);
		private static final Color ourFgSegment = new Color(0.0f, 0.0f, 0.0f);

		public Color getBackground(Object theArg0) {
			return Color.white;
		}

		public String getDisplayName(Object theObject) {
			if (theObject instanceof TreeNodeMessage) {

				TreeNodeMessage tnm = (TreeNodeMessage) theObject;
				return (tnm.getMessage().getMessageDescription());

			} else if (theObject instanceof TreeNodeBase) {

				TreeNodeBase base = (TreeNodeBase) theObject;
				return (base.getNodeText().toString());

			} else {

				return "Unknown: " + theObject.getClass().getName();

			}
		}

		public Color getForeground(Object theArg0) {
			if (theArg0 instanceof TreeNodeBase) {
				if (Boolean.FALSE == ((TreeNodeBase) theArg0).isHasContent()) {
					return ourFgEmpty;
				}
			}
			if (theArg0 instanceof TreeNodeGroup) {
				return ourFgGroup;
			}
			if (theArg0 instanceof TreeNodeSegment) {
				return ourFgSegment;
			}
			return ourFgNormal;
		}

		public Icon getIcon(Object theArg0) {
			if (theArg0 instanceof TreeNodeGroup) {
				return ImageFactory.getTreeBundle();
			} else if (theArg0 instanceof TreeNodeSegment) {
				return ImageFactory.getTreeLeaf();
			} else {
				return new ImageIcon();
			}
		}

		public String getTooltipText(Object theArg0) {
			return null;
		}

		public boolean isHtmlDisplayName(Object theArg0) {
			return true;
		}

	}

	private class TreeRowModel implements RowModel {

		private static final int COL_LENGTH = 2;
		private static final int COL_MAX = 1;
		private static final int COL_MIN = 0;
		private static final int COL_VALIDATED = 3;
		private static final int COL_VALUE = 4;

		private static final int NUM_COLS = 5;

		public TreeRowModel(DefaultTreeModel theModel) {
			myTreeModel = theModel;
		}

		public Class<?> getColumnClass(int theArg0) {
			if (theArg0 == COL_VALIDATED) {
				return NodeValidationFailure.class;
			}
			return String.class;
		}

		public int getColumnCount() {
			return NUM_COLS;
		}

		public String getColumnName(int theArg0) {
			switch (theArg0) {
			case COL_MIN:
				return "Min";
			case COL_MAX:
				return "Max";
			case COL_VALIDATED:
				return "";
			case COL_LENGTH:
				return "Length";
			case COL_VALUE:
			default:
				return "Value (Click to Edit)";
			}
		}

		public Object getValueFor(Object theObject, int theCol) {
			TreeNodeBase obj = (TreeNodeBase) theObject;
			switch (theCol) {
			case COL_VALUE: {
				return obj;
			}
			case COL_MIN:
				if (obj.getMinReps() == null) {
					return null;
				} else {
					return obj.getMinReps();
				}
			case COL_MAX:
				if (obj.getMaxReps() == null) {
					return null;
				} else if (obj.getMaxReps() == -1) {
					return "*";
				} else {
					return obj.getMaxReps();
				}
			case COL_LENGTH:
				return obj.getMaxLength();
			case COL_VALIDATED:
				// if (myMessages.getValidationContext() == null) {
				// return new NodeValidationFailure(new ImageIcon(), "");
				// } else
				if (obj.isContainError()) {
					if (obj.getErrorDescription() != null) {
						return new NodeValidationFailure(ImageFactory.getValFailed(), obj.getErrorDescription());
					} else {
						return new NodeValidationFailure(ImageFactory.getValFailedChild(), "Child element has validation failure");
					}
				} else {
					return new NodeValidationFailure(new ImageIcon(), "");
				}
			default:
				return "";
			}
		}

		public boolean isCellEditable(Object theValue, int theColumn) {
			if (theColumn == COL_VALUE) {
				if (theValue instanceof TreeNodeSegment) {
					return true;
				}
				if (theValue instanceof TreeNodeType) {
					return true;
				}
			}
			return false;
		}

		private void parse(Segment theSegment, String theNewValue) throws HL7Exception {
			EncodingCharacters enc;
			try {
				enc = EncodingCharacters.getInstance(theSegment.getMessage());
			} catch (HL7Exception e) {
				ourLog.error("Could not get encoding chars", e);
				enc = new EncodingCharacters('|', null);
			}

			myPipeParser.parse(theSegment, theNewValue, enc);
		}

		private void parse(Type theType, String theNewValue) throws HL7Exception {
			EncodingCharacters enc;
			try {
				enc = EncodingCharacters.getInstance(theType.getMessage());
			} catch (HL7Exception e) {
				ourLog.error("Could not get encoding chars", e);
				enc = new EncodingCharacters('|', null);
			}

			theType.clear();
			myPipeParser.parse(theType, theNewValue, enc);

		}

		public void setValueFor(Object theObject, int theCol, Object theNewValue) {
			if (theCol != COL_VALUE) {
				return;
			}

			Message msg = null;
			String newValue = (String) theNewValue;
			if (theObject instanceof TreeNodeSegment) {
				try {
					Segment segment = ((TreeNodeSegment) theObject).getSegment();
					parse(segment, newValue);
					msg = segment.getMessage();
				} catch (HL7Exception e) {
					ourLog.error("Could not set value: " + theNewValue, e);
					return;
				}
			} else if (theObject instanceof TreeNodeType) {
				try {
					TreeNodeType type = ((TreeNodeType) theObject);

					if (!myController.validateNewValue(type.getTerserPath(), newValue)) {
						return;
					}

					if (type.isMsh1orMsh2()) {
						((Primitive) type.getType()).setValue(newValue);
					} else {
						parse(type.getType(), newValue);
					}

					msg = type.getType().getMessage();

				} catch (HL7Exception e) {
					ourLog.error("Could not set value: " + theNewValue, e);
					return;
				}
			} else {
				return;
			}

			if (msg != null) {

				TreeNodeBase base = (TreeNodeBase) theObject;
				while (!(base instanceof TreeNodeMessage)) {
					base = (TreeNodeBase) base.getParent();
				}

				int messageIndex = ((TreeNodeMessage) base).getMessageIndex();
				myMessages.updateSourceMessageBasedOnParsedMessage(messageIndex, msg);
			}

			/*
			 * After making a change, the underlying collection may reparse the
			 * entire message which will invalidate the references to various
			 * structures held by my tree
			 */
			myUpdaterThread.scheduleUpdateNow();

		}

	}

	private class UpdaterThread extends Thread {
		private long myNextUpdate = 0;

		@Override
		public void run() {

			while (myNextUpdate > -1) {

				try {
					long sleepTime = myNextUpdate > 0 ? myNextUpdate - System.currentTimeMillis() : 5000;
					sleepTime = Math.max(0, sleepTime);
					sleepTime = Math.min(5000, sleepTime);

					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
						// ignore
					}

					if (myNextUpdate > 0 && myNextUpdate <= System.currentTimeMillis()) {
						ourLog.info("Running an update of the Message Tree");

						addChildren();

						int messages = myTop.countMessages();

						final StringBuilder b = new StringBuilder();
						b.append(messages > 0 ? messages : "No");
						b.append(" message");
						b.append(messages != 1 ? "s" : "");
						if (myMessages.isValidating()) {
							b.append(", ");
							int countExceptions = myTop.countExceptions();
							b.append(countExceptions > 0 ? countExceptions : "No");
							b.append(" problem");
							b.append(countExceptions != 1 ? "s" : "");
						}

						if (myWorkingListener != null) {
							EventQueue.invokeAndWait(new Runnable() {
								public void run() {
									myWorkingListener.finishedWorking(b.toString());
								}
							});
						}

						myNextUpdate = 0;
					}

				} catch (InterruptedException e) {

					// We can ignore these, they happen if the message is
					// updated by
					// the UI during a middle of an update loop

				} catch (Throwable e) {

					ourLog.info("Exception caught during update loop", e);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e2) {
						// ignore
					}

				}

			} // while

			ourLog.info("Message Tree updater shutting down");

		}

		public void scheduleUpdate() {
			myNextUpdate = System.currentTimeMillis() + 2000;
			interrupt();

			if (myWorkingListener != null) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						myWorkingListener.startedWorking();
					}
				});
			}

		}

		public void scheduleUpdateNow() {
			myNextUpdate = System.currentTimeMillis();
			interrupt();

			if (myWorkingListener != null) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						myWorkingListener.startedWorking();
					}
				});
			}

		}

		public void stopThread() {
			myNextUpdate = -1;
			interrupt();
		}

	}

	private class ValidationTreeCellRenderer extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable theTable, Object theValue, boolean theIsSelected, boolean theHasFocus, int theRow, int theColumn) {
			Component tableCellRendererComponent = super.getTableCellRendererComponent(theTable, theValue, theIsSelected, theHasFocus, theRow, theColumn);

			NodeValidationFailure vf = (NodeValidationFailure) theValue;
			setIcon(vf.getIcon());
			setToolTipText(vf.getMessage());
			setText("");

			return tableCellRendererComponent;
		}

	}

}
