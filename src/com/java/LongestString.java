package com.java;

import java.util.HashMap;
import java.util.Map;

public class LongestString {
//   Given a string s, find the length of the longest substring without repeating characters. 
//   Input: s = "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3.
//
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }



//    static int longest(String str) {
//        Map<Character, Integer> map = new HashMap();
//
//
//    }

    //solution with Map and Integer count. more concise.
    //This code was given to me. I would prefer different variable names than n, i, j
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i); //last instance of this repeated char
            }
            //if position-1 to previous char is longer, that's our answer now
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    //solution with array, this works when you know the limit of characters (lowercase only here)
    static int longest(String str) {
        if (str == null || str.length() == 0) return 0;
        int longest = 0;
        int left = 0, right = 0;
        int len = str.length();
        //we're only using lowercase, so this lets us do this in constant space -
        // O(26), better than O(n)
        int[] ar = new int[26];
        while (left < len && right < len) {
            char ch = str.charAt(right);
            if (ar[ch-97] >= 1) { //97 is ascii a
                while (left < right) {
                    char chLeft = str.charAt(left);
                    ar[chLeft-97] -= 1;
                    if (ar[left++] == ar[right]) {
                        break;
                    }

                }

            } else {
                ar[ch-97] += 1;
                right++;
            }
            if (right - left > longest) longest = right-left;


        }


        return longest;
    }

}
