package ru.devj110.homework2;

public class Main {
    public static void main(String[] args) {
        File f = new Video("BackToTheFuture1.avi", 1470984192,"Back to the future I, 1985",
                new Duration(1,48,8), new Dimension(640,352));
        File f1 = new Document("shitty.doc", 234234, 22);
        System.out.println(f1);
    }
}