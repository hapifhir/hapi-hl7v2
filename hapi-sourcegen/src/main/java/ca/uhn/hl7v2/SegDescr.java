package ca.uhn.hl7v2;

import java.io.File;
import java.util.Scanner;

public class SegDescr {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(SegDescr.class.getClassLoader().getResourceAsStream("segment descriptions.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] cols = line.split("\\s+", 2);

            // process the line

            System.out.printf("   <xsd:attributeGroup ref=\"%s.ATTRIBUTES\"/>\n", cols[0]);
            System.out.println("</xsd:complexType>");
            System.out.printf("<xsd:attributeGroup name=\"%s.ATTRIBUTES\">\n", cols[0]);
            System.out.printf("   <xsd:attribute name=\"LongName\" type=\"xsd:string\" fixed=\"%s\"/>\n", cols[1]);
            System.out.println("</xsd:attributeGroup>");
            System.out.println();
        }
    }
}

