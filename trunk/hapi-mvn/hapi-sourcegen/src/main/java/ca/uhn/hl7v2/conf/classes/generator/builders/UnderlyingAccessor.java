/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "UnderlyingAccessor.java".  Description:
 * "This class is used to determine the name of the accessor method on the
 * underlying object for a given conformance class. It is used to determine
 * whether underlying accessors require a "rep" parameter. For instance,
 * a message type might provide an accessor <code>getMSH()</code> to return
 * its MSH segment. The runtime profile may not provide any clue as to whether
 * the MSH segment in the HAPI library for the given message type is repeatable
 * or not. This class determines this information."
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): James Agnew
 * Paul Brohman
 * Mitch Delachevrotiere
 * Shawn Dyck
 * Cory Metcalf
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  ?GPL?), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.conf.classes.generator.builders;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.conf.classes.exceptions.ConformanceError;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.GenericSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Segment;

/**
 * This class is used to determine the name of the accessor method on the
 * underlying object for a given conformance class. It is used to determine
 * whether underlying accessors require a "rep" parameter. For instance,
 * a message type might provide an accessor <code>getMSH()</code> to return
 * its MSH segment. The runtime profile may not provide any clue as to whether
 * the MSH segment in the HAPI library for the given message type is repeatable
 * or not. This class determines this information.
 *
 * @author <table><tr><td>James Agnew</td></tr>
 *                <tr><td>Paul Brohman</td></tr>
 *                <tr><td>Mitch Delachevrotiere</td></tr>
 *                <tr><td>Shawn Dyck</td></tr>
 * 				   <tr><td>Cory Metcalf</td></tr></table>
 */
public class UnderlyingAccessor {
    
    private static final Logger log = LoggerFactory.getLogger(UnderlyingAccessor.class);
    
    boolean acceptsRep;    
    String theAccessor;
    
    //these are used to keep track of child numbers in case we can't find
    //a name-based getter 
    private static String ourCurrentParent = "";
    private static int ourCurrentChild = 0;
    
    /**
     * Determines the name of the accessor method on the underlying object for a given
     * conformance class. It is used to determine whether underlying accessors require
     * a "rep" parameter.
     * @param className the Class name
     * @param accessorName the Accessor ame
     */
    public UnderlyingAccessor(String className, String accessorName) {  
        acceptsRep = false;
        
        track(className);
        
        try {
            Class<?> c = getHapiModelClass(className);
            theAccessor = makeName(c, accessorName);

            //children of groups & segments repeat; children of composites don't 
            if (Group.class.isAssignableFrom(c)) {
                acceptsRep = true;
            } else if (Segment.class.isAssignableFrom(c)) {
                Method m = getMethod(c, accessorName);
                if (m == null || m.getParameterTypes().length == 1) {
                    acceptsRep = true;
                }
            }

//            Method methods[] = c.getMethods();
//            for (int i = 0; i < methods.length; i++) {
//                if (methods[i].getName().equals(accessorName)) {
//                    foundAccessor = true;
//                    if (methods[i].getParameterTypes().length == 1) {
//                        acceptsRep = true;
//                        break;
//                    }
//                }
//            }
//            
//            if (foundAccessor == false)
//                throw new ConformanceError("Underlying HAPI class \"" + className + "\" does not have accessor \"" + accessorName + "()\". This is probably a bug.");
            
        } catch (Exception e) {            
            e.printStackTrace();
            throw new ConformanceError("Underlying class/method " + className + "." + accessorName + "() can not be found. The complete HAPI API must be installed prior to using this system.");
        }
        
//        theAccessor = new String(accessorName);
//        theAccessor += acceptsRep ? "( rep )" : "()";
    }
    
    /**
     * Keeps track of the child number that is being processed.  We assume 
     * they are processed in order.   
     * @param theParent
     */
    private static void track(String theParent) {
        if (ourCurrentParent.equals(theParent)) {
            ourCurrentChild++;
        } else {
            ourCurrentParent = theParent;
            ourCurrentChild = 0;
        }
    }
    
    /**
     * @param theUnderlyingClassName the name of a HAPI model class
     * @return the Java class by that name if one is on the classpath; otherwise it is assumed 
     *      that we are dealing with a Z-segment, and GenericSegment.class is returned
     */
    public static Class<?>getHapiModelClass(String theUnderlyingClassName) {
        Class<?> c = null;
        try {
            c = Class.forName(theUnderlyingClassName);
        } catch (ClassNotFoundException e) {
            log.debug("Interpreting class {} as a GenericSegment", theUnderlyingClassName);
            c = GenericSegment.class;
        }
        return c;
    }
    
    /**
     * @param theParentClass
     * @param theChildName must be an integer when the parent is a composite  
     * @return the accessor name on the given parent that returns the the given child 
     */
    private String makeName(Class<?> theParentClass, String theChildName) {
        String result = null;
        if (Group.class.isAssignableFrom(theParentClass)) {
            result = "get(\"" + guessCompName(theChildName) + "\", rep)";
        } else if (Segment.class.isAssignableFrom(theParentClass)) {
            Method method = getMethod(theParentClass, theChildName);
            
            //use number if we can't find the field by name (could be site-defined)
            if (method == null) {
                result = "getField(" + ourCurrentChild + ", rep)";
            } else {
                result = (method.getParameterTypes().length == 1) ? theChildName + "( rep )" : theChildName + "()";
            }
            
        } else if (Composite.class.isAssignableFrom(theParentClass)) {
            result = "get(" + theChildName + ")";
        } else {
            throw new ConformanceError("The parent class " + theParentClass + " is not recognized as a Group, Segment, or Composite");
        }
        return result;
    }
    
    private static String guessCompName(String theAccessorName) {
        return theAccessorName.substring(3);
    }
    
    private static Method getMethod(Class<?> theParentClass, String theChildName) {
        Method result = null;
        Method methods[] = theParentClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().equals(theChildName)) {
                result = methods[i];
                if (result.getParameterTypes().length == 1) break;
            }
        }        
        return result;
    }
    
    /**
     * Returns true if the underlying accessor accepts a rep argument, or
     * false if the underlying accessor does not.
     * @return boolean Returns true if the underlying accessor accepts a rep argument, or
     * false if the underlying accessor does not.
     */
    public boolean getAcceptsRep() {
        return acceptsRep;
    }
    
    /** This method returns a string representation of the Accessor
     * @return a String representation of the Accessor
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return theAccessor;
    }
    
}
