package ru.devj110.homework2;

public abstract class MediaFile extends File {

    private String description;
    private Duration duration;

    public MediaFile(String name, long size, String format, String description, Duration duration) {
        super(name, size, format);
        setDescription(description);
        setDuration(duration);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
    @Override
    public String getDetails() {
        return super.getDetails()+", "+getDescription()+", "+getDuration();
    }
}
