package ru.devj110.lab_3_1;

public class Main {
    public static void main(String[] args) {
        OneDirList list = new OneDirList();
        list.addToHead("a");
        list.addToTail(null);
        list.addToHead("c");
        list.addToTail("d");

        list.print();
        System.out.println(list.contains(null));
        System.out.println(list.isEmpty());
        System.out.println(list.popFromTail());
        list.remove("a");
        System.out.println(list.isEmpty());

        list.print();
        System.out.println("Head: "+list.getHead()+" Tail: "+list.getTail());
        
    }
}
