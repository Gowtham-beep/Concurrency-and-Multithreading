package AlarmClock;

import java.time.LocalTime;
import java.util.concurrent.ConcurrentLinkedDeque;

public class AlarmEventLoop implements Runnable{
    private final ConcurrentLinkedDeque<AlarmEvent> queue = new ConcurrentLinkedDeque<>();

    public void scheduleAlarm(LocalTime Time, String message){
        queue.add(new AlarmEvent(Time, message));
        System.out.println("Alarm scheduled for "+ Time + ": "+ message);
    }
    @Override
    public void run(){
        while (true) {
            LocalTime now = LocalTime.now().withNano(0);
            for(AlarmEvent event : queue){
                if(now.equals(event.getTime())){
                  System.out.println("*** ALARM! " + event.getMessage() + " at " + event.getTime());  
                  queue.remove(event);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                System.out.println("Alarm event loop interrupted.");
                break;
            }
        }
    }
}
