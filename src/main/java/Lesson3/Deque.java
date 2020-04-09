/*
 *       Created by Alexander on 08/04/2020
 */

package Lesson3;

import java.util.EmptyStackException;

public class Deque<Item> extends Queue {

    private int tmpEnd = 0;

    public Deque(int capacity) {
        super(capacity);
        end = list.length - 1;
    }

    public Deque() {
        super();
    }

    public void insertLeft(Item item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        list[begin] = item;
        begin = nextIndex(begin);
    }

    public void insertRight(Item item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        list[end] = item;
        end = prevIndex(end);
    }

    private int prevIndex(int index) {
        if (list.length == size) {
            throw new StackOverflowError();
        }
        return --index;
    }

    public Item removeLeft() {
        Item value = (Item) peekFront();
        size--;
        list[begin] = null;
        return value;
    }
    @Override
    protected Item peekFront() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        if (size == list.length ){
            begin = 0;
        }
        else ++begin;
        return (Item) list[begin];
    }

    public Item removeRight() {
        Item value = peekEnd();
        list[tmpEnd] = null;
        size--;
        return value;
    }

    private Item peekEnd() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        if (tmpEnd == 0){
            tmpEnd = list.length - 1;
            end = 1;
        }
        else tmpEnd = list.length - end;
        Item tmpItem = (Item) list[tmpEnd];
        end ++;
        return tmpItem ;
    }

    public void printDeque() {
        for (Object o : list) {
            if (o != null) {
                System.out.print(o.toString() + "\t");
            }
        }
    }
}

class MainDeque {
    public static void main(String[] args) {
        Deque<Character> deque = new Deque(5);

        deque.insertLeft('A');
        deque.insertLeft('B');
        deque.insertRight('C');
        deque.insertRight('D');
        deque.insertLeft('I');

        deque.printDeque();
        System.out.println();

        System.out.println(deque.removeLeft());
        System.out.println(deque.removeRight());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.remove());
    }
}
