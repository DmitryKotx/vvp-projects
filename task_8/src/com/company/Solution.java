package com.company;

public class Solution {

    public static boolean solution(int[][] arr2) {
        int row = 1;
        int column = 0;
        int fMember = arr2[row - 1][column];
        int sMember = arr2[row][column];
        int tMember = 0;
        int a = -1;
        int b = 1;
        int repeat = arr2.length * arr2[0].length;

        for (int r = 1; r <= repeat; r++) {
            a *= -1;
            b *= -1;
            while (true) {
                row += b;
                column += a;
                tMember = arr2[row][column];
                if (sign(sMember - fMember) == sign(tMember - sMember)) {
                    fMember = sMember;
                    sMember = tMember;
                } else {
                    return false;
                }
                if (column == arr2[row].length - 1 || row == 0 || row == arr2.length - 1 || column == 0) {
                    break;
                }
            }
            if (r % 2 == 1) {
                column += a;
                if (column == arr2[row].length) {
                    column += b;
                    row += a;
                }
            } else {
                row -= a;
                if (row == arr2.length) {
                    column -= a;
                    row -= b;
                }
            }
            tMember = arr2[row][column];
            if (row == arr2.length - 1 && column == arr2[arr2.length - 1].length - 1) {
                break;
            }
            if (sign(sMember - fMember) == sign(tMember - sMember)) {
                fMember = sMember;
                sMember = tMember;
            } else {
                break;
            }
        }
        return sign(sMember - fMember) == sign(tMember - sMember);
    }

    public static int sign(int value) {
        return Integer.compare(value, 0);
    }
}