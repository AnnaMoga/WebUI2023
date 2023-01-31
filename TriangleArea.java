package ru.gb.lesson_4.HW;

public class TriangleArea {
    public static double calcTriangleArea (double sideA, double sideB, double sideC) throws Exception {
        if (sideA <= 0 || sideB <=0 || sideC <= 0) {
            throw new Exception("side length < 0");
        }

        double halfPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }
}
