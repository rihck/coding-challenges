package main.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
 */
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        String incrementalResult = "";
        int pointer = 0;
        //"ABCABC", "ABC"
        //"ABABAB", "ABAB"

        for (int i = 0; i < str1.length(); i++){
            Character currentChar = str1.charAt(i);

            if (pointer >= str2.length())
                pointer = 0;

            Character charAtPointer = str2.charAt(pointer);

            if (currentChar == charAtPointer){
                incrementalResult += currentChar;
                pointer++;
            }
            else {
                pointer = 0;
                str2 = incrementalResult;
                incrementalResult = "";
            }

        }

        return incrementalResult;
    }

    @Test
    public void perfectDivision(){
        assertEquals("ABC", gcdOfStrings("ABCABC", "ABC"));
    }

//    @Test
//    public void divisionButNoFullMatch(){
//        assertEquals("AB", gcdOfStrings("ABABAB", "ABAB"));
//    }

}
