import java.util.Arrays;
import java.util.Scanner;

public class Hangman2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("-------------------------------");
        System.out.println("Welcome to HANGMAN2");
        System.out.println("-------------------------------");
        System.out.println("   ");
        System.out.println("  ");
        System.out.println("OK Guessing Player ... turn around, while your friend enters the word to guess!");
        System.out.print("Other Player - Enter your word (up to 10 letters only, not case sensitive): ");
        char[] wordToGuess = scanner.nextLine().toLowerCase().toCharArray();

        for (int i = 0; i < 20; i++) {
            System.out.println();
        }


        char[] hiddenWord = new char[wordToGuess.length];
        Arrays.fill(hiddenWord, '*');
        char[] lettersNotTried = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int guessesLeft = 10;


        while (guessesLeft > 0) {

            System.out.println("Word to date: " + String.valueOf(hiddenWord) + " (" + guessesLeft + " guess(es) left)");
            System.out.print("Letters to try: ");
            for (char letter : lettersNotTried) {
                System.out.print(letter);
            }
            System.out.println();


            System.out.print("Want to solve the puzzle? Enter \"Y\" to solve the puzzle, or \"N\" to guess a character: ");
            String solveOrGuess = scanner.nextLine().toLowerCase();

            if (solveOrGuess.equals("y")) {

                System.out.print("Enter your solution: ");
                String solution = scanner.nextLine().toLowerCase();
                if (solution.equals(String.valueOf(wordToGuess))) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Congratulations!!!");
                    System.out.println("You guessed the mystery word: " + String.valueOf(wordToGuess) + " in "+ guessesLeft + " guesses!");
                    System.out.println(" ");
                    System.out.println("  ");
                    System.out.println("Goodbye....");
                    System.out.println("--------------------------------------------------");
                    return;
                } else {
                    System.out.println("Sorry you didn't find the mystery word!");
                    System.out.println("It was "+ String.valueOf(wordToGuess));
                    guessesLeft--;
                    break;
                }
            } else if (solveOrGuess.equals("n")) {

                System.out.print("Which letter should I check for? ");
                char guess = scanner.nextLine().toLowerCase().charAt(0);


                if (!Character.isLetter(guess)) {
                    System.out.println("--> Not a valid request - either not a letter or already guesses.");
                    continue;
                }


                lettersNotTried = removeElement(lettersNotTried, guess);


                boolean correctGuess = false;
                for (int i = 0; i < wordToGuess.length; i++) {
                    if (wordToGuess[i] == guess) {
                        hiddenWord[i] = guess;
                        correctGuess = true;
                    }
                }
                if (!correctGuess) {
                    guessesLeft--;
                    System.out.println("Incorrect guess");
                }


                if (Arrays.equals(hiddenWord, wordToGuess)) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Congratulations!!!");
                    System.out.println("You guessed the mystery word: " + String.valueOf(wordToGuess) + " in "+ guessesLeft + " guesses!");
                    System.out.println(" ");
                    System.out.println("  ");
                    System.out.println("Goodbye....");
                    System.out.println("--------------------------------------------------");

                }
            } else {
                System.out.println("Invalid input - please enter \"Y\" or \"N\"");

            }
        }
        if (guessesLeft == 0) {
            System.out.println("--------------------------------------------------");
            System.out.println("Sorry you didn't find the mystery word!");
            System.out.println("It was " + String.valueOf(wordToGuess));
            System.out.println("Goodbye....");
            System.out.println("--------------------------------------------------");
        }

    } public static char[] removeElement(char[] arr, char elem) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return arr;
        }
        char[] result = new char[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            result[j++] = arr[i];
        }
        return result;

    }
}