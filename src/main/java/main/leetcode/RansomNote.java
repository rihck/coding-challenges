package main.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine){
        Map<Character, Integer> magazineLetters = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++){
            Character currentChar = magazine.charAt(i);
            if (!magazineLetters.containsKey(currentChar))
                magazineLetters.put(currentChar, 0);


            Integer currentCharCount = magazineLetters.get(currentChar);
            magazineLetters.put(currentChar, ++currentCharCount);
        }

        for (int i = 0; i < ransomNote.length(); i++){
            Character currentChar = ransomNote.charAt(i);

            if (!magazineLetters.containsKey(currentChar) || magazineLetters.get(currentChar) == 0)
                return false;

            Integer currentCharCount = magazineLetters.get(currentChar);
            magazineLetters.put(currentChar, --currentCharCount);
        }

        return true;
    }
    public boolean canConstructBruteForce(String ransomNote, String magazine) {
        for (int i = 0; i < ransomNote.length(); i++){
            Character currentChar = ransomNote.charAt(i);

            if (magazine.indexOf(currentChar) == -1)
                return false;

            magazine =  magazine.replaceFirst(String.valueOf(currentChar), "");
        }

        return true;
    }

    @Test
    public void mainTestCases(){
        Assert.assertFalse(canConstruct("a", "b"));
        Assert.assertFalse(canConstruct("aa", "ab"));
        Assert.assertTrue(canConstruct("aa", "aab"));
    }

    @Test
    public void mainTestCasesOld(){
        Assert.assertFalse(canConstructBruteForce("a", "b"));
        Assert.assertFalse(canConstructBruteForce("aa", "ab"));
        Assert.assertTrue(canConstructBruteForce("aa", "aab"));
    }
}
