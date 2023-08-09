import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class TextReader {

//    public KeyWordList TextReader(String filename, KeyWordList wordList) throws IOException {
//
//        try {
//            File textToParse = new File(filename);
//            Scanner scanner = new Scanner(textToParse);
//            RemoveNonalpha removeNonalpha = new RemoveNonalpha();
//
//            while (scanner.hasNext()) {
//                String word = scanner.next();
//                if (!word.isBlank()) {
//                    wordList.add(removeNonalpha.RemoveNonalpha(word));
//                }
//            }
//        }
//        catch (FileNotFoundException e) {
//            System.err.println("File not found: " + e.getMessage());
//        }
//        return wordList;
//    }
    public KeyWordList UniqueReader(String filename, KeyWordList wordList) throws IOException {

        try {
            File textToParse = new File(filename);
            Scanner scanner = new Scanner(textToParse);
            RemoveNonalpha removeNonalpha = new RemoveNonalpha();

            String keyword = removeNonalpha.RemoveNonalpha(scanner.next());

            while (scanner.hasNext()) {
                String word = removeNonalpha.RemoveNonalpha(scanner.next());
                if (!word.isBlank()) {
                    wordList.foundWordSequence(keyword, word);
                    keyword = word;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return wordList;
    }
}
