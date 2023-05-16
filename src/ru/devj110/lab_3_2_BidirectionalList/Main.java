package ru.devj110.lab_3_2_BidirectionalList;


public class Main {
    public static void main(String[] args) {
        TwoDirList<String> list = new TwoDirList<>();
        list.addToHead("1");
        list.addToHead("bfr");
        list.addToHead(null);
        list.addToHead("gg");
        list.addToHead("tt");
        list.addToHead("u");
        list.printList();
        for (String s : list.backUntil("u")) {
            System.out.println(s);
        }


    }
}
