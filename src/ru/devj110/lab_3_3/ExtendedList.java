package ru.devj110.lab_3_3;

import java.util.NoSuchElementException;

public class ExtendedList {

    private static final int DEFAULT_NODE_CAPACITY = 10;
    private final int nodeCapacity;
    private Node head;
    private Node tail;


    public ExtendedList(int nodeCapacity) {
        this.nodeCapacity = nodeCapacity;
        head = tail = new Node();
    }

    public ExtendedList() {
        this(DEFAULT_NODE_CAPACITY);
    }

    public void recursiveAddToHead(Object value) {
        if ((tail.next = head.recursiveAddToHead(value)) != null)
            tail = tail.next;
    }

    public void addToTail(Object value) {
        if (!tail.isFull())
            tail.addToTail(value);
        else
            tail = tail.next = new Node(value);
    }

    public Object peekFromHead() {
        if (!head.isEmpty())
            return head.peekFirst();
        throw new NoSuchElementException("List is empty");
    }

    public Object peekFromTail() {
        if (!tail.isEmpty())
            return tail.peekLast();
        throw new NoSuchElementException("List is empty");
    }

    public Object popFromHead() {
        if (head.isEmpty())
            throw new NoSuchElementException("List is empty. Nothing to pop from head");
        Node aim = head;
        Object res = aim.popFirst();
        while (aim.next != null) {
            aim.addToTail(aim.next.popFirst());
            if (aim.next.isEmpty()) {
                aim.next = null;
                tail = aim;
                break;
            }
            aim = aim.next;
        }
        return res;
    }

    public Object popFromTail() {
        if (tail.isEmpty())
            throw new NoSuchElementException("List is empty. Nothing to pop from its tail");
        Object res = tail.popLast();
        if (tail.isEmpty()) {
            if (head != tail) {
                Node aim = head;
                while (!aim.next.isEmpty())
                    aim = aim.next;
                aim.next = null;
                tail = aim;
            }
        }
        return res;
    }


    public void print() {
        Node aim = head;
        while (aim != null) {
            System.out.print(aim.toString() + (aim.next != null ? " --> " : ""));
            aim = aim.next;
        }
        System.out.println();
    }

    private class Node {
        Object[] dataHolder;
        int size;
        Node next;


        Node(Object value) {
            this();
            addToTail(value);
        }

        Node() {
            this.dataHolder = new Object[nodeCapacity];
        }

        void addToTail(Object value) {
            dataHolder[size++] = value;
        }

        Node recursiveAddToHead(Object value) {
            if (!isFull()) {
                addToHead(value);
                return null;
            }
            Object excess = dataHolder[size - 1];
            System.arraycopy(dataHolder, 0, dataHolder, 1, size - 1);
            dataHolder[0] = value;
            if (next == null)
                return new Node(excess);
            return next.recursiveAddToHead(excess);
        }

        void addToHead(Object value) {
            System.arraycopy(dataHolder, 0, dataHolder, 1, size++);
            dataHolder[0] = value;
        }

        Object peekFirst() {
            return dataHolder[0];
        }

        Object peekLast() {
            return dataHolder[size - 1];
        }

        Object popLast() {
            return dataHolder[--size];
        }

        Object popFirst() {
            Object res = dataHolder[0];
            System.arraycopy(dataHolder, 1, dataHolder, 0, --size);
            return res;
        }

        Object recursivePopFirst() {
            if (next == null) {
                return popFirst();
            }
            Object res = dataHolder[0];
            System.arraycopy(dataHolder, 1, dataHolder, 0, --size);
            addToTail(recursivePopFirst());
            return res;
        }

        public boolean isFull() {
            return size == nodeCapacity;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                sb.append((dataHolder[i] != null ? dataHolder[i].toString() : "null") + (i < size - 1 ? "," : ""));
            }
            sb.append("]");
            return sb.toString();
        }

    }
}
