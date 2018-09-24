package Lesson_5;

public class Exponentiation {
    static int pow(int value, int power) {
        if (power == 1) {
            return value;
        } else {
            return value * pow(value, power - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(pow(4, 2));
    }
}
