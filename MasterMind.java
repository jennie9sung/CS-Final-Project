import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList; 

public class MasterMind extends Game{

	Main m = new Main();

	//Define variables
	private int a=0, b=0, c=0, d=0;
	private int L1, L2, L3,L4;
	private boolean win = false;
	private int exit;

	//array that has correct combination 
	private ArrayList<Integer> key = new ArrayList<>();
	
	//Array of player guesses
	private ArrayList<Integer> player = new ArrayList<>();

	//Method that runs the entire game
	public void PlayMastermind() {
		win=false;
		Pboard();
		Rkey();
		Instructions();
		//if (exit!=0){
		//if (L1!=0||L2!=0||L3!=0||L4!=0){
			CKcombo();
			while(win!=true) {
				Pboard();
				RDguess();
			}
		//}

	}

	//Create BLANK player board 
	public void Pboard() {
	//Player board
		for (int x=0; x<4; x++){
			player.add(0);
		}
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

	//Instructions
	public void Instructions() {
		System.out.println( "________Welcome to Mastermind________\n\n");
		System.out.println("The goal of this game is to postiton each number into\ntheir corect locations. To begin you are provided a blank board.\n     |\n     v\n");
		System.out.println(player);
		System.out.println( "Each spot could contain a '1' '2' '3' or '4'\nKnow that numbers can be repeated throughout the board.\nGuess the correct combination of numbers and win the game!");
		System.out.println( "_______________________________\n\n");
		//If want to exit click 0
		System.out.println("If you do not want to play this game enter '0' to return to the homepage.");
		Scanner rd = new Scanner(System.in);
		//exit = rd.nextInt();
	}

	//Read in answers
	public void RDguess() {
		Scanner rd = new Scanner(System.in);

		//read in values
		System.out.println("Enter in 4 numbers from the first location on the board to the last.\nBe sure to click enter after each number!");
		L1 = rd.nextInt();
		L2 = rd.nextInt();
		L3 = rd.nextInt();
		L4 = rd.nextInt();
		//Set values to player array
		player.set(0, L1);
		player.set(1, L2);
		player.set(2, L3);
		player.set(3, L4);	
		
		//Check combo after every read
		//if (L1!=0&&L2!=0&&L3!=0&&L4!=0){
		//	CKcombo();
		//}
	}
	
	//Check combo with key
	public void CKcombo() {
		if ((L1==a)&& (L2 == b)&&(L3 == c)&&(L4 == d)){
			System.out.println("You found the correct combo great Job!!!");
			//Set win to true
			win=true;
		}else{
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

		
}
