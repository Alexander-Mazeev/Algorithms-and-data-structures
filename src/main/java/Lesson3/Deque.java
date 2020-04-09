/*
 *       Created by Alexander on 08/04/2020
 */

package Lesson3;

import java.util.EmptyStackException;

public class Deque<Item> extends Queue {

    public Deque(int capacity) {
        super(capacity);
    }

    public Deque() {
        super();
    }

    public void insertLeft(Item item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertRight(Item item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        int pInd = prevIndex();
        list[pInd] = item;
        end = nextIndex(end);
    }

    private int prevIndex() {
        if (list.length == size) {
            throw new StackOverflowError();
        }
        Item[] tempArr = (Item[]) new Object[list.length];
        System.arraycopy(list, 0, tempArr, 1, size);
        list = tempArr;
        list[0] = null;
        return 0;
    }

    public Item removeLeft() {
        Item value = (Item) peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return value;
    }

    public Item removeRight() {
        Item value = peekEnd();
        list[size] = null;
        size--;
        return value;
    }

    private Item peekEnd() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (Item) list[size];
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
