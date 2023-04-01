package ru.devj110.lab_2_1;

public enum Degree {
    D("Doctor"), C("Candidate"), P("PhD");

    private String title;

    Degree(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
