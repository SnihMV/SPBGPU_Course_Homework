package ru.devj110.lab_2_1;

public class Main {
    public static void main(String[] args) {

        Person[] persons = new Person[]{
                new Teacher("Ronald", "Turner", Gender.MALE,Department.F1,Degree.P,"Programming paradigms"),
          new Teacher("Ruth", "Hollings", Gender.FEMALE,Department.F2,Degree.C,"Domestic arbitration"),
                new RegularStudent("Leo","Wilkinson", Gender.MALE,Department.F1,3,Stage.B),
                new RegularStudent("Anna","Cunningham", Gender.FEMALE,Department.F3,2,Stage.B),
                new RegularStudent("Jill", "Lundqvist",Gender.FEMALE, Department.F2,1,Stage.M),
                new PhdStudent("Ronald", "Correa",Gender.MALE,Department.F1,"Design of a functional programming language")
        };
        Person.printAll(persons);
    }
}