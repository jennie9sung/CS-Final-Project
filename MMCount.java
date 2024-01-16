import java.util.TimerTask;

public class MMCount extends TimerTask {

    private MasterMind m;

    // used chatGPT for constructor
    public MMCount(MasterMind mm) {
        this.m = mm;
    }

    // this method will be used to print out how many seconds are left and the points they will earn
    // every 10 seconds until the user wins or time is over. 
    public void run() {
        if (m.timeLeft > 0 && m.win==false) {
            m.timeLeft -= 10;
            System.out.println("****" + m.timeLeft + " seconds left!!****");
            m.points -= 20;
            System.out.println("points: " + m.points);
        }
    }
}
