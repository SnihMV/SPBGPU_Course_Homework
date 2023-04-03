package ru.devj110.lab_3_2;

public class Main {
    public static void main(String[] args) {
        TwoDirList list = new TwoDirList();
        list.printList();
        list.addToHead("a");
        list.addToHead(null);
        list.addToHead("c");
        list.addToHead("d");
        list.printList();
        System.out.println(list.popFromHead());
        list.printList();
        System.out.println(list.contains(0));

    }
}
