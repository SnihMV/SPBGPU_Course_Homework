package ru.devj110.homework2;

public class Dimension {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width <= 0) throw new IllegalArgumentException("Width is lower than 1");
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 0) throw new IllegalArgumentException("Height is lower than 1");

        this.height = height;
    }

    public Dimension(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    @Override
    public String toString() {
        return width + "x" + height;
    }
}
