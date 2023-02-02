package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Candy> solution (List<Candy> list, int money) {
        List<Candy> candies1 = new ArrayList<>(list);
        List<Candy> buy = new ArrayList<>();
        int maxPrice = 0;

        while (!candies1.isEmpty()) {
            maxPrice += minPrice(candies1).price;
            if (money - maxPrice > 0) {
                buy.add(minPrice(candies1));
                candies1.remove(minPrice(candies1));
            } else {
                maxPrice -= minPrice(candies1).price;
                break;
            }
        }

        for (Candy candy1 : candies1) {
            for (int i = buy.size() - 1; i >= 0; i--) {
                Candy candy2 = buy.get(i);
                maxPrice += - candy2.price + candy1.price;
                if (money - maxPrice > 0) {
                    buy.remove(candy2);
                    buy.add(i, candy1);
                } else {
                    maxPrice -= - candy2.price + candy1.price;
                    break;
                }
                candy1 = candy2;
            }
        }
        Candy balance = new Candy(0, balance(money,maxPrice));
        buy.add(balance);
        return buy;
    }

    public static Candy minPrice (List<Candy> list) {
        double minValue = 1e+9;
        Candy obj = null;
        for (Candy element : list) {
            if (element.price < minValue) {
                minValue = element.price;
                obj = element;
            }
        }
        return obj;
    }

    public static int balance (int money, int maxPrice) {
        return money - maxPrice;
    }
}
