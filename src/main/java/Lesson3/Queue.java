/*
 *       Created by Alexander on 07/04/2020
 */

package Lesson3;

import java.util.EmptyStackException;

public class Queue<Item> {
    protected Item[] list;
    protected int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    protected int begin = 0;
    protected int end = 0;

    public Queue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("bad size");
        }
        list = (Item[])new Object[capacity];
    }

    public Queue() {
        list = (Item[])new Object[DEFAULT_CAPACITY];
    }

    // метод вставки
    public void insert(Item item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public Item remove() {
        Item value = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return value;
    }

    int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    protected Item peekFront() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[begin];
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public int size() {
        return size;
    }
}
