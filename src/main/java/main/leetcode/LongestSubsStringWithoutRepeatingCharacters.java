package main.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestSubsStringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++){
            StringBuilder currentSubstring = new StringBuilder();
            for (int j = i; j < s.length(); j++){
                char innerLoopChar = s.charAt(j);
                if (currentSubstring.indexOf(String.valueOf(innerLoopChar)) != -1){
                    break;
                }

                currentSubstring.append(s.charAt(j));
                maxLength = Math.max(maxLength, currentSubstring.length());
            }
        }

        return maxLength;
    }

    @Test
    void validTestCase(){
        Assertions.assertEquals(4, lengthOfLongestSubstring("abcabcd"));
        Assertions.assertEquals(3, lengthOfLongestSubstring("abcabc"));
    }
}
