package ru.devj110.lab_3_3;

import java.util.Arrays;

public class ExtendedList {

    private final int capacity;
    private Node head;
    private Node tail;

    public ExtendedList() {
        this(10);
    }

    public ExtendedList(int capacity) {
        this.capacity = capacity;
    }

    public void addToHead(Object value) {

    }

    public void addToTail(Object value) {
        if (tail == null) {
            head = tail = new Node(value);
            return;
        }
        if (!tail.isFull()) {
            tail.addToTail(value);
            return;
        }
        tail = tail.next = new Node(value);
    }


    public void print(){
        Node aim = head;
        while (aim!=null){
            System.out.print(aim.toString() + (aim.next!=null?" --> ":""));
            aim=aim.next;
        }
        System.out.println();
    }

    private class Node {
        Object[] array;
        int volume;
        Node next;

        Node(Object value) {
            this.array = new Object[capacity];
            array[0] = value;
            this.volume = 1;
        }

        void addToTail(Object value) {
            array[volume++] = value;
        }

        void addToHead(Object value) {
            System.arraycopy(array, 0, array, 1, volume);
            array[0] = value;
            volume++;
        }

        @Override
        public String toString() {
            return Arrays.toString(array);
        }

        public boolean isFull() {
            return volume == capacity;
        }
    }
}
