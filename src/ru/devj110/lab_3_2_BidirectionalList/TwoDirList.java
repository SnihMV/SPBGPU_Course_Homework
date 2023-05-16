package ru.devj110.lab_3_2_BidirectionalList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoDirList<T> implements Iterable<T> {

    private ListItem<T> head;
    private ListItem<T> tail;

    public void addToHead(T value) {
        ListItem<T> newHead = new ListItem<>(value);
        if (head != null) {
            head.prev = newHead;
            newHead.next = head;
            head = newHead;
        } else
            head = tail = newHead;
    }

    public void addToTail(T value) {
        ListItem<T> newTail = new ListItem<>(value);
        if (tail != null) {
            tail.next = newTail;
            newTail.prev = tail;
            tail = newTail;
        } else
            head = tail = newTail;
    }

    public T peekFromHead() {
        if (!isEmpty())
            return head.value;
        throw new NoSuchElementException("List is empty. Nothing to peek from its head");
    }

    public T peekFromTail() {
        if (!isEmpty())
            return tail.value;
        throw new NoSuchElementException("List is empty. Nothing to peek from its tail");
    }

    public T popFromHead() {
        if (!isEmpty()) {
            T res = head.value;
            if (head != tail) {
                head = head.next;
                head.prev = null;
            } else
                head = tail = null;
            return res;
        }
        throw new NoSuchElementException("List is empty. Nothing to pop from its head");
    }

    public T popFromTail() {
        if (!isEmpty()) {
            T res = tail.value;
            if (tail != head) {
                tail = tail.prev;
                tail.next = null;
            } else
                head = tail = null;
            return res;
        }
        throw new NoSuchElementException("List is empty. Nothing to pop from its tail");
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(T value) {
        return getItemWith(value) != null;
    }

    public void remove(T value) {
        if (isEmpty())
            return;
        if (head.isTheSame(value)) {
            if (head != tail) {
                head = head.next;
                head.prev = null;
            } else
                head = tail = null;
            return;
        }
        ListItem<T> aim = head.next;
        while (aim != null) {
            if (aim.isTheSame(value)) {
                if (aim != tail) {
                    aim.prev.next = aim.next;
                    aim.next.prev = aim.prev;
                    return;
                } else {
                    tail = tail.prev;
                    tail.next = null;
                    return;
                }
            }
            aim = aim.next;
        }
    }

    public void printList() {
        ListItem<T> aim = head;
        while (aim != null) {
            System.out.print(aim + (aim.next != null ? " --> " : ""));
            aim = aim.next;
        }
        System.out.println();
    }

    public void reversePrint() {
        ListItem<T> aim = tail;
        while (aim != null) {
            System.out.print(aim + (aim.prev != null ? " --> " : ""));
            aim = aim.prev;
        }
        System.out.println();
    }

    public void transform(Transformator<T, ? extends T> t) {
        ListItem<T> aim = head;
        while (aim != null) {
            aim.value = t.transform(aim.value);
            aim = aim.next;
        }
    }

    public void reverseTransform(Transformator<T, ? extends T> t) {
        ListItem<T> aim = tail;
        while (aim != null) {
            aim.value = t.transform(aim.value);
            aim = aim.prev;
        }
    }

    public void addArrayToHead(T[] array) {
        if (array != null)
            for (int i = array.length - 1; i >= 0; i--)
                addToHead(array[i]);
    }

    public void addArrayToTail(T[] array) {
        if (array != null)
            for (int i = 0; i < array.length; i++)
                addToTail(array[i]);
    }

    public void addCollectionToHead(Iterable<? extends T> collection) {
        if (collection != null) {
            TwoDirList<T> tmpList = new TwoDirList<>();
            for (T value : collection) {
                tmpList.addToTail(value);
            }
            if (tmpList.head != null) {
                tmpList.tail.next = this.head;
                this.head = tmpList.head;
            }
        }
    }

    public void addCollectionToTail(Iterable<? extends T> collection) {
        if (collection != null)
            for (T value : collection)
                addToTail(value);

    }

    public void consumeToHead(TwoDirList<T> that) {
        if (that == null || that.head == null)
            return;
        that.tail.next = this.head;
        this.head.prev = that.tail;
        this.head = that.head;
        that.head = that.tail = null;
    }

    public void consumeToTail(TwoDirList<T> that) {
        if (that == null || that.head == null)
            return;
        that.head.prev = this.tail;
        this.tail.next = that.head;
        this.tail = that.tail;
        that.head = that.tail = null;
    }

    @Override
    public Iterator iterator() {
        return new ForwardIterator(head);
    }

    public Iterable<T> after(T value) {
        return () -> new ForwardIterator(getItemWith(value));
    }

    public Iterable<T> until(T value) {
        return () -> new ForwardIterator<>(head, getItemWith(value));
    }

    public Iterable<T> backward() {
        return () -> new BackwardIterator<>(tail);
    }

    public Iterable<T> backFrom(T value) {
        return () -> new BackwardIterator<>(getItemWith(value));
    }

    public Iterable<T> backUntil(T value){
        return () -> new BackwardIterator<>(tail, getItemWith(value));
    }

    private ListItem<T> getItemWith(T value) {
        ListItem<T> aim = head;
        while (aim != null) {
            if (aim.isTheSame(value))
                return aim;
            aim = aim.next;
        }
        return null;
    }

    private static class ListItem<T> {
        T value;
        ListItem<T> prev;
        ListItem<T> next;

        public ListItem(T value) {
            this.value = value;
        }

        public boolean isTheSame(T value) {
            return (this.value != null && this.value.equals(value)) || (this.value == null && value == null);
        }

        @Override
        public String toString() {
            return value != null ? value.toString() : null;
        }
    }

    private class ForwardIterator<T> implements Iterator<T> {

        protected ListItem<T> nextItem;
        protected ListItem<T> finalItem;

        public ForwardIterator(ListItem<T> startItem, ListItem<T> finalItem) {
            this.nextItem = startItem;
            this.finalItem = finalItem;
        }

        public ForwardIterator(ListItem<T> startItem) {
            this(startItem, null);
        }

        @Override
        public boolean hasNext() {
            return nextItem != null && !nextItem.equals(finalItem);
        }

        @Override
        public T next() {
            T res = nextItem.value;
            nextItem = nextItem.next;
            return res;
        }
    }

    private class BackwardIterator<T> extends ForwardIterator<T> {

        public BackwardIterator(ListItem<T> startItem, ListItem<T> finalItem) {
            super(startItem, finalItem);
        }

        public BackwardIterator(ListItem<T> startItem) {
            super(startItem);
        }

        @Override
        public T next() {
            T res = nextItem.value;
            nextItem = nextItem.prev;
            return res;
        }
    }

}
