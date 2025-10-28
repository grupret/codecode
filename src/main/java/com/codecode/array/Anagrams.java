package com.codecode.array;

public class Anagrams {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";


        System.out.println("Is anagram: " + extracted(str1, str2));

    }

    private static boolean extracted(String s, String t) {
        StringBuffer sBuf1 = new StringBuffer(s);
        StringBuffer sBuf2 = new StringBuffer(t);


        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < sBuf1.length(); i++) {
            char ch = sBuf1.charAt(i);
            int index = sBuf2.indexOf(String.valueOf(ch));
            if (index == -1) {
                return false;
            }
            sBuf2.replace(index,index+1, "0");
        }
        return true;
    }
}
