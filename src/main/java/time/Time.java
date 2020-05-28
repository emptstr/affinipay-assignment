package time;

public class Time {
    public static final int MINUTES_IN_A_DAY = 1440;
    private int minutesSinceMidnight;

    public Time(int minutesSinceMidnight) {
        this.minutesSinceMidnight = minutesSinceMidnight;
    }

    public Time addMinutes(int minutes) {
        int minutesToAdd = minutes % MINUTES_IN_A_DAY;
        int minutesAfterMidnight = (minutesSinceMidnight + minutesToAdd) % MINUTES_IN_A_DAY;
        if (minutesAfterMidnight >= 0) return new Time(minutesAfterMidnight);
        return new Time(MINUTES_IN_A_DAY + minutesAfterMidnight);
    }

    public int getHoursSinceMidnight() {
        return minutesSinceMidnight / 60;
    }

    public int getMinutesSinceMidnight() {
        return minutesSinceMidnight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Time)) return false;
        Time other = (Time) o;
        return minutesSinceMidnight == other.getMinutesSinceMidnight();
    }

    @Override
    public String toString() {
        return String.format("%d", minutesSinceMidnight);
    }
}
