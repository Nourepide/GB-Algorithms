package Lesson_1;

import javafx.util.Pair;

class ArrayManipulator {

    FilledArrayManipulator fill(int[] array) {
        return new FilledArrayManipulator(array);
    }

    protected class FilledArrayManipulator {
        private int[] array;

        FilledArrayManipulator(int[] array) {
            this.array = array;
        }

        int[] getArray() {
            return array;
        }

        private void setArray(int[] array) {
            this.array = array;
        }

        FilledArrayManipulator add(int value) {
            int[] newArray = new int[array.length + 1];

            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[array.length] = value;

            setArray(newArray);
            return this;
        }

        FilledArrayManipulator addSort(int value) {
            int[] newArray = new int[array.length + 1];

            Integer index = find(value - 1).getValue();

            if (index >= 0) System.arraycopy(array, 0, newArray, 0, index);

            newArray[index] = value;

            if (index >= 0) System.arraycopy(array, index, newArray, index + 1, array.length - index);

            setArray(newArray);

            return this;
        }

        FilledArrayManipulator delete(int index) {
            int[] newArray = new int[array.length - 1];

            if (index >= 0) System.arraycopy(array, 0, newArray, 0, index - 1);
            if (newArray.length - index >= 0)
                System.arraycopy(array, index, newArray, index - 1, newArray.length - index + 1);

            setArray(newArray);

            return this;
        }

        FilledArrayManipulator change(int index, int value) {
            array[index - 1] = value;

            return this;
        }

        Pair<FilledArrayManipulator, Integer> find(int value) {
            // Index -1 equals "Not found"
            int index = -1;

            for (int i = 0; i < array.length; i++) {
                if (array[i] == value) {
                    index = i;
                    break;
                }
            }

            return new Pair<>(this, index != -1 ? index + 1 : index);
        }

        Pair<FilledArrayManipulator, Integer> binaryFind(int value) {
            int min = 0;
            int max = array.length - 1;
            int index = -1;

            while (min < max) {
                index = (min + max) / 2;

                if (value == array[index]) {
                    break;
                } else {
                    if (value < array[index]) {
                        min = index;
                    } else {
                        min = index + 1;
                    }
                }
            }

            return new Pair<>(this, index != -1 ? index + 1 : index);
        }

        FilledArrayManipulator sortBubble() {
            for (int out = array.length - 1; out > 0; out--) {
                for (int in = 0; in < out; in++) {
                    if (array[in] > array[in + 1]) {
                        swap(in, in + 1);
                    }
                }
            }

            return this;
        }

        FilledArrayManipulator sortSelect() {
            int mark;

            for (int out = 0; out < array.length; out++) {
                mark = out;

                for (int in = out + 1; in < array.length; in++) {
                    if (array[in] < array[mark]) {
                        mark = in;
                    }
                }

                swap(out, mark);
            }

            return this;
        }

        FilledArrayManipulator sortInsert() {
            for (int out = 1; out < array.length; out++) {
                int tmp = array[out];
                int in = out;

                while (in > 0 && array[in - 1] >= tmp) {
                    array[in] = array[in - 1];
                    --in;
                }

                array[in] = tmp;
            }

            return this;
        }

        void swap(int indexMin, int indexMax) {
            int min = array[indexMin];
            int max = array[indexMax];

            array[indexMin] = max;
            array[indexMax] = min;
        }
    }
}
