import java.util.TimerTask;

public class MMEnd extends TimerTask {

    private masterM m;

    // used chatGPT for constructor
    public MMEnd(masterM mm) {
        this.m = mm;
    }

    public void run() {
        if (!m.win) {
            m.clear();
            System.out.println("\nTimes out!!\nThe correct answer was {" + m.key.get(0) + ", " + m.key.get(1) + ", " + m.key.get(2) + ", " + m.key.get(3) + "}.\nType any integer to go back to main:");
            int exit = m.reader.nextInt();
            Main main = new Main();
            main.startEverything();
        }
    }
}
