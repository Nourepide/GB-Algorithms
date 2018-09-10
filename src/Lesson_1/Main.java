package Lesson_1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000000);
        }

        System.out.println("Generation is complete");

        new ArrayManipulator()
                .fill(array)
                .sortBubble()
                .getArray();

        System.out.println("Warming is complete");

        System.out.println(executionBubbleTime(array));
        System.out.println(executionSelectTime(array));
        System.out.println(executionInsertTime(array));

        // Output :
        //  250000~
        //  300000~
        //  16775~
    }

    private static void example() {
        int[] array = {1, 3, 4, 9};

        int[] result = new ArrayManipulator()
                .fill(array)                // [1, 3, 4, 9]
                .add(2)                     // [1, 3, 4, 9, 2]
                .delete(3)                  // [1, 3, 9, 2]
                .change(3, 5)    // [1, 3, 5, 2] == [9 -> 5]
                .addSort(4)                 // [1, 3, 4, 5, 2]
                .sortInsert()               // [1, 2, 3, 4, 5]
                .getArray();                // Input

        // Out
        System.out.println(Arrays.toString(result));
    }

    // ------------------------------------

    private static long executionBubbleTime(int[] array) {
        long st, en;
        st = System.nanoTime();

        new ArrayManipulator()
                .fill(array)
                .sortBubble()
                .getArray();

        en = System.nanoTime();
        return en - st;
    }

    private static long executionSelectTime(int[] array) {
        long st, en;
        st = System.nanoTime();

        new ArrayManipulator()
                .fill(array)
                .sortSelect()
                .getArray();

        en = System.nanoTime();
        return en - st;
    }

    private static long executionInsertTime(int[] array) {
        long st, en;
        st = System.nanoTime();

        new ArrayManipulator()
                .fill(array)
                .sortInsert()
                .getArray();

        en = System.nanoTime();
        return en - st;
    }
}
