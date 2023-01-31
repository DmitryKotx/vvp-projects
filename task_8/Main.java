package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static double len(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static boolean isSquare(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double[] lens = {
                len(x1, y1, x2, y2),
                len(x2, y2, x3, y3),
                len(x3, y3, x4, y4),
                len(x4, y4, x1, y1),
                len(x2, y2, x4, y4),
                len(x1, y1, x3, y3),

        };
        Arrays.sort(lens);

        return equals(lens[0], lens[1]) && equals(lens[1], lens[2]) && equals(lens[2], lens[3])
                && equals(lens[4], lens[5]);
    }

    public static boolean equals(double a, double b) {
        return Math.abs(a - b) < 1e-10;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите координату x1 = ");
        int x1 = scanner.nextInt();
        System.out.print("Введите координату y1 = ");
        int y1 = scanner.nextInt();
        System.out.print("Введите координату x2 = ");
        int x2 = scanner.nextInt();
        System.out.print("Введите координату y2 = ");
        int y2 = scanner.nextInt();
        System.out.print("Введите координату x3 = ");
        int x3 = scanner.nextInt();
        System.out.print("Введите координату y3 = ");
        int y3 = scanner.nextInt();
        System.out.print("Введите координату x4 = ");
        int x4 = scanner.nextInt();
        System.out.print("Введите координату y4 = ");
        int y4 = scanner.nextInt();

        if (isSquare(x1, y1, x2, y2, x3, y3, x4, y4)) {
            System.out.println("Точки образуют квадрат");
        } else {
            System.out.println("Точки образуют произвольный четырехугольник");
        }
    }
}