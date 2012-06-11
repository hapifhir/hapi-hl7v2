/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "CommmonTM.java".  Description:
 * "Note: The class description below has been excerpted from the Hl7 2.4 documentation"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the "GPL"), in which case the provisions of the GPL are
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
import java.util.TimeZone;
import java.io.Serializable;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.DataTypeUtil;

/**
 * This class contains functionality used by the TM class
 * in the version 2.3.0, 2.3.1, and 2.4 packages
 *
 * Note: The class description below has been excerpted from the Hl7 2.4 documentation. Sectional
 * references made below also refer to the same documentation.
 *
 * Format: HH[MM[SS[.S[S[S[S]]]]]][+/-ZZZZ]
 * In prior versions of HL7, this data type was always specified to be in the
 * format HHMM[SS[.SSSS]][+/-ZZZZ] using a 24 hour clock notation. In the
 * current and future versions, the precision of a time may be expressed by
 * limiting the number of digits used with the format specification as shown
 * above. By site-specific agreement, HHMM[SS[.SSSS]][+/-ZZZZ] may be used where
 * backward compatibility must be maintained.
 * Thus, HH is used to specify a precision of "hour," HHMM is used to specify a
 * precision of "minute," HHMMSS is used to specify a precision of seconds, and
 * HHMMSS.SSSS is used to specify a precision of ten-thousandths of a second.
 * In each of these cases, the time zone is an optional component. The fractional
 * seconds could be sent by a transmitter who requires greater precision than whole
 * seconds. Fractional representations of minutes, hours or other higher-order units
 * of time are not permitted.
 * Note: The time zone [+/-ZZZZ], when used, is restricted to legally-defined time zones
 * and is represented in HHMM format.
 * The time zone of the sender may be sent optionally as an offset from the coordinated
 * universal time (previously known as Greenwich Mean Time). Where the time zone
 * is not present in a particular TM field but is included as part of the date/time
 * field in the MSH segment, the MSH value will be used as the default time zone.
 * Otherwise, the time is understood to refer to the local time of the sender.
 * Midnight is represented as 0000.
 * Examples:|235959+1100| 1 second before midnight in a time zone eleven hours
 * ahead of Universal Coordinated Time (i.e., east of Greenwich).
 * |0800| Eight AM, local time of the sender.
 * |093544.2312| 44.2312 seconds after Nine thirty-five AM, local time of sender.
 * |13| 1pm (with a precision of hours), local time of sender.
 * @author Neal Acharya
 */

@SuppressWarnings("serial")
public class CommonTM implements Serializable {
    
	/**
     * Value returned by {@link #getGMTOffset()} if no offset is set
     */
    public static final int GMT_OFFSET_NOT_SET_VALUE = -99;

    private String value;
    private int hour;
    private int minute;
    private int second;
    private float fractionOfSec;
    private int offSet;
    private boolean omitOffsetFg = false;

    /**
     * Constructs a TM datatype with fields initialzed to zero and the value set to
     * null.
     */
    public CommonTM() {
        //initialize all DT fields
        value = null;
        hour = 0;
        minute = 0;
        second = 0;
        fractionOfSec = 0;
        offSet = GMT_OFFSET_NOT_SET_VALUE;
    } //end constructor

    /**
     * Constructs a TM object with the given value.
     * The stored value will be in the following
     * format HH[MM[SS[.S[S[S[S]]]]]][+/-ZZZZ].
     */
    public CommonTM(String val) throws DataTypeException {
        this.setValue(val);
    } //end constructor

    /**
     * This method takes in a string HL7 Time value and performs validations
     * then sets the value field.  The stored value will be in the following
     * format HH[MM[SS[.S[S[S[S]]]]]][+/-ZZZZ].
     * Note: Trailing zeros supplied in the time value (HH[MM[SS[.S[S[S[S]]]]]])
     * and GMT offset ([+/-ZZZZ]) will be preserved.
     * Note: If the GMT offset is not supplied then the local
     * time zone (using standard time zone format which is not modified for daylight savings)
     * will be stored as a default. Passing in <code>null</code> clears any existing value.
     */
    public void setValue(String val) throws DataTypeException {

        if (val != null && !val.equals("") && !val.equals("\"\"")) {
            //check to see if any of the following characters exist: "." or "+/-"
            //this will help us determine the acceptable lengths

            int d = val.indexOf(".");
            int sp = val.indexOf("+");
            int sm = val.indexOf("-");
            int indexOfSign = -1;
            boolean offsetExists = false;
            if ((sp != -1) || (sm != -1))
                offsetExists = true;
            if (sp != -1)
                indexOfSign = sp;
            if (sm != -1)
                indexOfSign = sm;

            try {
                //If the GMT offset exists then extract it from the input string and store it
                //in another variable called tempOffset. Also, store the time value
                //(without the offset)in a separate variable called timeVal.
                //If there is no GMT offset then simply set timeVal to val.
                String timeVal = val;
                String tempOffset = null;
                if (offsetExists) {
                    timeVal = val.substring(0, indexOfSign);
                    tempOffset = val.substring(indexOfSign);
                } //end if

                if (offsetExists && (tempOffset.length() != 5)) {
                    //The length of the GMT offset must be 5 characters (including the sign)
                    String msg =
                        "The length of the TM datatype value does not conform to an allowable"
                            + " format. Format should conform to HH[MM[SS[.S[S[S[S]]]]]][+/-ZZZZ]";
                    DataTypeException e = new DataTypeException(msg);
                    throw e;
                } //end if

                if (d != -1) {
                    //here we know that decimal exists
                    //thus length of the time value can be between 8 and 11 characters
                    if ((timeVal.length() < 8) || (timeVal.length() > 11)) {
                        String msg =
                            "The length of the TM datatype value does not conform to an allowable"
                                + " format. Format should conform to HH[MM[SS[.S[S[S[S]]]]]][+/-ZZZZ]";
                        DataTypeException e = new DataTypeException(msg);
                        throw e;
                    } //end if
                } //end if

                if (d == -1) {
                    //here we know that the decimal does not exist
                    //thus length of the time value can be 2 or 4 or 6 characters
                    if ((timeVal.length() != 2) && (timeVal.length() != 4) && (timeVal.length() != 6)) {
                        String msg =
                            "The length of the TM datatype value does not conform to an allowable"
                                + " format. Format should conform to HH[MM[SS[.S[S[S[S]]]]]][+/-ZZZZ]";
                        DataTypeException e = new DataTypeException(msg);
                        throw e;
                    } //end if
                } //end if

                //We will now try to validate the timeVal portion of the TM datatype value
                if (timeVal.length() >= 2) {
                    //extract the hour data from the input value.  If the first 2 characters
                    //are not numeric then a number format exception will be generated
                    int hrInt = Integer.parseInt(timeVal.substring(0, 2));
                    //check to see if the hour value is valid
                    if ((hrInt < 0) || (hrInt > 23)) {
                        String msg = "The hour value of the TM datatype must be >=0 and <=23";
                        DataTypeException e = new DataTypeException(msg);
                        throw e;
                    } //end if
                    hour = hrInt;
                } //end if

                if (timeVal.length() >= 4) {
                    //extract the minute data from the input value
                    //If these characters are not numeric then a number
                    //format exception will be generated
                    int minInt = Integer.parseInt(timeVal.substring(2, 4));
                    //check to see if the minute value is valid
                    if ((minInt < 0) || (minInt > 59)) {
                        String msg = "The minute value of the TM datatype must be >=0 and <=59";
                        DataTypeException e = new DataTypeException(msg);
                        throw e;
                    } //end if
                    minute = minInt;
                } //end if

                if (timeVal.length() >= 6) {
                    //extract the seconds data from the input value
                    //If these characters are not numeric then a number
                    //format exception will be generated
                    int secInt = Integer.parseInt(timeVal.substring(4, 6));
                    //check to see if the seconds value is valid
                    if ((secInt < 0) || (secInt > 59)) {
                        String msg = "The seconds value of the TM datatype must be >=0 and <=59";
                        DataTypeException e = new DataTypeException(msg);
                        throw e;
                    } //end if
                    second = secInt;
                } //end if

                if (timeVal.length() >= 8) {
                    //extract the fractional second value from the input value
                    //If these characters are not numeric then a number
                    //format exception will be generated
                    float fract = Float.parseFloat(timeVal.substring(6));
                    //check to see if the fractional second value is valid
                    if ((fract < 0) || (fract >= 1)) {
                        String msg = "The fractional second value of the TM datatype must be >= 0 and < 1";
                        DataTypeException e = new DataTypeException(msg);
                        throw e;
                    } //end if
                    fractionOfSec = fract;
                } //end if

                //We will now try to validate the tempOffset portion of the TM datatype value
                if (offsetExists) {
                    //in case the offset are a series of zeros we should not omit displaying
                    //it in the return value from the getValue() method
                    omitOffsetFg = false;
                    //remove the sign from the temp offset
                    String tempOffsetNoS = tempOffset.substring(1);
                    //extract the hour data from the offset value.  If the first 2 characters
                    //are not numeric then a number format exception will be generated
                    int offsetInt = Integer.parseInt(tempOffsetNoS.substring(0, 2));
                    //check to see if the hour value is valid
                    if ((offsetInt < 0) || (offsetInt > 23)) {
                        String msg = "The GMT offset hour value of the TM datatype must be >=0 and <=23";
                        DataTypeException e = new DataTypeException(msg);
                        throw e;
                    } //end if
                    //extract the minute data from the offset value.  If these characters
                    //are not numeric then a number format exception will be generated
                    offsetInt = Integer.parseInt(tempOffsetNoS.substring(2, 4));
                    //check to see if the minute value is valid
                    if ((offsetInt < 0) || (offsetInt > 59)) {
                        String msg = "The GMT offset minute value of the TM datatype must be >=0 and <=59";
                        DataTypeException e = new DataTypeException(msg);
                        throw e;
                    } //end if
                    //validation done, update the offSet field
                    offSet = Integer.parseInt(tempOffsetNoS);
                    //add the sign back to the offset if it is negative
                    if (sm != -1) {
                        offSet = -1 * offSet;
                    } //end if
                } //end if

                //If the GMT offset has not been supplied then set the offset to the
                //local timezone
                //[Bryan: changing this to omit time zone because erroneous if parser in different zone than sender]
                if (!offsetExists) {
                    omitOffsetFg = true;
                    // set the offSet field to the current time and local time zone
                    //offSet = DataTypeUtil.getLocalGMTOffset();
                } //end if

                //validations are now done store the time value into the private value field
                value = timeVal;
            } //end try

            catch (DataTypeException e) {
                throw e;
            } //end catch

            catch (Exception e) {
                throw new DataTypeException(e);
            } //end catch
        } //end if
        else {
            //set the private value field to null or empty space.
            value = val;
        } //end else
    } //end method

    /**
     * This method takes in an integer value for the hour and performs validations,
     * it then sets the value field formatted as an HL7 time
     * value with hour precision (HH).
     */
    public void setHourPrecision(int hr) throws DataTypeException {
        try {
            //validate input value
            if ((hr < 0) || (hr > 23)) {
                String msg = "The hour value of the TM datatype must be >=0 and <=23";
                DataTypeException e = new DataTypeException(msg);
                throw e;
            } //end if
            hour = hr;
            minute = 0;
            second = 0;
            fractionOfSec = 0;
            offSet = 0;
            //Here the offset is not defined, we should omit showing it in the
            //return value from the getValue() method
            omitOffsetFg = true;
            value = DataTypeUtil.preAppendZeroes(hr, 2);
        } //end try

        catch (DataTypeException e) {
            throw e;
        } //end catch

        catch (Exception e) {
            throw new DataTypeException(e.getMessage());
        } //end catch

    } //end method

    /**
     * This method takes in integer values for the hour and minute and performs validations,
     * it then sets the value field formatted as an HL7 time value
     * with hour&minute precision (HHMM).
     */
    public void setHourMinutePrecision(int hr, int min) throws DataTypeException {
        try {
            this.setHourPrecision(hr);
            //validate input minute value
            if ((min < 0) || (min > 59)) {
                String msg = "The minute value of the TM datatype must be >=0 and <=59";
                DataTypeException e = new DataTypeException(msg);
                throw e;
            } //end if
            minute = min;
            second = 0;
            fractionOfSec = 0;
            offSet = 0;
            //Here the offset is not defined, we should omit showing it in the
            //return value from the getValue() method
            omitOffsetFg = true;
            value = value + DataTypeUtil.preAppendZeroes(min, 2);
        } //end try

        catch (DataTypeException e) {
            throw e;
        } //end catch

        catch (Exception e) {
            throw new DataTypeException(e.getMessage());
        } //end catch
    } //end method

    /**
     * This method takes in integer values for the hour, minute, seconds, and fractional seconds
     * (going to the tenthousandths precision).
     * The method performs validations and then sets the value field formatted as an
     * HL7 time value with a precision that starts from the hour and goes down to the tenthousandths
     * of a second (HHMMSS.SSSS).
     * Note: all of the precisions from tenths down to tenthousandths of a
     * second are optional. If the precision goes below tenthousandths of a second then the second
     * value will be rounded to the nearest tenthousandths of a second.
     */
    public void setHourMinSecondPrecision(int hr, int min, float sec) throws DataTypeException {
        try {
            this.setHourMinutePrecision(hr, min);
            //multiply the seconds input value by 10000 and round the result
            //then divide the number by tenthousand and store it back.
            //This will round the fractional seconds to the nearest tenthousandths
            int secMultRound = Math.round(10000F * sec);
            sec = secMultRound / 10000F;
            //Now store the second and fractional component
            second = (int) Math.floor(sec);
			//validate input seconds value
			if ((second < 0) || (second >= 60)) {
				String msg = "The (rounded) second value of the TM datatype must be >=0 and <60";
				DataTypeException e = new DataTypeException(msg);
				throw e;
			} //end if
            int fractionOfSecInt = (int) (secMultRound - (second * 10000));
            fractionOfSec = fractionOfSecInt / 10000F;
            String fractString = "";
            //Now convert the fractionOfSec field to a string without the leading zero
            if (fractionOfSec != 0.0F) {
                fractString = (Float.toString(fractionOfSec)).substring(1);
            } //end if
            //Now update the value field
            offSet = 0;
            //Here the offset is not defined, we should omit showing it in the
            //return value from the getValue() method
            omitOffsetFg = true;
            value = value + DataTypeUtil.preAppendZeroes(second, 2) + fractString;
        } //end try

        catch (DataTypeException e) {
            throw e;
        } //end catch

        catch (Exception e) {
            throw new DataTypeException(e);
        } //end catch
    } //end method

    /**
     * This method takes in the four digit (signed) GMT offset and sets the offset
     * field
     */
    public void setOffset(int signedOffset) throws DataTypeException {
        try {
            //When this function is called an offset is being created/updated
            //we should not omit displaying it in the return value from
            //the getValue() method
            omitOffsetFg = false;
            String offsetStr = Integer.toString(signedOffset);
            if ((signedOffset >= 0 && offsetStr.length() > 4) || (signedOffset < 0 && offsetStr.length() > 5)) {
                //The length of the GMT offset must be no greater than 5 characters (including the sign)
                String msg =
                    "The length of the GMT offset for the TM datatype value does"
                        + " not conform to the allowable format [+/-ZZZZ]. Value: " + signedOffset;
                DataTypeException e = new DataTypeException(msg);
                throw e;
            } //end if
            //obtain the absolute value of the input
            int absOffset = Math.abs(signedOffset);
            //extract the hour data from the offset value.
            //first preappend zeros so we have a 4 char offset value (without sign)
            offsetStr = DataTypeUtil.preAppendZeroes(absOffset, 4);
            int hrOffsetInt = Integer.parseInt(offsetStr.substring(0, 2));
            //check to see if the hour value is valid
            if ((hrOffsetInt < 0) || (hrOffsetInt > 23)) {
                String msg = "The GMT offset hour value of the TM datatype must be >=0 and <=23";
                DataTypeException e = new DataTypeException(msg);
                throw e;
            } //end if
            //extract the minute data from the offset value.
            int minOffsetInt = Integer.parseInt(offsetStr.substring(2, 4));
            //check to see if the minute value is valid
            if ((minOffsetInt < 0) || (minOffsetInt > 59)) {
                String msg = "The GMT offset minute value of the TM datatype must be >=0 and <=59";
                DataTypeException e = new DataTypeException(msg);
                throw e;
            } //end if
            //The input value is valid, now store it in the offset field
            offSet = signedOffset;
        } //end try

        catch (DataTypeException e) {
            throw e;
        } //end catch

        catch (Exception e) {
            throw new DataTypeException(e);
        } //end catch
    } //end method

    /**
     * Returns the HL7 TM string value.
     */
    public String getValue() {
        //combine the value field with the offSet field and return it
        String returnVal = null;
        if (value != null && !value.equals("")) {
            if (omitOffsetFg == false && !value.equals("\"\"")) {
                int absOffset = Math.abs(offSet);
                String sign = "";
                if (offSet >= 0) {
                    sign = "+";
                } //end if
                else {
                    sign = "-";
                } //end else
                returnVal = value + sign + DataTypeUtil.preAppendZeroes(absOffset, 4);
            }
            else {
                returnVal = value;
            } //end else
        } //end if
        return returnVal;
    } //end method

    /**
     * Convenience setter which sets the value using a {@link Calendar} object. Passing in <code>null</code> clears any existing value.
     * 
     * Note: Sets fields using precision up to the minute
     * 
     * @param theCalendar The calendar object from which to retrieve values 
     * @since 1.1 
     */
    public void setValueToMinute(Calendar theCalendar) throws DataTypeException {
		if (theCalendar == null) {
			setValue((String)null);
			return;
		}

        int hr = theCalendar.get(Calendar.HOUR_OF_DAY);
        int min = theCalendar.get(Calendar.MINUTE);
        setHourMinutePrecision(hr, min);
    }

    /**
     * Convenience setter which sets the value using a {@link Date} object. Passing in <code>null</code> clears any existing value.
     * 
     * Note: Sets fields using precision up to the minute
     * Note: Date is timezone-agnostic, representing always GMT time
     * 
     * @param theCalendar The calendar object from which to retrieve values 
     * @since 1.1 
     */
    public void setValueToMinute(Date theDate) throws DataTypeException {
		if (theDate == null) {
			setValue((String)null);
			return;
		}

		Calendar calendar = Calendar.getInstance();
        calendar.setTime(theDate);
        setValueToMinute(calendar);
    }
    
    /**
     * Convenience setter which sets the value using a {@link Calendar} object. Passing in <code>null</code> clears any existing value.
     * 
     * Note: Sets fields using precision up to the second
     * 
     * @param theCalendar The calendar object from which to retrieve values 
     * @since 1.1 
     */
    public void setValueToSecond(Calendar theCalendar) throws DataTypeException {
		if (theCalendar == null) {
			setValue((String)null);
			return;
		}

        int hr = theCalendar.get(Calendar.HOUR_OF_DAY);
        int min = theCalendar.get(Calendar.MINUTE);
        int sec = theCalendar.get(Calendar.SECOND);
        
        setHourMinSecondPrecision(hr, min, sec);
    }

    /**
     * Convenience setter which sets the value using a {@link Calendar} object. Passing in <code>null</code> clears any existing value.
     * 
     * Note: Sets fields using precision up to the millisecond, including timezone offset
     * 
     * @param theCalendar The calendar object from which to retrieve values 
     * @since 1.1 
     */
    public void setValue(Calendar theCalendar) throws DataTypeException {
		if (theCalendar == null) {
			setValue((String)null);
			return;
		}

        int hr = theCalendar.get(Calendar.HOUR_OF_DAY);
        int min = theCalendar.get(Calendar.MINUTE);
        float sec = theCalendar.get(Calendar.SECOND) + (theCalendar.get(Calendar.MILLISECOND) / 1000.0F);
        setHourMinSecondPrecision(hr, min, sec);
        
        // 3410095: care for integer overflow and timezones not at the full hour, e.g. India
        int hourOffset= theCalendar.get(Calendar.ZONE_OFFSET) / (1000 * 60 * 60);   
        int minuteOffset = (theCalendar.get(Calendar.ZONE_OFFSET) / (1000 * 60)) % 60;
        int zoneOffset = hourOffset * 100 + minuteOffset;
        setOffset(zoneOffset);
    }
   
    /**
     * Convenience setter which sets the value using a {@link Calendar} object. Passing in <code>null</code> clears any existing value.
     * 
     * Note: Sets fields using precision up to the millisecond, and sets the timezone offset to
     * the current system offset
     * Note: Date is timezone-agnostic, representing always GMT time
     * 
     * @param theDate The calendar object from which to retrieve values 
     * @since 1.1 
     */
	public void setValue(Date theDate) throws DataTypeException {
		if (theDate == null) {
			setValue((String)null);
			return;
		}

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(theDate);
		setValue(cal);
	}
    
    /**
     * Convenience setter which sets the value using a {@link Date} object. Passing in <code>null</code> clears any existing value.
     * 
     * Note: Sets fields using precision up to the second
     * Note: Date is timezone-agnostic, representing always GMT time
     * 
     * @param theCalendar The calendar object from which to retrieve values 
     * @since 1.1 
     */
    public void setValueToSecond(Date theDate) throws DataTypeException {
		if (theDate == null) {
			setValue((String)null);
			return;
		}

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(theDate);
        setValueToSecond(calendar);
    }
    
    /**
     * <p>Return the value as a calendar object.</p> 
     * 
     * <b>Note that only the time component of the return value is set to
     * the value from this object. Returned value will have today's date</b> 
     * @since 1.1 
     */
    public Calendar getValueAsCalendar() {
        Calendar retVal = Calendar.getInstance();
        retVal.set(Calendar.HOUR_OF_DAY, getHour());
        retVal.set(Calendar.MINUTE, getMinute());
        retVal.set(Calendar.SECOND, getSecond());
        
        float fractSecond = getFractSecond();
        retVal.set(Calendar.MILLISECOND, (int) (fractSecond * 1000.0));
        
        int gmtOff = getGMTOffset();
        if (gmtOff != GMT_OFFSET_NOT_SET_VALUE && !omitOffsetFg) {
            retVal.set(Calendar.ZONE_OFFSET, (gmtOff/100) * (1000 * 60 * 60));
            
            /*
             * The following sets the TimeZone associated with the returned calendar
             * to use the offset specified in the value if this conflicts with the
             * value it already contains.
             * 
             * This is needed in situations where daylight savings is in effect
             * during part of the year, and a date is parsed which contains the 
             * other part of the year (i.e. parsing a DST DateTime when it is not actually
             * DST according to the system clock).
             * 
             * See CommonTSTest#testGetCalendarRespectsDaylightSavings() for an example
             * which fails if this is removed.
             */
            if (retVal.getTimeZone().getRawOffset() != retVal.get(Calendar.ZONE_OFFSET)) {
	            int hrOffset = gmtOff / 100;
	            int minOffset = gmtOff % 100;
	            StringBuilder tzBuilder = new StringBuilder("GMT");
	            
	            if (hrOffset < 0) {
	            	tzBuilder.append('-');
	            }
	            tzBuilder.append(Math.abs(hrOffset));
	            tzBuilder.append(':');
	            if (minOffset < 10) {
	            	tzBuilder.append('0');
	            }
	            tzBuilder.append(minOffset);
	            
	            retVal.setTimeZone(TimeZone.getTimeZone(tzBuilder.toString()));
            }
            
        }
        
        return retVal;
    }

    
    /**
     * <p>Return the value as a date object</p>
     * 
     * <b>Note that only the time component of the return value is set to
     * the value from this object. Returned value will have today's date</b> 
     * Note: Date is timezone-agnostic, representing always GMT time
     * @since 1.1 
     */
    public Date getValueAsDate() {
        return getValueAsCalendar().getTime();
    }    
    
    /**
     * Returns the hour as an integer.
     */
    public int getHour() {
        return hour;
    } //end method

    /**
     * Returns the minute as an integer.
     */
    public int getMinute() {
        return minute;
    } //end method

    /**
     * Returns the second as an integer.
     */
    public int getSecond() {
        return second;
    } //end method

    /**
     * Returns the fractional second value as a float.
     */
    public float getFractSecond() {
        return fractionOfSec;
    } //end method

    /**
     * Returns the GMT offset value as an integer, {@link #GMT_OFFSET_NOT_SET_VALUE} if not set.  
     */
    public int getGMTOffset() {
        return offSet;
    } //end method
    
    /**
     * Returns a string value representing the input Gregorian Calendar object in
     * an Hl7 Time Format.
     */
    public static String toHl7TMFormat(GregorianCalendar cal) throws DataTypeException {
        String val = "";
        try {
            //set the input cal object so that it can report errors
            //on it's value
            cal.setLenient(false);
            int calHour = cal.get(GregorianCalendar.HOUR_OF_DAY);
            int calMin = cal.get(GregorianCalendar.MINUTE);
            int calSec = cal.get(GregorianCalendar.SECOND);
            int calMilli = cal.get(GregorianCalendar.MILLISECOND);
            //the inputs seconds and milli seconds should be combined into a float type
            float fractSec = calMilli / 1000F;
            float calSecFloat = calSec + fractSec;
            int calOffset = cal.get(GregorianCalendar.ZONE_OFFSET) + cal.get(GregorianCalendar.DST_OFFSET); 
            //Note the input's Offset value is in milliseconds, we must convert it to
            //a 4 digit integer in the HL7 Offset format.
            int offSetSignInt;
            if (calOffset < 0) {
                offSetSignInt = -1;
            }
            else {
                offSetSignInt = 1;
            }
            //get the absolute value of the gmtOffSet
            int absGmtOffSet = Math.abs(calOffset);
            int gmtOffSetHours = absGmtOffSet / (3600 * 1000);
            int gmtOffSetMin = (absGmtOffSet / 60000) % (60);
            //reset calOffset
            calOffset = ((gmtOffSetHours * 100) + gmtOffSetMin) * offSetSignInt;
            //Create an object of the TS class and populate it with the above values
            //then return the HL7 string value from the object
            CommonTM tm = new CommonTM();
            tm.setHourMinSecondPrecision(calHour, calMin, calSecFloat);
            tm.setOffset(calOffset);
            val = tm.getValue();
        } // end try

        catch (DataTypeException e) {
            throw e;
        } //end catch

        catch (Exception e) {
            throw new DataTypeException(e);
        } //end catch
        return val;
    } //end method

} //end class
