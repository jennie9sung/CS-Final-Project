import java.util.Scanner;
//import Bingo;

public class Main {

    // delcaration
    private static Scanner reader = new Scanner(System.in);
    public static int gn;
    // start 
    public static void main(String[] args){
        startEverything();
    }

    // method to print instructions + call game based on user input
    public static void startEverything(){
        int valid=0;
        do{
            // print choices
            clear();
            System.out.println("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄ Mini Games ▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄"+"\n");
            System.out.println("\t"+"1."+"\t"+"MasterMind");
            System.out.println("\t"+"2."+"\t"+"Wordle");
            System.out.println("\t"+"3."+"\t"+"Bingo");
            System.out.println("\t"+"0."+"\t"+"End Mini Games");
            // call a game/ending class based on user choice
            if (valid == 0){
                System.out.print("Choose an option: ");
            }else{
                // error checking --> if user types in a invalid number, it will ask user to type again
                System.out.print("Choose a valid option: ");
                valid =0;
            }
            gn = reader.nextInt();
            clear();
            // call games based on user input, repeated until user chooses 0.
            switch(gn){
                case 0:
                    Ending end = new Ending();
                    end.theEnd();
                    break;
                case 1:
                    MasterMind m = new MasterMind();
                    m.PlayMastermind();
                    break;
                case 2:
                    Wordle wd = new Wordle("");
                    wd.staratW();
                    break;
                case 3:
                    Bingo bg = new Bingo();
                    bg.startB();
                    break;
                default:
                    valid = 1;
            }
        }while(gn!=0);
        clear();
        // real ending(exiting)
        System.out.println("\n\n\n~-----Thanks for playing MINI GAMES!-----~\n\n\n\n");
    }

    // method to clear console
    // https://www.javatpoint.com/how-to-clear-screen-in-java
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}