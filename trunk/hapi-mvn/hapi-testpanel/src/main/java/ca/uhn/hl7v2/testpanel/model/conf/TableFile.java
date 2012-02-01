package ca.uhn.hl7v2.testpanel.model.conf;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.store.CodeStore;
import ca.uhn.hl7v2.testpanel.model.AbstractModelClass;
import ca.uhn.hl7v2.testpanel.ui.v2tree.Hl7V2MessageTree;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TableFile")
public class TableFile extends AbstractModelClass implements CodeStore {

	public static final String PROP_TABLES = TableFile.class.getName() + "_TABLES";
	private static final Logger ourLog = LoggerFactory.getLogger(TableFile.class);

	private transient File myFileName;

	@XmlElement(name = "id")
	private String myId;

	@XmlElement(name = "name")
	private String myName;

	@XmlElement(name = "table")
	private List<Table> myTables = new ArrayList<Table>();

	private transient Map<String, Table> myCodeSystemIdToTable;

	private transient boolean myUnsaved;

	public Table addTable() {
		Set<String> codes = getCodeSystemIdToTable().keySet();
		int csNum = 0;
		String tableCodeSystemId;
		do {
			csNum++;
			tableCodeSystemId = "HL7" + Hl7V2MessageTree.toHl7Table(csNum);
		} while (codes.contains(tableCodeSystemId));

		ourLog.info("Adding table {}", tableCodeSystemId);
		
		Table newTable = new Table();
		newTable.setCodeSystemId(tableCodeSystemId);
		newTable.setCodeSystemName("HL7 Table " + csNum);
		myTables.add(newTable);
		
		firePropertyChange(PROP_TABLES, null, null);
		newTable.setTableFile(this);
		
		updateCodeSystemIdToTable();
		
		return newTable;
	}

	void updateCodeSystemIdToTable() {
		myCodeSystemIdToTable = null;
	}
	
	private Map<String, Table> getCodeSystemIdToTable() {
		if (myCodeSystemIdToTable == null) {
			myCodeSystemIdToTable = new HashMap<String, Table>();
			for (Table next : getTables()) {
				myCodeSystemIdToTable.put(next.getCodeSystemId(), next);
			}
		}
		return myCodeSystemIdToTable;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object theObj) {
		if (!(theObj instanceof TableFile)) {
			return false;
		}

		return ObjectUtils.equals(myId, ((TableFile) theObj).myId);
	}

	@Override
	public Object exportConfigToXml() {
		return null;
	}

	public void flushToFile() throws IOException {
		Validate.notNull(myFileName);

		File tableFile = (myFileName);
		FileWriter w = new FileWriter(tableFile, false);

		JAXB.marshal(this, w);
		w.close();
	}

	/**
	 * @return the fileName
	 */
	public File getFileName() {
		return myFileName;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return myId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return StringUtils.defaultString(myName);
	}

	/**
	 * @return the tables
	 */
	public List<Table> getTables() {
		if (myTables == null) {
			myTables = new ArrayList<Table>();
		}
		return myTables;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		HashCodeBuilder b = new HashCodeBuilder();
		b.append(myId);
		return b.toHashCode();
	}

	/**
	 * @return the unsaved
	 */
	public boolean isUnsaved() {
		return myUnsaved;
	}

	/**
	 * @param theFileName
	 *            the fileName to set
	 */
	public void setFileName(File theFileName) {
		myFileName = theFileName;
	}

	/**
	 * @param theId
	 *            the id to set
	 */
	public void setId(String theId) {
		myId = theId;
	}

	/**
	 * @param theName
	 *            the name to set
	 */
	public void setName(String theName) {
		myName = theName;
	}

	/**
	 * @param theTables
	 *            the tables to set
	 */
	public void setTables(List<Table> theTables) {
		myTables = theTables;
	}

	/**
	 * @param theUnsaved
	 *            the unsaved to set
	 */
	public void setUnsaved(boolean theUnsaved) {
		myUnsaved = theUnsaved;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "TableFile[id=" + myId + "]";
	}

	public static TableFile readFromFile(File theFile) throws IOException {
		TableFile retVal = JAXB.unmarshal(new FileReader(theFile), TableFile.class);
		retVal.setFileName(theFile);
		Collections.sort(retVal.myTables);

		for (Table next : retVal.getTables()) {
			next.setTableFile(retVal);
		}

		return retVal;
	}

	public String[] getValidCodes(String theCodeSystem) throws ProfileException {
		return getCodeSystemIdToTable().get(theCodeSystem).getCodesAsArray();
	}

	public boolean knowsCodes(String theCodeSystem) {
		return getCodeSystemIdToTable().containsKey(theCodeSystem);
	}

	public boolean isValidCode(String theCodeSystem, String theCode) {
		return getCodeSystemIdToTable().get(theCodeSystem).isValidCode(theCode);
	}

	public void removeTable(Table theTable) {
		myTables.remove(theTable);
		firePropertyChange(PROP_TABLES, null, null);
	}

}
