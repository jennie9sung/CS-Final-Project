import java.util.Scanner;
import java.util.Random;
public class Bingo extends Game{
    public static void main(String args[]) {
     /*Welcome to Bingo:
    - provides 25 squares = 5x5 (2D array(?)) **
    - randomly assigns numbers to the bingo card **
    - yes or no (Y or N) command that they can type to mark off their bingo
    - up to 25 chances to get a bingo
    - reply command? type Bingo if there is one (strings)
    Also includes methods: making a board, assigning a number to compare to the users board */
    
//Starts Here:
   System.out.println("Welcome to Bingo! Let's get you a board."+"\n");
   System.out.println("___________________________________"+"\n");
        int[][] result = UsersBingo(5, 5);

// Print the 2D array using a separate method
        TheUserArrayPrints(result);
        
//finds the largest number in the array and then uses that number to make every 25 randomized numbers after that less than or equal to it
    }

    
public static Scanner reader = new Scanner(System.in);
public static Random random = new Random();

public static int[][] UsersBingo(int row, int column){
    
    //this code will make a 5x5 arrray by inputting random numbers
    row = 5;
    column = 5;
    int[][] BingoCard = new int[row][column];
    System.out.println("B"+ "\t"+"I"+ "\t"+"N"+ "\t"+"G"+ "\t"+"O");
    for (int i = 0; i < row; i++) {
        switch(i){
            case 0:
                for (int j = 0; j < column; j++) {
                    boolean only = false;
                    int num=0;
                    while(only==false){
                        num = random.nextInt(100);
                        only = oneAndOnly(num, BingoCard);
                    }
                    BingoCard[0][j]=num;
                }
                break;
            case 1:
                for (int j = 0; j < column; j++) {
                    boolean only = false;
                    int num=0;
                    while(only==false){
                        num = random.nextInt(100);
                        only = oneAndOnly(num, BingoCard);
                    }
                    BingoCard[1][j]=num;
                }
                break;   
            case 2:
                for (int j = 0; j < column; j++) {
                    boolean only = false;
                    int num=0;
                    while(only==false){
                        num = random.nextInt(100);
                        only = oneAndOnly(num, BingoCard);
                    }
                    BingoCard[2][j]=num;
                }
                break;    
            case 3:
                for (int j = 0; j < column; j++) {
                    boolean only = false;
                    int num=0;
                    while(only==false){
                        num = random.nextInt(100);
                        only = oneAndOnly(num, BingoCard);
                    }
                    BingoCard[3][j]=num;
            }
                break;         
            case 4:
                for (int j = 0; j < column; j++) {
                    boolean only = false;
                    int num=0;
                    while(only==false){
                        num = random.nextInt(100);
                        only = oneAndOnly(num, BingoCard);
                    }
                    BingoCard[4][j]=num;
                }
                break;  
        }
}

    return BingoCard;
}
     //this method will print out the 2D array
     //Chat GPT was used for this part
    public static void TheUserArrayPrints(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            //System.out.println("");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();  
        }
    }

    public static boolean oneAndOnly(int checkNum, int[][] array){
            for(int x=0; x<5;x++){
                for(int y=0; y<5; y++){
                    if (checkNum==array[x][y]){
                        return false;
                        }
                    }
            }
            return true;

    }
}
