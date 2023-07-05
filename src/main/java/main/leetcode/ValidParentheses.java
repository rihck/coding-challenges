package main.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/** https://leetcode.com/problems/valid-parentheses/ **/
public class ValidParentheses {
    public boolean isValid(String s) {
        Map<String, Integer> simbolsCount = new HashMap<>();
        simbolsCount.put("(", 0);
        simbolsCount.put(")", 0);
        simbolsCount.put("[", 0);
        simbolsCount.put("]", 0);
        simbolsCount.put("{", 0);
        simbolsCount.put("}", 0);

        for (int i = 0; i < s.length(); i++){
            String currentChar = String.valueOf(s.charAt(i));
            simbolsCount.put(currentChar, simbolsCount.get(currentChar) + 1);
        }

        if (simbolsCount.get("(") != simbolsCount.get(")"))
            return false;

        if (simbolsCount.get("[") != simbolsCount.get("]"))
            return false;

        if (simbolsCount.get("{") != simbolsCount.get("}"))
            return false;

        return true;
    }

    @Test
    public void mainTestCases(){
        Assert.assertTrue(isValid("()"));
        Assert.assertTrue(isValid("()[]{}"));
        Assert.assertFalse(isValid("(]"));
    }
}
