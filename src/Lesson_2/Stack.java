package Lesson_2;

public class Stack {
    private int size;
    private int[] stack;
    private int top;

    public Stack(int size) {
        this.size = size;

        stack = new int[size];
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

    void push(int value) {
        stack[++top] = value;
    }

    int pop() {
        return stack[top--];
    }

    int peek() {
        return stack[top];
    }


}
