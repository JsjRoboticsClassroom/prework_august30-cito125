package nyc.c4q;

import java.util.Scanner;


public class Hangman {
    private final SecretWord mSecretWord;
    private char mLastGuess;
    private int mMisses = 0;

    public Hangman(){
        mSecretWord = new SecretWord();
    }


    public int getMisses(){
        return mMisses;
    }

    public void readLetter() {
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        mLastGuess = Character.toUpperCase(input);
    }

    public void promptPlayer(String string) {
        System.out.println(string);
    }

    public boolean checkLetter() {
        if (mSecretWord.isLetter(mLastGuess)) {
            // If letter is in word do something
            mSecretWord.set(mLastGuess);
            return true;
        } else {
            mMisses++;
            return false;
        }
    }

    public void printCurrentWord(){
        System.out.println(mSecretWord);
    }

    public String getSecretWord() {
        return mSecretWord.reveal();
    }

    public boolean guessedSuccessfully() {
        return mSecretWord.isGuessed();
    }

    public boolean wantToPlayAgain(){
        System.out.println("Play again? Enter yes or no: ");
        String userInput = "";
        do {
            userInput = readString();
            if (userInput.equalsIgnoreCase("no") || userInput.equalsIgnoreCase("n")) {
                return false;
            } else if (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("y")) {
                return true;
            } else {
                System.out.println("Please enter yes, y or no, n ");
            }
        } while(true);
    }

    public static String readString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}