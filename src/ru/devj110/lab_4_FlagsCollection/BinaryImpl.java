package ru.devj110.lab_4_FlagsCollection;

public class BinaryImpl implements FlagsCollection {
    private int[] array = new int[SIZE / 32];

    @Override
    public boolean get(int index) {
        checkIndex(index);
        return ((array[index / 32] >> (index % 32)) & 1) != 0;
    }

    @Override
    public void setTrue(int index) {
        checkIndex(index);
        array[index / 32] |= (1 << index % 32);
    }

    @Override
    public void setFalse(int index) {
        checkIndex(index);
        array[index / 32] &= ~(1 << index % 32);
    }

    @Override
    public void set(int index, boolean value) {
        checkIndex(index);
        if (value)
            setTrue(index);
        else setFalse(index);
    }

    @Override
    public void swap(int index) {
        checkIndex(index);
        array[index / 32] ^= (1 << index % 32);
    }

    @Override
    public int count() {
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            if (get(i))
                counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        char[] chars = new char[SIZE];
        for (int i = 0; i < SIZE; i++) {
            chars[i]=get(i)?'1':'0';
        }
        return new String(chars);
    }
}
