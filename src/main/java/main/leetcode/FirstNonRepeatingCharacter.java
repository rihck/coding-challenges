package main.leetcode;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class FirstNonRepeatingCharacter {

    public String firstNonRepeatingCharacter(String s){
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
