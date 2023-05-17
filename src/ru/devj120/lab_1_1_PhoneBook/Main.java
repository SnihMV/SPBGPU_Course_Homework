package ru.devj120.lab_1_1_PhoneBook;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PhoneNumber pn = new PhoneNumber("921", "9894856"),
                pn1 = new PhoneNumber("921", "4296363"),
                pn2 = new PhoneNumber("81287", "01"),
                pn3 = new PhoneNumber("921", "98948567");
        Set<PhoneNumber> nmbs = new HashSet<>();
        nmbs.add(pn);
        nmbs.add(pn1);
        nmbs.add(pn2);
        nmbs.add(pn3);
        nmbs.add(pn);

/*
        for (PhoneNumber num : nmbs) {
            System.out.println(num);
        }*/

        Set<IntWrapper> iws = new HashSet<>();
        IntWrapper iw = new IntWrapper();
        iws.add(iw);
        System.out.println(iws.contains(iw));
        iw.hc=24;
        System.out.println(iws.contains(iw));
        iw.hc=42;
        System.out.println(iws.contains(iw));
        iw.hc=43;
        System.out.println(iws.contains(iw));


    }

    static class IntWrapper {
        int hc = 42;

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass())
                return false;
            return this.hc == ((IntWrapper) o).hc;
        }

        @Override
        public int hashCode() {
            return hc;
        }
    }
}
