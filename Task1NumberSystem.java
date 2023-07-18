import java.util.Scanner;
import java.util.Random;
public class Task1NumberSystem {
    public static void main(String[] args) {
        int minNum = 1;
        int maxNum = 100;
        int randomNum = generateRandomNumber(minNum, maxNum);
        int attempts = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int userGuess = getUserGuess(scanner);
            attempts++;
            String result = checkGuess(randomNum, userGuess);
            System.out.println(result);

            if (result.equals("Correct!")) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            }
        }

        scanner.close();
    }

    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess (between 1 and 100): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String checkGuess(int randomNumber, int userGuess) {
        if (userGuess < randomNumber) {
            return "Too low";
        } else if (userGuess > randomNumber) {
            return "Too high";
        } else {
            return "Correct!";
        }
    }
}
