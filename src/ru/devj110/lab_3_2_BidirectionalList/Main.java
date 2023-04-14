package ru.devj110.lab_3_2_BidirectionalList;


public class Main {
    public static void main(String[] args) {
        TwoDirList list = new TwoDirList();
        list.addToHead(1);
        list.addToHead("bfr");
        list.addToHead('c');
        list.addToHead(null);
        list.printList();
        TwoDirList list1 = new TwoDirList();
        list1.addToHead("gg");
        list1.addToHead('F');
        list1.addToHead(42);
        list1.printList();
        list.consumeToHead(list1);
        list.printList();
        list.reversePrint();



    }
}
