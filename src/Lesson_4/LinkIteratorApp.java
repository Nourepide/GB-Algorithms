package Lesson_4;

public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkIterator iter = new LinkIterator(list);

        iter.insertAfter("Artem", 22);
        iter.insertBefore("Denis", 21);

        iter.atEnd();
        iter.deleteCurrent();
        iter.insertAfter("Test", 23);
        iter.nextLink();
        iter.insertBefore("Test 2", 25);
        iter.getCurrent().display();
    }
}
