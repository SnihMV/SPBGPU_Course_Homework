package ru.devj110.homework2;

public class AudioFile extends MediaFile{
    public AudioFile(String name, long size, String description, Duration duration) {
        super(name, size, "audio", description, duration);
    }


}
