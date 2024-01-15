import java.util.Scanner;
import java.util.Random;
public class mightbe
{
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        Random random = new Random();
     /*Welcome to Bingo:
    - provides 25 squares = 5x5 (2D array(?)) **
    - randomly assigns numbers to the bingo card **
    - yes or no (Y or N) command that they can type to mark off their bingo **
    - up to 25 chances to get a bingo
    - reply command? type Bingo if there is one (strings)
    - IF TIME add a black out thing */
   
//Starts Here:
   System.out.println("Welcome to Bingo! Let's get you a board."+"\n");
   System.out.println("___________________________________"+"\n");
        int[][] result = UsersBingo(5, 5);


// Print the 2D array using a separate method
        TheUserArrayPrints(result);
       
//explains the rules of Bingo
Rules();

//generates random numbers (25 chances) and asks the user is it does match their card
int chances = 0;
int points = 0;

String yes = "Y";
String no = "N";
for(int i = 0; i<=24; i++){
  int  bingoballer = random.nextInt(99);
    System.out.println("Does " + bingoballer + " match any of your numbers? Y or N");
    String ans = reader.next();
//Checks if the users number really does equal the randomly generated number
if(ans.equals (yes)){
System.out.println("Lets check! Use (rows,columns) and DONT FORGET TO START THE COUNTING FROM 0" + "\n" + "Type in the row:");
    int x = reader.nextInt();
System.out.println("Type in the column: ");
    int y = reader.nextInt();
if(result[x][y] == bingoballer){
    System.out.println("Alright, guess you werent lying. + 5 points");
//Shows their bingo card again but with an X in place of the random generated number
result[x][y] = 0;
TheUserArrayPrints(result);
    
}
else{
    System.out.println("Girl, why are you lying? Dont let it happen again...");
}
    
    
}
 
}



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

     //this method will check if any of the numbers on the Bingo card are the same 
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
    //Method of the Rules for bingo
    public static void Rules(){
        System.out.println("___________________________________"+"\n");
System.out.println("The rules:" + "\n" + " * If you think you have Bingo just simply type: 'BINGO' " + "\n" +
" * If the number matches the one on your board, type in Y (yes) if not, type in N (no)"+ " \n" + 
" * If you type Y, it will ask for the coordinates where your number supposedly is. DONT FORGET TO START THE COUNTING FROM 0"+ "\n" +
" * For every number you cross out you get 5 pts");
    }
    
}




