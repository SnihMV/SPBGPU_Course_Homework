package ru.devj110.lab_3_3;

public class Main {
    public static void main(String[] args) {
        ExtendedList list = new ExtendedList(5);
        list.print();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(4);
        list.addToTail(5);
        list.addToTail(6);
        list.addToTail(7);
        list.addToTail(8);
        list.addToTail(9);
        list.addToTail(2);
        list.addToTail("hello");



        list.print();
    }

}
