package ru.devj110.lab_3_3;

public class Main {
    public static void main(String[] args) {
        ExtendedList list = new ExtendedList(5);
        list.print();

        list.addToHead(1);
        list.addToHead(2);
        list.addToHead(3);
        list.addToHead(null);
        list.addToHead("hello");
        list.addToHead(42);
        list.addToHead(13);
        list.addToHead(true);
        list.addToHead("privet");
        list.addToHead(88);
        list.addToHead(1);
        list.addToHead("Mike");




        list.print();
        System.out.println("head: "+list.getHead()+" head.next: "+list.getHeadNext());
        System.out.println("Tail: "+list.getTail()+" tail.next: "+list.getTailNext());
    }

}
