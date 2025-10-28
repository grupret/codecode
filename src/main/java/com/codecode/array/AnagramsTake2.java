package com.codecode.array;

import java.util.Arrays;
import java.util.stream.Stream;

public class AnagramsTake2 {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";


        System.out.println("Is anagram: " + extracted(str1, str2));

    }

    private static boolean extracted(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tcharArray = t.toCharArray();
        //stream -> create a map of (char, count) --> iterate over str1 to check if each char and their count matchees
return true;
    }
}
