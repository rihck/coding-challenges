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
        int pointer = 0;

        while (pointer < word1.length() || pointer < word2.length()){
            if (pointer < word1.length())
                result.append(word1.charAt(pointer));

            if (pointer < word2.length())
                result.append(word2.charAt(pointer));

            pointer++;
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
