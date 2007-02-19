/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "AbstractSegment.java".  Description: 
"Provides common functionality needed by implementers of the Segment interface.
  Implementing classes should define all the fields for the segment they represent 
  in their constructor" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  “GPL”), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>Provides common functionality needed by implementers of the Segment interface.</p>
 * <p>Implementing classes should define all the fields for the segment they represent 
 * in their constructor.  The add() method is useful for this purpose.</p>
 * <p>For example the constructor for an MSA segment might contain the following code:<br> 
 * <code>this.add(new ID(), true, 2, null);<br>
 * this.add(new ST(), true, 20, null);<br>...</code></p>
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public abstract class AbstractSegment implements Segment {

    private static final HapiLog log = HapiLogFactory.getHapiLog(AbstractSegment.class);

    private ArrayList fields;
    private ArrayList types;
    private ArrayList required;
    private ArrayList length;
    private ArrayList args;
    private ArrayList maxReps;
    private Group parent;
    //private Message message;
    //private String name;

    /**
     * Calls the abstract init() method to create the fields in this segment.
     * 
     * @param parent parent group
     * @param factory all implementors need a model class factory to find datatype classes, so we 
     *      include it as an arg here to emphasize that fact ... AbstractSegment doesn't actually 
     *      use it though
     */
    public AbstractSegment(Group parent, ModelClassFactory factory) {
        this.parent = parent;
        this.fields = new ArrayList();
        this.types = new ArrayList();
        this.required = new ArrayList();
        this.length = new ArrayList();
        this.args = new ArrayList();
        this.maxReps = new ArrayList();
    }

    /**
     * Returns an array of Field objects at the specified location in the segment.  In the case of
     * non-repeating fields the array will be of length one.  Fields are numbered from 1.
     */
    public Type[] getField(int number) throws HL7Exception {

        ensureEnoughFields(number);
        
        if (number < 1 || number > fields.size()) {
            throw new HL7Exception(
                "Can't retrieve field "
                    + number
                    + " from segment "
                    + this.getClass().getName()
                    + " - there are only "
                    + fields.size()
                    + " fields.",
                HL7Exception.APPLICATION_INTERNAL_ERROR);
        }

        return (Type[]) fields.get(number - 1); //note: fields are numbered from 1 from the user's perspective
    }

    /**
     * Returns a specific repetition of field at the specified index.  If there exist 
     * fewer repetitions than are required, the number of repetitions can be increased 
     * by specifying the lowest repetition that does not yet exist.  For example 
     * if there are two repetitions but three are needed, the third can be created
     * and accessed using the following code: <br>
     * <code>Type t = getField(x, 3);</code>
     * @param number the field number 
     * @param rep the repetition number (starting at 0)
     * @throws HL7Exception if field index is out of range, if the specified 
     *    repetition is greater than the maximum allowed, or if the specified 
     *    repetition is more than 1 greater than the existing # of repetitions.  
     */
    public Type getField(int number, int rep) throws HL7Exception {
        Type[] arr = this.getField(number);

        //check if out of range ... 
        if (rep > arr.length)
            throw new HL7Exception(
                "Can't get repetition "
                    + rep
                    + " from field "
                    + number
                    + " - there are currently only "
                    + arr.length
                    + " reps.",
                HL7Exception.APPLICATION_INTERNAL_ERROR);

        /*if (this.getMaxCardinality(number) > 0 && rep >= this.getMaxCardinality(number))
            throw new HL7Exception(
                "Can't get repetition "
                    + rep
                    + " from field "
                    + number
                    + " - only "
                    + this.getMaxCardinality(number)
                    + " reps allowed.",
                HL7Exception.APPLICATION_INTERNAL_ERROR);*/

        //add a rep if necessary ... 
        if (rep == arr.length) {
            Type[] newArr = new Type[arr.length + 1];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            newArr[rep] = createNewType(number);
            arr = newArr;

            //replace old field array with new one - note: "fields" is #d from 0
            this.fields.remove(number - 1);
            this.fields.add(number - 1, arr);
        }

        return arr[rep];

    }

    /**
     * Creates a new instance of the Type at the given field number in this segment.  
     */
    private Type createNewType(int field) throws HL7Exception {
        int number = field - 1;
        Class c = (Class) this.types.get(number);

        Type newType = null;
        try {
            Object[] args = getArgs(number);
            Class[] argClasses = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof Message) {
                    argClasses[i] = Message.class;
                } else {
                    argClasses[i] = args[i].getClass();                        
                }
            }
            newType = (Type) c.getConstructor(argClasses).newInstance(args);
        }
        catch (IllegalAccessException iae) {
            throw new HL7Exception(
                "Can't access class " + c.getName() + " (" + iae.getClass().getName() + "): " + iae.getMessage(),
                HL7Exception.APPLICATION_INTERNAL_ERROR);
        }
        catch (InstantiationException ie) {
            throw new HL7Exception(
                "Can't instantiate class " + c.getName() + " (" + ie.getClass().getName() + "): " + ie.getMessage(),
                HL7Exception.APPLICATION_INTERNAL_ERROR);
        }
        catch (InvocationTargetException ite) {
            throw new HL7Exception(
                "Can't instantiate class " + c.getName() + " (" + ite.getClass().getName() + "): " + ite.getMessage(),
                HL7Exception.APPLICATION_INTERNAL_ERROR);
        }
        catch (NoSuchMethodException nme) {
            throw new HL7Exception(
                "Can't instantiate class " + c.getName() + " (" + nme.getClass().getName() + "): " + nme.getMessage(),
                HL7Exception.APPLICATION_INTERNAL_ERROR);
        }
        return newType;
    }
    
    //defaults to {this.getMessage}
    private Object[] getArgs(int fieldNum) {
        Object[] result = null;
        
        Object o = this.args.get(fieldNum);        
        if (o != null && o instanceof Object[]) {
            result = (Object[]) o;
        } else {
            result = new Object[]{getMessage()};
        }
        
        return result;
    }

    /**
     * Returns true if the given field is required in this segment - fields are 
     * numbered from 1. 
     * @throws HL7Exception if field index is out of range.  
     */
    public boolean isRequired(int number) throws HL7Exception {
        if (number < 1 || number > required.size()) {
            throw new HL7Exception(
                "Can't retrieve optionality of field "
                    + number
                    + " from segment "
                    + this.getClass().getName()
                    + " - there are only "
                    + fields.size()
                    + " fields.",
                HL7Exception.APPLICATION_INTERNAL_ERROR);
        }

        boolean ret = false;
        try {
            ret = ((Boolean) required.get(number - 1)).booleanValue();
        }
        catch (Exception e) {
            throw new HL7Exception(
                "Can't retrieve optionality of field " + number + ": " + e.getMessage(),
                HL7Exception.APPLICATION_INTERNAL_ERROR);
        }

        return ret;
    }

    /**
     * Returns the maximum length of the field at the given index, in characters -   
     * fields are numbered from 1.  
     * @throws HL7Exception if field index is out of range.  
     */
    public int getLength(int number) throws HL7Exception {
        if (number < 1 || number > length.size()) {
            throw new HL7Exception(
                "Can't retrieve max length of field "
                    + number
                    + " from segment "
                    + this.getClass().getName()
                    + " - there are only "
                    + fields.size()
                    + " fields.",
                HL7Exception.APPLICATION_INTERNAL_ERROR);
        }

        int ret = 0;
        try {
            ret = ((Integer) length.get(number - 1)).intValue(); //fields #d from 1 to user 
        }
        catch (Exception e) {
            throw new HL7Exception(
                "Can't retrieve max length of field " + number + ": " + e.getMessage(),
                HL7Exception.APPLICATION_INTERNAL_ERROR);
        }

        return ret;
    }

    /**
     * Returns the number of repetitions of this field that are allowed.  
     * @throws HL7Exception if field index is out of range.
     */
    public int getMaxCardinality(int number) throws HL7Exception {
        if (number < 1 || number > length.size()) {
            throw new HL7Exception(
                "Can't retrieve cardinality of field "
                    + number
                    + " from segment "
                    + this.getClass().getName()
                    + " - there are only "
                    + fields.size()
                    + " fields.",
                HL7Exception.APPLICATION_INTERNAL_ERROR);
        }

        int reps = 0;
        try {
            reps = ((Integer) maxReps.get(number - 1)).intValue(); //fields #d from 1 to user
        }
        catch (Exception e) {
            throw new HL7Exception(
                "Can't retrieve max repetitions of field " + number + ": " + e.getMessage(),
                HL7Exception.APPLICATION_INTERNAL_ERROR);
        }

        return reps;
    }

    /**
     * Returns the Message to which this segment belongs.  
     */
    public Message getMessage() {
        Structure s = this;
        while (!Message.class.isAssignableFrom(s.getClass())) {
            s = s.getParent();
        }
        return (Message) s;
    }
    
    public Group getParent() {
        return this.parent;
    }

    /**
     * Adds a field to the segment.  The field is initially empty (zero repetitions).   
     * The field number is sequential depending on previous add() calls.  Implementing 
     * classes should use the add() method in their constructor in order to define fields 
     * in their segment.  
     * @param c the class of the data for this field - this should inherit from Type
     * @param required whether a value for this field is required in order for the segment 
     *    to be valid
     * @param maxReps the maximum number of repetitions - 0 implies that there is no limit
     * @param length the maximum length of each repetition of the field (in characters) 
     * @param constructorArgs an array of objects that will be used as constructor arguments 
     *    if new instances of this class are created (use null for zero-arg constructor)
     * @throws HL7Exception if the given class does not inherit from Type or if it can 
     *    not be instantiated.
     */
    protected void add(Class c, boolean required, int maxReps, int length, Object[] constructorArgs)
        throws HL7Exception {
        if (!Type.class.isAssignableFrom(c))
            throw new HL7Exception(
                "Class " + c.getName() + " does not inherit from " + "ca.on.uhn.datatype.Type",
                HL7Exception.APPLICATION_INTERNAL_ERROR);

        Type[] arr = new Type[0];
        this.types.add(c);
        this.fields.add(arr);
        this.required.add(new Boolean(required));
        this.length.add(new Integer(length));
        this.args.add(constructorArgs);
        this.maxReps.add(new Integer(maxReps));
    }

    /**
     * Called from getField(...) methods.  If a field has been requested that 
     * doesn't exist (eg getField(15) when only 10 fields in segment) adds Varies
     * fields to the end of the segment up to the required number.  
     */
    private void ensureEnoughFields(int fieldRequested) {
        int fieldsToAdd = fieldRequested - this.numFields();
        if (fieldsToAdd < 0)
            fieldsToAdd = 0;

        try {
            for (int i = 0; i < fieldsToAdd; i++) {
                this.add(Varies.class, false, 0, 65536, null); //using 65536 following example of OBX-5
            }
        }
        catch (HL7Exception e) {
            log.error("Can't create additional generic fields to handle request for field " + fieldRequested, e);
        }
    }

    public static void main(String[] args) {
        /*
        try {
          Message mess = new TestMessage();
          MSH msh = new MSH(mess);
          
          //get empty array 
          Type[] ts = msh.getField(1);
          System.out.println("Got Type array of length " + ts.length);
          
          //get first field
          Type t = msh.getField(1, 0);
          System.out.println("Got a Type of class " + t.getClass().getName());
          
          //get array now
          Type[] ts2 = msh.getField(1);
          System.out.println("Got Type array of length " + ts2.length);
          
          //set a value
          ST str = (ST)t;
          str.setValue("hello");
          
          //get first field
          Type t2 = msh.getField(1, 0);
          System.out.println("Got a Type of class " + t.getClass().getName());
          System.out.println("It's value is " + ((ST)t2).getValue());
          
          msh.getFieldSeparator().setValue("thing");
          System.out.println("Field Sep: " + msh.getFieldSeparator().getValue());
          
          msh.getConformanceStatementID(0).setValue("ID 1");
          msh.getConformanceStatementID(1).setValue("ID 2");
          System.out.println("Conf ID #2: " + msh.getConformanceStatementID(1).getValue());
          
          ID[] cid = msh.getConformanceStatementID();
          System.out.println("CID: " + cid);
          for (int i = 0; i < cid.length; i++) {
              System.out.println("Conf ID element: " + i + ": " + cid[i].getValue());
          }
          msh.getConformanceStatementID(3).setValue("this should fail");
          
          
        } catch (HL7Exception e) {
             e.printStackTrace();
        }*/
    }

    /**
     * Returns the number of fields defined by this segment (repeating 
     * fields are not counted multiple times).  
     */
    public int numFields() {
        return this.fields.size();
    }

    /**
     * Returns the class name (excluding package). 
     * @see Structure#getName() 
     */
    public String getName() {
        String fullName = this.getClass().getName();
        return fullName.substring(fullName.lastIndexOf('.') + 1, fullName.length());
    }

    /**
     * Sets the segment name.  This would normally be called by a Parser. 
     */
    /*public void setName(String name) {
        this.name = name;
    }*/

}