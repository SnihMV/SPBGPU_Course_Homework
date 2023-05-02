package ru.devj110.lab_3_3_ExtendedList;

public class Main {
    public static void main(String[] args) {
        ExtendedList<String> list = new ExtendedList<>(3);
        list.print();
        list.addToHead("hello");
        list.addToHead("1");
        list.addToTail("jo");
        list.addToHead("kilo");
        list.addToHead("42");
        list.addToHead("gg");
        list.addToTail("tail");
        list.print();
        list.remove("jo");
        list.print();
        list = list.restructure(4);
        list.print();
        String s1 = list.popFromHead();
        System.out.println(s1);
        list.print();
        list = list.restructure(10);
        list.print();

        for (String s : list) {
            System.out.println(s);
        }
    }
}
