package com.java;

import java.util.Arrays;

public class PermutationCount {
   // https://www.algoexpert.io/assessments/Count%20Contained%20Permutations
   public static void main(String[] args) {
       String big = "abcdefg";
       String small = "abcdefg";
       countContainedPermutations(big, small);
   }
        public static int countContainedPermutations(String bigString, String smallString) {
            int[] ar = new int[123];
            for (char c : smallString.toCharArray()) {
                ar[c] += 1;
            }
            int count = 0;
            for (int i = 0; i < bigString.length()-smallString.length(); i++) {
                if (isPermutation(Arrays.copyOf(ar, 123), bigString.substring(i, i+smallString.length()+1), smallString.length())) count++;
            }

            return count;
        }

        static boolean isPermutation(int[] ar, String bigString, int len) {
            if (len > bigString.length()) return false;
            for (char c : bigString.toCharArray()) {
                ar[c]-= 1;
                if (ar[c] < 0) return false;
            }
            for (int i = 97; i < ar.length; i++) {
                if (ar[i] != 0) return false;
            }
            return true;

        }
}


