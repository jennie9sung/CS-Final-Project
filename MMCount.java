import java.util.TimerTask;

public class MMCount extends TimerTask {

    private masterM m;

    // used chatGPT for constructor
    public MMCount(masterM mm) {
        this.m = mm;
    }

    public void run() {
        if (m.timeLeft > 0 && !m.win) {
            m.timeLeft -= 10;
            System.out.println("****" + m.timeLeft + " seconds left!!****");
            m.points -= 20;
            System.out.println("points: " + m.points);
        }
    }
}
