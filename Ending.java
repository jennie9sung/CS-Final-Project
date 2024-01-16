import java.util.Scanner;

public class Ending extends Game{

    public void theEnd(){
        Scanner reader = new Scanner(System.in);
        Main m = new Main();
        String end;
        // print out result --> print out highest scores of each game
        System.out.println("\n"+"\n"+"~~~~~~~~~~Game Summary~~~~~~~~~~"+"\n");
        System.out.println("Your highest score for...");
        System.out.println("---------------------------------");
        System.out.println("|"+"\t"+"MasterMind"+"\t"+highestScore[0]+"\t"+"|");
        System.out.println("|"+"\t"+"Wordle:"+"\t"+"\t"+highestScore[1]+"\t"+"|");
        System.out.println("|"+"\t"+"Bingo:"+"\t"+"\t"+highestScore[2]+"\t"+"|");
        System.out.println("---------------------------------");

        // user can choose to restart the entire minigame or quit
        System.out.print("\n\nDo you want to retry?\nType 'R' to retry or any other thing to exit: ");
        end = reader.next();
        if(end.equalsIgnoreCase("r")){
            // reset saved data
            for(int x=0; x<3; x++){
                highestScore[x]=0;
            }
            // restart minigame
            m.startEverything();
        }else{
            // end
            m.gn=0;
        }
    }
    
}
