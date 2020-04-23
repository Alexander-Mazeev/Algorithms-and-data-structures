/*
 *       Created by Alexander on 20/04/2020
 */

package Lesson6;

import java.util.Random;

public class MyTreeApp {
    public static void main(String[] args) {
        int count = 20;
        int balanced = 0;
        for (int i = 0; i < count; i++) {
            MyTree<Integer, Integer> mtm = new MyTree<>();
            initMyTree(mtm);
            System.out.println(mtm);
            if (mtm.isBalanced()) balanced++;
        }
        System.out.println("Из " + count + " деревьев сбалансированы " + balanced + ", несбалансированы " + (count - balanced) + " деревьев" + " (" + ((((float) (count - balanced)) * 100) / (float) count) + "%" + ")");
    }

    public static void initMyTree (MyTree<Integer, Integer> mtm){
        while (mtm.height() < 6){
            Integer number = randomInt(-100, 100);
            mtm.put(number, number);
        }
    }

    public static int randomInt (int minInt, int maxInt){
        Random random = new Random();
        return minInt + random.nextInt(maxInt - minInt);
    }
}
