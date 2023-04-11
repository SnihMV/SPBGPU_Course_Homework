package ru.devj110.lab_3_3;

public class Main {
    public static void main(String[] args) {
        ExtendedList list = new ExtendedList(3);
        list.print();

        list.addToHead(1);
        list.addToHead(2);
        list.addToHead(3);
        list.addToHead(null);
        list.addToHead("hello");
        list.addToHead(42);
        list.addToHead(true);

        list.print();

        list.convertAll(v -> v != null ? v.hashCode() : "null");

        list.print();


    }

}
