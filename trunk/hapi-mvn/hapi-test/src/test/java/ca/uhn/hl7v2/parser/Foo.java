package ca.uhn.hl7v2.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v26.datatype.CX;
import ca.uhn.hl7v2.model.v26.datatype.FT;
import ca.uhn.hl7v2.model.v26.datatype.XPN;
import ca.uhn.hl7v2.model.v26.message.REF_I12;
import ca.uhn.hl7v2.model.v26.segment.MSH;
import ca.uhn.hl7v2.model.v26.segment.NTE;
import ca.uhn.hl7v2.model.v26.segment.PID;
import ca.uhn.hl7v2.model.v26.segment.RF1;

public class Foo {

    private static final Logger log = LoggerFactory.getLogger(Foo.class);
    
    public static void main(String[] args) throws HL7Exception {
        REF_I12 refI12 = new REF_I12();
        fillMsh(refI12.getMSH());
        fillRf1(refI12.getRF1());
        fillPid(refI12.getPID());
        fillNte0(refI12.getNTE(0));
        fillNte1(refI12.getNTE(1));

        PipeParser pipeParser = new PipeParser();
        String hl7Text = pipeParser.encode(refI12);

        log.info(hl7Text.replace("\r", "\n"));
        log.info("NTE Segments before : " + refI12.getNTEReps());

        log.info("---------------");

        REF_I12 newRefI12 = (REF_I12) pipeParser.parse(hl7Text);
        log.info("NTE Segments after : " + newRefI12.getNTEReps());
    }

    private static void fillMsh(MSH msh) throws DataTypeException {
        msh.getFieldSeparator().setValue("|");
        msh.getEncodingCharacters().setValue("^~\\&");
        msh.getVersionID().getVersionID().setValue("2.6");
        msh.getMessageType().getMessageCode().setValue("REF");
        msh.getMessageType().getTriggerEvent().setValue("I12");
        msh.getMessageType().getMessageStructure().setValue("REF_I12");
    }

    private static void fillRf1(RF1 rf1) throws HL7Exception {
        rf1.getReferralType().getIdentifier().setValue("Lab");
        rf1.getReferralType().getText().setValue("Laboratory");
        rf1.getReferralDisposition(0).getIdentifier().setValue("WR");
        rf1.getReferralDisposition(0).getText().setValue("Send Written Report");
        rf1.getOriginatingReferralIdentifier().getEntityIdentifier().setValue("123456");
        rf1.getReferralReason(0).getIdentifier().setValue("S");
        rf1.getReferralReason(0).getText().setValue("Second Opinion");
    }

    private static void fillPid(PID pid) throws HL7Exception {
        pid.getSetIDPID().setValue("1");

        CX cx = pid.getPatientIdentifierList(0);
        cx.getIDNumber().setValue("12345");

        XPN xpn = pid.getPatientName(0);
        xpn.getFamilyName().getSurname().setValue("last name");
        xpn.getGivenName().setValue("first name");
        xpn.getNameTypeCode().setValue("L");

        pid.getAdministrativeSex().setValue("M");
    }

    private static void fillNte0(NTE nte) throws HL7Exception {
        nte.getCommentType().getText().setValue("type");
        FT ft = nte.getComment(0);
        ft.setValue("asdf");
    }

    private static void fillNte1(NTE nte) throws HL7Exception {
        nte.getCommentType().getText().setValue("type1");
        FT ft = nte.getComment(0);
        ft.setValue("asdf1");
    }

}
