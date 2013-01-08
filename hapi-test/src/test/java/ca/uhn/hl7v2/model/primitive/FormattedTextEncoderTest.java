package ca.uhn.hl7v2.model.primitive;

import org.junit.Test;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v25.datatype.FT;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import static org.junit.Assert.*;

public class FormattedTextEncoderTest {

	@Test
	public void testEscapeHtmlReservedChars() throws DataTypeException {
		ADT_A01 msg = new ADT_A01();
		FT ft = new FT(msg);

		String value = "< lt > gt & amp ";
		ft.setValue(value);
		assertEquals("&lt; lt &gt; gt &amp; amp ", ft.getValueAsHtml());

	}

	@Test
	public void testGetValueAsHtmlHighAscii() throws DataTypeException {
		ADT_A01 msg = new ADT_A01();
		FT ft = new FT(msg);

		String value = "hello " + ((char)177);
		ft.setValue(value);
		assertEquals("hello &#177;", ft.getValueAsHtml());

	}

	@Test
	public void testGetValueAsHtmlBr() throws DataTypeException {
		ADT_A01 msg = new ADT_A01();
		FT ft = new FT(msg);

		String value = "some text\\.br\\line 2\\.br\\line 3";
		ft.setValue(value);
		assertEquals("some text<br>line 2<br>line 3", ft.getValueAsHtml());

		value = "some text\\.BR\\line 2\\.BR\\line 3";
		ft.setValue(value);
		assertEquals("some text<br>line 2<br>line 3", ft.getValueAsHtml());

	}

	@Test
	public void testGetValueAsHtmlCe() throws DataTypeException {
		ADT_A01 msg = new ADT_A01();
		FT ft = new FT(msg);

		String value = "this line isn't centered\\.ce\\this line is centered\\.br\\also not";
		ft.setValue(value);
		assertEquals("this line isn't centered<br><center>this line is centered</center><br>also not", ft.getValueAsHtml());

		value = "this line isn't centered\\.CE\\this line is centered\\.BR\\also not";
		ft.setValue(value);
		assertEquals("this line isn't centered<br><center>this line is centered</center><br>also not", ft.getValueAsHtml());

		value = "this line isn't centered\\.ce\\this line is centered";
		ft.setValue(value);
		assertEquals("this line isn't centered<br><center>this line is centered</center>", ft.getValueAsHtml());

		value = "this line isn't centered\\.ce\\this line is centered\\.ce\\so is this";
		ft.setValue(value);
		assertEquals("this line isn't centered<br><center>this line is centered</center><br><center>so is this</center>", ft.getValueAsHtml());

		value = "\\.ce\\this line is centered\\.ce\\so is this";
		ft.setValue(value);
		assertEquals("<center>this line is centered</center><br><center>so is this</center>", ft.getValueAsHtml());

	}

	@Test
	public void testGetValueAsHtmlAmpersands() throws DataTypeException {
		ADT_A01 msg = new ADT_A01();
		FT ft = new FT(msg);

		String value = "peas&carrots";
		ft.setValue(value);
		assertEquals("peas&amp;carrots", ft.getValueAsHtml());
	}

	@Test
	public void testGetValueAsHtmlHN() throws DataTypeException {
		ADT_A01 msg = new ADT_A01();
		FT ft = new FT(msg);

		String value = "start\\H\\bold\\N\\not";
		ft.setValue(value);
		assertEquals("start<b>bold</b>not", ft.getValueAsHtml());

		// Make sure no dangling <b> tags are left over
		value = "start\\H\\\\H\\bold\\N\\not";
		ft.setValue(value);
		assertEquals("start<b><b>bold</b></b>not", ft.getValueAsHtml());

	}

	@Test
	public void testGetValueAsHtmlNfFi() throws DataTypeException {
		ADT_A01 msg = new ADT_A01();
		FT ft = new FT(msg);

		String value = "word wrap\\.nf\\don't word wrap\\.fi\\word wrap";
		ft.setValue(value);
		assertEquals("word wrap<nobr>don't word wrap</nobr>word wrap", ft.getValueAsHtml());

		value = "word wrap\\.nf\\don't word wrap";
		ft.setValue(value);
		assertEquals("word wrap<nobr>don't word wrap</nobr>", ft.getValueAsHtml());

		value = "word wrap\\.nf\\don't word wrap\\.br\\also don't\\.fi\\word wrap";
		ft.setValue(value);
		assertEquals("word wrap<nobr>don't word wrap<br>also don't</nobr>word wrap", ft.getValueAsHtml());

	}

	@Test
	public void testGetValueAsHtmlSk() throws DataTypeException {
		ADT_A01 msg = new ADT_A01();
		FT ft = new FT(msg);

		String value = "text\\.sk 5\\more";
		ft.setValue(value);
		assertEquals("text&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;more", ft.getValueAsHtml());

		value = "text\\.sk 0\\more";
		ft.setValue(value);
		assertEquals("textmore", ft.getValueAsHtml());

	}

	@Test
	public void testGetValueAsHtmlInTi() throws DataTypeException {
		ADT_A01 msg = new ADT_A01();
		FT ft = new FT(msg);

		// String value2 = "text\\.br\\\\.in+5\\more\\.br\\still";
		// ft.setValue(value2);
		// String valueAsHtml = ft.getValueAsHtml();
		// System.out.println(valueAsHtml);
		// assertEquals("text<div style=\"margin-left: 5em;\">more</div><div style=\\\"margin-left: 5em;\\\">still</div>",
		// valueAsHtml);
		//

		// Need a \\.br\\ before the \\.in 5\\
		String value = "text\\.in 5\\more";
		ft.setValue(value);
		assertEquals(value, ft.getValueAsHtml());

		value = "text\\.br\\\\.in 5\\more";
		ft.setValue(value);
		assertEquals("text<div style=\"margin-left: 5em;\">more</div>", ft.getValueAsHtml());

		value = "text\\.br\\\\.in+5\\more";
		ft.setValue(value);
		assertEquals("text<div style=\"margin-left: 5em;\">more</div>", ft.getValueAsHtml());

		value = "text\\.br\\\\.in-5\\more";
		ft.setValue(value);
		assertEquals("text<br>more", ft.getValueAsHtml());

		value = "text\\.br\\\\.in+5\\more\\.br\\still";
		ft.setValue(value);
		assertEquals("text<div style=\"margin-left: 5em;\">more</div><div style=\"margin-left: 5em;\">still</div>", ft.getValueAsHtml());

		value = "text\\.br\\\\.in+5\\more\\.br\\\\.ti-2\\still";
		ft.setValue(value);
		assertEquals("text<div style=\"margin-left: 5em;\">more</div><div style=\"margin-left: 3em;\">still</div>", ft.getValueAsHtml());

	}

	@Test
	public void testGetValueAsHtmlSp() throws DataTypeException {
		ADT_A01 msg = new ADT_A01();
		FT ft = new FT(msg);

		String value = "text\\.sp\\more text";
		ft.setValue(value);
		assertEquals("text<br>&nbsp;&nbsp;&nbsp;&nbsp;more text", ft.getValueAsHtml());

		value = "text\\.sp 2\\more text";
		ft.setValue(value);
		assertEquals("text<br><br>&nbsp;&nbsp;&nbsp;&nbsp;more text", ft.getValueAsHtml());

		value = "text\\.sp 2\\more\\.sp 1\\still";
		ft.setValue(value);
		assertEquals("text<br><br>&nbsp;&nbsp;&nbsp;&nbsp;more<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;still", ft.getValueAsHtml());

		value = "text\\.sp 2\\more\\.br\\not\\.sp\\three";
		ft.setValue(value);
		assertEquals("text<br><br>&nbsp;&nbsp;&nbsp;&nbsp;more<br>not<br>&nbsp;&nbsp;&nbsp;three", ft.getValueAsHtml());

		// junk at the end should be preserved.. i guess?

		value = "text\\.sp";
		ft.setValue(value);
		assertEquals(value, ft.getValueAsHtml());

		value = "text\\.sp ";
		ft.setValue(value);
		assertEquals(value, ft.getValueAsHtml());

		value = "text\\.sp 1";
		ft.setValue(value);
		assertEquals(value, ft.getValueAsHtml());

		value = "text\\.sp \\";
		ft.setValue(value);
		assertEquals(value, ft.getValueAsHtml());

	}

}
