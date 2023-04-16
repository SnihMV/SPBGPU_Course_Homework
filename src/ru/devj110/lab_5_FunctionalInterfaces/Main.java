package ru.devj110.lab_5_FunctionalInterfaces;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {

        LnFunc lf = new LnFunc();


        System.out.println(EquationRoots.findRoot(x -> pow(E, -x) - 0.5, 0.01, 2));
        System.out.println(EquationRoots.findRoot(new Function() {
            @Override
            public double f(double x) {
                return sin(x) - 0.75;
            }
        }, 2, 3));
        System.out.println(EquationRoots.findRoot(lf::f, 1, 3));
        System.out.println(EquationRoots.findRoot(Math::tan, 2, 4));
        System.out.println(EquationRoots.findRoot(new CubeEq()::f, 1, 5));
    }

    private static class CubeEq implements Function {
        @Override
        public double f(double x) {
            return pow(x, 3) - 8 * x + 2;
        }
    }
}

class LnFunc implements Function {
    @Override
    public double f(double x) {
        return log((x * x * x)) - 2;
    }
}

