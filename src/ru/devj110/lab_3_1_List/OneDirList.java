package ru.devj110.lab_3_1_List;

import java.util.Iterator;
import java.util.Objects;

public class OneDirList<T> implements Iterable<T> {
    private ListItem<T> head;
    private ListItem<T> tail;

    public void addToTail(T value) {
        if (tail != null)
            tail = tail.next = new ListItem<>(value);
        else
            head = tail = new ListItem<>(value);
    }

    public void addToHead(T value) {
        if (head == null)
            head = tail = new ListItem<>(value);
        else {
            ListItem<T> newHead = new ListItem<>(value);
            newHead.next = head;
            head = newHead;
        }
    }

    public T peekFromHead() {
        return head == null ? null : head.value;
    }

    public T peekFromTail() {
        return tail == null ? null : tail.value;
    }

    public T popFromHead() {
        if (head == null)
            return null;
        T res = head.value;
        if (head == tail)
            head = tail = null;
        else head = head.next;
        return res;
    }

    public T popFromTail() {
        if (tail == null)
            return null;
        T res = tail.value;
        if (head == tail) {
            head = tail = null;
            return res;
        }
        ListItem<T> aim = head;
        while (aim.next != tail)
            aim = aim.next;
        tail = aim;
        tail.next = null;
        return res;
    }

    public void remove(T value) {
        if (head == null)
            return;
        if (head.isTheSame(value)) {
            popFromHead();
            return;
        }

        ListItem<T> prevTrg = head;
        ListItem<T> aim = prevTrg.next;
        while (aim != null) {
            if (aim.isTheSame(value)) {
                if (aim == tail) {
                    tail = prevTrg;
                    tail.next = null;
                } else
                    prevTrg.next = aim.next;
                return;
            }
        }
    }

    private ListItem<T> findItem(T value) {
        ListItem<T> aim = head;
        while (aim != null) {
            if (aim.isTheSame(value))
                return aim;
            aim = aim.next;
        }
        return null;
    }

    public boolean contains(T value) {
        return findItem(value) != null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        ListItem<T> aim = head;
        while (aim != null) {
            System.out.print(aim.toString() + (aim.next != null ? " --> " : ""));
            aim = aim.next;
        }
        System.out.println();
    }

    public void transformValues(Transformer<T, ? extends T> transformer) {
        ListItem<T> aim = head;
        while (aim != null) {
            aim.value = transformer.transform(aim.value);
            aim = aim.next;
        }
        System.out.println();
    }

    public Iterable<T> after(T value) {
        return () -> new MyListIterator<>(findItem(value));
    }

    public Iterable<T> before(T value) {
        return () -> new BeforeIterator(head, value);
    }


    @Override
    public Iterator<T> iterator() {
        return new MyListIterator<T>(head);
    }


    static class ListItem<T> {
        private T value;
        private ListItem<T> next;

        public ListItem(T value) {
            this.value = value;
        }

        boolean isTheSame(T value) {
            return (this.value != null && this.value.equals(value)) || (this.value == null && value == null);
        }

        @Override
        public String toString() {
            return (value != null ? value.toString() : "null");
        }

    }

    private class MyListIterator<T> implements Iterator<T> {
        private ListItem<T> nxtItem;

        public MyListIterator(ListItem<T> starter) {
            this.nxtItem = starter;
        }

        @Override
        public boolean hasNext() {
            return nxtItem != null;
        }

        @Override
        public T next() {
            T tmp = nxtItem.value;
            nxtItem = nxtItem.next;
            return tmp;
        }
    }

    private class BeforeIterator implements Iterator<T> {

        private ListItem<T> nxtItem;
        private T finalValue;

        public BeforeIterator(ListItem<T> starter, T finalValue) {
            this.nxtItem = starter;
            this.finalValue = finalValue;
        }

        @Override
        public boolean hasNext() {
            return nxtItem != null && !Objects.equals(nxtItem.value, finalValue);
        }

        @Override
        public T next() {
            T res = nxtItem.value;
            nxtItem = nxtItem.next;
            return res;
        }
    }
}
