import java.util.Scanner;
public class MainPage {

    public Scanner reader = new Scanner(System.in);

    public int choice = 0;

    // function to print 
    public void format(){
        System.out.println("------------------Mini Games------------------"+"\n");
        System.out.println("\t"+"1."+"\t"+"Hangman");
        System.out.println("\t"+"2."+"\t"+"Sudoku");
        System.out.println("\t"+"3."+"\t"+"Bingo");
        System.out.println("\t"+"0."+"\t"+"End Mini Games");
        // call a game/ending class based on user choice
        System.out.print("Choose an option: ");
        choice = reader.nextInt();
        options(choice);
    }   

    // actuall call happens in this class
    public void options(int gn){
        Ending end = new Ending();

        if(gn==0){
            //System.out.println("worked");
            end.theEnd();
        }else if (gn>=1&&gn<=3){
            startGame(gn);
        }else{
            System.out.print("Choose a valid option: ");
            gn = reader.nextInt();
            options(gn);
        }
    }


    // calls game or end class based on user input
    public void startGame(int gameNum){
        switch(gameNum){
            case 1:
            // game1
            break;
            case 2:
            // game2
            break;
            case 3:
            // game 3
            break;
        }
    }



}
