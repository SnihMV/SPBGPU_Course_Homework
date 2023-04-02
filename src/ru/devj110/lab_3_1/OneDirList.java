package ru.devj110.lab_3_1;

import java.util.List;

public class OneDirList {
    private ListItem head;
    private ListItem tail;

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
        if (head == tail) {
            Object res = tail.value;
            head = tail = null;
            return res;
        }
        ListItem target = head;
        while (target.next.next != null) {
            target = target.next;
        }
        Object res = target.next.value;
        target.next = null;
        tail = target;
        return res;
    }

    public boolean contains(Object value) {
        ListItem target = head;
        while (target != null) {
            if (target.value.equals(value))
                return true;
            target = target.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        ListItem target = head;
        while (target != null) {
            System.out.print(target.value.toString() + (target.next == null ? "" : " -> "));
        }

    }


    private class ListItem {
        private Object value;
        private ListItem next;

        public ListItem(Object value) {
            this.value = value;
        }
    }
}
