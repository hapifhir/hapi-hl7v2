/*
 * Created on Dec 11, 2006
 */
package ca.uhn.hl7v2;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.view.TreePanel;

/**
 * TODO: add!
 * 
 * @author <a href="mailto:james.agnew@uhn.on.ca">James Agnew</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:39 $ by $Author: jamesagnew $
 */
public class Test
{
    
    
    public static void main(String[] args) throws EncodingNotSupportedException, HL7Exception {
        
        Parser p = new GenericParser();
        String msg = "MSH|^~\\&|LABMI1||DMCRES||19951010134000||ORU^R01|LABMI1199510101340007|D|2.2|||AL|\r\n" + 
                "PID|||BB1127||LABHLVII^MICRO^A||19780625|F||||||||||001680\r\n" + 
                "PV1|||CFLC|||||||MED||||||||P||||||||||||||||||||||||||19950303150000|19950311\r\n" + 
                "OBR|1||09528307086003110|6003110^CULTURE BACTERIA UR INDWELL CA^^^C UR ICATH|||19951010131900|||||||19951010131900|S03593&URINE-INDWELLING CATHETER     &&&URI|||||0952830708||1995101013360000||600|P||^^^^^RT||^09528307086003110\r\n" + 
                "OBX||CE|6000417^PRELIMINARY^^^R PRE|0002|I80013^^^^GE100,~I80013^^^^GE100,~I80013^^^^GE100,||||||F|||19951010133600||001\r\n"; 
        Message m = p.parse(msg);
        
        DefaultXMLParser xp = new DefaultXMLParser();
        System.out.println(xp.encode(m));
        //TreePanel.showInNewWindow(m);
        
    }

}
