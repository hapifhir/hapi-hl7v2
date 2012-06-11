/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "CommonDT.java".  Description:
 * "Note: The class description below has been excerpted from the Hl7 2.4 documentation"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */

package ca.uhn.hl7v2.model.primitive;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.io.Serializable;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.DataTypeUtil;

/**
 * This class contains functionality used by the DT class
 * in the version 2.3.0, 2.3.1, and 2.4 packages
 *
 * Note: The class description below has been excerpted from the Hl7 2.4 documentation. Sectional
 * references made below also refer to the same documentation.
 *
 * Format: YYYY[MM[DD]]
 * In prior versions of HL7, this data type was always specified to be in the format YYYYMMDD. In the current and future
 * versions, the precision of a date may be expressed by limiting the number of digits used with the format specification
 * YYYY[MM[DD]]. Thus, YYYY is used to specify a precision of "year," YYYYMM specifies a precision of "month,"
 * and YYYYMMDD specifies a precision of "day."
 * By site-specific agreement, YYYYMMDD may be used where backward compatibility must be maintained.
 * Examples:   |19880704|  |199503|
 * @author Neal Acharya
 */

@SuppressWarnings("serial")
public class CommonDT implements Serializable {

    private String value;
    private int year;
    private int month;
    private int day;

    /**
     * Constructs a DT datatype with fields initialzed to zero and value initialized
     * to null.
     */
    public CommonDT() {
        //initialize all DT fields
        value = null;
        year = 0;
        month = 0;
        day = 0;
    } //end constructor

    /**
     * Constructs a DT object with the given value.
     * The stored value will be in the following
     * format YYYY[MM[DD]].
     */
    public CommonDT(String val) throws DataTypeException {
        this.setValue(val);
    } //end constructor

    /**
     * Convenience setter which sets the value using a {@link Calendar} object. Passing in <code>null</code> clears any existing value.
     * 
     * Note: Sets fields using maximum possible precision
     * 
     * @param theCalendar The calendar object from which to retrieve values
     * @since 1.1 
     */
    public void setValue(Calendar theCalendar) throws DataTypeException {
		if (theCalendar == null) {
			setValue((String)null);
			return;
		}

        int yr = theCalendar.get(Calendar.YEAR);
        int mnth = theCalendar.get(Calendar.MONTH) + 1;
        int dy = theCalendar.get(Calendar.DATE);
        setYearMonthDayPrecision(yr, mnth, dy);
    }

    /**
     * Convenience setter which sets the value using a {@link Date} object. Passing in <code>null</code> clears any existing value.
     * 
     * Note: Sets fields using maximum possible precision
     * 
     * @param theCalendar The calendar object from which to retrieve values 
     * @since 1.1 
     */
    public void setValue(Date theDate) throws DataTypeException {
		if (theDate == null) {
			setValue((String)null);
			return;
		}

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(theDate);
        setValue(calendar);
    }
    
    
    /**
     * Return the value as a calendar object
     * @since 1.1 
     */
    public Calendar getValueAsCalendar() {
        Calendar retVal = Calendar.getInstance();
        retVal.set(Calendar.DATE, getDay());
        retVal.set(Calendar.MONTH, getMonth() - 1);
        retVal.set(Calendar.YEAR, getYear());

        // Truncate
        retVal.set(Calendar.HOUR_OF_DAY, 0);
        retVal.set(Calendar.MINUTE, 0);
        retVal.set(Calendar.SECOND, 0);
        retVal.set(Calendar.MILLISECOND, 0);
        
        return retVal;
    }

    
    /**
     * Return the value as a date object
     * @since 1.1 
     */
    public Date getValueAsDate() {
        return getValueAsCalendar().getTime();
    }
    
    
    /**
     * This method takes in a string HL7 date value and performs validations
     * then sets the value field. The stored value will be in the following
     * format YYYY[MM[DD]]. Passing in <code>null</code> clears any existing value.
     *
     */
    public void setValue(String val) throws DataTypeException {

        if (val != null && !val.equals("") && !val.equals("\"\"")){
            try {
                GregorianCalendar cal = new GregorianCalendar();
                cal.clear();
                cal.setLenient(false);

                //check the length, must be either four, six, or eight digits
                if ((val.length() != 4) && (val.length() != 6) && (val.length() != 8)) {
                    String msg =
                        "The length of the DT datatype value does not conform to an allowable"
                            + " format. Format should conform to YYYY[MM[DD]]";
                    DataTypeException e = new DataTypeException(msg);
                    throw e;
                }

                if (val.length() >= 4) {
                    //extract the year from the input value
                    int yrInt = Integer.parseInt(val.substring(0, 4));
                    //check to see if the year is valid by creating a Gregorian calendar object with
                    //this value.  If an error occurs then processing will stop in this try block
                    cal.set(yrInt, 0, 1);
                    cal.getTime(); //for error detection
                    year = yrInt;
                }

                if (val.length() >= 6) {
                    //extract the month from the input value
                    int mnthInt = Integer.parseInt(val.substring(4, 6));
                    //check to see if the month is valid by creating a Gregorian calendar object with
                    //this value.  If an error occurs then processing will stop in this try block
                    cal.set(year, mnthInt - 1, 1);
                    cal.getTime(); //for error detection
                    month = mnthInt;

                }

                if (val.length() == 8) {
                    //extract the day from the input value
                    int dayInt = Integer.parseInt(val.substring(6, 8));
                    //check to see if the day is valid by creating a Gregorian calendar object with
                    //the year/month/day combination.  If an error occurs then processing will stop
                    // in this try block
                    cal.set(year, month - 1, dayInt);
                    cal.getTime(); //for error detection
                    day = dayInt;
                }
                //validations are complete now store the input value into the private value field
                value = val;
            } //end try

            catch (DataTypeException e) {
                throw e;
            } //end catch

            catch (Exception e) {
                throw new DataTypeException( e );
            } //end catch
        } //end if
        else {
            //set the private value field to null or empty space.
            value = val;
        } //end else       

    } //end method

    /**
     * This method takes in an integer value for the year and performs validations,
     * it then sets the value field formatted as an HL7 date.
     * value with year precision (YYYY)
     */
    public void setYearPrecision(int yr) throws DataTypeException {
        try {
            GregorianCalendar cal = new GregorianCalendar();
            cal.clear();
            cal.setLenient(false);

            //ensure that the year field is four digits long
            if (Integer.toString(yr).length() != 4) {
                String msg = "The input year value must be four digits long";
                DataTypeException e = new DataTypeException(msg);
                throw e;
            }
            //check is input year is valid
            //GregorianCalendar cal = new GregorianCalendar(yr,0,1);
            cal.set(yr, 0, 1);
            cal.getTime(); //for error detection
            year = yr;
            month = 0;
            day = 0;
            value = Integer.toString(yr);
        } //end try

        catch (DataTypeException e) {
            throw e;
        } //end catch

        catch (Exception e) {
            throw new DataTypeException( e );
        } //end catch

    } //end method

    /**
     * This method takes in integer values for the year and month and performs validations,
     * it then sets the value field formatted as an HL7 date
     * value with year&month precision (YYYYMM).
     * Note: The first month = 1 = January.
     */
    public void setYearMonthPrecision(int yr, int mnth) throws DataTypeException {
        try {
            GregorianCalendar cal = new GregorianCalendar();
            cal.clear();
            cal.setLenient(false);
            //ensure that the year field is four digits long
            if (Integer.toString(yr).length() != 4) {
                String msg = "The input year value must be four digits long";
                DataTypeException e = new DataTypeException(msg);
                throw e;
            }
            //validate the input month
            //GregorianCalendar cal = new GregorianCalendar(yr,(mnth-1),1);
            cal.set(yr, (mnth - 1), 1);
            cal.getTime(); //for error detection
            year = yr;
            month = mnth;
            day = 0;
            value = Integer.toString(yr) + DataTypeUtil.preAppendZeroes(mnth, 2);
        }

        catch (DataTypeException e) {
            throw e;
        } //end catch

        catch (Exception e) {
            throw new DataTypeException( e );
        } //end catch
    } //end method

    /**
     * This method takes in integer values for the year and month and day
     * and performs validations, it then sets the value in the object
     * formatted as an HL7 date value with year&month&day precision (YYYYMMDD).
     */
    public void setYearMonthDayPrecision(int yr, int mnth, int dy) throws DataTypeException {
        try {
            GregorianCalendar cal = new GregorianCalendar();
            cal.clear();
            cal.setLenient(false);

            //ensure that the year field is four digits long
            if (Integer.toString(yr).length() != 4) {
                String msg = "The input year value must be four digits long";
                DataTypeException e = new DataTypeException(msg);
                throw e;
            }
            //validate the input month/day combination
            cal.set(yr, (mnth - 1), dy);
            cal.getTime(); //for error detection
            year = yr;
            month = mnth;
            day = dy;
            value = Integer.toString(yr) + DataTypeUtil.preAppendZeroes(mnth, 2) + DataTypeUtil.preAppendZeroes(dy, 2);
        }

        catch (DataTypeException e) {
            throw e;
        } //end catch

        catch (Exception e) {
            throw new DataTypeException( e );
        } //end catch

    } //end method

    /**
     * Returns the HL7 DT string value.
     */
    public String getValue() {
        return value;
    } //end method

    /**
     * Returns the year as an integer.
     */
    public int getYear() {
        return year;
    } //end method

    /**
     * Returns the month as an integer.
     */
    public int getMonth() {
        return month;
    } //end method

    /**
     * Returns the day as an integer.
     */
    public int getDay() {
        return day;
    } //end method

    
    /**
     * Returns a string value representing the input Gregorian Calendar object in
     * an Hl7 Date Format.
     */
    public static String toHl7DTFormat(GregorianCalendar cal) throws DataTypeException {
        String val = "";
        try {
            //set the input cal object so that it can report errors
            //on it's value
            cal.setLenient(false);
            int calYear = cal.get(GregorianCalendar.YEAR);
            int calMonth = cal.get(GregorianCalendar.MONTH) + 1;
            int calDay = cal.get(GregorianCalendar.DAY_OF_MONTH);
            CommonDT dt = new CommonDT();
            dt.setYearMonthDayPrecision(calYear, calMonth, calDay);
            val = dt.getValue();
        } //end try

        catch (DataTypeException e) {
            throw e;
        } //end catch

        catch (Exception e) {
            throw new DataTypeException( e );
        } //end catch
        return val;
    } //end method

} //end class
