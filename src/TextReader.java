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
    public KeyWordList UniqueReader(String filename, KeyWordList wordList, int stringSize) throws IOException {

        String[] keywordList = new String[stringSize];
        String keyword = "";

        try {
            File textToParse = new File(filename);
            Scanner scanner = new Scanner(textToParse);
            RemoveNonalpha removeNonalpha = new RemoveNonalpha();

            for (int i = 0; i < keywordList.length; i++) {
                keywordList[i] = removeNonalpha.RemoveNonalpha(scanner.next());
                keyword += keywordList[i] + " ";
            }

            keyword = keyword.strip();

            while (scanner.hasNext()) {
                String word = removeNonalpha.RemoveNonalpha(scanner.next());
                if (!word.isBlank()) {
                    wordList.foundWordSequence(keyword, word);
                    keyword = "";
                }
                for (int i = 1; i < keywordList.length; i++) {
                    keywordList[i - 1] = keywordList[i];
                    keyword += keywordList[i - 1] + " ";
                }
                keywordList[keywordList.length - 1] = word;
                keyword += word;
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return wordList;
    }
}
