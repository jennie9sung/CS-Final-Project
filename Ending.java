public class Ending extends Game{

    public void theEnd(){
        // add code here later
        System.out.println("\n"+"\n"+"~~~~~~~~~~Game Summary~~~~~~~~~~"+"\n");
        System.out.println("Your highest score for...");
        System.out.println("---------------------------------");
        System.out.println("|"+"\t"+"Hangman:"+"\t"+highestScore[0]+"\t"+"|");
        System.out.println("|"+"\t"+"Sudoku:"+"\t"+"\t"+highestScore[1]+"\t"+"|");
        System.out.println("|"+"\t"+"Bingo:"+"\t"+"\t"+highestScore[2]+"\t"+"|");
        System.out.println("---------------------------------");
    }
    
}
