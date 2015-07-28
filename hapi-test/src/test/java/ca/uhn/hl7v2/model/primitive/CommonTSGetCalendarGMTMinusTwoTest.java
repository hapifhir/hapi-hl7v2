package ca.uhn.hl7v2.model.primitive;

import ca.uhn.hl7v2.model.DataTypeException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CommonTSGetCalendarGMTMinusTwoTest {
    private static TimeZone defaultTZ;

    @BeforeClass
    public static void setUpBeforeClass() {
        defaultTZ = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-02:00"));
    }

    @AfterClass
    public static void tearDownAfterClass() {
        TimeZone.setDefault(defaultTZ);
    }

    @Parameters(name = "{0},{1}")
    public static Collection<Object[]> params() {
        List<String> tzs = new ArrayList<String>();
        {
            // west to east
            tzs.add("Canada/Eastern");
            tzs.add("GMT-1");
            tzs.add("UTC");
            tzs.add("GMT");
            tzs.add("Europe/London");
            tzs.add("GMT+1");
            tzs.add("CET");
            tzs.add("Europe/Copenhagen");
            tzs.add("GMT+2");
        }
        List<String> instants = new ArrayList<String>();
        {
            instants.add("2015010112");
            instants.add("2015060112");
        }

        List<Object[]> params = new ArrayList<Object[]>();
        for (String tz : tzs) {
            for (String i : instants) {
                params.add(new Object[]{tz, i});
            }
        }
        return params;
    }


    @Rule
    public ErrorCollector collector = new ErrorCollector();

    SimpleDateFormat dfm = new SimpleDateFormat("yyyyMMddHH");
    CommonTS cts = new CommonTS();
    GregorianCalendar expected;
    final TimeZone tz;

    public CommonTSGetCalendarGMTMinusTwoTest(
            String tz, String instant) throws ParseException {
        this.tz = TimeZone.getTimeZone(tz);

        this.expected = new GregorianCalendar(this.tz);
        dfm.setTimeZone(this.tz);
        Date parse = dfm.parse(instant);
        expected.setTime(parse);
    }

    @Test
    public void calendar() throws DataTypeException {
        cts.setValue(expected);
        GregorianCalendar actual = (GregorianCalendar) cts.getValueAsCalendar();

        compareCalendar(actual);
    }

    @Test
    public void calendarWithDefaultChanged() throws DataTypeException {
        TimeZone dfTz = TimeZone.getDefault();
        TimeZone.setDefault(tz);
        try {
            cts.setValue(expected);
            GregorianCalendar actual =
                    (GregorianCalendar) cts.getValueAsCalendar();

            compareCalendar(actual);
        } finally {
            TimeZone.setDefault(dfTz);
        }
    }

    @Test
    public void date() throws DataTypeException {
        cts.setValue(expected);
        Date actual = cts.getValueAsDate();

        assertThat(actual, equalTo(expected.getTime()));
    }

    @Test
    public void constructCalendarManuallyUsingGMTOffsetWithCommonTMGetters() throws DataTypeException {
        cts.setValue(expected);

        int offset = cts.getGMTOffset() / 100;
        final TimeZone timeZone;
        if (offset >= 0) {
            timeZone = TimeZone.getTimeZone("GMT+" + offset);
        } else {
            timeZone = TimeZone.getTimeZone("GMT" + offset);
        }
        GregorianCalendar actual = new GregorianCalendar(timeZone);
        actual.set(Calendar.YEAR, cts.getYear());
        actual.set(Calendar.MONTH, cts.getMonth() - 1);
        actual.set(Calendar.DATE, cts.getDay());
        actual.set(Calendar.HOUR_OF_DAY, cts.getHour());
        actual.set(Calendar.MINUTE, cts.getMinute());
        actual.set(Calendar.SECOND, cts.getSecond());

        float fractSecond = cts.getFractSecond();
        actual.set(Calendar.MILLISECOND, (int) Math.round(fractSecond * 1000.0));

        compareCalendar(actual);
    }

    @Test
    public void constructCalendarManuallyUsingUTCWithCommonTMGetters() throws DataTypeException {
        cts.setValue(expected);

        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        GregorianCalendar actual = new GregorianCalendar(timeZone);
        actual.set(Calendar.YEAR, cts.getYear());
        actual.set(Calendar.MONTH, cts.getMonth() - 1);
        actual.set(Calendar.DATE, cts.getDay());
        actual.set(Calendar.HOUR_OF_DAY, cts.getHour());
        actual.set(Calendar.MINUTE, cts.getMinute());
        actual.set(Calendar.SECOND, cts.getSecond());

        float fractSecond = cts.getFractSecond();
        actual.set(Calendar.MILLISECOND, (int) Math.round(fractSecond * 1000.0));
        int offset = cts.getGMTOffset() / -100;
        actual.add(Calendar.HOUR, offset);
        actual.getTime();

        compareCalendar(actual);
    }

    private void compareCalendar(GregorianCalendar actual) {
        collector.checkThat(actual.getTime(), equalTo(expected.getTime()));
    }
}
