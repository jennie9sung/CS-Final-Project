import java.util.Timer;
import java.util.TimerTask;
import java.util.*;

public class happy {
    protected static happy obj;
    public static void main(String[] args){
        obj = new happy();
        Timer timer = new Timer();
        TimerTask task  = new MMEnd();

        timer.schedule(task, 2000, 5000);


    }
}
