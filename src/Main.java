import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in); // Initialize Scanner object

        System.out.println("Welcome to the Markov gibberish generator.\n");
        System.out.println("This program will analyze a number of texts");
        System.out.println("and produce a sentence based on those texts.\n");
        System.out.println("Enter a number which will determine the amount");
        System.out.println("of words you can use in your search:");

        int stringSize = scanner.nextInt(); // int holding the size of the keyword string

        System.out.println("How many words long will this sentence be?: ");
        int sentenceLength = scanner.nextInt();

        KeyWordList uniqueWordList = new KeyWordList(); // Initialize KeyWordList object
        TextReader textReader = new TextReader(); // Initialize TextReader object
        uniqueWordList = textReader.UniqueReader("aliceInWonderland.txt", uniqueWordList, stringSize);
        uniqueWordList.print();

        System.out.println("Enter a string that is " + stringSize + " word(s) long: ");
        scanner.nextLine(); // Get to nextLine

        String startingWord = scanner.nextLine();
        String[] wordList = startingWord.split(" ");
        System.out.print(startingWord + " ");

        for (int i = 1; i < sentenceLength; i++) { // Iterating sentenceLength times to call to getRandomNextWord
            if (i % 20 == 0) {
                System.out.println();
            }
            String nextWord = uniqueWordList.getRandomNextWord(startingWord);
            System.out.print(nextWord + " ");
            startingWord = "";
            for (int j = 1; j < wordList.length; j++) {
                wordList[j - 1] = wordList[j];
                startingWord += wordList[j - 1] + " ";

            }
            wordList[wordList.length - 1] = nextWord;
            startingWord += nextWord;
        }
    }
}