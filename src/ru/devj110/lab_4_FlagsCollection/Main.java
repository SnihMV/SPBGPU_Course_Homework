package ru.devj110.lab_4_FlagsCollection;

public class Main {
    public static void main(String[] args) {
        BooleanArrayImpl ba = new BooleanArrayImpl();
        BinaryImpl bi = new BinaryImpl();

        System.out.println(bi);
        bi.setTrue(39);
        System.out.println(bi);
    }
}
