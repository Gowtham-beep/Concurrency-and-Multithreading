package AlarmClock;

import java.time.LocalTime;

public class AlarmEvent {
    private final LocalTime time;
    private final String message;

    public AlarmEvent(LocalTime time ,String message){
        this.time=time;
        this.message=message;
    }

    public LocalTime getTime(){
        return time;
    }
    public String getMessage(){
        return message;
    }
}
