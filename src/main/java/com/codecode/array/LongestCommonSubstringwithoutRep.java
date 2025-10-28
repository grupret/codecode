package com.codecode.array;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubstringwithoutRep {
    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(countLongestNonRepSubstring(s));

    }

    private static int countLongestNonRepSubstring(String s) {

        Map<Character, Integer> test = new HashMap<Character, Integer>();
        int localCount = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (test.containsKey(s.charAt(i))) {


                max = Math.max(max, localCount);
                localCount = 0;
                System.out.println(test.toString());
                test.clear();
            }
                test.put(s.charAt(i), 1);
                localCount++;

        }

        max = Math.max(max, localCount);
        return max;
    }
}
