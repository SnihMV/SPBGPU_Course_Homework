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

        for (String s : list.after("1")) {
            System.out.println(s);
        }
    }
}
