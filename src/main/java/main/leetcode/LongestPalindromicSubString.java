package main.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindromicSubString {

    public String longestPalindrome(String s) {

        int right, left;
        String longestString = "";
        int longestStringLength = 0;
        for(int i =0; i < s.length(); i++){
            right = i;
            left = i;
            // odd
            while (right < s.length() && left >= 0
            && s.charAt(right) == s.charAt(left)){
                if (right - left + 1 > longestStringLength){
                    longestStringLength = right - left + 1;
                    longestString = s.substring(left, right + 1);
                }

                left--;
                right++;
            }

            // even
            left = i;
            right = i + 1;
            while (right < s.length() && left >=0 && s.charAt(left) == s.charAt(right)){
                if (right - left + 1 > longestStringLength){
                    longestStringLength = right - left + 1;
                    longestString = s.substring(left, right + 1);
                }

                left--;
                right++;
            }
        }

        return longestString;
    }

    @Test
    public void test(){
        assertEquals("aba", longestPalindrome("aba"));
        assertEquals("bab", longestPalindrome("babad"));
        assertEquals("bb", longestPalindrome("cbbd"));
    }

}
