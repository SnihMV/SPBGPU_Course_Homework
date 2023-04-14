package ru.devj110.lab_3_1_List;

public class OneDirList {
    private ListItem head;
    private ListItem tail;

    public ListItem getHead() {
        return head;
    }

    public ListItem getTail() {
        return tail;
    }

    public void addToTail(Object value) {
        if (tail != null)
            tail = tail.next = new ListItem(value);
        else
            head = tail = new ListItem(value);
    }

    public void addToHead(Object value) {
        if (head == null)
            head = tail = new ListItem(value);
        else {
            ListItem newHead = new ListItem(value);
            newHead.next = head;
            head = newHead;
        }
    }

    public Object peekFromHead() {
        return head == null ? null : head.value;
    }

    public Object peekFromTail() {
        return tail == null ? null : tail.value;
    }

    public Object popFromHead() {
        if (head == null)
            return null;
        Object res = head.value;
        if (head == tail)
            head = tail = null;
        else head = head.next;
        return res;
    }

    public Object popFromTail() {
        if (tail == null)
            return null;
        Object res = tail.value;
        if (head == tail) {
            head = tail = null;
            return res;
        }
        ListItem aim = head;
        while (aim.next != tail)
            aim = aim.next;
        tail = aim;
        tail.next = null;
        return res;
    }

    public void remove(Object value) {
        if (head == null)
            return;
        if (head.isTheSame(value)) {
            popFromHead();
            return;
        }

        ListItem prevTrg = head;
        ListItem aim = prevTrg.next;
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

    public boolean contains(Object value) {
        ListItem aim = head;
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

    private String itemToStr(ListItem item) {
        return item.toString() + (item.next != null ? " --> " : "");
    }

    public void printList() {
       customPrint(item -> item.toString());
    }

    public void customPrint(Converter c) {
        ListItem aim = head;
        while (aim != null) {
            System.out.print(c.convert(aim) + (aim.next != null ? " --> " : ""));
            aim = aim.next;
        }
        System.out.println();
    }


    public class ListItem {
        private Object value;
        private ListItem next;

        public ListItem(Object value) {
            this.value = value;
        }

        boolean isTheSame(Object value) {
            return (this.value != null && this.value.equals(value)) || (this.value == null && value == null);
        }

        @Override
        public String toString() {
            return (value != null ? value.toString() : "null");
        }
    }
}
