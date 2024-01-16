import java.util.Scanner;
import java.util.Random;

// used chat GPT to indent the code properly(SHOULD I JUST ERASE THIS)

public class Bingo extends Game {

    // declaration(global)
    private Scanner reader = new Scanner(System.in);
    private Random random = new Random();
    private String checks = "BINGO";
    private int points = 0;


    // method that will be called in Main class
    public void startB() {
        Scanner reader = new Scanner(System.in);
        Random random = new Random();

        // Starts Here:
        int[][] result = UsersBingo(5, 5);

        // Print the 2D array using a separate method
        System.out.println("Welcome to Bingo! Let's get you a board." + "\n**Remember, anytime you want to exit, type 0.**");
        TheUserArrayPrints(result);

        // Explains the rules of Bingo
        instruction(3);

        // Array to prevent generating redundant numbers
        int[] leftovers = new int[50];
        for (int x = 0; x < 50; x++) {
            leftovers[x] = x + 1;
        }

        String yes = "Y";
        String no = "N";

        // Generates random numbers (25 chances) and asks the user if it matches their card
        for (int i = 0; i <= 24; i++) {
            int ind;
            int bingoballer;
            do {
                ind = random.nextInt(49) + 1;
                // exitMiddle(ind,"");
                bingoballer = leftovers[ind];
            } while (bingoballer == 0);
            leftovers[ind] = 0;
            System.out.println("Does " + bingoballer + " match any of your numbers? Y or N");
            String ans = reader.next();
            exitMiddle(1,ans);

            // Checks if the user's number really does equal the randomly generated number
            if (ans.equals(yes)) {
                System.out.println(
                        "Let's check! Use (rows,columns) and DONT FORGET TO START THE COUNTING FROM 1" + "\n"
                                + "Type in the row:");
                int x = reader.nextInt();
                exitMiddle(x,"");
                System.out.println("Type in the column: ");
                int y = reader.nextInt();
                exitMiddle(y,"");

                if (result[x-1][y-1] != bingoballer) {
                    clear();
                    System.out.println("Girl, why are you lying? Don't let it happen again...");
                    TheUserArrayPrints(result);
                } else if (result[x-1][y-1] == bingoballer) {
                    clear();
                    System.out.println("Alright, guess you weren't lying. + 5 points");
                    // Keeps track of points
                    points += 5;
                    // Shows their bingo card again but with an X in place of the randomly generated
                    // number
                    result[x-1][y-1] = 0;
                    TheUserArrayPrints(result);

                    System.out.println("Remember if you have Bingo... Type BINGO in now! If not say: No.");
                    String BINGLETSGO = reader.next();
                    exitMiddle(1,BINGLETSGO);
                    CheckingForBingo(BINGLETSGO, result);
                }
            }
        }

        // These are your points at the end
        findHighest(3, points);
        System.out.println("GAME OVER!");
        System.out.println("Nice! You ended with " + points + " points.");
        System.out.print("Type any number to go back to main: ");
        int end = reader.nextInt();
        exitMiddle(end,"");
    }

    // This code will make a 5x5 array by inputting non-redundant random numbers from 1~50
    public int[][] UsersBingo(int row, int column) {
        row = 5;
        column = 5;
        int[][] BingoCard = new int[row][column];
        for (int i = 0; i < row; i++) {
            switch (i) {
                case 0:
                    for (int j = 0; j < column; j++) {
                        boolean only = false;
                        int num = 0;
                        // if that number has never been generated, set the number to the board
                        while (only == false) {
                            num = random.nextInt(49) + 1;
                            only = oneAndOnly(num, BingoCard);
                        }
                        BingoCard[0][j] = num;
                    }
                    break;
                case 1:
                    for (int j = 0; j < column; j++) {
                        boolean only = false;
                        int num = 0;
                        while (only == false) {
                            num = random.nextInt(49) + 1;
                            only = oneAndOnly(num, BingoCard);
                        }
                        BingoCard[1][j] = num;
                    }
                    break;
                case 2:
                    for (int j = 0; j < column; j++) {
                        boolean only = false;
                        int num = 0;
                        while (only == false) {
                            num = random.nextInt(49) + 1;
                            only = oneAndOnly(num, BingoCard);
                        }
                        BingoCard[2][j] = num;
                    }
                    break;
                case 3:
                    for (int j = 0; j < column; j++) {
                        boolean only = false;
                        int num = 0;
                        while (only == false) {
                            num = random.nextInt(49) + 1;
                            only = oneAndOnly(num, BingoCard);
                        }
                        BingoCard[3][j] = num;
                    }
                    break;
                case 4:
                    for (int j = 0; j < column; j++) {
                        boolean only = false;
                        int num = 0;
                        while (only == false) {
                            num = random.nextInt(49) + 1;
                            only = oneAndOnly(num, BingoCard);
                        }
                        BingoCard[4][j] = num;
                    }
                    break;
            }
        }

        return BingoCard;
    }

    // method to print the bingo board
    public void TheUserArrayPrints(int[][] array) {
        System.out.println("B" + "\t" + "I" + "\t" + "N" + "\t" + "G" + "\t" + "O");
        System.out.println("___________________________________" + "\n");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    System.out.print(array[i][j] + "\t");
                } else {
                    // 0, which represents removed numbers from the board, will be printed as 'X' just for user convenience.
                    System.out.print("X\t");
                }
            }
            System.out.println();
        }
        System.out.println("___________________________________" + "\n");
    }

    // method to check if the integer was generated before
    public boolean oneAndOnly(int checkNum, int[][] array) {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (checkNum == array[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    // method to check for bingo
    public void CheckingForBingo(String input, int[][] array) {
    //     System.out.println("DEBUG: Input received: " + input);  // Add this line
    // if (input.equals(checks)) {
    //     System.out.println("DEBUG: Entered if condition");

        if (input.equals(checks)) {
            System.out.println("Alright, let's check.");
            // across first row
            if (array[0][0] == 0 && array[0][1] == 0 && array[0][2] == 0 && array[0][3] == 0
                    && array[0][4] == 0) {
                System.out.println("BINGOOOO YOU WIN!!!!(+ 10 points)");
                points += 10;
            }
            // across last row
            else if (array[4][0] == 0 && array[4][1] == 0 && array[4][2] == 0 && array[4][3] == 0
                    && array[4][4] == 0) {
                System.out.println("BINGOOOO YOU WIN!!!!(+ 10 points)");
                points += 10;
            }
            // top to bottom first row
            else if (array[0][0] == 0 && array[1][0] == 0 && array[2][0] == 0 && array[3][0] == 0
                    && array[4][0] == 0) {
                System.out.println("BINGOOOO YOU WIN!!!!(+ 10 points)");
                points += 10;
            }
            // top to bottom last row
            else if (array[0][4] == 0 && array[1][4] == 0 && array[2][4] == 0 && array[3][4] == 0
                    && array[4][4] == 0) {
                System.out.println("BINGOOOO YOU WIN!!!!(+ 10 points)");
                points += 10;
            }
            // across left to right
            else if (array[0][0] == 0 && array[1][1] == 0 && array[2][2] == 0 && array[3][3] == 0
                    && array[4][4] == 0) {
                System.out.println("BINGOOOO YOU WIN!!!!(+ 10 points)");
                points += 10;
            }
            // across right to left
            else if (array[0][4] == 0 && array[1][3] == 0 && array[2][2] == 0 && array[3][1] == 0
                    && array[4][0] == 0) {
                System.out.println("BINGOOOO YOU WIN!!!!(+ 10 points)");
                points += 10;
            // no bingos..
            } else {
                System.out.println("Sorry, no bingos yet...");
            }
        }
    }
}
