import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Task2WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = "";

        System.out.println("Enter 'text' to provide input text, or 'file' to provide a file path:");
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("text")) {
            System.out.println("Enter your text:");
            inputText = scanner.nextLine();
        } else if (choice.equals("file")) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine().trim();
            try {
                inputText = readTextFromFile(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please check the file path and try again.");
                System.exit(1);
            }
        } else {
            System.out.println("Invalid choice. Please enter either 'text' or 'file'.");
            System.exit(1);
        }

        int wordCount = countWords(inputText);
        System.out.println("Total words: " + wordCount);

        scanner.close();
    }

    public static String readTextFromFile(String filePath) throws FileNotFoundException {
        StringBuilder text = new StringBuilder();
        Scanner fileScanner = new Scanner(new File(filePath));

        while (fileScanner.hasNextLine()) {
            text.append(fileScanner.nextLine()).append("\n");
        }

        fileScanner.close();
        return text.toString();
    }

    public static int countWords(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        // Split the text into words using space or punctuation as delimiters
        String[] words = text.split("[\\s.,;!?()\"'-]+");
        return words.length;
    }
}
