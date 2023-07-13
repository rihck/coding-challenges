package main.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class isPalindrome2 {

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    private boolean isPalindrome(String s) {
        if (s == null || s.isEmpty())
            return false;

        // odd = A  N  A
        // even = A  B  B  A

        String stringLoweredCase = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left <= right){
            Character leftChar =  stringLoweredCase.charAt(left);
            Character rightChar = stringLoweredCase.charAt(right);

            if (leftChar != rightChar)
                return false;

            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindromeFromMiddle(String s){


        return false;
    }

    public void validPalindromeWithSpacesAndOtherCharacters(){
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void validOddPalindrome(){
        assertTrue(isPalindrome("ana")); ;
    }

    @Test
    public void validEvenPalindrome(){
        assertTrue(isPalindrome("abba"));
    }

    @Test
    public void invalidOddPalindrome(){
        assertFalse(isPalindrome("ffa"));
    }

    @Test
    public void invalidEvenPalindrome(){
        assertFalse(isPalindrome("afff"));
    }

    @Test
    public void validateNullOrEmpty() {
        assertFalse(isPalindrome(""));
        assertFalse(isPalindrome(null));
    }
}
