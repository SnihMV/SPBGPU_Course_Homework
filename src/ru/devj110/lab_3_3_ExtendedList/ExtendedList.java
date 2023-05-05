package ru.devj110.lab_3_3_ExtendedList;


import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import static java.lang.Math.min;

public class ExtendedList<E> implements Iterable<E> {

    private static final int DEFAULT_NODE_CAPACITY = 10;
    private final int nodeCapacity;
    private Node<E> head;
    private Node<E> tail;


    public ExtendedList(int nodeCapacity) {
        if (nodeCapacity <= 0)
            throw new IllegalArgumentException("Node capacity must be > 0");
        this.nodeCapacity = nodeCapacity;
        head = tail = new Node<E>();
    }

    public ExtendedList() {
        this(DEFAULT_NODE_CAPACITY);
    }

    public ExtendedList(E[] array, int nodeCapacity) {
        this(nodeCapacity);
        int rest = array.length;
        Node<E> node = head;
        while (true) {
            int srcPos = array.length - rest;
            int copiedLength = min(nodeCapacity, rest);
            System.arraycopy(array, srcPos, node.dataHolder, 0, copiedLength);
            rest -= copiedLength;
            node.size += copiedLength;
            if (rest > 0) {
                node.next = new Node<E>();
                node = node.next;
            } else {
                tail = node;
                break;
            }
        }
    }

    public ExtendedList(E[] array) {
        this(array, DEFAULT_NODE_CAPACITY);
    }

    public void addToHead(E value) {
        Node<E> node = head;
        E tmp;
        while (node != null) {
            if (!node.isFull()) {
                node.addToHead(value);
                return;
            }
            tmp = node.popLast();
            node.addToHead(value);
            value = tmp;
            if (node == tail) {
                tail = new Node<E>(value);
                node.next = tail;
                return;
            }
            node = node.next;
        }
    }

    public void recursiveAddToHead(E value) {
        if ((tail.next = head.recursiveAddToHead(value)) != null)
            tail = tail.next;
    }

    public void addToTail(E value) {
        if (!tail.isFull())
            tail.addToTail(value);
        else
            tail = tail.next = new Node<E>(value);
    }

    public E peekFromHead() {
        if (!head.isEmpty())
            return head.peekFirst();
        throw new NoSuchElementException("List is empty");
    }

    public E peekFromTail() {
        if (!tail.isEmpty())
            return tail.peekLast();
        throw new NoSuchElementException("List is empty");
    }

    public E popFromHead() {
        if (head.isEmpty())
            throw new NoSuchElementException("List is empty. Nothing to pop from its head");
        Node<E> node = head;
        E res = node.popElement(0);
        pullUp(node);
        return res;
    }

    public E popFromTail() {
        if (tail.isEmpty())
            throw new NoSuchElementException("List is empty. Nothing to pop from its tail");
        E res = tail.popLast();
        if (tail.isEmpty()) {
            if (head != tail) {
                Node<E> node = head;
                while (!node.next.isEmpty())
                    node = node.next;
                node.next = null;
                tail = node;
            }
        }
        return res;
    }

    private Address getAddress(E value) {
        if (!head.isEmpty()) {
            Node<E> node = head;
            while (node != null) {
                int pos = -1;
                if ((pos = node.getPosWith(value)) != -1)
                    return new Address(node, pos);
                node = node.next;
            }
        }
        return null;
    }

    private Node<E> getNodeWith(E value) {
        return getAddress(value) != null ? getAddress(value).getNode() : null;
    }

    public boolean contains(E value) {
        return getNodeWith(value) != null;
    }

    public boolean isEmpty() {
        return head.isEmpty();
    }

    public void remove(E value) {
        if (isEmpty())
            return;
        Node<E> node = head;

        while (node != null) {
            int pos = node.getPosWith(value);
            if (pos >= 0) {
                node.popElement(pos);
                pullUp(node);
                return;
            }
            node = node.next;
        }
    }

    private void pullUp(Node<E> node) {
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

    public void addArrayToHeadSimple(E[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            addToHead(array[i]);
        }
    }

    public void addArrayToTailSimple(E[] array) {
        for (int i = 0; i < array.length; i++) {
            addToTail(array[i]);
        }
    }

    public void addArrayToHead(E[] array) {
        if (array.length == 0)
            return;
        ExtendedList<E> that = new ExtendedList<>(array, nodeCapacity);
        that.tail.next = this.head;
        this.head = that.head;
        if (!that.tail.isFull())
            pullUp(that.tail);
    }

    public void addArrayToTail(E[] array) {
        if (array.length == 0)
            return;
        ExtendedList<E> that = new ExtendedList<>(array, nodeCapacity);
        this.tail.next = that.head;
        if (!this.tail.isFull())
            pullUp(this.tail);
        this.tail = that.tail;
    }

    public void addCollectionToHead(Iterable<E> collection) {
        if (collection == null)
            throw new IllegalArgumentException("Input collection is null");
        ExtendedList<E> tmp = new ExtendedList(nodeCapacity);
        for (E value : collection) {
            tmp.addToTail(value);
        }
        consumeToHead(tmp);
    }

    public void addCollectionToTail(Iterable<E> collection) {
        if (collection == null)
            throw new IllegalArgumentException("Input collection is null");
        for (E value : collection) {
            addToTail(value);
        }
    }

    public void consumeToHead(ExtendedList<E> list) {
        ExtendedList<E> that = list;
        if (list.nodeCapacity != this.nodeCapacity)
            that = list.restructure(this.nodeCapacity);
        that.tail.next = this.head;
        if (!that.tail.isFull())
            pullUp(that.tail);
        this.head = that.head;
        list.head = list.tail = null;
    }

    public void consumeToTail(ExtendedList<E> list) {
        ExtendedList<E> that = list;
        if (that.nodeCapacity != this.nodeCapacity)
            that = list.restructure(this.nodeCapacity);
        this.tail.next = that.head;
        if (!this.tail.isFull())
            pullUp(this.tail);
        this.tail = that.tail;
        list.head = list.tail = null;
    }

    public ExtendedList<E> restructure(int nodeCapacity) {
        ExtendedList<E> tmp = new ExtendedList<>(nodeCapacity);
        while (!isEmpty()) {
            tmp.addToTail(popFromHead());
        }
        return tmp;
    }

    public void convertAll(Converter<E, ? extends E> c) {
        Node<E> node = head;
        while (node != null) {
            node.convert(c);
            node = node.next;
        }
    }

    public void print() {
        Node<E> node = head;
        while (node != null) {
            System.out.print(node + (node.next != null ? " --> " : ""));
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public Iterator<E> iterator() {
        return new XListIterator<>(new Address(head,0));
    }

    public Iterable<E> after(E value) {
        return () -> new XListIterator<>(getAddress(value));
    }


    private class Node<E> {
        E[] dataHolder;
        int size;
        Node<E> next;

        Node() {
            this.dataHolder = (E[]) new Object[nodeCapacity];
        }

        Node(E value) {
            this();
            addToTail(value);
        }

        Node(E[] array) {
            this();
            if (array.length > nodeCapacity)
                throw new IllegalArgumentException("Incorrect array length");
            System.arraycopy(array, 0, dataHolder, 0, array.length);
            this.size += array.length;
        }


        void addToTail(E value) {
            dataHolder[size++] = value;
        }

        void addToHead(E value) {
            System.arraycopy(dataHolder, 0, dataHolder, 1, size++);
            dataHolder[0] = value;
        }

        Node<E> recursiveAddToHead(E value) {
            if (!isFull()) {
                addToHead(value);
                return null;
            }
            E excess = dataHolder[size - 1];
            System.arraycopy(dataHolder, 0, dataHolder, 1, size - 1);
            dataHolder[0] = value;
            if (next == null)
                return new Node<E>(excess);
            return next.recursiveAddToHead(excess);
        }

        E peekFirst() {
            return dataHolder[0];
        }

        E peekLast() {
            return dataHolder[size - 1];
        }

        E popLast() {
            return dataHolder[--size];
        }

        E popElement(int pos) {
            E res = dataHolder[pos];
            System.arraycopy(dataHolder, pos + 1, dataHolder, pos, --size - pos);
            return res;
        }


        public void pullUp() {
            int lack = nodeCapacity - size;
            int moved = min(lack, next.size);
            System.arraycopy(next.dataHolder, 0, this.dataHolder, size, moved);
            System.arraycopy(next.dataHolder, moved, next.dataHolder, 0, next.size - moved);
            this.size += moved;
            next.size -= moved;
        }

        public void convert(Converter<E, ? extends E> c) {
            for (int i = 0; i < size; i++) {
                dataHolder[i] = c.convert(dataHolder[i]);
            }
        }

        public boolean contains(E value) {
            return getPosWith(value) != -1;
        }

        private int getPosWith(E value) {
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
                sb.append((dataHolder[i] != null ? dataHolder[i].toString() : "null") + (i < size - 1 ? ", " : ""));
            }
            sb.append("]");
            return sb.toString();
        }
    }

    private class XListIterator<E> implements Iterator<E> {
        private Node<E> nxtNode;
        private int nxtPos;


        public XListIterator(Address address) {
            if (address != null) {
                this.nxtNode = address.getNode();
                this.nxtPos = address.getPosition();
            }
        }

        @Override
        public boolean hasNext() {
            return nxtNode != null ? nxtNode.size - 1 >= nxtPos : false;
        }

        @Override
        public E next() {
            E res = nxtNode.dataHolder[nxtPos];
            if (nxtNode.size - 1 == nxtPos && nxtNode.next != null) {
                nxtNode = nxtNode.next;
                nxtPos = 0;
            } else
                nxtPos++;
            return res;
        }
    }

    private class Address<E> {
        private final Node<E> node;
        private final int position;

        public Address(Node<E> node, int position) {
            this.node = node;
            this.position = position;
        }

        public Node<E> getNode() {
            return node;
        }

        public int getPosition() {
            return position;
        }
    }
}
