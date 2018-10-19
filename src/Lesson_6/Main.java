package Lesson_6;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
           testTree();
        }
    }

    static void testTree() {
        Tree tree = new Tree();
        for (int i = 0; i < 100; i++) {
            tree.insert((int) (Math.random() * 100));
        }
    }
}
