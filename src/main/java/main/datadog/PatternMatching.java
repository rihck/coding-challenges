package main.datadog;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Possible Problem Statement
 * Create an algorithm that validates whether a given pattern string aligns with a test string. The pattern string may contain alphanumeric characters and numeric placeholders. The algorithm should compare this pattern with the test string, considering both exact character matches and designated placeholders. Determine if the test string matches the pattern criteria, returning **`true`** if all characters align or act as placeholders; otherwise, return **`false`**.
 *
 * This problem requires a function that takes two strings as input: a pattern string and a test string. The function should assess whether the characters in the test string correspond to the pattern criteria, returning **`true`** if they align with the pattern or act as placeholders and **`false`** otherwise.
 */
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
