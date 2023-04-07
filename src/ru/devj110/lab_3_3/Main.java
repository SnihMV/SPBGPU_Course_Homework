package ru.devj110.lab_3_3;

public class Main {
    public static void main(String[] args) {
        ExtendedList list = new ExtendedList(3);
        list.print();

        list.recursiveAddToHead(1);
        list.recursiveAddToHead(2);
        list.recursiveAddToHead(3);
        list.recursiveAddToHead(null);
        list.recursiveAddToHead("hello");
        list.recursiveAddToHead(42);
        list.recursiveAddToHead(13);
        list.recursiveAddToHead(true);
        list.recursiveAddToHead("privet");
        list.recursiveAddToHead(88);
        list.recursiveAddToHead(1);
        list.recursiveAddToHead("Mike");

        list.print();


    }

}
