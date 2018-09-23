package Lesson_4;

public class Queue {
    private LinkedList list;

    public Queue() {
        list = new LinkedList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void insert(String name, int age) {
        list.insert(name, age);
    }

    public Link delete() {
        return list.delete();
    }

    public void display() {
        list.display();
    }
}
