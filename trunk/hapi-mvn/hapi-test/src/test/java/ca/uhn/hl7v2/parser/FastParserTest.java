/*
 * Created on 23-May-2005
 */
package ca.uhn.hl7v2.parser;

import java.net.URL;
import java.util.Map;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.model.v22.message.ORU_R01;
import ca.uhn.hl7v2.parser.FastParser.StructRef;
import ca.uhn.hl7v2.util.Terser;

import junit.framework.TestCase;

/**
 * Unit tests for FastParser. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:50 $ by $Author: jamesagnew $
 */
@SuppressWarnings("deprecation")
public class FastParserTest extends TestCase {

    /**
     * @param arg0 ... 
     */
    public FastParserTest(String arg0) {
        super(arg0);
    }

	public void testLoadEventGuideMap() throws Exception {
        URL url = FastParserTest.class.getClassLoader().getResource("ca/uhn/hl7v2/parser/guide.txt");
        Map<Object, StructRef> map = FastParser.loadEventGuideMap(url);
        
        FastParser.RootRef rr = (FastParser.RootRef) map.get("ORU^R01");
        assertEquals(true, rr.getSuccessor("MSH").isSegment());
        assertEquals("/PATIENT_RESULT(*)", 
                rr.getSuccessor("MSH").getSuccessor("PID").getRelativePath());
        assertEquals(false, 
                rr.getSuccessor("MSH").getSuccessor("PID").isSegment());
        assertEquals("/PATIENT", 
                rr.getSuccessor("MSH").getSuccessor("PID").getSuccessor("PID").getRelativePath());
        assertEquals("/PID", 
                rr.getSuccessor("MSH").getSuccessor("PID").getSuccessor("PID").getSuccessor("PID").getRelativePath());
        
        FastParser.StructRef ref = rr.getSuccessor("MSH").getSuccessor("PID").getSuccessor("PID").getSuccessor("PID");
        rr.reset();
        assertEquals("/PATIENT_RESULT(-1)/PATIENT/PID", ref.getFullPath());
        
        assertEquals("/ORDER_OBSERVATION(*)", 
                rr.getSuccessor("MSH").getSuccessor("PID").getSuccessor("PID").getSuccessor("PID").getSuccessor("OBX")
                .getRelativePath());
        assertEquals("/OBSERVATION(*)", 
                rr.getSuccessor("MSH").getSuccessor("PID").getSuccessor("PID").getSuccessor("PID").getSuccessor("OBX")
                .getSuccessor("OBX").getRelativePath());
        assertEquals("/OBX", 
                rr.getSuccessor("MSH").getSuccessor("PID").getSuccessor("PID").getSuccessor("PID").getSuccessor("OBX")
                .getSuccessor("OBX").getSuccessor("OBX").getRelativePath());
        assertEquals(true, 
                rr.getSuccessor("MSH").getSuccessor("PID").getSuccessor("PID").getSuccessor("PID").getSuccessor("OBX")
                .getSuccessor("OBX").getSuccessor("OBX").isSegment());
        assertEquals("/ORDER_OBSERVATION(*)", 
                rr.getSuccessor("MSH").getSuccessor("PID").getSuccessor("PID").getSuccessor("PID").getSuccessor("OBX")
                .getSuccessor("OBX").getSuccessor("OBX").getSuccessor("OBX").getRelativePath());
        assertEquals("/PATIENT_RESULT(*)", 
                rr.getSuccessor("MSH").getSuccessor("PID").getSuccessor("PID").getSuccessor("PID").getSuccessor("OBX")
                .getSuccessor("OBX").getSuccessor("OBX").getSuccessor("PID").getRelativePath());
    }

	public void testParse() throws HL7Exception {
        URL url = FastParserTest.class.getClassLoader().getResource("ca/uhn/hl7v2/parser/guide.txt");
        Map<Object, StructRef> map = FastParser.loadEventGuideMap(url);
        
        FastParser parser = new FastParser(map);

        Message msg = parser.parse(getORU());
        assertEquals(ORU_R01.class, msg.getClass());
        Terser t = new Terser(msg);
        assertEquals("ORU", t.get("/MSH-9-1"));
        assertEquals("2.2", t.get("/MSH-12"));
        assertEquals("T12345", t.get("/.PID-3"));
        assertEquals(null, t.get("/.PID-6")); //not parsed
       
        Message msg2 = parser.parse(getADT());
        assertEquals(ADT_A01.class, msg2.getClass());
        t = new Terser(msg2);
        assertEquals("ADT", t.get("/MSH-9-1"));
        assertEquals("2.2", t.get("/MSH-12"));
        assertEquals("00001122", t.get("/.PID-3"));
        assertEquals("GEORGE", t.get("/.PV1-7-3")); 
    }
    
    /**
     * A performance test.  
     * @param args
     */
	public static void main(String[] args) {
//        FastParserTest test = new FastParserTest("");
        try {
            URL url = FastParserTest.class.getClassLoader().getResource("ca/uhn/hl7v2/parser/guide.txt");
            Map<Object, StructRef> map = FastParser.loadEventGuideMap(url);
            FastParser fast = new FastParser(map);
            PipeParser slow = PipeParser.getInstanceWithNoValidation();
            
            String message = getORU();
            int reps = 1000;
            
            System.out.println("slow parser: " + timeParses(message, slow, reps) + "ms");        
            System.out.println("fast parser: " + timeParses(message, fast, reps) + "ms");
        } catch (HL7Exception e) {
            e.printStackTrace();
        }
    }
    
    private static long timeParses(String theMessage, Parser theParser, int theReps) throws HL7Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < theReps; i++) {
            theParser.parse(theMessage);
        }
        return System.currentTimeMillis() - start;
    }
    
    private static String getORU() {
        return "MSH|^~\\&|LABGL1||DMCRES||19951002185300||ORU^R01|LABGL1199510021853635|P|2.2\r"
            + "PID|||T12345||TEST^PATIENT^P|TEST|19601002|M||||||||||123456\r"
            + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r"
            + "OBR|1||09527539447004050|7004050^DRUG SCREEN- ED GENERAL URINE^^^ED-GEN UR|||19951002180500|||||||19951002182500||||1793562||0952753944||1995100218530000||100|F||^^^^^RT\r"
            + "OBX||TX|7003215^BARBITURATES URINE^^^BARB-URINE|0001|NEG||||||F|||19951002185300||182\r"
            + "NTE|||THC = NEG\r"
            + "NTE\r"
            + "NTE|||          POSITIVE THRESHOLD\r"
            + "NTE|||          ******************\r"
            + "NTE|||           >200 ng/mL\r"
            + "OBX||TX|7003255^BENZODIAZEPINE URINE^^^BENZO-UR|0001|POS||||||F|||19951002185300||182\r"
            + "NTE\r"
            + "NTE|||          POSITIVE THRESHOLD\r"
            + "NTE|||          ******************\r"
            + "NTE|||           >200 ng/mL\r"
            + "OBX||TX|7003265^COCAINE METABOLITE^^^COCAINE-UR|0001|NEG||||||F|||19951002185300||182\r"
            + "NTE\r"
            + "NTE|||          POSITIVE THRESHOLD\r"
            + "NTE|||          ******************\r"
            + "NTE|||           >300 ng/mL\r"
            + "OBX||TX|7003275^OPIATES URINE^^^OPIATES-UR|0001|NEG||||||F|||19951002185300||182\r"
            + "NTE\r"
            + "NTE|||          POSITIVE THRESHOLD\r"
            + "NTE|||          ******************\r"
            + "NTE|||           >300 ng/mL\r";        
    }
    
    private static String getADT() {
        return "MSH|^~\\&|HIS|RIH|EKG|EKG|199904140038||ADT^A01||P|2.2\r"
            + "PID|0001|00009874|00001122|A00977|LEG^RIGHT^M|MOM|19581119|F|NOTREAL^LINDA^M|C|564 SPRING ST^^NEEDHAM^MA^02494^US|0002|(818)565-1551|(425)828-3344|E|S|C|0000444444|252-00-4414||||SA|||SA||||NONE|V1|0001|I|D.ER^50A^M110^01|ER|P00055|11B^M011^02|070615^BATMAN^GEORGE^L|555888^NOTREAL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^NOTREAL^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|199904101200||||5555112333|||666097^NOTREAL^MANNY^P\r"
            + "NK1|0222555|NOTREAL^JAMES^R|FA|STREET^OTHER STREET^CITY^ST^55566|(222)111-3333|(888)999-0000|||||||ORGANIZATION\r"
            + "PV1|0001|I|D.ER^1F^M950^01|ER|P000998|11B^M011^02|070615^BATMAN^GEORGE^L|555888^OKNEL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^VOICE^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|||||5555112333|||666097^DNOTREAL^MANNY^P\r"
            + "PV2|||0112^TESTING|55555^PATIENT IS NORMAL|NONE|||199902251200|199902262200|1|1|TESTING|555888^NOTREAL^BOB^K^DR^MD||||||||||PROD^003^099|02|ER||NONE|19990225|19990223|19990316|NONE\r"
            + "AL1||SEV|001^POLLEN\r"
            + "GT1||0222PL|NOTREAL^BOB^B||STREET^OTHER STREET^CITY^ST^77787|(444)999-3333|(222)777-5555||||MO|111-33-5555||||NOTREAL GILL N|STREET^OTHER STREET^CITY^ST^99999|(111)222-3333\r"
            + "IN1||022254P|4558PD|BLUE CROSS|STREET^OTHER STREET^CITY^ST^00990||(333)333-6666||221K|LENIX|||19980515|19990515|||PATIENT01 TEST D||||||||||||||||||02LL|022LP554\r";

    }

}
