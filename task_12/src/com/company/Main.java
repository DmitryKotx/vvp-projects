package com.company;

import com.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите массив: ");
        int[] elementsArr = ;
        List<Integer> elements = new ArrayList<>(Arrays.asList(ArrayUtils.toObject(elementsArr)));
        System.out.print("Введите длину сочетания: ");
        int k = scanner.nextInt();
        List<Integer> answer = new ArrayList<>();
        genAll(0, 0, elements, k, answer, next -> System.out.println(Arrays.toString(next.toArray())));

    }

    public static void genAll(int num, int last, List<Integer> list1, int k, List<Integer> list2, Consumer<List<Integer>> callback) {
        if (num == k) {
            callback.accept(list2);
        }
        for (int i = last + 1; i <= list1.size(); i++) {
            list2.add(list1.get(i - 1));
            genAll(num + 1, i, list1, k, list2, callback);
            list2.remove(list2.size() - 1);
        }
    }
}


