import java.util.*;
public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) {
            throw new IllegalArgumentException("Неверные значения времени. Укажите правильные часы, минуты и секунды.");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public void addHours(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Количество часов не может быть отрицательным.");
        }
        hour = (hour + hours) % 24;
    }

    public void addMinutes(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Количество минут не может быть отрицательным.");
        }
        int totalMinutes = hour * 60 + minute + minutes;
        hour = (totalMinutes / 60) % 24;
        minute = totalMinutes % 60;
    }

    public void addSeconds(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Количество секунд не может быть отрицательным.");
        }
        int totalSeconds = hour * 3600 + minute * 60 + second + seconds;
        hour = (totalSeconds / 3600) % 24;
        minute = (totalSeconds / 60) % 60;
        second = totalSeconds % 60;
    }

    public static void main(String[] args) {
        System.out.println("Введите часы, минуты, секунды через пробел: ");
        Scanner in = new Scanner(System.in);
        Time time = new Time(in.nextInt(), in.nextInt(), in.nextInt());
        System.out.println("Введите промежуток изменения времени(в том же формате, через пробел):  ");
        int h = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        try {
            time.addHours(h);
            System.out.println("Time after adding " + h + " hours: " + time.hour + ":" + time.minute + ":" + time.second);
            
            time.addMinutes(m);
            System.out.println("Time after adding "+ m + " minutes: " + time.hour + ":" + time.minute + ":" + time.second);
            
            time.addSeconds(s);
            System.out.println("Time after adding " + s + " seconds: " + time.hour + ":" + time.minute + ":" + time.second);
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
