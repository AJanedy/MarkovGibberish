import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //KeyWordList keyWordList = new KeyWordList();
        KeyWordList uniqueWordList = new KeyWordList();
        //NextWordList nextWordList = new NextWordList();
        TextReader textReader = new TextReader();


        uniqueWordList = textReader.UniqueReader("this.txt", uniqueWordList);

        uniqueWordList.print();
//        nextWordList.FoundNextWord("you");
//        nextWordList.FoundNextWord("you");
//        nextWordList.FoundNextWord("do");
//        nextWordList.FoundNextWord("get");
//        nextWordList.FoundNextWord("you");
//        nextWordList.FoundNextWord("goodbye");
//        nextWordList.print();

        //uniqueWordList.getRandomNextWord("this");
        System.out.println("Enter a starting word:");
        Scanner scanner = new Scanner(System.in);
        String startingWord = scanner.nextLine();
        System.out.print(startingWord + " ");

        for (int i = 1; i < 50; i++) {
            if (i % 20 == 0) {
                System.out.println();
            }
            String nextWord = uniqueWordList.getRandomNextWord(startingWord);
            System.out.print(nextWord + " ");
            startingWord = nextWord;
        }
    }
}