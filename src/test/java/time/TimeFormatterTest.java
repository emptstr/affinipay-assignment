package time;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class TimeFormatterTest {
    private static final String VALID_TIME_STRING_1 = "1:12 AM";
    private static final String VALID_TIME_STRING_2 = "01:12 AM";
    private static final String VALID_TIME_STRING_3 = "1:00 PM";
    private static final String VALID_TIME_STRING_4 = "01:00 PM";
    private static final Time TIME_1 = new Time(72);
    private static final Time TIME_2 = new Time(780);

    private static final String INVALID_TIME_STRING_1 = ":00 AM";
    private static final String INVALID_TIME_STRING_2 = "01:0 AM";
    private static final String INVALID_TIME_STRING_3 = "1:00 EU";
    private static final String INVALID_TIME_STRING_4 = "1:00 AM\\s";
    private static final String INVALID_TIME_STRING_5 = "1:60 AM";
    private static final String INVALID_TIME_STRING_6 = "14:00 AM";

    @Test
    public void shouldParseTime() {
        assertEquals(TIME_1, TimeFormatter.parse(VALID_TIME_STRING_1));
        assertEquals(TIME_1, TimeFormatter.parse(VALID_TIME_STRING_2));
        assertEquals(TIME_2, TimeFormatter.parse(VALID_TIME_STRING_3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenMissingHours() {
        TimeFormatter.parse(INVALID_TIME_STRING_1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenMissingMinutes() {
        TimeFormatter.parse(INVALID_TIME_STRING_2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenPeriodIsInvalid() {
        TimeFormatter.parse(INVALID_TIME_STRING_3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenStringContainsTrailingCharacters() {
        TimeFormatter.parse(INVALID_TIME_STRING_4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenMinutesIsInvalid() {
        TimeFormatter.parse(INVALID_TIME_STRING_5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenHoursIsInvalid() {
        TimeFormatter.parse(INVALID_TIME_STRING_6);
    }

    @Test
    public void shouldFormatTime() {
        assertEquals(VALID_TIME_STRING_2, TimeFormatter.format(TIME_1));
        assertEquals(VALID_TIME_STRING_4, TimeFormatter.format(TIME_2));
    }
}