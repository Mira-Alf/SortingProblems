import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    public static Time noon() {
        Time noonTime = new Time();
        noonTime.hour = 12;
        noonTime.minute = 0;
        noonTime.second = 0;
        return noonTime;
    }

    public static Time midnight() {
        Time mTime = new Time();
        mTime.hour = 0;
        mTime.minute = 0;
        mTime.second = 0;
        return mTime;
    }

    public static Time ofSeconds(long seconds) {
        Time instance = new Time();
        long numHours = seconds/3600;
        instance.hour = (int) (numHours > 24 ? numHours%24 : numHours);
        int remainingSeconds = (int)(seconds % 3600);
        instance.minute = remainingSeconds/60;
        instance.second = remainingSeconds % 60;
        return instance;
    }

    public static Time of(int hour, int minute, int second) {
        boolean isValidHour = hour >= 0 && hour <= 23;
        boolean isValidMinute = minute >= 0 && minute <= 59;
        boolean isValidSecond = second >= 0 && second <= 59;
        Time instance = null;
        if(isValidHour && isValidMinute && isValidSecond) {
            instance = new Time();
            instance.hour = hour;
            instance.minute = minute;
            instance.second = second;
        }
        return instance;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}