package ru.devj110.lab_2_1;

public enum Gender {
    MALE("He", "His"), FEMALE("She", "Her");

    private String pronoun;
    private String posPronoun;


    Gender(String pronoun, String posPronoun) {
        this.pronoun = pronoun;
        this.posPronoun = posPronoun;
    }

    public String getPronoun() {
        return pronoun;
    }

    public String getPosPronoun() {
        return posPronoun;
    }
}
