package ru.devj110.lab_2_1;

public abstract class AbstractStudent extends Person{
    public AbstractStudent(String firstName, String lastName, Gender gender, Department department) {
        super(firstName, lastName, gender, department, "studies");
    }
}
