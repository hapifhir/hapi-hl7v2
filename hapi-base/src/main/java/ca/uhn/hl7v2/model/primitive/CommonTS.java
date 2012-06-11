/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 *
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
import java.io.Serializable;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.DataTypeUtil;

/**
 * <p>
 * This class contains functionality used by the TS class
 * in the version 2.3.0, 2.3.1, and 2.4 packages
 * </p>
 * 
 * <p>
 * Note: The class description below has been excerpted from the Hl7 2.4 documentation. Sectional
 * references made below also refer to the same documentation.
 * </p>
 *
 * <p>
 * Format: YYYY[MM[DD[HHMM[SS[.S[S[S[S]]]]]]]][+/-ZZZZ]^<degree of precision>
 * </p>
 * 
 * <p>
 * Contains the exact time of an event, including the date and time. The date portion of a time stamp follows the rules of a
 * date field and the time portion follows the rules of a time field. The time zone (+/-ZZZZ) is represented as +/-HHMM
 * offset from UTC (formerly Greenwich Mean Time (GMT)), where +0000 or -0000 both represent UTC (without offset).
 * The specific data representations used in the HL7 encoding rules are compatible with ISO 8824-1987(E).
 * In prior versions of HL7, an optional second component indicates the degree of precision of the time stamp (Y = year, L
 * = month, D = day, H = hour, M = minute, S = second). This optional second component is retained only for purposes of
 * backward compatibility.
 * </p>
 * 
 * <p>
 * By site-specific agreement, YYYYMMDD[HHMM[SS[.S[S[S[S]]]]]][+/-ZZZZ]^<degree of precision> may be used
 * where backward compatibility must be maintained.
 * In the current and future versions of HL7, the precision is indicated by limiting the number of digits used, unless the
 * optional second component is present. Thus, YYYY is used to specify a precision of "year," YYYYMM specifies a
 * precision of "month," YYYYMMDD specifies a precision of "day," YYYYMMDDHH is used to specify a precision of
 * "hour," YYYYMMDDHHMM is used to specify a precision of "minute," YYYYMMDDHHMMSS is used to specify a
 * precision of seconds, and YYYYMMDDHHMMSS.SSSS is used to specify a precision of ten thousandths of a second.
 * In each of these cases, the time zone is an optional component. Note that if the time zone is not included, the timezone
 * defaults to that of the local time zone of the sender. Also note that a TS valued field with the HHMM part set to "0000"
 * represents midnight of the night extending from the previous day to the day given by the YYYYMMDD part (see example
 * below). Maximum length of the time stamp is 26. 
 * </p>
 * <p>
 * Examples: <br/>
 * |19760704010159-0500|<br/>
 * 1:01:59 on July 4, 1976 in the Eastern Standard Time zone (USA).<br/>
 * |19760704010159-0400|<br/>
 * 1:01:59 on July 4, 1976 in the Eastern Daylight Saving Time zone (USA).<br/>
 * |198807050000|<br/>
 * Midnight of the night extending from July 4 to July 5, 1988 in the local time zone of the sender.<br/>
 * |19880705|<br/>
 * Same as prior example, but precision extends only to the day. Could be used for a birthdate, if the time of birth is
 * unknown.<br/>
 * |19981004010159+0100|<br/>
 * 1:01:59 on October 4, 1998 in Amsterdam, NL. (Time zone=+0100).<br/>
 * </p>
 * <p>
 * The HL7 Standard strongly recommends that all systems routinely send the time zone offset but does not require it. All
 * HL7 systems are required to accept the time zone offset, but its implementation is application specific. For many
 * applications the time of interest is the local time of the sender. For example, an application in the Eastern Standard Time
 * zone receiving notification of an admission that takes place at 11:00 PM in San Francisco on December 11 would prefer
 * to treat the admission as having occurred on December 11 rather than advancing the date to December 12.
 * </p>
 * <p>
 * Note: The time zone [+/-ZZZZ], when used, is restricted to legally-defined time zones and is represented in HHMM
 * format.
 * </p>
 * <p>
 * One exception to this rule would be a clinical system that processed patient data collected in a clinic and a nearby hospital
 * that happens to be in a different time zone. Such applications may choose to convert the data to a common
 * representation. Similar concerns apply to the transitions to and from daylight saving time. HL7 supports such requirements
 * by requiring that the time zone information be present when the information is sent. It does not, however, specify which of
 * the treatments discussed here will be applied by the receiving system.
 * </p>
 * @author Neal Acharya
 */

@SuppressWarnings("serial")
public class CommonTS implements Serializable {

    private CommonDT dt;
    private CommonTM tm;

    /** Creates new ValidTS
     * zero argument constructor.
     * Creates an uninitailized TS datatype
     */
    public CommonTS() {
    } //zero arg constructor

    /**
     * Constructs a TS object with the given value.
     * The stored value will be in the following
     * format YYYY[MM[DD[HHMM[SS[.S[S[S[S]]]]]]]][+/-ZZZZ]
     */
    public CommonTS(String val) throws DataTypeException {
        this.setValue(val);
    } //end constructor

    /**
     * Returns the day as an integer.
     */
    public int getDay() {
        int day = 0;
        if (dt != null) {
            day = dt.getDay();
        } //end if
        return day;
    } //end method

    /**
     * Returns the fractional second value as a float.
     */
    public float getFractSecond() {
        float fractionOfSec = 0;
        if (tm != null) {
            fractionOfSec = tm.getFractSecond();
        } //end if
        return fractionOfSec;
    } //end method

    /**
     * Returns the GMT offset value as an integer.
     */
    public int getGMTOffset() {
        int offSet = 0;
        if (tm != null) {
        	offSet = tm.getGMTOffset();
        } //end if
        return offSet;
    } //end method

    /**
     * Returns the hour as an integer.
     */
    public int getHour() {
        int hour = 0;
        if (tm != null) {
            hour = tm.getHour();
        } //end if
        return hour;
    } //end method

    /**
     * Returns the minute as an integer.
     */
    public int getMinute() {
        int minute = 0;
        if (tm != null) {
            minute = tm.getMinute();
        } //end if
        return minute;
    } //end method

    /**
     * Returns the month as an integer.
     */
    public int getMonth() {
        int month = 0;
        if (dt != null) {
            month = dt.getMonth();
        } //end if
        return month;
    } //end method

    /**
     * Returns the second as an integer.
     */
    public int getSecond() {
        int seconds = 0;
        if (tm != null) {
            seconds = tm.getSecond();
        } //end if
        return seconds;
    } //end method

    /**
     * Returns the HL7 TS string value.
     */
    public String getValue() {
        String value = null;
        if (dt != null) {
            value = dt.getValue();
        } //end if
        if (tm != null && value != null && !value.equals("")) {
            if (tm.getValue() != null && !tm.getValue().equals("")) {
                //here we know we have a delete value or separate date and the time values supplied
                if (tm.getValue().equals("\"\"") && dt.getValue().equals("\"\"")) {
                    //set value to the delete value ("")
                    value = "\"\"";
                }
                else{
                    //set value to date concatonated with time value
                    value = value + tm.getValue();
                }                
            } //end if
            if (tm.getValue() == null || tm.getValue().equals("")) {
                //here we know we both have the date and just the time offset value
                //change the offset value from an integer to a signed string
                int offset = tm.getGMTOffset();
                String offsetStr = "";
                if (offset != CommonTM.GMT_OFFSET_NOT_SET_VALUE) {
                    offsetStr = DataTypeUtil.preAppendZeroes(Math.abs(offset), 4);
                    if (tm.getGMTOffset() >= 0) {
                        offsetStr = "+" + offsetStr;
                    } //end if
                    else {
                        offsetStr = "-" + offsetStr;
                    } //end else
                }
                value = value + offsetStr;
            } //end if
        } //end if
        return value;
    } //end method
    
    /**
     * Return the value as a calendar object. If the value is null (e.g. no value has
     * been set), returns null
     * 
     * @since 1.1 
     */
    public Calendar getValueAsCalendar() {
    	if (getValue() == null) {
    		return null;
    	}
    	
        Calendar retVal = tm.getValueAsCalendar();

        retVal.set(Calendar.YEAR, getYear());
        retVal.set(Calendar.MONTH, getMonth() - 1);
        retVal.set(Calendar.DATE, getDay());
        
        return retVal;
    }

    /**
     * Return the value as a date objectIf the value is null (e.g. no value has
     * been set), returns null
     * 
     * @since 1.1 
     */
    public Date getValueAsDate() {
    	if (getValue() == null) {
    		return null;
    	}

    	return getValueAsCalendar().getTime();
    }
    
    /**
     * Returns the year as an integer.
     */
    public int getYear() {
        int year = 0;
        if (dt != null) {
            year = dt.getYear();
        } //end if
        return year;
    } //end method

    
    /**
     * This method takes in integer values for the year, month, day, hour
     * and minute and performs validations, it then sets the value in the object
     * formatted as an HL7 Time Stamp value with year&month&day&hour&minute precision (YYYYMMDDHHMM).
     */
    public void setDateMinutePrecision(int yr, int mnth, int dy, int hr, int min) throws DataTypeException {
        try {
            //set the value of the date object to the input date value
            this.setDatePrecision(yr, mnth, dy);
            //create new time object is there isn't one
            if (tm == null) {
                tm = new CommonTM();
            }
            //set the value of the time object to the minute precision with the input values
            tm.setHourMinutePrecision(hr, min);
        } //end try

        catch (DataTypeException e) {
            throw e;
        } //end catch

        catch (Exception e) {
            throw new DataTypeException(e);
        } //end catch
    } //end method
    
    
    /**
     * This method takes in integer values for the year and month and day
     * and performs validations, it then sets the value in the object
     * formatted as an HL7 Time Stamp value with year&month&day precision (YYYYMMDD).
     *
     */
    public void setDatePrecision(int yr, int mnth, int dy) throws DataTypeException {
        try {
            //create date object if there isn't one
            if (dt == null) {
                dt = new CommonDT();
            }
            //set the value of the date object to the input date value
            dt.setYearMonthDayPrecision(yr, mnth, dy);
            //clear the time value object
            tm = null;
        } //end try

        catch (DataTypeException e) {
            throw e;
        } //end catch

        catch (Exception e) {
            throw new DataTypeException(e);
        } //end catch
    } //end method

    /**
     * This method takes in integer values for the year, month, day, hour, minute, seconds,
     * and fractional seconds (going to the tenthousandths precision).
     * The method performs validations and then sets the value in the object formatted as an
     * HL7 time value with a precision that starts from the year and goes down to the tenthousandths
     * of a second (YYYYMMDDHHMMSS.SSSS).
     * The Gmt Offset will not be effected.
     * Note: all of the precisions from tenths down to
     * tenthousandths of a second are optional. If the precision goes below tenthousandths
     * of a second then the second value will be rounded to the nearest tenthousandths of a second.
     */
    public void setDateSecondPrecision(int yr, int mnth, int dy, int hr, int min, float sec) throws DataTypeException {
        try {
            //set the value of the date object to the input date value
            this.setDatePrecision(yr, mnth, dy);
            //create new time object is there isn't one
            if (tm == null) {
                tm = new CommonTM();
            }
            //set the value of the time object to the second precision with the input values
            tm.setHourMinSecondPrecision(hr, min, sec);
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
            //create new time object is there isn't one
            if (tm == null) {
                tm = new CommonTM();
            }
            //set the offset value of the time object to the input value
            tm.setOffset(signedOffset);
        }

        catch (DataTypeException e) {
            throw e;
        } //end catch

        catch (Exception e) {
            throw new DataTypeException(e);
        } //end catch
    } //end method

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

		int yr = theCalendar.get(Calendar.YEAR);
        int mnth = theCalendar.get(Calendar.MONTH) + 1;
        int dy = theCalendar.get(Calendar.DATE);
        int hr = theCalendar.get(Calendar.HOUR_OF_DAY);
        int min = theCalendar.get(Calendar.MINUTE);
        float sec = theCalendar.get(Calendar.SECOND) + (theCalendar.get(Calendar.MILLISECOND) / 1000.0F);
        setDateSecondPrecision(yr, mnth, dy, hr, min, sec);
        
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
     * This method takes in a string HL7 Time Stamp value and performs validations.
     * The stored value will be in the following
     * format YYYY[MM[DD[HHMM[SS[.S[S[S[S]]]]]]]][+/-ZZZZ].
     * Note: Trailing zeros supplied in the time value (HHMM[SS[.S[S[S[S]]]]]])
     * and GMT offset ([+/-ZZZZ]) will be preserved.
     * Note: If the GMT offset is not supplied then the local
     * time zone (using standard time zone format which is not modified for daylight savings)
     * will be stored as a default. Passing in <code>null</code> clears any existing value.
     */
    public void setValue(String val) throws DataTypeException {
        if (val != null && !val.equals("") && !val.equals("\"\"")) {
            try {
                //check the length of the input value, ensure that it is no less than
                //8 characters in length
                if (val.length() < 4) {
                    String msg = "The length of the TS datatype value must be at least 4 characters in length.";
                    DataTypeException e = new DataTypeException(msg);
                    throw e;
                }

                //check the length of the input value, ensure that it is not greater
                //than 24 characters in length
                if (val.length() > 24) {
                    String msg = "The length of the TS datatype value must not be more than 24 characters in length.";
                    DataTypeException e = new DataTypeException(msg);
                    throw e;
                }

                //at this point we know that we have a value that should conform to the DT
                //datatype and possibly a value that should conform to the TM datatype
                String dateVal = null;
                String timeVal = null;
                String timeValLessOffset = null;
                int sp = val.indexOf("+");
                int sm = val.indexOf("-");
                int indexOfSign = -1;
                boolean offsetExists = false;
                boolean timeValIsOffsetOnly = false;
                if ((sp != -1) || (sm != -1)) {
                    offsetExists = true;
                }
                if (sp != -1)
                    indexOfSign = sp;
                if (sm != -1)
                    indexOfSign = sm;

                if (offsetExists == false) {
                    if (val.length() <= 8) {
                        dateVal = val;
                    }
                    else {
                        //here we know that a time value is present
                        dateVal = val.substring(0, 8);
                        timeVal = val.substring(8);
                        timeValLessOffset = timeVal;
                    }
                } //offset not exist

                if (offsetExists == true) {
                    if (indexOfSign > 8) {
                        dateVal = val.substring(0, 8);
                        timeVal = val.substring(8);
                        timeValLessOffset = val.substring(8, indexOfSign);
                    }
                    else {
                        //we know that the time val is simply the offset
                        dateVal = val.substring(0, indexOfSign);
                        timeVal = val.substring(indexOfSign);
                        timeValIsOffsetOnly = true;
                    }
                } //offset exists

                //create date object
                dt = new CommonDT();
                //set the value of the date object to the input date value
                dt.setValue(dateVal);
                //if the offset does not exist and a timvalue does not exist then
                //we must provide a default offset = to the local time zone
                if (timeVal == null && offsetExists == false) {
//                    int defaultOffset = DataTypeUtil.getLocalGMTOffset();
                    tm = new CommonTM();
                    //tm.setOffset(defaultOffset);
                    tm.setValue("");
                } //end if

                //if we have a time value then make a new time object and set it to the
                //input time value (as long as the time val has time + offset or just time only)
                if (timeVal != null && timeValIsOffsetOnly == false) {
                    // must make sure that the time component contains both hours 
                    // at the very least -- must be at least 2 chars in length.
                	// Note: this changed as of v2.5, before hours AND minutes were required.
                    if (timeValLessOffset.length() < 2) {
                        String msg =
                            "The length of the time component for the TM datatype"
                                + " value does not conform to the allowable format"
                                + " YYYY[MM[DD[HH[MM[SS[.S[S[S[S]]]]]]]]][+/-ZZZZ].";
                        DataTypeException e = new DataTypeException(msg);
                        throw e;
                    } //end if
                    tm = new CommonTM();
                    tm.setValue(timeVal);
                } //end if

                //if we have a time value and it only has the offset then make a new
                //time object and set the offset value to the input value
                if (timeVal != null && timeValIsOffsetOnly == true) {
                    //we know that the time value is just the offset so we
                    //must check to see if it is the right length before setting the
                    //offset field in the tm object
                    if (timeVal.length() != 5) {
                        String msg =
                            "The length of the GMT offset for the TM datatype value does"
                                + " not conform to the allowable format [+/-ZZZZ]";
                        DataTypeException e = new DataTypeException(msg);
                        throw e;
                    } //end if 
                    tm = new CommonTM();
                    //first extract the + sign from the offset value string if it exists
                    if (timeVal.indexOf("+") == 0) {
                        timeVal = timeVal.substring(1);
                    } //end if
                    int signedOffset = Integer.parseInt(timeVal);
                    tm.setOffset(signedOffset);
                } //end if
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
            if (val == null) {
                dt = null;
                tm = null;
            } //end if
            if (val != null && val.equals("")) {
                dt = new CommonDT();
                dt.setValue("");
                tm = new CommonTM();
                tm.setValue("");
            } //end if
            if (val != null && val.equals("\"\"")) {
                dt = new CommonDT();
                dt.setValue("\"\"");
                tm = new CommonTM();
                tm.setValue("\"\"");
            } //end if
        } //end else    

    } // end method

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

    	int yr = theCalendar.get(Calendar.YEAR);
        int mnth = theCalendar.get(Calendar.MONTH) + 1;
        int dy = theCalendar.get(Calendar.DATE);
        int hr = theCalendar.get(Calendar.HOUR_OF_DAY);
        int min = theCalendar.get(Calendar.MINUTE);
        setDateMinutePrecision(yr, mnth, dy, hr, min);
        
    }

    /**
     * Convenience setter which sets the value using a {@link Date} object. Passing in <code>null</code> clears any existing value.
     * 
     * Note: Sets fields using precision up to the minute
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

        int yr = theCalendar.get(Calendar.YEAR);
        int mnth = theCalendar.get(Calendar.MONTH) + 1;
        int dy = theCalendar.get(Calendar.DATE);
        int hr = theCalendar.get(Calendar.HOUR_OF_DAY);
        int min = theCalendar.get(Calendar.MINUTE);
        int sec = theCalendar.get(Calendar.SECOND);
        setDateSecondPrecision(yr, mnth, dy, hr, min, sec);
    }

    /**
     * Convenience setter which sets the value using a {@link Date} object. Passing in <code>null</code> clears any existing value.
     * 
     * Note: Sets fields using precision up to the second
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
     * Returns a string value representing the input Gregorian Calendar object in
     * an Hl7 TimeStamp Format.
     */
    public static String toHl7TSFormat(GregorianCalendar cal) throws DataTypeException {
        String val = "";
        try {
            //set the input cal object so that it can report errors
            //on it's value
            cal.setLenient(false);
            int calYear = cal.get(GregorianCalendar.YEAR);
            int calMonth = cal.get(GregorianCalendar.MONTH) + 1;
            int calDay = cal.get(GregorianCalendar.DAY_OF_MONTH);
            int calHour = cal.get(GregorianCalendar.HOUR_OF_DAY);
            int calMin = cal.get(GregorianCalendar.MINUTE);
            int calSec = cal.get(GregorianCalendar.SECOND);
            int calMilli = cal.get(GregorianCalendar.MILLISECOND);
            //the inputs seconds and milli seconds should be combined into a float type
            float fractSec = calMilli / 1000F;
            float calSecFloat = calSec + fractSec;
            int calOffset = cal.get(GregorianCalendar.ZONE_OFFSET);
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
            CommonTS ts = new CommonTS();
            ts.setDateSecondPrecision(calYear, calMonth, calDay, calHour, calMin, calSecFloat);
            ts.setOffset(calOffset);
            val = ts.getValue();
        } // end try

        catch (DataTypeException e) {
            throw e;
        } //end catch

        catch (Exception e) {
            throw new DataTypeException(e);
        } //end catch
        return val;
    } //end method

    
    public static void main(String[] args) throws DataTypeException {
    	
    	CommonTS ts = new CommonTS();
    	ts.setValue("1984");
    	
    	System.out.println(ts.getValue());
    	
    }
    
    
} //end class
