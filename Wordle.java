import java.util.Random;
import java.util.Scanner;

public class Wordle extends Game {
    private String word;

    // method to start Wordle
    public void staratW(){
        instruction(2);
        playGame();
    }

    // Constructor to initialize the hidden word
    public Wordle(String hWord) {
        setWord(hWord);
    }

    // Set the hidden word
    public void setWord(String newWord) {
        word = newWord.toLowerCase();
    }

    // Get a random word from a list of possibilities
    public void setRandomWord(String[] possibleWords) {
        Random random = new Random();
        word = possibleWords[random.nextInt(possibleWords.length)].toLowerCase();
    }

    // Method to get hints based on user guesses
    public String getHint(String guess) {
        String hint = "";

        // Iterate through each character in the guess
        if(guess.length()<6){
            for (int i = 0; i < guess.length(); i++) {
                // Compare the guessed character with the corresponding character in the hidden word
                if (guess.substring(i, i + 1).equals(word.substring(i, i + 1))) {
                    // If the characters match, add the guessed character to the hint
                    hint += guess.substring(i, i + 1);
                } else if (word.indexOf(guess.substring(i, i + 1)) != -1) {
                    // If the guessed character exists in the hidden word but not in the correct position, add "+"
                    hint += "+";
                } else {
                    // If the guessed character is not in the hidden word, add "*"
                    hint += "*";
                }
            }   
        }else{
            for (int i = 0; i < 5; i++) {
                // Compare the guessed character with the corresponding character in the hidden word
                if (guess.substring(i, i + 1).equals(word.substring(i, i + 1))) {
                    // If the characters match, add the guessed character to the hint
                    hint += guess.substring(i, i + 1);
                } else if (word.indexOf(guess.substring(i, i + 1)) != -1) {
                    // If the guessed character exists in the hidden word but not in the correct position, add "+"
                    hint += "+";
                } else {
                    // If the guessed character is not in the hidden word, add "*"
                    hint += "*";
                }

            }
        }

        // Return the final hint
        return hint;
    }

    // Method to get user input for guessed word
    public String getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("______________________________________________\n");
        System.out.print("Enter your guess: ");
        String guess = scanner.nextLine().toLowerCase();
        exitMiddle(1, guess);
        return guess;
    }

    // Getter for the hidden word (useful for testing)
    public String getWord() {
        return word;
    }

    // Main game loop
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Main m = new Main();

        // Initialize the WordleGame with a random word from the list
        String[] possibleWords = {
        	    "apple", "table", "world", "drink", "paint", "truck", "about", "above", "abuse", "actor", "acute",
        	    "admit", "adopt", "adult", "after", "begun", "being", "below", "bench", "broke", "brown", "build",
        	    "civil", "claim", "class", "clean", "clear", "click", "clock", "close", "coach", "coast"
        	};

        setRandomWord(possibleWords);

        // Get hints based on the initial state (all underscores)
       
        System.out.println("\nInitial Hint: " + getHint("_____"));

        // Game loop
        int attempts = 0;
        int points = 100; 
        while (attempts < 6) {
            // Get user input for guessed word
            String userGuess = getUserGuess();
            clear();

            // Get hints based on the user's guess
            String hint = getHint(userGuess);

            System.out.println("~~\t\t{WORDLE}\t\t~~\n");
            System.out.println("______________________________________________\n");


            // Check if the user guessed the word
            if (getWord().equals(userGuess)) {
                System.out.println("Congratulations! You've guessed the word.");
                points+= 0;

                // check if highest score + store highest score
                System.out.println(" You have " + points + " points!");
                System.out.println("Hidden Word: " + getWord());
                System.out.println("Type any number to go back to main.");
                int exit = reader.nextInt();
                findHighest(2, points);
                m.startEverything();
                
                //m.startEverything();
                break;
            }else{
                // Display the hint
                if (userGuess.length()!=5){
                    System.out.println("\nRemember, the answer is a 5 letter word.");
                }
                System.out.println("Hint: " + hint);
            }

            attempts++;
            System.out.println("Attempts remaining: " + (6 - attempts));
           points = 100 - ((attempts-1) * 20); 
           System.out.println(" You have " + points + " points!");
        }

        // Check if the player ran out of attempts
        if (attempts == 6) {
        	points+=0; 
        	  System.out.println("You have " + points + "points!");
              System.out.println("___________________");
            System.out.println("Sorry, you've run out of attempts. The word was: " + getWord());
            System.out.println("Type any number to go back to main.");
            int exit = reader.nextInt();
            m.startEverything();
        }

        //scanner.close();
    }
    
}