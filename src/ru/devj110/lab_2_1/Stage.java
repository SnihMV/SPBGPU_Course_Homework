package ru.devj110.lab_2_1;

public enum Stage {
    B("Bachelor"), M("Master");


    private final String title;

    Stage(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
