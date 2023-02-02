package com.company;
import java.util.List;


public class Solution {
    public static List<Integer> solution (List<Integer> list1, List<Integer> list2) {
        int k = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (!existsIn(list1.get(k), list2)) {
                list1.add(list1.get(k));
                list1.remove(k);
            } else {
                k++;
            }
        }
        return list1;
    }

    public static boolean existsIn (int value, List<Integer> list) {
        for (Integer element : list) {
            if (value == element) {
                return true;
            }
        }
        return false;
    }
}

