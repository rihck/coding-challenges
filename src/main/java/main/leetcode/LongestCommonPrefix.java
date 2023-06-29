package main.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length <= 1) return "";

        String first = strs[0];
        String second = strs[1];
        String commonLetters = "";

        for (int i = 0; i < first.length() && i < second.length(); i++){
            Character currentChar = first.charAt(i);
            Character currentSecondChar = second.charAt(i);
            if (currentChar == currentSecondChar)
                commonLetters+= currentChar;
        }

        if (commonLetters.length() == 0) return "";

        // strs = ["flower","flow","flight"]
        for (int i = 2; i < strs.length; i++){
            String currentString = strs[i];
            if (currentString.substring(0, commonLetters.length()) != commonLetters)
                return "";
        }

        return commonLetters;
    }

    @Test
    public void mainTestCases(){
        // FAILING: Finding "flow" between first two, Approach of creating rule base on 2 firsts does not work
        Assert.assertEquals("fl", longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
