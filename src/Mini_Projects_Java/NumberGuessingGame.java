package Mini_Projects_Java;

import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {

        Scanner sc = new Scanner(System.in);

        // Generate a random number between 1 and 100
        int randomNumber = 1 + (int) (Math.random() * 100);

        // Maximum number of attempts
        int maxAttempts = 5;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts.\n");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {

            System.out.print("Attempt " + attempt + ": Enter your guess: ");
            int guess = sc.nextInt();

            if (guess == randomNumber) {
                System.out.println("\n🎉 Congratulations! You guessed the correct number.");
                sc.close();
                return;
            } else if (guess < randomNumber) {
                System.out.println("📈 Too low! Try a higher number.\n");
            } else {
                System.out.println("📉 Too high! Try a lower number.\n");
            }
        }

        System.out.println("\n❌ Game Over!");
        System.out.println("The correct number was: " + randomNumber);

        sc.close();
    }
}