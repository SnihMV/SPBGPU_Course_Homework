package ru.devj110.homework2;

public class Video extends MediaFile{
    private Dimension dimension;

    public Video(String name, long size, String description, Duration duration, Dimension dimension) {
        super(name, size, "video", description, duration);
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
        return super.getDetails() + ", " +getDimension();
    }
}
