package codsoft;

import java.util.Random;
import java.util.Scanner;

public class guess {

    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            playGame(scanner);

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Game Over. Thanks for playing!");
        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        int minRange = getRange("Enter the minimum range: ", scanner);
        int maxRange = getRange("Enter the maximum range: ", scanner);
        int targetNumber = getRandomNumber(minRange, maxRange);

        System.out.println("\nI've generated a number between " + minRange + " and " + maxRange);

        int numberOfAttempts = 0;
        int score = 0;

        while (true) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numberOfAttempts++;

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + numberOfAttempts + " attempts.");
                score += calculateScore(numberOfAttempts);
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }
        }

        System.out.println("Your score for this game is: " + score);
    }

    private static int getRange(String message, Scanner scanner) {
        System.out.print(message);
        return scanner.nextInt();
    }

    private static int getRandomNumber(int min, int max) {
    	return min+(int) (Math.random()*((max - min) + 1));
    }

    private static int calculateScore(int attempts) {
        return 10 * (6 - attempts);
    }
}
