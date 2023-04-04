package ru.devj110.lab_3_2;


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

    public void transform (Transformer t){
        ListItem aim = head;
        while (aim!=null){
            aim.value = t.transform(aim.value);
            aim=aim.next;
        }
    }

    public void reverseTransform (Transformer t){
        ListItem aim = tail;
        while (aim!=null){
            aim.value = t.transform(aim.value);
            aim=aim.prev;
        }
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
