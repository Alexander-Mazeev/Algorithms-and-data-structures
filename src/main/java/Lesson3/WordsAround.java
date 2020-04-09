/*
 *       Created by Alexander on 07/04/2020
 */

package Lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordsAround {
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static void main(String[] args) {
        String input = null;
        while (true) {
            try {
                System.out.println("Enter phrase (Empty exit): ");
                input = getString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (input.equals("")) break;
            Stack<Character> stacks = new Stack(input.length());
            for (int i = 0; i < input.length(); i++) {
                stacks.push(input.charAt(i));
            }
            System.out.println();
            do{
                System.out.print(stacks.pop());
            } while (!stacks.isEmpty());
            System.out.println();
        }
    }
}
