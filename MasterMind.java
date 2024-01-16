import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList; 
import java.util.Timer;

public class MasterMind extends Game{

	// method to call class MMCount and MMEnd in certain time duration.
	// used https://www.geeksforgeeks.org/java-util-timer-class-java/ for the code and chatGPT for the constructor
    public void timerMethod(){
        Timer timer = new Timer();
		// schedule == just once
        timer.schedule(new MMEnd(this), 50000);
		// scheduleAtFixedRate == repeat
        // repeated every 10 seconds, starts count down after 10 seconds
        timer.scheduleAtFixedRate(new MMCount(this), 10000, 10000);

    }


//Define variables
	public int a=0, b=0, c=0, d=0;
	private int L1, L2, L3,L4;
	public boolean win = false;
    public int points = 100;
    public int timeLeft;

    // constructor
    public MasterMind(){
        points = 100;
        timeLeft = 50;
    }

    
//array that has correct combination 
	public ArrayList<Integer> key = new ArrayList<>();
	
//Array of player guesses
	public ArrayList<Integer> player = new ArrayList<>();

//Create BLANK player board 
	public void Pboard() {
	//Player board
			player.add(0);
			player.add(0);
			player.add(0);
			player.add(0);
	}
//Randomize key combination and set player board
	public void Rkey() {
		Random rnd = new Random();
		a = rnd.nextInt(4)+1;
		b = rnd.nextInt(4)+1;
		c = rnd.nextInt(4)+1;
		d = rnd.nextInt(4)+1;
//set values to key
		key.add(a);
		key.add(b);
		key.add(c);
		key.add(d);
	}
// print rest of the Instructions
	public void Instructions() {
		System.out.println(player);
		System.out.println( );
		System.out.println( "_______________________________\n\n");
		// Scanner rd = new Scanner(System.in);
		}
	//}

//Read in answers
	public void RDguess() {
		Scanner rd = new Scanner(System.in);

//read in values, but user can still exit game if they type 0.
		System.out.println("Enter in 4 numbers from the first location on the board to the last.\nBe sure to click enter after each number!\n");
		L1 = rd.nextInt();
		exitMiddle(L1,"");
		L2 = rd.nextInt();
		exitMiddle(L1,"");
		L3 = rd.nextInt();
		exitMiddle(L1,"");
		L4 = rd.nextInt();
		exitMiddle(L1,"");
//Set values to player array
		player.set(0, L1);
		player.set(1, L2);
		player.set(2, L3);
		player.set(3, L4);	
		
//Check combo after every read
		CKcombo();

	}

	
//Check combo with key
	public void CKcombo() {
        Main m = new Main();
		if ((L1==a)&& (L2 == b)&&(L3 == c)&&(L4 == d)){
            win=true;
            findHighest(1, points);
			System.out.print("You found the correct combo great Job!!!\nYou earned "+points+" points.\nType any integer to go back to main:");
            int exitM = reader.nextInt();
            exitMiddle(exitM,"");
            m.startEverything();
//Set win to true
		}
		else{
//If individual scores are true
				if (L1 == a)
				{
					System.out.println("The first location has the right value!!!");
				}
				if (L2 == b)
				{
					System.out.println("The second location has the right value!!!");
				}if (L3 == c)
				{
					System.out.println("The third location has the right value!!!");
				}if (L4 == d)
				{
					System.out.println("The fourth location has the right value!!!");
				}
//If not right combo read in new numbers
				RDguess();
				
			}
}
		   
//Method that runs the entire game
	public void PlayMastermind() {
        Main m = new Main();

        // call method
        timerMethod();
        win = false;
        Pboard();
        Rkey();
        instruction(1);
		Instructions();
        while (win==false) {
            Pboard();
            RDguess();
        }
        // System.out.println("\nTimes out!!\nThe correct answer was {" + key.get(0) + ", " + key.get(1) + ", " + key.get(2) + ", " + key.get(3) + "}.\nType any integer twice to go back to main: ");
        // int exit = reader.nextInt();
        // m.startEverything();

	}
		
}