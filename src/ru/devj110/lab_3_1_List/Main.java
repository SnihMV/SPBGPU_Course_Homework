package ru.devj110.lab_3_1_List;

public class Main {
    public static void main(String[] args) {
        OneDirList list = new OneDirList();
        list.addToHead("a");
        list.addToTail(null);
        list.addToHead("c");
        list.addToTail("d");

        list.printList();
        list.customPrint(item -> Integer.toString(item.hashCode()));
        System.out.println(list.contains(null));
        System.out.println(list.isEmpty());
        System.out.println(list.popFromTail());
        list.remove("a");
        System.out.println(list.isEmpty());

        list.printList();
        list.customPrint(i -> Integer.toString(i.toString().length()));
        System.out.println("Head: "+list.getHead()+"\nTail: "+list.getTail());
        
    }
}
