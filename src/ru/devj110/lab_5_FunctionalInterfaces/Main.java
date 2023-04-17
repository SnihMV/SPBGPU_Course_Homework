package ru.devj110.lab_5_FunctionalInterfaces;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {

//        Lab 5.1

        Function f1 = new CubeEq();
        LnFunc lf = new LnFunc();

        System.out.println(EquationRoots.findRoot(f1, 1, 5));
        System.out.println(EquationRoots.findRoot(new Function() {
            @Override
            public double f(double x) {
                return sin(x) - 0.75;
            }
        }, 2, 3));
        System.out.println(EquationRoots.findRoot(Math::tan, 2, 4));
        System.out.println(EquationRoots.findRoot(lf::f, 1, 3));
        System.out.println(EquationRoots.findRoot(x -> pow(E, -x) - 0.5, 0.01, 2));

//        Lab 5.2

        Function quadEq = new QuadEq();
        Quadratic quad = new Quadratic();

        System.out.println(Integral.solve(Math::log, 2, 5));
        System.out.println(Integral.solve(quadEq, 3, 4));
        System.out.println(Integral.solve(new Function() {
            @Override
            public double f(double x) {
                return pow(E, -x);
            }
        }, 0.01, 2));
        System.out.println(Integral.solve(quad::eval, 1, 3));
        System.out.println(Integral.solve(x -> x * sin(x), 0, 1));

//        Lab 5.3

        BivariateFunc bf = new Multiplication();
        Sum s = new Sum();

        System.out.println(Integral.solve(bf, 1, 3, 1, 3));
        System.out.println(Integral.solve(new BivariateFunc() {
            @Override
            public double f(double x, double y) {
                return (x * x + x) * (2 * y + 1);
            }
        }, 3, 4, 7, 10));
        System.out.println(Integral.solve(SuperFunction::act, 0.01, 2, 0.5, 4));
        System.out.println(Integral.solve(s::treat,1,3,1,2));
        System.out.println(Integral.solve((x,y)->x*y*sin(x*y),0,1,0,1));
    }


    static class CubeEq implements Function {
        @Override
        public double f(double x) {
            return pow(x, 3) - 8 * x + 2;
        }
    }

    static class QuadEq implements Function {
        @Override
        public double f(double x) {
            return x * x + x;
        }
    }

    static class Multiplication implements BivariateFunc {
        @Override
        public double f(double x, double y) {
            return x * y;
        }
    }
}

class LnFunc {
    public double f(double x) {
        return log((x * x * x)) - 2;
    }
}

class Quadratic {
    public double eval(double x) {
        return x * x;
    }
}

class Sum {
    public double treat(double p1, double p2) {
        return pow(p1, 2) + pow(p2, 3);
    }
}

class SuperFunction {
    public static double act(double c, double d) {
        return pow(E, -(c * d));
    }
}

