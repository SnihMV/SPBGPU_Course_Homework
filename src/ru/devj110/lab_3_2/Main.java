package ru.devj110.lab_3_2;

public class Main {
    public static void main(String[] args) {
        TwoDirList list = new TwoDirList();
        list.printList();
        list.addToHead("a");
        list.addToHead("b");
        list.addToHead("c");
        list.addToHead("d");
        list.printList();
        list.transform(value -> Integer.decode(value.toString()));
        list.printList();

    }
}
