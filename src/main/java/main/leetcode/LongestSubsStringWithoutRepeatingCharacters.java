package main.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubsStringWithoutRepeatingCharacters {

    // Algo explanation: https://www.youtube.com/watch?v=GS9TyovoU4c&t=1957s
    public int lengthOfLongestSubstringSlidingWindow(String s){
        int maxLength = 0;
        Map<String, Integer> visitedCharacters = new HashMap<>();

        for (int right = 0, left = 0; right < s.length(); right++){
            String currentCharLoop = String.valueOf(s.charAt(right));

            // Checking if my subs-string is valid, that is, moving the left pointer IF the actual value (right)
            // is inside our sub-string
            if (visitedCharacters.containsKey(currentCharLoop)
                    && visitedCharacters.get(currentCharLoop) >= left){
                left = visitedCharacters.get(currentCharLoop) + 1;

                //left++ doesn't work in case we have repeated letters in sequence like "aab",
                // we should move the left pointer from 0 to 2, not to 1.
            }

            // Didn't get this part (maybe because indexes start at zero)
            maxLength = Math.max(maxLength, right - left + 1);

            // Updating the occurrence for that char
            visitedCharacters.put(currentCharLoop, right);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringBruteForce(String s) {
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
        Assertions.assertEquals(4, lengthOfLongestSubstringBruteForce("abcabcd"));
        Assertions.assertEquals(3, lengthOfLongestSubstringBruteForce("abcabc"));

        Assertions.assertEquals(4, lengthOfLongestSubstringSlidingWindow("abcabcd"));
        Assertions.assertEquals(3, lengthOfLongestSubstringSlidingWindow("abcabc"));
    }
}
