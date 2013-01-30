package ca.uhn.hl7v2.parser;

import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v251.message.OML_O21;

public class IHE_LTW_Examples {

   // Los OML deben ser respondidos con ORL (ACK)
   // OUL son de resultado
   //   OUL^R22 reporte de resultados asociados a muestras (IHE vol2a 3.3.5)
   //   OUL^R01 reporde de resultados asociados a ordenes (IHE vol2a 3.3.5)
   //   OUL^R24 reporde de resultados asociados a baterias de multiples muestras (IHE vol2a 3.3.5)
   
   static String ejemplo1 = "MSH|^~\\&|OP|Entero-gastric|OF|Chemistry|200309060820||OML^O21^OML_O21|msgOP123|T|2.5.1|123\r" +
                            "PID|1||12345^5^M10^Memphis_Hosp^PI||EVERYMAN^ADAM^^JR^^^L||19800101|M\r" +
                            "PV1|1|O|Ward|||||||||||||||12345\r" +
                            "ORC|NW|12345678^gastric||666^gastric|||||200309060710|222221^NURSE^NANCY|||||||||||Entero-gastric^^^^^^FI^^^EG02\r" +
                            "TQ1|||||||||A\r" +
                            "OBR||12345678^gastric||82951^Glucose Tolerance Test^C4||||||1234^BLEEDER|P|||||222222^PHYSICIAN^^^^DR|821\r" +
                            "OBX|1|NM|GLUCOSE||75|g|||||F|||200309060735\r" +
                            "SPM|1|123456781^gastric||SER|||||||P||||||200309060735|||||||||1\r" +
                            "SPM|2|123456782^gastric||SER|||||||P||||||200309060755|||||||||1\r" +
                            "SPM|3|123456783^gastric||SER|||||||P||||||200309060815|||||||||1";
   
   static String ejemplo2 = "MSH|^~\\&|OF|Chemistry|OP|Entero-gastric|200309060825||OML^O21^OML_O21|msgOF102|T|2.5.1|123\r" +
                            "PID|1||12345^5^M10^Memphis_Hosp^PI||EVERYMAN^ADAM^^JR^^^L||19800101|M\r" +
                            "PV1|1|O|Ward|||||||||||||||12345\r" +
                            "ORC|SC|12345678^gastric||666^gastric|IP||||200309060824|222221^NURSE^NANCY |||||||||||Entero-gastric^^^^^^FI^^^EG02\r" +
                            "TQ1|||||||||A\r" +
                            "OBR||12345678^gastric|555^chemistry|82951^Glucose Tolerance Test^C4||||||1234^BLEEDER|P|||||222222^PHYSICIAN^^^^DR|821||||||||I\r" +
                            "SPM|1|123456781^gastric||SER|||||||P||||||200309060735|200309060821||Y||||||1\r" +
                            "SPM|2|123456782^gastric||SER|||||||P||||||200309060755|200309060821||Y||||||1\r" +
                            "SPM|3|123456783^gastric||SER|||||||P||||||200309060815|200309060821||N|RB^Broken container|||||1";
   
   static String ejemplo3 = "MSH|^~\\&|OF|Chemistry|ORT||200309060825||OUL^R22^OUL_R22|msgOF103|T|2.5.1\r" +
                            "PID|1||12345^5^M10^Memphis_Hosp^PI||EVERYMAN^ADAM^^JR^^^L||19800101|M\r" +
                            "PV1|1|O|Ward|||||||||||||||12345\r" +
                            "ORC|SC|12345678^gastric||666^gastric|IP||||200309060824|222221^NURSE^NANCY|||||||||||Entero-gastric^^^^^^FI^^^EG02\r" +
                            "OBR||12345678^gastric|555^chemistry|82951^Glucose Tolerance Test^C4||||||1234^BLEEDER|P|||||222222^PHYSICIAN^^^^DR|821||||||||I\r" +
                            "TQ1|||||||||A\r" +
                            "OBX|1|NM|GLUCOSE||75|g|||||F|||200309060735\r" +
                            "OBX|2|NM|30264-6^GLUCOSE 40M POST DOSE GLUCOSE^LN||||||||X\r" +
                            "SPM|1|123456781^gastric||SER|||||||P||||||200309060735|200309060821||Y||||||1\r" +
                            "SPM|2|123456782^gastric||SER|||||||P||||||200309060755|200309060821||Y||||||1\r" +
                            "SPM|3|123456783^gastric||SER|||||||P||||||200309060815|200309060821||N|RB^Broken container|||||1";
   
   static String ejemplo4 = "MSH|^~\\&|OF|Chemistry|ORT||200309060825||OUL^R22^OUL_R22|msgOF105|T|2.5.1|123\r" +
                            "PID|1||12345^5^M10^Memphis_Hosp^PI||EVERYMAN^ADAM^^JR^^^L||19800101|M\r" +
                            "PV1|1|O|Ward|||||||||||||||12345\r" +
                            "ORC|SC|12345678^gastric||666^gastric|A||||200309060834|222221^NURSE^NANCY|||||||||||Entero-gastric^^^^^^FI^^^EG02\r" +
                            "OBR||12345678^gastric|^chemistry|82951^Glucose ToleranceTest^C4||||||1234^BLEEDER|P|||||222222^PHYSICIAN^^^^DR|821||||||||R\r" +
                            "TQ1|||||||||A\r" +
                            "OBX|1|NM|GLUCOSE||75|g|||||F|||200309060735\r" +
                            "OBX|2|NM|14996-3^GLUCOSE PRE 75 G GLUCOSE PO^LN||4200|umol/l|4000-6100|N|||R|||200309060755\r" +
                            "OBX|3|NM|30263-8^GLUCOSE 20M POST DOSE GLUCOSE^LN||6000|umol/l|<7800|N|||R|||200309060755\r" +
                            "OBX|4|NM|30264-6^GLUCOSE 40M POST DOSE GLUCOSE^LN||||||||X\r" +
                            "SPM|1|123456781^gastric||SER|||||||P||||||200309060735|200309060821||Y||||||1\r" +
                            "SPM|2|123456782^gastric||SER|||||||P||||||200309060755|200309060821||Y||||||1\r" +
                            "SPM|3|123456783^gastric||SER|||||||P||||||200309060815|200309060821||N|RB^Broken container|||||1";
   
   static String ejemplo5 = "MSH|^~\\&|OP|Entero-gastric|OF|Chemistry|200309060900||OML^O21^OML_O21|msgOP124|T|2.5.1|123\r" +
                            "PID|1||12345^5^M10^Memphis_Hosp^PI||EVERYMAN^ADAM^^JR^^^L||19800101|M\r" +
                            "PV1|1|O|Ward|||||||||||||||12345\r" +
                            "ORC|XO|12345678^gastric||666^gastric|||||200309060855|222221^NURSE^NANCY|||||||||||Entero-gastric^^^^^^FI^^^EG02\r" +
                            "TQ1|||||||||A\r" +
                            "OBR||12345678^gastric||82951^Glucose Tolerance Test^C4||||||1234^BLEEDER|S|||||222222^PHYSICIAN^^^^DR|821\r" +
                            "OBX|1|NM|GLUCOSE||75|g|||||F|||200309060735\r" +
                            "SPM|1|123456781^gastric||SER|||||||P||||||200309060735|||||||||1\r" +
                            "SPM|2|123456782^gastric||SER|||||||P||||||200309060755|||||||||1\r" +
                            "SPM|3|123456783^gastric||SER|||||||P||||||200309060815|||||||||1\r" +
                            "SPM|4|123456784^gastric||SER|||||||P||||||200309060835|||||||||1\r" +
                            "SPM|5|123456785^gastric||SER|||||||P||||||200309060855|||||||||1";
   
   static String ejemplo6 = "MSH|^~\\&|OF|Chemistry|ORT||200309060905||OUL^R22^OUL_R22|msgOF108|T|2.5.1|123\r" +
                            "PID|1||12345^5^M10^Memphis_Hosp^PI||EVERYMAN^ADAM^^JR^^^L||19800101|M\r" +
                            "PV1|1|O|Ward|||||||||||||||12345\r" +
                            "ORC|SC|12345678^gastric||666^gastric|A||||200309060904|222221^NURSE^NANCY|||||||||||Entero-gastric^^^^^^FI^^^EG02\r" +
                            "OBR||12345678^gastric|555^chemistry|82951^Glucose Tolerance Test^C4||||||1234^BLEEDER|S|||||222222^PHYSICIAN^^^^DR|821||||||||R\r" +
                            "TQ1|||||||||A\r" +
                            "OBX|1|NM|GLUCOSE||75|g|||||F|||200309060735\r" +
                            "OBX|2|NM|14996-3^GLUCOSE PRE 75 G GLUCOSE PO^LN||4200|umol/l|4000-6100|N|||R|||200309060735\r" +
                            "OBX|3|NM|30263-8^GLUCOSE 20M POST DOSE GLUCOSE^LN||6000|umol/l|<7800|N|||R|||200309060755\r" +
                            "OBX|4|NM|30264-6^GLUCOSE 40M POST DOSE GLUCOSE^LN||||||||X\r" +
                            "SPM|1|123456781^gastric||SER|||||||P||||||200309060735|200309060821||Y||||||1\r" +
                            "SPM|2|123456782^gastric||SER|||||||P||||||200309060755|200309060821||Y||||||1\r" +
                            "SPM|3|123456783^gastric||SER|||||||P||||||200309060815|200309060821||N|RB^Broken container|||||1\r" +
                            "SPM|4|123456784^gastric||SER|||||||P||||||200309060835|200309060902||Y||||||1\r" +
                            "SPM|5|123456785^gastric||SER|||||||P||||||200309060855|200309060902||Y||||||1";
   
   // 4.3.3.13
   static String ejemplo7 = "MSH|^~\\&|OF|Chemistry|OP|Entero-gastric|200309060930||OML^O21^OML_O21|msgOF109|T|2.5.1|123\r" +
                            "PID|1||12345^5^M10^Memphis_Hosp^PI||EVERYMAN^ADAM^^JR^^^L||19800101|M\r" +
                            "PV1|1|O|Ward|||||||||||||||12345\r" +
                            "ORC|SC|12345678^gastric||666^gastric|CM||||200309060929|222221^NURSE^NANCY|||||||||||Entero-gastric^^^^^^FI^^^EG02\r" +
                            "TQ1|||||||||A\r" +
                            "OBR||12345678^gastric|555^chemistry|82951^Glucose Tolerance Test^C4||||||1234^BLEEDER|S|||||222222^PHYSICIAN^^^^DR|821|||||200309060929|||F|||||||444444&CHEMISTRY-EXPERT&Jane&&&&&&MEMPHIS HOSPITAL^200309060929\r" +
                            "SPM|1|123456781^gastric ||SER|||||||P||||||200309060735|200309060821||Y||||||1\r" +
                            "SPM|2|123456782^gastric ||SER|||||||P||||||200309060755|200309060821||Y||||||1\r" +
                            "SPM|3|123456783^gastric ||SER|||||||P||||||200309060815|200309060821||N|RB|||||1\r" +
                            "SPM|4|123456784^gastric ||SER|||||||P||||||200309060835|200309060902||Y||||||1\r" +
                            "SPM|5|123456785^gastric ||SER|||||||P||||||200309060855|200309060902||Y||||||1";
   
   //4.3.3.14
   static String ejemplo8 = "MSH|^~\\&|OF|Chemistry|ORT||200309060930||OUL^R22^OUL_R22|msgOF110|T|2.5.1|123\r" +
                           "PID|1||12345^5^M10^Memphis_Hosp^PI||EVERYMAN^ADAM^^JR^^^L||19800101|M\r" +
                           "PV1|1|O|Ward|||||||||||||||12345\r" +
                           "ORC|SC|12345678^gastric||666^gastric|CM||||200309060929|222221^NURSE^NANCY|||||||||||Entero-gastric^^^^^^FI^^^EG02\r" +
                           "OBR||12345678^gastric|555^chemistry|82951^Glucose Tolerance Test^C4||||||1234^BLEEDER|S|||||222222^PHYSICIAN^^^^DR|821|||||200309060929|||F|||||||444444&CHEMISTRY-EXPERT&Jane&&&&&&MEMPHIS HOSPITAL^200309060929\r" +
                           "TQ1|||||||||A\r" +
                           "OBX|1|NM|GLUCOSE||75|g|||||F|||200309060735\r" +
                           "OBX|2|NM|14996-3^GLUCOSE PRE 75 G GLUCOSE PO^LN||4200|umol/l|4000-6100|N|||F|||200309060735\r" +
                           "OBX|3|NM|30263-8^GLUCOSE 20M POST DOSE GLUCOSE^LN||6000|umol/l|<7800|N|||F|||200309060755\r" +
                           "OBX|4|NM|30264-6^GLUCOSE 40M POST DOSE GLUCOSE^LN||||||||X\r" +
                           "OBX|5|NM|14756-1^GLUCOSE 1H POST DOSE GLUCOSE^LN||7200|umol/l|<7800|N|||F|||200309060835\r" +
                           "OBX|6|NM|30265-3^GLUCOSE 1.3H POST DOSE GLUCOSE^LN||7100|umol/l|<7800|N|||F|||200309060855\r" +
                           "SPM|1|123456781^gastric ||SER|||||||P||||||200309060735|200309060821||Y||||||1\r" +
                           "SPM|2|123456782^gastric ||SER|||||||P||||||200309060755|200309060821||Y||||||1\r" +
                           "SPM|3|123456783^gastric ||SER|||||||P||||||200309060815|200309060821||N|RB^Broken container|||||1\r" +
                           "SPM|4|123456784^gastric ||SER|||||||P||||||200309060835|200309060902||Y||||||1\r" +
                           "SPM|5|123456785^gastric ||SER|||||||P||||||200309060855|200309060902||Y||||||1";
   
   // No esta relacionado al flujo anterior
   // 4.2.3.2 ORL (ACK)
   static String ejemplo9 = "MSH|^~\\&|AM|Automation|OF|Cytology|200310060826||ORL^O34^ORL_O34|301|T|2.5.1\r" +
                              "MSA|AA|101\r" +
                              "PID|1||6543210^^^Abbeville Hospital^PI||ILL^JOHN^^^^^L||19810101|M\r" +
                              "SPM|1|456_1^Cytology||BLD|||||||P||||||200310060735|200310060821||||||||1\r" +
                              "ORC|OK|||555^Urology|SC||||200310060710|^NURSE^JANET|||||||||||Urology^^^^^^FI^^^UR01\r" +
                              "TQ1|1||||||||R\r" +
                              "OBR|1|456^Cytology||85027^Hemogram and platelet count, automated^C4||||||^COLLECT^JOHN|S|||||^URO^^^^DR\r" +
                              "ORC|OK|||555^Urology|SC||||200310060710|^NURSE^JANET|||||||||||Urology^^^^^^FI^^^UR01\r" +
                              "TQ1|1||||||||R\r" +
                              "OBR|1|457^Cytology||85009^Differential WBC Count, buffy coat^C4||||||^COLLECT^JOHN|S|||||^URO^^^^DR";
   
   static String ejemplo10 = "MSH|^~\\&|LAB||HCE||20010913141958||ORU^R01^ORU_R01|LAB562901|T|2.5.1||||ER\r" +
                              "PID|1|| |123456^^^^DNI|DEPRUEBA^JUAN||19220415|F||||||||||\r" +
                              "ORC|SC|P999999/5^LAB|P999999/5^LAB|P999999/5^LAB|CM||||200109131410\r" +
                              "OBR|1|P999999/5^LAB||123^HEMOGRAMA^LAB_COD^500123^HEMOGRAMA^RED_LAB||||||||||||||||||||DMT500|||1^^^20010911075500|||||||||\r" +
                              "OBX|1|NM|470^HEMOGLOBINA SANGRE TOTAL^LAB_COD ^4546-8^HEMOGLOBIN:MCNC:PT:BLD:QN^LN||14.31|g/dL||||A|F|\r" +
                              "OBX|2|NM|466^HEMATOCRITO^ LAB_COD^20570-8^HEMATOCRIT:VFR:PT:BLD:QN^LN||41.86|%||||A|F|\r" +
                              "OBX|3|NM|410^HEMATIES RECUENTO^ LAB_COD^789-8^ERYTHROCYTES:NCNC:PT:BLD:QN^LN||4.46|mill/mm3|4.50&5.90|||A|F|\r" +
                              "OBX|4|NM|409^LEUCOCITOS RECUENTO^ LAB_COD^6690-2^LEUCOCYTES:NCNC:PT:BLD:QN^LN||7350.00|/mm3|0.00&10000.00|||A|F|\r" +
                              "OBX|5|NM|354-01^Neutrofilos mielocitos:^LAB_COD^750-0^MYELOCYTES/100LEUKOCYTES:VFR:PT:BLD:QN^LN||0.00|%||||A|F";
   

   static String ejemploOML = "MSH|^~\\&|HIS|ASE|LIS|Rapela|||OML^O21||T|2.5\r" +
                              "PID|||14^^^^HC-HCE||BARRIONUEVO^RODOLFO SEBASTIÁN\r" +
                              "IN1|1|260^^Planes-HCE|10464^^^^OOSS-HCE|OSDE 210\r" +
                              "ORC|NW|1^HCE\r" +
                              "OBR|1|1^HCE||1041^FAUCES RAPIDO (EIA O LATEX)^Desarrollo^2117^FAUCES RAPIDO (EIA O LATEX)^Cod-HCE|S|201301221046\r" +
                              "ORC|NW|2^HCE\r" +
                              "OBR|2|2^HCE||1050^OSTEOCALCINA SERICA^Desarrollo^2121^OSTEOCALCINA SERICA^Cod-HCE|S|201301221046\r" +
                              "ORC|NW|3^HCE\r" +
                              "OBR|3|3^HCE||10525^HEPATITIS B GENOTIPO^Desarrollo^2126^HEPATITIS B GENOTIPO^Cod-HCE|S|201301221046\r" +
                              "ORC|NW|4^HCE\r" +
                              "OBR|4|4^HCE||10526^HEMOCULTIVO BACTEC - 1 MUESTRA (CULTIVO RAPIDO)^Desarrollo^2127^HEMOCULTIVO BACTEC - 1 MUESTRA (CULTIVO RAPIDO)^Cod-HCE|S|201301221046";
   
   static String ejemploOML2 = "MSH|^~\\&|OF|Chemistry|AM|Automation|200309060825||OML^O21^OML_O21|msgOF101|T|2.5|123||||USA||EN\r" +
                               "PID|1||12345^5^M10^Memphis_Hosp^PI||EVERYMAN^ADAM^^JR^^^L||19800101|M\r" +
                               "PV1|1|O|Ward|||||||||||||||12345\r" +
                              "ORC|NW|||666^gastric|||||200309060824|222221^NURSE^NANCY|||||||||||Entero-gastric^^^^^^FI^^^EG02\r" +
                              "TQ1|||||||||A\r" +
                              "OBR||555_1^chemistry||GLUC^GLUCOSE^L||||||1234^BLEEDER|S|||||222222^PHYSICIAN^^^^DR|821\r" +
                              "SPM|1|123456781^gastric ||SER|||||||P||||||200309060735|200309060821||||||||1\r" +
                              "ORC|NW|||666^gastric|||||200309060710|222221^NURSE^NANCY|||||||||||Entero-gastric^^^^^^FI^^^EG02\r" +
                              "TQ1|||||||||A\r" +
                              "OBR||555_2^chemistry||GLUC^GLUCOSE^L||||||1234^BLEEDER|S|||||222222^PHYSICIAN^^^^DR|821\r" +
                              "SPM|1|123456782^gastric||SER|||||||P||||||200309060755|200309060821||||||||1";
   
   // ORC-2, OBR-2: Placer Order Number
   static String ejemploHL7v25 = "MSH|^~\\&|HIS|ASE|LIS|Rapela|||OML^O21||T|2.5\r"+
                                 "PID|||14^^^^HC-HCE||BARRIONUEVO^RODOLFO SEBASTIÁN\r"+
                                 "ORC|NW|||GROUP1^HCE\r"+
                                 "TQ1|\r"+
                                 "OBR||id1^HCE|81641^RAD|73666^Bilateral Feet|\r"+
                                 "SPM|1|123456781^gastric||SER\r"+
                                 "ORC|NW|||GROUP1^HCE\r"+
                                 "TQ1|\r"+
                                 "OBR||id2^HCE|81642^RAD|73642^Bilateral Hand PA|\r"+
                                 "SPM|2|123456782^gastric||SER\r"+
                                 "ORC|NW|||GROUP1^HCE\r"+
                                 "TQ1|\r"+
                                 "OBR||id3^HCE|81643^RAD|73916^Bilateral Knees|\r"+
                                 "SPM|3|123456783^gastric||SER";
   
   /**
    * @param args
 * @throws HL7Exception 
    */
   public static void main(String[] args) throws HL7Exception
   {
      // Test crear OML_O21
      OML_O21 msg = new OML_O21();
      try
      {
         msg.initQuickstart("OML", "O21", "T");
      
         for (int i=0; i<5; i++)
         {
            msg.getORDER(i).getORC().getOrc1_OrderControl().setValue("NW");
            msg.getORDER(i).getORC().getOrc2_PlacerOrderNumber().getEi1_EntityIdentifier().setValue("ORCID1");
            msg.getORDER(i).getORC().getOrc2_PlacerOrderNumber().getEi2_NamespaceID().setValue("HCE");
            msg.getORDER(i).getORC().getOrc4_PlacerGroupNumber().getEi1_EntityIdentifier().setValue("grupo");
            
            msg.getORDER(i).getOBSERVATION_REQUEST().getOBR().getObr4_UniversalServiceIdentifier().getCe1_Identifier().setValue("STDIO1");
            msg.getORDER(i).getOBSERVATION_REQUEST().getOBR().getObr4_UniversalServiceIdentifier().getCe3_NameOfCodingSystem().setValue("LOINC");
            
         }
         
         System.out.println(new PipeParser().encode(msg));
         System.out.println("--------------------------------");
         System.out.println(msg.printStructure(false));
      }
      catch (HL7Exception e)
      {
         e.printStackTrace();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      
      Message message = parseMessage(ejemplo1);
      if (message != null)
      {
         //showXML(message);
      }
      
      message = parseMessage(ejemplo2);
      if (message != null)
      {
         //showXML(message);
      }
      
      message = parseMessage(ejemplo3);
      if (message != null)
      {
         //showXML(message);
      }
      
      message = parseMessage(ejemplo4);
      if (message != null)
      {
    	  //System.out.println(message.printStructure());
         //showXML(message);
      }
      
      message = parseMessage(ejemplo5);
      if (message != null)
      {
         //showXML(message);
      }
      
      message = parseMessage(ejemplo6);
      if (message != null)
      {
         //showXML(message);
      }
      
      message = parseMessage(ejemplo7);
      if (message != null)
      {
         //showXML(message);
      }
      
      message = parseMessage(ejemplo8);
      if (message != null)
      {
         //showXML(message);
      }
      
      message = parseMessage(ejemplo9);
      if (message != null)
      {
         //showXML(message);
      }
      
      message = parseMessage(ejemplo10);
      if (message != null)
      {
         //showXML(message);
      }
      
      message = parseMessage(ejemploOML);
      if (message != null)
      {
         //showXML(message);
      }
      message = parseMessage(ejemploOML2);
      if (message != null)
      {
         //showXML(message);
      }
      message = parseMessage(ejemploHL7v25);
      if (message != null)
      {
         //showXML(message);
      }
      
      
   }
   
   private static Message parseMessage(String msg)
   {
      Parser p = new GenericParser();
      
      Message message;
      try
      {
         message = p.parse(msg);
      }
      catch (EncodingNotSupportedException e)
      {
         e.printStackTrace();
         return null;
      }
      catch (HL7Exception e)
      {
         e.printStackTrace();
         return null;
      }
      
      // Por si quiero acceder a los datos
      // Va a depender del tipo de mensaje (eso se puede ver pidiendo el tipo en MSH
      // OML_O21 msg = (OML_O21)message;
      // ORL_O22 ...
      // OUL_...
      
      return message;
   }
   
   /**
    * // Muestra mensaje en XML
    * 
    * @param message
    */
   private static void showXML(Message message)
   {
      XMLParser xmlParser = new DefaultXMLParser();
      
      //encode message in XML 
      String xml = "no convirtio el mensaje a XML";
      try
      {
         xml = xmlParser.encode(message);
      }
      catch (HL7Exception e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      //print XML-encoded message to standard out
      System.out.println(xml);
   }
}
