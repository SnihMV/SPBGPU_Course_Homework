package ru.devj110.lab_2_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Teacher("Ronald", "Turner", Gender.MALE, Department.F1, Degree.P, "Programming paradigms"));
        persons.add(new Teacher("Ruth", "Hollings", Gender.FEMALE, Department.F2, Degree.C, "Domestic arbitration"));
        persons.add(new RegularStudent("Leo", "Wilkinson", Gender.MALE, Department.F1, 3, Stage.B));
//        persons.add(new RegularStudent("Anna", "Cunningham", Gender.FEMALE, Department.F3, 2, Stage.B));
//        persons.add(new RegularStudent("Jill", "Lundqvist", Gender.FEMALE, Department.F2, 1, Stage.M));
        persons.add(new PhdStudent("Ronald", "Correa", Gender.MALE, Department.F1, "Design of a functional programming language"));

        Person.printAll(persons);

        RegularStudent.loadStudents(persons);

        Person.printAll(persons);

    }
}
