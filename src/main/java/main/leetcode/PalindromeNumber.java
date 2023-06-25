package main.leetcode;

import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String numberString = String.valueOf(x);
        int right = numberString.length() -1, left = 0;
        while (left <= right){
            if (numberString.charAt(left)  != numberString.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    @Test
    public void mainTestCases(){
        assertTrue(isPalindrome(121));
        assertFalse(isPalindrome(10));
        assertFalse(isPalindrome(-121));
    }
}
