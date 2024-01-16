
/* This class will be the base class of all the game classes.
 * (this means that all game classes should inherit this)
 */

import java.util.Scanner;

public class Game {

    //public masterM mm = new masterM();

    public Scanner reader = new Scanner(System.in);

    // keep track of the highest score
    public int[] highestScore = new int[3];

    // list of instructions --> use with 'instruction' method to guide user
    private String [] inst = {"________Welcome to Mastermind________\n\n"+"The goal of this game is to postiton each number into\ntheir corect locations. To begin you are provided a blank board.\n     |\n     v\n","Welcome to Wordle!\nYou have six guesses.\nA + means you have the right letter in the wrong place, a * means it's the wrong letter.\nGood luck!","The rules:" + "\n" + " * If you think you have Bingo just simply type: 'BINGO' " + "\n" +
    " * If the number matches the one on your board, type in Y (yes) if not, type in N (no)"+ " \n" + 
    " * If you type Y, it will ask for the coordinates where your number supposedly is. DONT FORGET TO START THE COUNTING FROM 0"+ "\n" +
    " * For every number you cross out you get 5 pts"};

    // print instructions based on game number
    public void instruction (int gameNum){
        System.out.println(inst[gameNum-1]);
    }

    // compare & store the highest score of a specific game
    public void findHighest(int gameNum, int current){
        if (highestScore[gameNum-1]<current){
            highestScore[gameNum-1]=current;
            System.out.println("highest score: "+highestScore[gameNum-1]);
        }
    }

    // clear console
    public void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public void exitMiddle(int integer, String string){
        Main m = new Main();
        if (integer == 0){
            m.startEverything();
        }
        if(string.equals("0")){
            m.startEverything();
        }
    }

    
}
