package ru.devj110.homework2;

public class Main {
    public static void main(String[] args) {
        File[] files = {new Document("j110-lab2-files.docx", 23212, 2),
                new Image("spb-map.png", 1703527, new Dimension(1024, 3072)),
                new AudioFile("06-PrettyGirl.mp3", 7893454, "Eric Clapton, Pretty Girl",
                        new Duration(0, 5, 28)),
                new Video("BackToTheFuture1.avi", 1470984192, "Back to the future I, 1985",
                        new Duration(1, 48, 8), new Dimension(640, 352))};
        File.printAll(files);
    }
}