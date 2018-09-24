package Lesson_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramApp {
    private static char[] arr = new char[4];
    private static int size;
    private static int count;

    public static void main(String[] args) throws IOException {
        String input = getString();
        size = input.length();
        count = 0;

        for (int i = 0; i < size; i++) {
            arr[i] = input.charAt(i);
        }

        getAnagram(size);
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    private static void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
        }

        System.out.println();
    }

    private static void getAnagram(int newSize) {
        if (newSize == 1) return;
        for (int i = 0; i < newSize; i++) {
            getAnagram(newSize - 1);
            if (newSize == 2) display();
            rotate(newSize);
        }
    }

    private static void rotate(int newSize) {
        int i;
        int pos = size - newSize;
        char temp = arr[pos];
        for (i = pos + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }

        arr[i - 1] = temp;
    }
}
