/*
 *       Created by Alexander on 14/04/2020
 */

package Lesson5;

public class Exponentiation {
    public static int exp (int a, int n){
        if (n == 1) return a;
        return a *= exp(a, n - 1);
    }

    public static void main(String[] args) {
        int a = 2;
        int n = 8;
        System.out.println(a + " ^ " + n + " = " + exp(a, n));
    }
}


