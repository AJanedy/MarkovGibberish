import java.util.HashSet;

public class KeyWordList {
    private Element first; // Pointer to the first element
    private Element last;  // Pointer to the last element
    private class Element {  // Nested class that handles a single string element
        String word;
        Element next;
        NextWordList nextWordList;
        public Element(String string) {
            word = string;
            next = null;
        }
    }
    // Constructor: makes an empty list
    public KeyWordList() {
        first = null;
        last = null;
    }
    // Takes a String, encapsulates it, adds it to the linked list
    public void add(String keyword, String nextWord) {

        Element capsule = new Element(keyword); // Make a new Element capsule
        capsule.nextWordList = new NextWordList();
        capsule.nextWordList.FoundNextWord(nextWord);

        // Makes this Element the last Element in the list
        if (last == null) { // Makes this Element first and last if list is empty
            first = capsule;
        }
        else {
            last.next = capsule; // Goes to last Element and points to this Element
        }
        last = capsule;
    }
    // Takes an index, gives me the element at that index
    public Element get(int index) {

        Element current = first;
       int currentIndex = 0;

       while (current != null) {
           if (currentIndex == index) {
               return current;
           }
           current = current.next;
           currentIndex++;
       }
       throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }
    // Returns the number of elements in the list
    public int getLength() {

        Element current = first;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
    public void addUnique(String keyword, String nextWord) {

        if (first == null) { // Makes this Element first and last if list is empty
            add(keyword, nextWord);
        }
        else {
            if (find(keyword) == -1) {
                add(keyword, nextWord);
            }
            else {
                get(find(keyword)).nextWordList.FoundNextWord(nextWord);
            }
        }
    }
    // Returns the index of the first instance of string
    public int find(String string) {

        int index = 0;
        Element current = first;
        if (current == null) {
            return index;
        }
        while (current != null) {
            if (string.compareToIgnoreCase(current.word) != 0) {
                index++;
                current = current.next;
            }
            else {
                return index;
            }
        }
        return -1;
    }
    // Takes String and an index, puts String at that index
//    public void put(String string, int index) {
//        if (index == 0) {
//            Element element = new Element(string);
//            element.next = first;
//            first = element;
//        }
//        else {
//            Element current = first;
//            int currentPosition = 0;
//
//            while (current != null && currentPosition < index - 1) {
//                current = current.next;
//                currentPosition++;
//            }
//            if (current != null) {
//                Element element = new Element(string);
//                element.next = current.next;
//                current.next = element;
//            }
//            else {
//                System.out.println("Invalid position.  Adding at the end of the list.");
//                add(string, null);
//            }
//        }
//    }
    // Prints out the whole list
    public void print() {
        // Start at the beginning, print out elements until we hit null
        Element element = first;
        while (element != null) {
            System.out.println(element.word + ":");
            //System.out.print("        ");
            element.nextWordList.print();
            element = element.next;
        }
    }
    public void foundWordSequence(String keyword, String nextWord) {
        addUnique(keyword, nextWord);
    }
    public String getRandomNextWord(String keyword) {
        Element current = first;
        String word = " ";
        while (current != null) {
            if (current.word.compareToIgnoreCase(keyword) == 0) {
                word = current.nextWordList.getRandomWord();
                break;
            }
            else {
                current = current.next;
            }
        }
        return word;
    }
}
