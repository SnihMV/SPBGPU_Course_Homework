package ru.devj110.lab_5_FunctionalInterfaces;

public class EquationRoots {
    private static final double TOLERANCE = 1e-8; // 1 * 10^(-5)

    public static double findRoot(Function function, double left, double right) {
        while (right - left > TOLERANCE) {
            double mid = (right + left) / 2;
            double res = function.f(mid);
            if (Math.abs(res) <= TOLERANCE) return mid;
            if ((function.f(left) > 0 && (function.f(mid) < 0) ||
                    (function.f(left) < 0 && function.f(mid) > 0)))
                right = mid;
            else if ((function.f(right) > 0 && (function.f(mid) < 0) ||
                    (function.f(right) < 0 && function.f(mid) > 0)))
                left = mid;
        }
        return (right+left)/2;
    }


}
