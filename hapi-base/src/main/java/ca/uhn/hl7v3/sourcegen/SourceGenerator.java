/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "SourceGenerator.java".  Description: 
"Tools for the generation of HL7 v3 source code." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v3.sourcegen;

import java.io.*;
import java.sql.*;

/**
 * Tools for the generation of HL7 v3 source code.
 * @author Bryan Tripp
 * @deprecated
 */
public class SourceGenerator {
    
    /** Creates a new instance of SourceGenerator */
    public SourceGenerator() {
    }
    
    public static void writeEJBCode(File baseDirectory, Connection conn) throws Exception {
        File rimDir = prepDirectories(baseDirectory);
        
        DefinitionLoader dl = new DefinitionLoader(conn);
        String[] classes = dl.getRIMClassNames();
        for (int i = 0; i < classes.length; i++) {
            writeEJBCode(rimDir, classes[i], conn);
        }
        String[] datatypes = dl.getRIMDataTypeNames();
        File dtDir = new File(rimDir, "datatype");
        for (int i = 0; i < datatypes.length; i++) {
            writeDataTypeCode(dtDir, datatypes[i], conn);
        }        
    }
    
    /** 
     * Checks that the given baseDirectory is a directory (throws Exception otherwise) and 
     * creates appropriate RIM class and datatype directories under it.  Returns the RIM class
     * directory, under which the child "datatype" is the datatype directory.  
     */
    private static File prepDirectories(File baseDirectory) throws Exception {
        if (!baseDirectory.isDirectory()) {
            throw new Exception("The specified base directory " + baseDirectory.toString() + " is not a directory.");
        }
        
        File rimDir = new File(baseDirectory, getRIMPackage().replace('.', File.separatorChar));
        File dtDir = new File(rimDir, "datatype");
        dtDir.mkdirs();

        return rimDir;
    }
    
    /**
     * Writes source code for an EJB representation of the given RIM class to
     * the given directory.
     */
    public static void writeEJBCode(File rimDir, String RIMClass, Connection conn) throws Exception {
        DefinitionLoader dl = new DefinitionLoader(conn);
        ClassDefinition def = dl.getRIMClassDef(RIMClass);
        CMPClassGenerator gen = new CMPClassGenerator();
        
        //write home interface ...
        BufferedWriter home = new BufferedWriter(new FileWriter(new File(rimDir, def.getName() + "Home.java")));
        home.write(gen.makeHomeCode(def));
        home.flush();
        home.close();
        
        //write remote interface ...
        BufferedWriter remote = new BufferedWriter(new FileWriter(new File(rimDir, def.getName() + ".java")));
        remote.write(gen.makeRemoteCode(def));
        remote.flush();
        remote.close();
        
        //write bean interface ...
        BufferedWriter bean = new BufferedWriter(new FileWriter(new File(rimDir, def.getName() + "Bean.java")));
        bean.write(gen.makeBeanCode(def));
        bean.flush();
        bean.close();
    }
    
    public static void writeDataTypeCode(File dtDir, String dataType, Connection conn) throws Exception {
        DefinitionLoader dl = new DefinitionLoader(conn);
        DataTypeDefinition def = dl.getDataTypeDef(dataType);
        DataTypeGenerator gen = new DataTypeGenerator();
        
        BufferedWriter out = new BufferedWriter(new FileWriter(new File(dtDir, def.getName() + ".java")));
        out.write(gen.makeDataType(def));
        out.flush();
        out.close();
    }
    
    /** Returns a public method signature for the setter of a given attribute (not incl. throws clause) */
    public static String makeSetterSignature(AttributeDefinition att) {
        StringBuffer code = new StringBuffer();
        code.append("public void set");
        code.append(att.getName().substring(0, 1).toUpperCase());
        code.append(att.getName().substring(1, att.getName().length()));
        code.append("(");
        code.append(att.getDataType());
        code.append(" ");
        code.append(att.getName());
        code.append(")");
        return code.toString();
    }
    
    /** Returns a public method signature for the getter of a given attribute (not incl. throws clause) */
    public static String makeGetterSignature(AttributeDefinition att) {
        StringBuffer code = new StringBuffer();
        code.append("public ");
        code.append(att.getDataType());
        code.append(" get");
        code.append(att.getName().substring(0, 1).toUpperCase());
        code.append(att.getName().substring(1, att.getName().length()));
        code.append("()");
        return code.toString();
    }
    
    public static String getRIMPackage() {
        return "ca.uhn.hl7v3.rim";
    }
    
    public static String getRIMDataTypePackage() {
        return "ca.uhn.hl7v3.rim.datatype";
    }
    
    public static String makeJavaDocComment(String description, int indent) {
        if (description == null) {
            return spaces(indent) + "/** */ \r\n";
        }
            
        int width = 70 - indent;
        StringBuffer comment = new StringBuffer();
        comment.append(spaces(indent));
        comment.append("/** \r\n");
        
        boolean done = false;
        int start = 0;
        while (!done) {
            comment.append(spaces(indent));
            comment.append(" * ");
            int lineBreak = findLineBreak(description, start, width);
            comment.append(description.substring(start, lineBreak).trim());
            comment.append(" \r\n");
            if (lineBreak == description.length()) {
                done = true;
            } else {
                start = lineBreak;
            }
        }
        comment.append(spaces(indent));
        comment.append(" */ \r\n");
        return comment.toString();
    }
    
    /** Returns a String with the number of specified spaces. */
    private static String spaces(int numSpaces) {
        StringBuffer spaces = new StringBuffer();
        for (int i = 0; i < numSpaces; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }
    
    /**
     * Returns a suitable location for a line break (e.g. beginning of a word) in the given
     * String, starting at the given location, using the given maximum line length.
     */
    public static int findLineBreak(String s, int start, int maxLength) {
        int lineBreak = start + maxLength;
        int existingCarriageReturnLoc = s.indexOf('\r', start);
        if (existingCarriageReturnLoc > -1 && existingCarriageReturnLoc < lineBreak) {
            lineBreak = existingCarriageReturnLoc + 1;
        } else if (lineBreak >= s.length()) {
            lineBreak = s.length();
        } else {
            boolean found = false;
            while (!found) {
                char c = s.charAt(lineBreak);
                if (Character.isWhitespace(c)) {
                    found = true;
                    lineBreak++;
                } else {
                    lineBreak--;
                }
            }
        }
        return lineBreak;
    }
    
    public static void main(String args[]) {
        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage: SourceGenerator base_directory [RIM_class]");
            System.exit(1);
        }
        
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:odbc:RIM");
            File base = new File(args[0]);
            base.mkdirs();
            if (args.length == 1) {
                SourceGenerator.writeEJBCode(base, conn);
            } else {
                SourceGenerator.writeEJBCode(base, args[1], conn);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
