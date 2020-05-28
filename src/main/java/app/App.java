package app;

import java.util.Scanner;

import time.Time;
import time.TimeFormatter;

public class App {

    public static String addMinutesToTime(String timeString, int minutesToAdd) {
        Time time = TimeFormatter.parse(timeString);
        time = time.addMinutes(minutesToAdd);
        return TimeFormatter.format(time);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String timeString = scanner.nextLine();
        int minutesToAdd = Integer.parseInt(scanner.next());
        try {
            System.out.println(addMinutesToTime(timeString, minutesToAdd));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
