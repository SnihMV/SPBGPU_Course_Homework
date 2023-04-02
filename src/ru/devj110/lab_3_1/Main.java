package ru.devj110.lab_3_1;

public class Main {
    public static void main(String[] args) {
        OneDirList list = new OneDirList();
        list.addToHead("gg");
        list.addToTail("hello");
        list.addToHead("Mike");
        System.out.println(list.contains("hello"));
        System.out.println(list.isEmpty());
        System.out.println(list.popFromTail());
        list.print();
        
    }
}
