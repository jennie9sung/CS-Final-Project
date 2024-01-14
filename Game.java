
/* This class will be the base class of all the game classes.
 * (this means that all game classes should inherit this)
 */

import java.util.Scanner;

public class Game {

    public Scanner reader = new Scanner(System.in);

    // keep track of the highest score
    public int[] highestScore = new int[3];

    // list of instructions --> use with 'instruction' method to guide user
    private String [] inst = {"smt","smt2","Welcome to Wordle! You have six guesses. A + means you have the right letter in the wrong place, a * means it's the wrong letter. Good luck!"};

    public void instruction (int gameNum){
        System.out.println(inst[gameNum]);
    }

    public void findHighest(int gameNum, int current){
        if (highestScore[gameNum]<current){
            highestScore[gameNum]=current;
        }
    }

    
}
