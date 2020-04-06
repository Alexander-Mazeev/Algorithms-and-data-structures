/*
 *       Created by Alexander on 01/04/2020
 */

package Lesson2;

import java.util.Scanner;

public class Array {
    private int sizeArr;
    private int[] arr;

    public Array(int sizeArr, boolean boolRandom) {
        this.sizeArr = sizeArr;
        this.arr = new int[sizeArr];
        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = (boolRandom) ? (int) (Math.random() * 100) : (i + 1);
        }
    }

    public Array (int sizeArr){
        this.sizeArr = sizeArr;
        this.arr = new int[sizeArr];
    }

    public void printArray (){
        for (int i = 0; i < this.sizeArr; i++) {
            System.out.print(this.arr[i] + "\t");
        }
        System.out.println();
    }

    public int findElement (int element){
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == element){
                return i;
            }
        }
        return -1;
    }

    public void delElement (int element){
        if (findElement(element) != -1){
            int tempElement = findElement(element);
            int temp;
            for (int i = tempElement; i < this.arr.length; i++) {
                if ((i + 1) == this.arr.length)  {
                    this.sizeArr --;
                    break;
                }
                temp = this.arr[i + 1];
                this.arr[i] = temp;
            }
        }
        else System.out.println("Not found element = " + element);
    }

    public static int inputElement(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input element:");
        return sc.nextInt();
    }

    public void insertElement(int element){
        int i;
        for(i = 0; i < this.sizeArr; i++) {
            if (this.arr[i] > element) {
                break;
            }
        }
        for (int j = this.sizeArr; j > i; j--){
            this.arr[j] = this.arr[j - 1];
        }
        this.arr[i] = element;
        this.sizeArr++;
    }

    public void sortBubble(){
        for (int out = this.sizeArr - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(this.arr[in] > this.arr[in + 1])
                    change(in, in + 1);
            }
        }
    }

    private void change(int first, int second){
        int temp = this.arr[first];
        this.arr[first] = this.arr[second];
        this.arr[second] = temp;
    }

    public void sortInsert(){
        for (int left = 0; left < this.arr.length; left++) {
            int element = this.arr[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (element < this.arr[i]) {
                    this.arr[i + 1] = this.arr[i];
                } else {
                    break;
                }
            }
            this.arr[i + 1] = element;
        }
    }

    public void sortSelect(){
        int mark;
        for(int out = 0; out < this.sizeArr; out++){
            mark = out;
            for(int in = out + 1; in < this.sizeArr; in++){
                if (this.arr[in] < this.arr[mark]){
                    mark = in;
                }
            }
            change(out, mark);
        }
    }


}

class ArryaMain{
    public static void main(String[] args) {
//        Array arr = new Array(1000000, false);
//        System.out.println("Array:");
//        arr.printArray();

//        System.out.print("Size array ");
//        int sizeArray = Array.inputElement();
//        Array arr2 = new Array(sizeArray, true);
//        arr2.printArray();
//        System.out.println();
//        System.out.print("For find ");
//        int findElement = arr2.inputElement();
//        System.out.println("Find element = " + findElement + " array[" + arr2.findElement(findElement) + "] = " + findElement);
//        System.out.print("For delete ");
//        int delElement = arr2.inputElement();
//        arr2.delElement(delElement);
//        arr2.printArray();
//        System.out.print("For insert ");
//        int insElement = arr2.inputElement();
//        arr2.insertElement(insElement);
//        arr2.printArray();

        int sizeArray = 1000; //Array.inputElement();
        Array arr3 = new Array(sizeArray, true);
        System.out.println("Sort bubble:");
        arr3.printArray();
        long time = System.currentTimeMillis();
        arr3.sortBubble();
        System.out.println("Time sorting:" + (System.currentTimeMillis() - time));
        arr3.printArray();
        System.out.println("Sort insert:");
        Array arr4 = new Array(sizeArray, true);
        arr4.printArray();
        time = System.currentTimeMillis();
        arr4.sortInsert();
        System.out.println("Time sorting:" + (System.currentTimeMillis() - time));
        arr4.printArray();
        System.out.println("Sort select:");
        Array arr5 = new Array(sizeArray, true);
        arr5.printArray();
        time = System.currentTimeMillis();
        arr5.sortSelect();
        System.out.println("Time sorting:" + (System.currentTimeMillis() - time));
        arr5.printArray();
    }
}
