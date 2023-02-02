package com.company;

import java.util.Scanner;

public class Main {
    public static double aNext(double a, double x, int n) {
        return a * x * -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число x: ");
        double x = scanner.nextDouble();
        System.out.print("Введите номер n: ");
        int n = scanner.nextInt();
        System.out.print("Введите предел e: ");
        double e = scanner.nextDouble();

        Solution sol = calc(x, n, e);

        System.out.printf("Сумму n слагаемых заданного вида: %.10f%n", sol.sumN);
        System.out.printf("Сумма тех слагаемых, которые по абсолютной величине больше e: %.10f%n", sol.sumE);
        System.out.printf("Сумма тех слагаемых, которые по абсолютной величине больше e/10: %.10f%n", sol.sumE10);
        System.out.printf("Значение функции: %.10f%n", sol.fValue);
    }

    public static Solution calc(double x, int n, double e) {
        Solution sol = new Solution();
        double a = 1;
        for (int i = 0; i <= n ; i++) {

            sol.sumN += a;

            if (Math.abs(a) > e) {
                sol.sumE += a;
            }
            if (Math.abs(a) > e / 10) {
                sol.sumE10 += a;
            }
            a = aNext(a, x, n);
        }

        sol.fValue = 1 / (1 + x);

        return sol;
    }
}