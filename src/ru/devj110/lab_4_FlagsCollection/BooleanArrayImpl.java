package ru.devj110.lab_4_FlagsCollection;

public class BooleanArrayImpl implements FlagsCollection {
    private boolean[] values;

    public BooleanArrayImpl() {
        this.values = new boolean[SIZE];
    }

    @Override
    public boolean get(int index) {
        checkIndex(index);
        return values[index];
    }

    @Override
    public void setTrue(int index) {
        checkIndex(index);
        values[index] = true;
    }

    @Override
    public void setFalse(int index) {
        checkIndex(index);
        values[index] = false;
    }

    @Override
    public void set(int index, boolean value) {
        checkIndex(index);
        values[index] = value;
    }

    @Override
    public void swap(int index) {
        checkIndex(index);
        values[index] = !values[index];
    }

    @Override
    public int count() {
        int counter = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i])
                counter++;
        }
        return counter;
    }

    public String toString() {
        char[] chars = new char[SIZE];
        for (int i = 0; i < values.length; i++) {
            chars[i] = values[i] ? '1' : '0';
        }
        return new String(chars);
    }
}
