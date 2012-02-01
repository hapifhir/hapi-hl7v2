package ca.uhn.hl7v2.testpanel.model.conf;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.uhn.hl7v2.testpanel.model.AbstractModelClass;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Table")
public class Table extends AbstractModelClass implements Comparable<Table> {

	public static final String PROP_CODES = Table.class.getName() + "_CODES";

	@XmlElement(name = "code")
	private List<Code> myCodes;

	@XmlElement(name = "id")
	private String myCodeSystemId;

	@XmlElement(name = "name")
	private String myCodeSystemName;

	private transient TableFile myTableFile;

	private transient LinkedHashMap<String, Code> myCodeIdToCodes;
	
	public void addCode(Code theCode) {
		myCodes.add(theCode);
		updateCodeIdToCodes();
		firePropertyChange(PROP_CODES, null, null);
	}

	private Map<String, Code> getCodeIdToCodes() {
		if (myCodeIdToCodes == null) {
			myCodeIdToCodes = new LinkedHashMap<String, Code>(myCodes.size() + 10);
			for (Code next : myCodes) {
				next.setTable(this);
				myCodeIdToCodes.put(next.getCode(), next);
			}
		}
		return myCodeIdToCodes;
	}
	
	void updateCodeIdToCodes() {
		myCodeIdToCodes = null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object theObj) {
		if (!(theObj instanceof Table)) {
			return false;
		}

		return ObjectUtils.equals(myCodeSystemId, ((Table) theObj).myCodeSystemId) && ObjectUtils.equals(myCodes, ((Table) theObj).myCodes);
	}

	@Override
	public Object exportConfigToXml() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the codes
	 */
	public List<Code> getCodes() {
		if (myCodes == null) {
			myCodes = new ArrayList<Code>();
		}
		return myCodes;
	}

	/**
	 * @return the codeSystemId
	 */
	public String getCodeSystemId() {
		return myCodeSystemId;
	}

	/**
	 * @return the codeSystemName
	 */
	public String getCodeSystemName() {
		return myCodeSystemName;
	}

	/**
	 * @return the tableFile
	 */
	public TableFile getTableFile() {
		return myTableFile;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		HashCodeBuilder b = new HashCodeBuilder();
		b.append(myCodeSystemId);
		return b.toHashCode();
	}

	/**
	 * @param theCodes
	 *            the codes to set
	 */
	public void setCodes(List<Code> theCodes) {
		myCodes = theCodes;
	}

	/**
	 * @param theCodeSystemId
	 *            the codeSystemId to set
	 */
	public void setCodeSystemId(String theCodeSystemId) {

		if (myTableFile != null) {
			myTableFile.updateCodeSystemIdToTable();
		}

		myCodeSystemId = theCodeSystemId;
	}

	/**
	 * @param theCodeSystemName
	 *            the codeSystemName to set
	 */
	public void setCodeSystemName(String theCodeSystemName) {
		myCodeSystemName = theCodeSystemName;
	}

	public void setTableFile(TableFile theTableFile) {
		myTableFile = theTableFile;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Table[id=" + myCodeSystemId + ", codes=" + myCodes + "]";
	}

	public String[] getCodesAsArray() {
		String[] retVal = new String[myCodes.size()];
		int i = 0;
		for (Code next : myCodes) {
			retVal[i++] = next.getCode();
		}
		return retVal;
	}

	public boolean isValidCode(String theCode) {
		return getCodeIdToCodes().containsKey(theCode);
	}

	public int compareTo(Table theO) {
		return myCodeSystemId.compareTo(theO.myCodeSystemId);
	}

}
