package main.leetcode;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class FirstNonRepeatingCharacter {

    public String firstNonRepeatingCharacter(String s){
        if (s == null || s.isEmpty()) return "";

        String loweredCase = s.toLowerCase();
        LinkedHashMap<Character, Integer> counters = new LinkedHashMap<>();
        for (int i = 0; i < loweredCase.length(); i++){
            Character actualChar = loweredCase.charAt(i);
            if (!counters.containsKey(loweredCase.charAt(i))){
                counters.put(loweredCase.charAt(i), 0);
            }

            counters.put(actualChar, counters.get(actualChar) + 1);
        }

        Set<Map.Entry<Character, Integer>> entries = counters.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() == 1)
                return String.valueOf(entry.getKey());
        }

        return "";
    }

    @Test
    public void emptyOrNullString(){
        assertEquals("", firstNonRepeatingCharacter(""));
        assertEquals("", firstNonRepeatingCharacter(null));
    }

    @Test
    public void noRepeatingCharacter(){
        assertEquals("", firstNonRepeatingCharacter("GeeksGeeks"));
    }

    @Test
    public void repeatingCharacter(){
        assertEquals("f", firstNonRepeatingCharacter("geeksforgeeks"));
    }

    @Test
    public void repeatingCharacterCaseSensitive(){
        assertEquals("f", firstNonRepeatingCharacter("GeEkSfOrGeEKs"));
    }


}
