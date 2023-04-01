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

    public void addToHead(Object value){
        if (head==null)
            head=tail=new ListItem(value);
        else {
            ListItem newHead = new ListItem(value);
            newHead.next = head;
            head = newHead;
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
