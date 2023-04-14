package ru.devj110.lab_4_FlagsCollection;

public interface FlagsCollection {
    int SIZE = 1024;

    default void checkIndex(int index){
        if (index<0||index>=SIZE)
            throw new IllegalArgumentException("Index is out of range");
    }
    boolean get(int index);

    void setTrue(int index);

    void setFalse(int index);

    void set(int index, boolean value);
    void swap (int index);
    int count();
    String toString();

}
