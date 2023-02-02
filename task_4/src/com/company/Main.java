package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите номер: ");
            int n = scanner.nextInt();
            System.out.println(task4(n));

        }
    }

    public static boolean checkNumber(int k) {
        int a = k % 10;
        int b = (k / 10) % 10;
        int c = (k / 100) % 10;

        return a == b && b != c || a == c && a != b || b == c && b != a;
    }

    public static int task4(int n) {
        int j = 0;
        for (int i = 100; i < 1000; i++) {
            if (checkNumber(i)) {
                j++;
                if (j == n) {
                    return i;
                }
            }
        }
        return 0;
    }

}