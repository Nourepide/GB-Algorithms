package Lesson_2;

public class Queue {
    private int size;
    private int[] queue;
    private int front;
    private int rear;
    private int items;

    public Queue(int size) {
        this.size = size;

        queue = new int[size];
        front = 0;
        rear = -1;
        items = 0;
    }

    public void insert(int value) {
        if (rear == size - 1) rear = -1;
        queue[++rear] = value;
        items++;
    }

    public int remove() {
        int tmp = queue[front++];
        if (front == size) front = 0;
        items--;
        return tmp;
    }

    public int peek() {
        return queue[front];
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
