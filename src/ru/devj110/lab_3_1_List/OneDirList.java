package ru.devj110.lab_3_1_List;

public class OneDirList<T> {
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

    public boolean contains(T value) {
        ListItem<T> aim = head;
        while (aim != null) {
            if (aim.isTheSame(value))
                return true;
            aim = aim.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

//    private String itemToStr(ListItem<T> item) {
//        return item.toString() + (item.next != null ? " --> " : "");
//    }

    public void print() {
        ListItem<T> aim = head;
        while (aim != null) {
            System.out.print(aim.toString() + (aim.next != null ? " --> " : ""));
            aim = aim.next;
        }
        System.out.println();
    }

    public void transformValues(Transformer<T,? extends T> transformer) {
        ListItem<T> aim = head;
        while (aim != null) {
            aim.value = transformer.transform(aim.value);
            aim = aim.next;
        }
        System.out.println();
    }


    public class ListItem<T> {
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
}
