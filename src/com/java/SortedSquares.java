package com.java;

public class SortedSquares {

    public static void main(String[] args) {
        System.out.println(sortedSquares(new int[] {-10, -4, 1, 2, 3, 5, 6, 8, 9}));
    }

    public static int[] sortedSquares(int[] array) {
        int pos = array.length;
        int[] ar = new int[pos--];
        int left = 0, right = pos;
        for (; pos >= 0; pos--) {
            int leftVal = Math.abs(array[left]);
            int rightVal = Math.abs(array[right]);
            if (leftVal > rightVal) {
                ar[pos] = leftVal * leftVal;
                left++;
            } else {
                ar[pos] = rightVal * rightVal;
                right--;
            }
        }
        return ar;
    }
}

