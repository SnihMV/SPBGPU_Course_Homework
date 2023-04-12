package ru.devj110.lab_3_3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ExtendedList list = new ExtendedList(3);
        list.print();
        Object[] arr = {1, "Go", false, null, "ZVO", 43};
//        System.out.println(Arrays.toString(arr));

        list.addToHead(1);
        list.addToHead(2);
        list.addToHead(3);
        list.addToHead(null);
        list.addToHead("hello");
        list.addToHead(42);
        list.addToHead(true);
        list.addToHead(22);

        list.print();

    }

}
