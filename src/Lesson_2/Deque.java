package Lesson_2;

public class Deque {
    private int size;
    private int[] queue;
    private int front;
    private int rear;
    private int items;

    public Deque(int size) {
        this.size = size;

        queue = new int[size];
        front = 0;
        rear = -1;
        items = 0;
    }

    void addFirst(int value) {
        if (rear == size - 1) rear = -1;
        queue[++rear] = value;
        items++;
    }

    void addLast(int value) {
        if (front == size - 1) front = -1;
        queue[++front] = value;
        items++;
    }

    int removeFirst() {
        int tmp = queue[rear--];
        if (rear == size) rear = 0;
        items--;
        return tmp;
    }

    int removeLast() {
        int tmp = queue[front++];
        if (front == size) front = 0;
        items--;
        return tmp;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == size;
    }

    public int size() {
        return items;
    }
}
