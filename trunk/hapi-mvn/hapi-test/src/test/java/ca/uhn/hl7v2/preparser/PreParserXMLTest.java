/*
 * Created on 28-Apr-2004
 */
package ca.uhn.hl7v2.preparser;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;


/**
 * Unit tests of PreParser with XML-encoded messages.
 *  
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:52 $ by $Author: jamesagnew $
 */
public class PreParserXMLTest  {

    private String myMessage = "<?xml version=\"1.0\" standalone=\"no\"?> <QBP_Q22>  <MSH>   <MSH.1>|</MSH.1>   <MSH.2>^~/&amp;</MSH.2>   <MSH.3>    <HD.1>UHN Vista</HD.1>    <HD.3>ISO</HD.3>   </MSH.3>   <MSH.4>    <HD.1>UHN</HD.1>    <HD.3>ISO</HD.3>   </MSH.4>   <MSH.5>    <HD.1>MPI</HD.1>    <HD.3>ISO</HD.3>   </MSH.5>   <MSH.6>    <HD.1>HealthLink</HD.1>    <HD.3>ISO</HD.3>   </MSH.6>   <MSH.7>20020429132718.734-0400</MSH.7>   <MSH.9>    <CM_MSG_TYPE.1>QBP</CM_MSG_TYPE.1>    <CM_MSG_TYPE.2>Q22</CM_MSG_TYPE.2>  <CM_MSG_TYPE.3>QBP_Q21</CM_MSG_TYPE.3>   </MSH.9>   <MSH.10>855</MSH.10>   <MSH.11>    <PT.1>P</PT.1>   </MSH.11>   <MSH.12>    <VID.1>2.4</VID.1>      </MSH.12>   <MSH.21>Q22</MSH.21>  </MSH>  <QPD>   <QPD.1>    <CE.1>Q22</CE.1>    <CE.2>Find Candidates</CE.2>    <CE.3>HL7nnnn</CE.3>   </QPD.1>   <QPD.3><QIP><QIP.1>@PID.3.1</QIP.1><QIP.2>9583518684</QIP.2></QIP><QIP><QIP.1>@PID.3.4.1</QIP.1><QIP.2>CANON</QIP.2></QIP><QIP><QIP.1>@PID.5.1.1</QIP.1><QIP.2>ECG-Acharya</QIP.2></QIP><QIP><QIP.1>@PID.5.2</QIP.1><QIP.2>Nf</QIP.2></QIP><QIP><QIP.1>@PID.5.7</QIP.1><QIP.2>L</QIP.2></QIP><QIP><QIP.1>@PID.7</QIP.1><QIP.2>197104010000</QIP.2></QIP><QIP><QIP.1>@PID.8</QIP.1><QIP.2>M</QIP.2></QIP></QPD.3>   <QPD.4>100</QPD.4>   <QPD.8><CX.4><HD.2>TTH</HD.2></CX.4></QPD.8>  <QPD.9>13831</QPD.9><QPD.10>ULTIuser2</QPD.10><QPD.11>234564</QPD.11><QPD.12>R&amp;H Med</QPD.12></QPD>  <RCP>   <RCP.1>I</RCP.1>   <RCP.2><CQ.1>100</CQ.1><CQ.2>RD</CQ.2></RCP.2>   <RCP.3>   <CE.1>R</CE.1>   </RCP.3>  </RCP> </QBP_Q22>";
    
    @Test
    public void testFirstCompImplicit() throws Exception {
        assertField("MSH-9", "QBP");                       
    }
    
    @Test
    public void testSecondComp() throws Exception  {
        assertField("MSH-9-2", "Q22");              
    }
    
    @Test
    public void testSecondSubcomp() throws Exception  {
        assertField("QPD-8-4-2", "TTH");              
    }
    
    private void assertField(String field, String expected) throws HL7Exception {
        String[] result = PreParser.getFields(myMessage, new String[]{field});
        assertEquals(expected, result[0]);         
    }
}
