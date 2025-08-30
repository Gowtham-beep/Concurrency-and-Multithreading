package AlarmClock;

import java.time.LocalTime;
import java.util.*;

public class AlarmClock {
    public static void main(String[] args) {
        AlarmEventLoop eventLoop= new AlarmEventLoop();
        Thread loopThread = new Thread(eventLoop);
        loopThread.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Alarm Clock started. Enter alarms in format HH:mm:ss Message (Ctrl+C to stop):");

        while(true){
            System.out.println("Set Alarm: ");
            String input =scanner.nextLine();
            String[] parts = input.split(" ",2);
            if(parts.length<2){
                System.out.println("Please provide the time and message");
                continue;
            }
            try {
                LocalTime alarmTime = LocalTime.parse(parts[0]);
                String message = parts[1];
                eventLoop.scheduleAlarm(alarmTime, message);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Invalid format! Use HH:mm:ss  Message");
            }

        }
    }
}
