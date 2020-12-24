package com.company;
/*
Given an array of ints, determine the position in the array
where the values to the left are equal to the values to its right.

The following returns position 5, where both sides equal 10.
[0, 9, -8, 2, 7, 1, 11, -2, 1]
0 + 9 + -8 + 2 + 7 == 11 + -2 + 1

If there are multiple solutions, any correct solution is valid for return.
If there is no solution, return -1.
 */
class BalanceIndex {
    public static void main(String[] args) {
        System.out.println(balanceIndex(new int[] {0, 9, -8, 2, 7, 1, 11, -2, 1}));
    }
    public static int balanceIndex(int[] array) {

        int len = array.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int prev = 0;
        for (int i = 0; i < len; i++) {
            left[i] = array[i] + prev;
            prev = left[i];
        }

        prev = 0;
        for (int i = len-1; i >= 0; i--) {
            right[i] = array[i] + prev;
            prev = right[i];
            if (right[i] == left[i]) return i;
        }

        return -1;

    }
}
