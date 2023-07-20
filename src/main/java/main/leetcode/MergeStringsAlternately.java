package main.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
 */
public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        if ((word1 == null || word1.isEmpty()) && (word2 == null || word2.isEmpty()))
                return "";

        if (word1 == null || word1.isEmpty())
            return word2;

        if (word2 == null || word2.isEmpty())
            return word1;

        StringBuilder result = new StringBuilder();
        int word1Pointer = 0;
        int word2Pointer = 0;

        while (word1Pointer < word1.length() || word2Pointer < word2.length()){
            if (word1Pointer < word1.length()){
                result.append(word1.charAt(word1Pointer));
                word1Pointer++;
            }

            if (word2Pointer < word2.length()){
                result.append(word2.charAt(word2Pointer));
                word2Pointer++;
            }
        }

        return result.toString();
    }

    @Test
    public void bothStringsWithSameLength(){
        assertEquals("apbqcr", mergeAlternately("abc", "pqr"));
    }

    @Test
    public void oneStringIsEmptyOrNull(){
        assertEquals("abc", mergeAlternately("", "abc"));
        assertEquals("def", mergeAlternately("def", ""));
        assertEquals("abc", mergeAlternately(null, "abc"));
        assertEquals("def", mergeAlternately("def", null));
    }

    @Test
    public void stringsWithDifferentLength(){
        assertEquals("abcd", mergeAlternately("a", "bcd"));
        assertEquals("bacd", mergeAlternately("bcd", "a"));
    }

    @Test
    public void bothInvalidStringsNullOrEmpty(){
        assertEquals("", mergeAlternately(null, null));
        assertEquals("", mergeAlternately(null, null));
    }
}
