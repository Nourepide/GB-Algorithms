package Lesson_2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Stack<Character> characters = new Stack<>();

            for (char c : scanner.nextLine().toCharArray()) {
                characters.push(c);
            }

            while (true) {
                try {
                    System.out.print(characters.pop());
                } catch (Exception e) {
                    break;
                }
            }

            // New line
            System.out.println();
        }
    }
}
