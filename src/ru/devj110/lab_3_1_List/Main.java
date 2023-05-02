package ru.devj110.lab_3_1_List;

import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        /*OneDirList<Animal> list = new OneDirList<>();
        list.addToHead(new Animal("Petrovich"));
        list.addToHead(new Cat("Barsik", 3));
        list.addToHead(new Animal("Vyhuhol"));
        list.addToHead(new Cat("Murzik", 4));
        list.addToTail(new Cat("Maarsik", 2));
        list.print();

        list.transformValues(v -> new Cat(v.getName().toUpperCase(),v.getClass()==Cat.class?((Cat) v).getAge():11));
        list.print();

        for (Animal a : list) {
            System.out.println(a);
        }*/

        OneDirList<String> li = new OneDirList<>();
        li.addToHead("hello");
        li.addToHead("privet");
        li.addToHead("hi");
        li.addToHead("guten tag");
        li.addToHead("siema");
        li.print();
        li.transformValues(val -> val.toUpperCase());
        li.print();
        for (String s :
                li.before("HI")) {
            System.out.println(s);
        }
    }


    static class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }


        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class Cat extends Animal {
        private int age;

        public Cat(String name, int age) {
            super(name);
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "age=" + age +
                    ", name='" + getName() + '\'' +
                    '}';
        }
    }

}
