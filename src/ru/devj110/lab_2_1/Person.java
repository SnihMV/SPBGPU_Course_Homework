package ru.devj110.lab_2_1;

import javax.sound.midi.Soundbank;

public abstract class Person {
    private String firstName;
    private String lastName;
    private Gender gender;
    private Department department;
    private String verb;

    public Person(String firstName, String lastName, Gender gender, Department department, String verb) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.department = department;
        this.verb = verb;
    }

    public void print(){
        System.out.println("This is "+firstName+" "+lastName+". "+gender.getPronoun()+" "+verb+" at "+getDepartment().getTitle()+" department.");
        System.out.println(getDetailedInfo());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public Department getDepartment() {
        return department;
    }

    public String getVerb() {
        return verb;
    }

    public abstract String getDetailedInfo();

    public static void printAll(Person[] persons){
        for (Person person:persons) person.print();
    }
}
