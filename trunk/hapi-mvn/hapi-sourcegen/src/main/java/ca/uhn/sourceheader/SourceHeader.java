package ca.uhn.sourceheader;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p>Adds header comments to source code files, such as copyright  
 * and license information.  A template for the header should be stored
 * in a file.  The template can contain plain text and a few template fields
 * that are replaced with values related to each file being processed (see 
 * the <code>setHeaderFile(...)</code> method).</p>
 * <p>Warning: This code is not very well-tested, although it seems to work for 
 * my code.  Use at own risk.</p>
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public class SourceHeader {

    String headerText = null;
    File destDir = null;
    
    /** 
     * Creates new SourceHeader. 
     * @param destinationDirectory the directory to which modified files 
     *      should be written 
     */
    public SourceHeader(String destinationDirectory) throws IOException {
        this.destDir = new File(destinationDirectory);
        if (!destDir.isDirectory()) throw new IOException("Can't create SourceHeader - " + 
            destinationDirectory + "is not a directory. ");
    }

    /** 
     * Set the text file from which header information should be 
     * read.  The file can contain plain text as well as the following 
     * template field strings (which are replaced with values related to each file 
     * that is processed):
     * <ul><li>[file_name] ... the name of the file, e.g. Class1.java </li>
     * <li>[one_line_description] ... the first sentence, delimited by ". ", in the class
     *      JavaDoc comments</li>
     * <li>[full_description] ... the entire class JavaDoc comments</li></ul>
     */ 
    public void setHeaderFile(String headerFileName) throws IOException {
        File header = new File(headerFileName);
        
        StringBuffer h = new StringBuffer();
        h.append("/**\r\n");
        BufferedReader in = new BufferedReader(new FileReader(headerFileName));
        String nextLine;
        while ((nextLine = in.readLine()) != null) {
            //h.append(" * ");
            h.append(nextLine);
            h.append("\r\n");
        }
        h.append("*/");
        
        this.headerText = h.toString();
    }
    
    /** 
     * <p>Returns text of header with "template fields" filled in using information from 
     * the source code file.  The header file can contain "template field" strings as 
     * described in the <code>setHeaderFile(...)</code> method. </p>
     */
    public String getHeader(File sourceFile, String sourceCode) {
        
        //get field values for this source file ... 
        String fileName = sourceFile.getName();
        String fullDesc = getClassDocs(sourceCode);
        
        int endOfFirstSentence = fullDesc.indexOf(". ");
        if (endOfFirstSentence < 0) endOfFirstSentence = fullDesc.length();
        String oneLineDesc = fullDesc.substring(0, endOfFirstSentence).trim();
        
        String header = replaceAll(this.headerText, "[file_name]", fileName);
        header = replaceAll(header, "[one_line_description]", oneLineDesc);
        return replaceAll(header, "[full_description]", fullDesc);
    }
    
    /**
     * Attempts to extract class JavaDocs from the given source code.  "*" characters are 
     * stripped from the beginning of each line.  If anyone reading this knows how to 
     * do this with the Doclet API, please feel free.  
     */
    private String getClassDocs(String sourceCode) {
        //find first instance of the word "class" or "interface" that isn't in comments
        boolean foundDecl = false;
        int currPosition = 0;
        int declPosition = 0;
        while (!foundDecl && declPosition >= 0) {
            int classDeclPos = sourceCode.indexOf("class", currPosition);
            int intDeclPos = sourceCode.indexOf("interface", currPosition);
            declPosition = Math.min(classDeclPos, intDeclPos);
            if (declPosition == -1) {
                declPosition = (classDeclPos == -1) ? intDeclPos : classDeclPos;
            }
            if (declPosition >= 0) {
                if (!inComment(declPosition, sourceCode)) foundDecl = true;
                currPosition = declPosition + 1;
            }
        }

        String ret = "";
        
        //return comments immediately preceding this location, if any
        if (declPosition >= 0) {
            int endComments = sourceCode.substring(0, declPosition).lastIndexOf("*/");
            int startComments = sourceCode.substring(0, Math.max(endComments, 0)).lastIndexOf("/*");
            if (startComments >= 0 && endComments >= 0) ret = sourceCode.substring(startComments+5, endComments);
        }
        return stripTags(stripStars(ret));
    }
    
    /**
     * Returns true if the given location is within comment delimiters in the given 
     * String. 
     */
    private static boolean inComment(int location, String code) {
        boolean inComment = false;
        
        // check for C style comments ... 
        int startComment = code.substring(0, location).lastIndexOf("/*") + 2;
        int endComment = code.substring(startComment, code.length()).indexOf("*/") + startComment;
        if (startComment >= 0 && endComment > location) {
            inComment = true;
        } else {
            //check for C++ style comments ... 
            startComment = code.substring(0, location).lastIndexOf("//") + 2;
            endComment = code.substring(startComment, code.length()).indexOf("\n") + startComment;
            if (startComment >= 0 && endComment > location) inComment = true;
        } 
        return inComment;        
    }
    
    /**
     * Given text of JavaDoc comments, returns the comments with tabs and asterisks removed 
     * from the beginning of each line. 
     */
    private static String stripStars(String comments) {
        //should change this to use javax.util.regexp when J2SE 1.4 is well established ... 
        //  in the mean time we'll just delete all the tabs and asterisks.  
        StringBuffer result = new StringBuffer();
        StringTokenizer tok = new StringTokenizer(comments, "\t*", false);
        while (tok.hasMoreTokens()) {
            result.append(tok.nextToken());
        }
        return result.toString();
    }
    
    /** 
     * Removes HTML tags (anything between a less than and a greater than).
     */
    private static String stripTags(String comments) {
        StringBuffer result = new StringBuffer();
        int lastIndex = 0; 
        int index;
        while ((index = comments.indexOf("<", lastIndex)) >= 0) {
            result.append(comments.substring(lastIndex, index));
            lastIndex = comments.indexOf(">", index) + 1;
            if (lastIndex == 0) lastIndex = comments.length();
        }
        result.append(comments.substring(lastIndex));
        return result.toString();
    }
    
    /**
     * Replaces all occurances of the "replace" string in the "source" string with 
     * the "with" string.
     */
    private static String replaceAll(String source, String replace, String with) {
        StringBuffer result = new StringBuffer();
        int lastIndex = 0;
        int index = -1;
        while ((index = source.indexOf(replace, lastIndex)) >= 0) {
            result.append(source.substring(lastIndex, index));
            result.append(with);
            lastIndex = index + replace.length();
        } 
        result.append(source.substring(lastIndex));
        return result.toString();
    }
    
    /**
     * Reads a file and copies it to the destination directory with header added.  
     * If the file is a directory, processes all of it's children that have the 
     * extension ".java". 
     */
    public void processFile(File sourceFile) throws IOException {

        System.out.println("Processing " + sourceFile.getName() + ((sourceFile.isDirectory()) ? " (DIRECTORY)" : ""));
        
        if (sourceFile.isDirectory()) {
            //process *.java ... 
            File[] children = sourceFile.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    boolean ok = false;
                    if (name.endsWith(".java")) ok = true;
                    return ok;
                }
            });
            
            for (int i = 0; i < children.length; i++) {
                processFile(children[i]);
            }
            
            //process subdirectories ... 
            children = sourceFile.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    boolean ok = false;
                    if (pathname.isDirectory()) ok = true;
                    return ok;
                }
            });
            for (int i = 0; i < children.length; i++) {
                processFile(children[i]);
            }
            
        } else {        
            BufferedReader in = new BufferedReader(new FileReader(sourceFile));
        
            //read body of source document ... 
            char[] buf = new char[(int)sourceFile.length()];
            int charsRead = in.read(buf);
            in.close();

            //open output file (after done reading in case we are writing to the same file
            File writeDir = new File(destDir.getCanonicalPath());
            File destFile = new File(writeDir, sourceFile.getPath());
            destFile.getParentFile().mkdirs();
            BufferedWriter out = new BufferedWriter(new FileWriter(destFile));

            //write header ... 
            out.write(this.getHeader(sourceFile, new String(buf)));
            out.write("\r\n\r\n");
        
            //write body ...
            out.write(buf);
            out.flush();
            out.close();
        }
    }
    
    public static void main(String args[]) {
        if (args.length != 3) {
            System.err.println("Usage: SourceHeader  destination_dir  header_file  source_file");
            System.exit(1);
        }
        try {
            SourceHeader h = new SourceHeader(args[0]);
            h.setHeaderFile(args[1]);
            h.processFile(new File(args[2]));       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
