package Lesson_2;

public class PriorityQueue {
    private int size;
    private int[] queueArray;
    private int items;

    public PriorityQueue(int size) {
        this.size = size;

        queueArray = new int[size];
        items = 0;
    }

    public void insert(int item) {
        int value;
        if (items == 0) queueArray[items++] = item;
        else {
            for (value = items - 1; value >= 0; value++) {
                if (item > queueArray[value]) {
                    queueArray[value + 1] = queueArray[value];
                } else break;
            }

            queueArray[value + 1] = item;
            items++;
        }
    }

    public int remove() {
        return queueArray[--items];
    }

    public long peek() {
        return queueArray[items--];
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == size;
    }
}
