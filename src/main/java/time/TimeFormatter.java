package time;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeFormatter {
    private static final int HOURS_INDEX = 1;
    private static final int MINUTES_INDEX = 2;
    private static final int PERIOD_INDEX = 3;
    private static final Pattern TIME_FORMAT = Pattern.compile("^(\\d{1,2}):(\\d{2})\\s(AM|PM)$");

    private TimeFormatter() {

    }

    public static String format(Time time) {
        int hoursSinceMidnight = time.getHoursSinceMidnight();
        int minutesAfterHour = time.getMinutesSinceMidnight() - hoursSinceMidnight * 60;
        if (hoursSinceMidnight > 11) {
            return String.format("%02d:%02d PM", hoursSinceMidnight - 12, minutesAfterHour);
        }
        return String.format("%02d:%02d AM", hoursSinceMidnight, minutesAfterHour);
    }

    public static Time parse(String timeString) {
        Matcher matcher = TIME_FORMAT.matcher(timeString);
        if (!matcher.find()) throw new IllegalArgumentException("Expected input in format: " + TIME_FORMAT.toString());
        int hours = Integer.parseInt(matcher.group(HOURS_INDEX));
        checkArgument(hours >= 0 && hours <= 12, "Hours must be in the range 0-12: " + hours);
        int minutes = Integer.parseInt(matcher.group(MINUTES_INDEX));
        checkArgument(minutes >= 0 && minutes < 60, "Minutes must be in the range 0-59: " + minutes);
        int hoursSinceMidnight = hours + toHoursSinceMidnight(matcher.group(PERIOD_INDEX));
        return new Time(hoursSinceMidnight * 60 + minutes);
    }

    private static int toHoursSinceMidnight(String periodOfDay) {
        return periodOfDay.equals("AM") ? 0 : 12;
    }

    private static void checkArgument(boolean predicate, String message) {
        if (!predicate) throw new IllegalArgumentException(message);
    }
}

