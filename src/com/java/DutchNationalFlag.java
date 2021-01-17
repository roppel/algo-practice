package com.java;

import com.sun.jdi.Value;

import java.util.Arrays;

//sort by groups. you could also use a range of numbers, ie
/*
You have an unsorted array of integers and a  function........string getCategory(integer)........which deterministically returns 1 of three possible strings: "low", "medium", or "high", depending on the input integer. You need to output an array with all the "low" numbers at the bottom, all the "medium" numbers in the middle, and all the "high" numbers at the top. This is basically a partial sort. Within each category, the order of the numbers does not matter...For example, you might be give the array [5,7,2,9,1,14,12,10,5,3]. For input integers 1 - 3, getCategory(integer) returns "low", for 4 - 10 it returns "medium," and for 11 - 15 it returns "high". You could output an array (or modify the given array) that looks like this:
[3,1,2,5,5,9,7,10,14,12]
your helper function getCategory(integer) returns some arbitrary value that you use to sort
in above example
getCategory(3) -> low
getCategory(5) -> mid
getCategory(10) -> mid
getCategory(12) -> high
 */
//brute force - use NlogN sorting algorithm and sort the whole thing
//better - O(n) space with bucket sort - bucket into groups, then put back into array for output
//best  - constant space below - use pointers to group
public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] ar = new int[]{5,7,2,9,1,14,12,10,5,3};//{2,1,3,9,7,5,5,10,12,14};
        sortLowMedHigh(ar);
        for (int i : ar) {
            System.out.print(i + ",");
        }
    }
    public static void swap(int low, int high, int[] ar) {
        int temp = ar[low];
        ar[low] = ar[high];
        ar[high] = temp;
    }
    //sort 0,1,2
    static void sortColors(int[] ar) {
        int low = 0, mid = 0, high = ar.length - 1;
        while (mid <= high) {
            if (ar[mid] == 0) {
                swap(low++, mid++, ar);
            } else if (ar[mid] == 1) {
                mid++;
            } else {
                swap(mid, high--, ar);
            }
        }
    }
    //sort by some arbitrary group, based on getValue(int)
    static void sortLowMedHigh(int[] ar) {
        int low = 0, mid = 0, high = ar.length - 1;
        while (mid <= high) {
            Value current = getValue(ar[mid]);
            if (current == Value.LOW) {
                swap(low++, mid++, ar);
            } else if (current == Value.MEDIUM) {
                mid++;
            } else { //Value.HIGH
                swap(mid, high--, ar);
            }
        }
    }

    static Value getValue(int i) {
        if (i < 5) return Value.LOW;
        if (i < 11) return Value.MEDIUM;
        return Value.HIGH;
    }
    enum Value{
        LOW, MEDIUM, HIGH
    }
}
