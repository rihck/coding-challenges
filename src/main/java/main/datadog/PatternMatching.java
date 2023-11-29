package main.datadog;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PatternMatching {

    public boolean validatePattern(String pattern, String word) {
        StringBuilder newPattern = new StringBuilder();
        final char UNDERSCORE = '_';

        for (int i = 0; i < pattern.length(); i++) {
            char currentChar = pattern.charAt(i);
            if (Character.isDigit(currentChar)) {
                for (int j = 0; j < Character.getNumericValue(currentChar); j++) {
                    newPattern.append(UNDERSCORE);
                }
            }
            else
                newPattern.append(currentChar);
        }

        String newPatternString = newPattern.toString();

        for (int i = 0; i < word.length(); i++) {
            char currentCharPattern = newPatternString.charAt(i);
            char curremtCharWord = word.charAt(i);

            if (currentCharPattern != UNDERSCORE &&
                    currentCharPattern != curremtCharWord) {
                return false;
            }

        }

        return true;

    }

    @Test
    public void validCase(){
        assertTrue(validatePattern("dat3g", "datadog"));
        assertFalse(validatePattern("dat2g", "datadog"));
    }
}
