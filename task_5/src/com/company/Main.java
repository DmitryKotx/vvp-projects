package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ширину: ");
        int s = scanner.nextInt();
        getFigure(s);

    }


    public static void getFigure(int s) {
        for (int i = 0; i < s; i++) {
            System.out.print("*");
        }

        int star1 = 1;
        int star2 = s;

        for (int j = 1; j <= s - 2; j++) {
            star1++;
            star2--;

            System.out.println("");
            for (int k = 1; k <= s; k++) {

                if (k == star1 || k == star2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
        }
        System.out.println("");
        for (int i = 0; i < s; i++) {
            System.out.print("*");
        }
    }
}