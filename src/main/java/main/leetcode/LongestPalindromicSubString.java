package main.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindromicSubString {

    // TODO: Refactor was not good because we're using global variable since changing string by reference in palindrome() didn't work. We need to refactor it to remove this class variable
    String longestString = "";
    public String longestPalindrome(String s) {
        longestString = "";

        int right, left;
        for(int i =0; i < s.length(); i++){
            // odd
            longestString = palindrome(s, i, i);

            // even
            longestString = palindrome(s, i, i + 1);
        }

        return longestString;
    }

    private String palindrome(String originalString, int left, int right){
        while (left >= 0 && right < originalString.length() && originalString.charAt(left) == originalString.charAt(right)){
            if (originalString.substring(left, right + 1).length() >= longestString.length())
                longestString = originalString.substring(left, right + 1);

            left--;
            right++;
        }

        return longestString;
    }

    @Test
    public void test(){
        // Both are valid Palindromes with same length, workaround to assert one or another
        Assertions.assertTrue(longestPalindrome("babad").equals("bab") || longestPalindrome("babad").equals("aba"));

        assertEquals("aba", longestPalindrome("aba"));
        assertEquals("bb", longestPalindrome("cbbd"));
    }

    public String longestPalindromeOld(String s) {

        int right, left;
        String longestString = "";
        for(int i =0; i < s.length(); i++){
            right = i;
            left = i;
            // odd
            while (right < s.length() && left >= 0
                    && s.charAt(right) == s.charAt(left)){
                if (right - left + 1 > longestString.length()){
                    longestString = s.substring(left, right + 1);
                }

                left--;
                right++;
            }

            // even
            left = i;
            right = i + 1;
            while (right < s.length() && left >=0 && s.charAt(left) == s.charAt(right)){
                if (right - left + 1 > longestString.length()){
                    longestString = s.substring(left, right + 1);
                }

                left--;
                right++;
            }
        }

        return longestString;
    }

}
