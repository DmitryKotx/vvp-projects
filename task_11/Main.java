package com.company;

import java.util.Scanner;

public class Main {

    public static final Parabola VerticalParabola = new Parabola(-3, -6, 1.0 / 8);
    public static final Parabola ReverseParabola = new Parabola(-6, 0, -1.0 / 2);
    public static final Parabola HorizontalParabola = new Parabola(2, 3, 1);

    public static SimpleColor getColor(double x, double y) {
        if (VerticalParabola.isPointAboveOfParabola(x, y) && !ReverseParabola.isPointBelowOfParabola(x, y)
                && HorizontalParabola.isPointLeftOfParabola(x, y)
                ||
                !VerticalParabola.isPointAboveOfParabola(x, y) && !ReverseParabola.isPointBelowOfParabola(x, y)
                        && HorizontalParabola.isPointLeftOfParabola(x, y)
                        && x > -3 && y < 2) {
            return SimpleColor.ORANGE;
        }
        if (ReverseParabola.isPointBelowOfParabola(x, y) && !VerticalParabola.isPointAboveOfParabola(x, y)) {
            return SimpleColor.BLUE;
        }
        if (HorizontalParabola.isPointRightOfParabola(x, y) && VerticalParabola.isPointAboveOfParabola(x, y)
                || ReverseParabola.isPointBelowOfParabola(x, y) && VerticalParabola.isPointAboveOfParabola(x, y)) {
            return SimpleColor.WHITE;
        }
        if (x < -8 && !VerticalParabola.isPointAboveOfParabola(x, y) && !ReverseParabola.isPointBelowOfParabola(x, y)) {
            return SimpleColor.GRAY;
        }
        if (x > 6 && y > 5 && !VerticalParabola.isPointAboveOfParabola(x, y)
                && HorizontalParabola.isPointLeftOfParabola(x, y)) {
            return SimpleColor.GREEN;
        }

        return SimpleColor.RAD;


    }

    public static void printColorForPoint(double x, double y) {
        System.out.println("(" + x + ",  " + y + ") -> " + getColor(x, y));

    }


    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите координаты х, у: ");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            printColorForPoint(x, y);
        }


    }

}

