package ru.devj110.lab_5_FunctionalInterfaces;

public class Integral {

    public static final int X_PARTS = 100;
    public static final int XY_PARTS = 100;

    public static double solve(Function function, double left, double right) {
        double piece = (right - left) / X_PARTS;
        double mid = left + piece / 2;
        double res = 0;
        while (mid < right) {
            res += function.f(mid) * piece;
            mid += piece;
        }
        return res;
    }

    public static double solve(BivariateFunc function, double xLeft, double xRight, double yLeft, double yRight) {
        double xPiece = (xRight - xLeft) / XY_PARTS;
        double yPiece = (yRight - yLeft) / XY_PARTS;
        double xMid = xLeft + xPiece / 2;
        double res = 0;
        for (int x = 0; x < XY_PARTS; x++) {
            double yMid = yLeft + yPiece / 2;
            for (int y = 0; y < XY_PARTS; y++) {
                res += function.f(xMid, yMid) * xPiece * yPiece;
                yMid += yPiece;
            }
            xMid += xPiece;
        }
        return res;
    }
}
