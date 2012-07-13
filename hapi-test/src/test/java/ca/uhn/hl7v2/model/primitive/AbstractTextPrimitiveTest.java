package ca.uhn.hl7v2.model.primitive;

import org.junit.Test;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v25.datatype.FT;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import static org.junit.Assert.*;

public class AbstractTextPrimitiveTest {

	/**
	 * From ATP:
	 * <li>\.br\
	 * <li>\.ce\
	 * <li>\.sk\
	 * <li>\.sp\
	 * <li>\.sp ###\
	 * <li>\.fi\
	 * <li>\.nf\
	 * <li>\.in\
	 * <li>\.ti\
	 * <li>\H\
	 * <li>\N\
	 * <li>Ampersands (&amp;) are converted to their HTML equivalent (&amp;amp;)
	 * <li>Chars over ASCII 160 are HTML encoded (e.g. &amp;#199;) 
	 */
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
