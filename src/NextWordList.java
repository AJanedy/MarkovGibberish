import java.util.Random;

public class NextWordList {
    private Element first; // Pointer to the first element
    private Element last;  // Pointer to the last element
    private class Element {  // Nested class that handles a single string element and a count of that String
        String word;
        int count = 0;
        Element next;
        public Element(String string) {
            word = string;
        }
    }
    // Constructor: makes an empty list
    public NextWordList() {
        first = null;
        last = null;
    }
    public void FoundNextWord(String nextWord) {
        Element current = first;
        boolean added = false;
        if (current == null) {
            added = true;
            Element element = new Element(nextWord);
            element.count++;
            first = element;
            last = element;
        }
        while (current != null) {
            if (nextWord.compareToIgnoreCase(current.word) == 0) {
                current.count++;
                added = true;
                break;
            }
            else {
                current = current.next;
            }
        }
        if (!added) {
            Element element = new Element(nextWord);
            element.count++;
            last.next = element;
            last = element;
        }
    }
    public void print() {
        // Start at the beginning, print out elements until we hit null
        Element element = first;
        while (element != null) {
            System.out.println("     " + element.word + " " + element.count);
            element = element.next;
        }
    }
    public String getRandomWord() {
        int totalCount = 0;
        int runnningCount = 0;

        Element current = first;
        while (current != null) {
            totalCount += current.count;
            current = current.next;
        }
        Random random = new Random();
        int choice = random.nextInt(totalCount + 1);

        current = first;
        while (current != null) {
            runnningCount += current.count;

            if (runnningCount >= choice) {
                return current.word;
            }
            else {
                current = current.next;
            }
        }
        return "";
    }
}
