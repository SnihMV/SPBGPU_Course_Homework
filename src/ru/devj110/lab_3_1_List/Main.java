package ru.devj110.lab_3_1_List;

public class Main {
    public static void main(String[] args) {
        OneDirList<Cat> list = new OneDirList<>();
        list.addToHead(new Cat("Barsik"));
        list.addToHead(new Cat("Murzik"));
        list.addToTail(new Cat("Maarsik"));

        list.transformValues(v -> new Cat(v.getName().toUpperCase()));

        list.print();

    }

    static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
