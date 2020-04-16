/*
 *       Created by Alexander on 14/04/2020
 */

package Lesson5;

public class MyArr {
    private int[] arr;
    private int size;

    public MyArr(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    public int getSizeArr() {
        return arr.length;
    }

    public void binaryFind(int search) throws Exception {
        int index = recBinaryFind(search, 0, size-1);
        if (index > -1){
            System.out.println(true + " - index = " + index);
        } else throw new Exception("Not search index for " + search);
    }

    private int recBinaryFind(int searchKey, int low, int high) {
        int curIn;
        curIn = (low + high ) / 2;
        if (arr[curIn] == searchKey)
            return curIn;
        else
        if(low > high)
            return -1;
        else{
            if(arr[curIn] < searchKey)
                return recBinaryFind(searchKey, curIn+1, high);
            else
                return recBinaryFind(searchKey, low, curIn-1);
        }
    }

    public void insert(int value){
        int i;
        for(i=0; i < this.size; i++){
            if (this.arr[i] > value)
                break;
        }
        for(int j = this.size; j > i; j--){
            this.arr[j] = this.arr[j - 1];
        }
        this.arr[i] = value;
        this.size++;
    }
}

class MyArrApp {
    public static void main(String[] args) {
        MyArr arr = new MyArr(50);
        for (int i = 0; i < arr.getSizeArr(); i++) {
            arr.insert(i + 1);
        }

        int search = 50;

        try {
            arr.binaryFind(search);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
