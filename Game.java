
/* This class will be the base class of all the game classes.
 * (this means that all game classes should inherit this)
 */

import java.util.Scanner;

public class Game {

    public Scanner reader = new Scanner(System.in);

    // keep track of the highest score
    public static int[] highestScore = new int[3];

    // list of instructions --> use with 'instruction' method to guide user
    private static String [] inst = {"smt","Welcome to Wordle!\nYou have six guesses.\nA + means you have the right letter in the wrong place, a * means it's the wrong letter.\nGood luck!","The rules:" + "\n" + " * If you think you have Bingo just simply type: 'BINGO' " + "\n" +
    " * If the number matches the one on your board, type in Y (yes) if not, type in N (no)"+ " \n" + 
    " * If you type Y, it will ask for the coordinates where your number supposedly is. DONT FORGET TO START THE COUNTING FROM 0"+ "\n" +
    " * For every number you cross out you get 5 pts"};

    public static void instruction (int gameNum){
        System.out.println(inst[gameNum-1]);
    }

    public void findHighest(int gameNum, int current){
        if (highestScore[gameNum-1]<current){
            highestScore[gameNum-1]=current;
            System.out.println("highest score: "+highestScore[gameNum-1]);
        }
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    
}
