package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Количество элементов подпоследовательности: " + solution(arr)[0]);
        System.out.println("Позиция её первого элемента: " + solution(arr)[1]);
    }

    public static int[] solution (int[] arr) {
        int counter = 0;
        int maxLength = 0;
        int minIndex = 0;
        int j = 0;
        for (int i = 0; i < arr.length -1; i++) {
                if (counter > 2) {
                    counter = 0;
                    if (i > maxLength) {
                        maxLength = i;
                        minIndex = Math.min(j - minIndex, minIndex);
                        i = 1;
                        j = i;
                    }
                }
                if (arr[i] != arr[i+1]) {
                    counter++;
                }
            }
        return new int[] {maxLength, minIndex};
    }
}

//16
//4 5 3 3 7 3 3 7 6 4 6 7 7 7 7 1