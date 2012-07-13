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
	public void testGetValueAsHtml() throws DataTypeException {
		ADT_A01 msg = new ADT_A01();
		FT ft = new FT(msg);
		
		String value = "some text\\.br\\line 2\\.br\\line 3";
		ft.setValue(value);
		assertEquals("some text<br>line 2<br>line 3", ft.getValueAsHtml());

		value = "some text\\.BR\\line 2\\.BR\\line 3";
		ft.setValue(value);
		assertEquals("some text<br>line 2<br>line 3", ft.getValueAsHtml());

	}
	
}
