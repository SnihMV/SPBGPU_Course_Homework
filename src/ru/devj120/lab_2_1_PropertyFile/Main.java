package ru.devj120.lab_2_1_PropertyFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            PropertyFile pf = new PropertyFile("D:\\my.properties");
            pf.print();
            pf.set("name", "Popek");
            pf.save("result.txt");
        } catch (IOException | IllegalArgumentException e) {
            System.err.println(e);
        }
    }
}
