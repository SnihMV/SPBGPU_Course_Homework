package ru.devj110.lab_3_3;

public class ExtendedList {

    private final int capacity;
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public Node getHeadNext() {
        return head.next;
    }

    public Node getTail() {
        return tail;
    }

    public Node getTailNext() {
        return tail.next;
    }

    public ExtendedList() {
        this(10);
    }

    public ExtendedList(int capacity) {
        this.capacity = capacity;
    }

    public void addToHead(Object value) {
        if (head != null) {
            if ((tail.next = head.addToHead(value)) != null)
                tail = tail.next;
            return;
        }
        head = tail = new Node(value);
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


    public void print() {
        Node aim = head;
        while (aim != null) {
            System.out.print(aim.toString() + (aim.next != null ? " --> " : ""));
            aim = aim.next;
        }
        System.out.println();
    }

    private class Node {
        Object[] array;
        int size;
        Node next;


        Node(Object value) {
            this.array = new Object[capacity];
            array[0] = value;
            this.size = 1;
        }

        void addToTail(Object value) {
            array[size++] = value;
        }

        Node addToHead(Object value) {
            if (!isFull()) {
                System.arraycopy(array, 0, array, 1, size++);
                array[0] = value;
                return null;
            }
            Object excess = array[size - 1];
            System.arraycopy(array, 0, array, 1, size - 1);
            array[0] = value;
            if (next==null)
                return new Node(excess);
            return next.addToHead(excess);
        }

        Object popFromTail() {
            return array[--size];
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                sb.append((array[i] != null ? array[i].toString() : "null") + (i < size - 1 ? "," : ""));
            }
            sb.append("]");
            return sb.toString();
        }

        public boolean isFull() {
            return size == capacity;
        }
    }
}
