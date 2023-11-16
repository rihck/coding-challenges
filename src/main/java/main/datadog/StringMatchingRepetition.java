package main.datadog;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringMatchingRepetition {
    public static boolean matchStringRepetition(String match, String word){

        Character letterToMatch = match.charAt(0);
        Integer timesToMATCH = Integer.valueOf(String.valueOf(match.charAt(1)));

        for (int i = 0; i < word.length(); i++){
            Character currentChar = word.charAt(i);

            if (currentChar == letterToMatch){
                timesToMATCH--;

                if (timesToMATCH <= 0) return true;
            }
        }

        return false;
    }

    @Test
    public void emptyOrNullString(){
        assertTrue(matchStringRepetition("a2", "aa"));
    }

}
