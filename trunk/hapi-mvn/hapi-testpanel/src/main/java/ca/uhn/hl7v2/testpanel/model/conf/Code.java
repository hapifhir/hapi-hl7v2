package ca.uhn.hl7v2.testpanel.model.conf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Code")
public class Code {

	@XmlElement(name="code")
	private String myCode;
	
	@XmlElement(name="displayName")
	private String myDisplayName;

	private transient Table myTable;

	public Code() {
		super();
	}

	public Code(String theCode, String theDisplayName) {
		super();
		myCode = theCode;
		myDisplayName = theDisplayName;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object theObj) {
		if (!(theObj instanceof Code)) {
			return false;
		}
		
		return ObjectUtils.equals(myCode, ((Code)theObj).myCode);
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return myCode;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return myDisplayName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		HashCodeBuilder b= new HashCodeBuilder();
		b.append(myCode);
		return b.toHashCode();
	}

	/**
	 * @param theCode the code to set
	 */
	public void setCode(String theCode) {
		myCode = theCode;
		if (myTable != null) {
			myTable.updateCodeIdToCodes();
		}
	}
	
	/**
	 * @param theDisplayName the displayName to set
	 */
	public void setDisplayName(String theDisplayName) {
		myDisplayName = theDisplayName;
	}

	/**
	 * @param theTable the table to set
	 */
	public void setTable(Table theTable) {
		myTable = theTable;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Code[code=" + myCode + "]";
	}

	
}
