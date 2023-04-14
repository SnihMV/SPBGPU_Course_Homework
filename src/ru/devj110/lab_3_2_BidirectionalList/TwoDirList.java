package ru.devj110.lab_3_2_BidirectionalList;

public class TwoDirList {

    private ListItem head;
    private ListItem tail;

    public void addToHead(Object value) {
        ListItem newHead = new ListItem(value);
        if (head != null) {
            head.prev = newHead;
            newHead.next = head;
            head = newHead;
        } else
            head = tail = newHead;
    }

    public void addToTail(Object value) {
        ListItem newTail = new ListItem(value);
        if (tail != null) {
            tail.next = newTail;
            newTail.prev = tail;
            tail = newTail;
        } else
            head = tail = newTail;
    }

    public Object peekFromHead() {
        return head != null ? head.value : null;
    }

    public Object peekFromTail() {
        return tail != null ? tail.value : null;
    }

    public Object popFromHead() {
        if (head != null) {
            Object res = head.value;
            if (head != tail) {
                head = head.next;
                head.prev = null;
            } else
                head = tail = null;
            return res;
        }
        throw new IllegalArgumentException("List is empty. Nothing to pop from its head");
    }

    public Object popFromTail() {
        if (tail != null) {
            Object res = tail.value;
            if (tail != head) {
                tail = tail.prev;
                tail.next = null;
            } else
                head = tail = null;
            return res;
        }
        throw new IllegalArgumentException("List is empty. Nothing to pop from its tail");
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(Object value) {
        ListItem aim = head;
        while (aim != null) {
            if (aim.isTheSame(value))
                return true;
            aim = aim.next;
        }
        return false;
    }

    public void remove(Object value) {
        if (head == null)
            return;
        if (head.isTheSame(value)) {
            popFromHead();
            return;
        }
        ListItem aim = head.next;
        while (aim != null) {
            if (aim.isTheSame(value)) {
                if (aim != tail) {
                    aim.prev.next = aim.next;
                    aim.next.prev = aim.prev;
                    return;
                } else {
                    tail.prev.next = null;
                    tail = tail.prev;
                    return;
                }
            }
            aim = aim.next;
        }

    }

    public void printList() {
        ListItem aim = head;
        while (aim != null) {
            System.out.print(aim + (aim.next != null ? " --> " : ""));
            aim = aim.next;
        }
        System.out.println();
    }

    public void reversePrint() {
        ListItem aim = tail;
        while (aim != null) {
            System.out.print(aim + (aim.prev != null ? " --> " : ""));
            aim = aim.prev;
        }
        System.out.println();
    }

    public void transform(Transformator t) {
        ListItem aim = head;
        while (aim != null) {
            aim.value = t.transform(aim.value);
            aim = aim.next;
        }
    }

    public void reverseTransform(Transformator t) {
        ListItem aim = tail;
        while (aim != null) {
            aim.value = t.transform(aim.value);
            aim = aim.prev;
        }
    }

    public void addArrayToHead(Object[] array) {
        if (array == null)
            return;
        for (int i = array.length - 1; i >= 0; i--) {
            addToHead(array[i]);
        }
    }

    public void addArrayToTail(Object[] array) {
        if (array == null) return;
        for (int i = 0; i < array.length; i++) {
            addToTail(array[i]);
        }
    }

    public void addCollectionToHead(Iterable collection) {
        if (collection == null)
            return;
        TwoDirList tmpList = new TwoDirList();
        for (Object o : collection) {
            tmpList.addToTail(o);
        }
        if (tmpList.head != null) {
            tmpList.tail.next = this.head;
            this.head = tmpList.head;
        }
    }

    public void addCollectionToTail(Iterable collection) {
        if (collection == null)
            return;
        for (Object value : collection) {
            addToTail(value);
        }
    }

    public void consumeToHead(TwoDirList that) {
        if (that == null || that.head == null)
            return;
        that.tail.next = this.head;
        this.head.prev = that.tail;
        this.head = that.head;
        that.head = that.tail = null;
    }

    public void consumeToTail(TwoDirList that) {
        if (that == null || that.head == null)
            return;
        that.head.prev = this.tail;
        this.tail.next = that.head;
        this.tail = that.tail;
        that.head = that.tail = null;
    }

    private static class ListItem {
        Object value;
        ListItem prev;
        ListItem next;

        public ListItem(Object value) {
            this.value = value;
        }

        public boolean isTheSame(Object value) {
            return (this.value != null && this.value.equals(value)) || (this.value == null && value == null);
        }

        @Override
        public String toString() {
            return value != null ? value.toString() : null;
        }
    }
}
