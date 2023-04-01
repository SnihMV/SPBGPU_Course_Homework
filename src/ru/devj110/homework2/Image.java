package ru.devj110.homework2;

public class Image extends File {
    private Dimension dimension;

    public Image(String name, long size, Dimension dimension) {
        super(name, size, "image");
        this.dimension = dimension;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", " + getDimension().toString();
    }
}
