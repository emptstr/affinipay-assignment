package time;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class TimeTest {
    private static final int ONE_DAY = 1440;
    private static final int ONE_DAY_THIRTEEN_MINUTES = 1453;
    private static final Time MIDNIGHT = new Time(0);
    private static final Time THIRTEEN_MINUTES_AFTER_MIDNIGHT = new Time(13);
    private static final Time THIRTEEN_MINUTES_BEFORE_MIDNIGHT = new Time(1427);

    @Test
    public void shoudAddMinutesToTime() {
        Time midnight = new Time(0);
        Time oneMinuteBeforeMidnight = new Time(1439);
        Time twentySixMinutesAfterMidnight = new Time(26);
        assertEquals(THIRTEEN_MINUTES_AFTER_MIDNIGHT, midnight.addMinutes(13));
        assertEquals(THIRTEEN_MINUTES_AFTER_MIDNIGHT, twentySixMinutesAfterMidnight.addMinutes(-13));
        assertEquals(THIRTEEN_MINUTES_AFTER_MIDNIGHT, oneMinuteBeforeMidnight.addMinutes(14));
        assertEquals(THIRTEEN_MINUTES_BEFORE_MIDNIGHT, midnight.addMinutes(-13));
        assertEquals(MIDNIGHT, midnight.addMinutes(ONE_DAY));
        assertEquals(MIDNIGHT, midnight.addMinutes(-ONE_DAY));
        assertEquals(THIRTEEN_MINUTES_AFTER_MIDNIGHT, midnight.addMinutes(ONE_DAY_THIRTEEN_MINUTES));
        assertEquals(THIRTEEN_MINUTES_BEFORE_MIDNIGHT, midnight.addMinutes(-ONE_DAY_THIRTEEN_MINUTES));
    }
}