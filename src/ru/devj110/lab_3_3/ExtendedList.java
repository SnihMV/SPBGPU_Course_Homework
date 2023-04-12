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

    private Node biteOff(Object[] array, int srcPos) {
        Object[] res = new Object[nodeCapacity];
        System.arraycopy(array, srcPos, res, 0, nodeCapacity);
        return new Node(res);
    }

    public void addToHead(Object value) {
        Node node = head;
        Object tmp;
        while (node != null) {
            if (!node.isFull()) {
                node.addToHead(value);
                return;
            }
            tmp = node.popLast();
            node.addToHead(value);
            value = tmp;
            if (node == tail) {
                tail = new Node(value);
                node.next = tail;
                return;
            }
            node = node.next;
        }
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
            throw new NoSuchElementException("List is empty. Nothing to pop from its head");
        Node node = head;
        Object res = node.popElement(0);
        pullUp(node);
        return res;
    }

    public Object popFromTail() {
        if (tail.isEmpty())
            throw new NoSuchElementException("List is empty. Nothing to pop from its tail");
        Object res = tail.popLast();
        if (tail.isEmpty()) {
            if (head != tail) {
                Node node = head;
                while (!node.next.isEmpty())
                    node = node.next;
                node.next = null;
                tail = node;
            }
        }
        return res;
    }

    public boolean contains(Object value) {
        if (!head.isEmpty()) {
            Node node = head;
            while (node != null) {
                if (node.contains(value) != -1)
                    return true;
                node = node.next;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return head.isEmpty();
    }

    public void remove(Object value) {
        if (isEmpty())
            return;
        Node node = head;
        while (node != null) {
            if (node.remove(value)) {
                pullUp(node);
                break;
            }
            node = node.next;
        }
    }

    private void pullUp(Node node) {
        while (node.next != null) {
            node.pullUp();
            if (node.next.isEmpty()) {
                node.next = null;
                tail = node;
                break;
            }
            node = node.next;
        }
    }

    /*public void addArrayToHead(Object[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            addToHead(array[i]);
        }
    }*/


    public void convertAll(Converter c) {
        Node node = head;
        while (node != null) {
            node.convert(c);
            node = node.next;
        }
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node + (node.next != null ? " --> " : ""));
            node = node.next;
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

        Node(Object[] array) {
            if (array.length != nodeCapacity)
                throw new IllegalArgumentException("Incorrect array length");
            this.dataHolder = array;
            this.size = nodeCapacity;
        }

        Node() {
            this.dataHolder = new Object[nodeCapacity];
        }

        void addToTail(Object value) {
            dataHolder[size++] = value;
        }

        void addToHead(Object value) {
            System.arraycopy(dataHolder, 0, dataHolder, 1, size++);
            dataHolder[0] = value;
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

        Object peekFirst() {
            return dataHolder[0];
        }

        Object peekLast() {
            return dataHolder[size - 1];
        }

        Object popLast() {
            return dataHolder[--size];
        }

        Object popElement(int pos) {
            Object res = dataHolder[pos];
            System.arraycopy(dataHolder, pos + 1, dataHolder, pos, --size - pos);
            return res;
        }

        public boolean remove(Object value) {
            int i;
            if ((i = contains(value)) != -1) {
                popElement(i);
                return true;
            }
            return false;
        }

        public void pullUp() {
            int lack = nodeCapacity - size;
            int moved = next.size >= lack ? lack : next.size;
            System.arraycopy(next.dataHolder, 0, this.dataHolder, size, moved);
            System.arraycopy(next.dataHolder, moved, next.dataHolder, 0, next.size - moved);
            this.size += moved;
            next.size -= moved;
        }

        public void convert(Converter c) {
            for (int i = 0; i < size; i++) {
                dataHolder[i] = c.convert(dataHolder[i]);
            }
        }

        public int contains(Object value) {
            for (int i = 0; i < size; i++) {
                if (dataHolder[i] != null && dataHolder[i].equals(value) || dataHolder[i] == null && value == null)
                    return i;
            }
            return -1;
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
