package main.leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

// https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String commonPrefix = strs[0];

        for (int i = 1; i < strs.length; i++){ //O(N)
            int pointer = 0;
            String actualString = strs[i];

            while (pointer < commonPrefix.length() && pointer < actualString.length()){
                if (actualString.charAt(pointer) != commonPrefix.charAt(pointer)) {
                    break;
                }

                pointer++;
            }

            if (pointer == 0)
                return "";

            commonPrefix = commonPrefix.substring(0, pointer);
        }

        return commonPrefix;
    }

    @Test
    public void mainTestCases(){
        assertEquals("fl", longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assertEquals("", longestCommonPrefix(new String[]{"dog", "car", "racecar"}));
        assertEquals("", longestCommonPrefix(new String[]{"one"}));
    }
}
