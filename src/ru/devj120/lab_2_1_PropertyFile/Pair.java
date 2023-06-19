package ru.devj120.lab_2_1_PropertyFile;

public class Pair {
    private String value;
    private String commentary;

    public Pair(String value, String commentary) {
        this.value = value;
        this.commentary = commentary;
    }

    public Pair() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    @Override
    public String toString() {
        return "\'" + value + "\'" + (commentary != null ? " #\'" + commentary +"\'": "");
    }
}
