package main.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IsPalindrome {
    boolean isPalindrome(String s){

        int start = 0;
        int last = s.length() -1;

        while (start <= last){
            char currentStart = s.charAt(start);
            char currentEnd = s.charAt(last);

            if (!Character.isLetterOrDigit(currentStart))
                start++;
            if (!Character.isLetterOrDigit(currentEnd))
                last++;

            if (Character.toLowerCase(currentStart) != Character.toLowerCase(currentEnd)) {
                return false;
            }
            start++;
            last--;
        }

        return true;
    }

    @Test
    @DisplayName("Valid Case")
    void validCase(){

        String word = "ana";
        boolean isPalindrome = isPalindrome(word);

        Assertions.assertEquals(true, isPalindrome);
    }

    @Test
    @DisplayName("Not Palindrome")
    void validPalindrome(){

        String word = "anaaee";
        boolean isPalindrome = isPalindrome(word);

        Assertions.assertEquals(false, isPalindrome);
    }

    @Test
    @DisplayName("Not Palindrome")
    void notPalindrome(){

        String word = "anaaee";
        boolean isPalindrome = isPalindrome(word);

        Assertions.assertEquals(false, isPalindrome);
    }

}
