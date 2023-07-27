package main.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
 */
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        System.out.println("str1: " + str1 + ", | str2: " + str2);

        if(str2.length() > str1.length()){
            System.out.println("str2 is longer than str1, so we swap them");
            return gcdOfStrings(str2, str1);
        }

        if(str2.equals(str1)){
            System.out.println("str2 is equal to str1, so we return str2");
            return str1;
        }

        if(str1.startsWith(str2)){
            System.out.println("str1 starts with str2, so we return the gcd of the remainder of str1 and str2");
            System.out.println("str1 becomes " + str1.substring(str2.length()));
            System.out.println(str2.length());

            return gcdOfStrings(str1.substring(str2.length()), str2);
        }

        return "";
    }

    @Test
    public void perfectDivision(){
        assertEquals("ABC", gcdOfStrings("ABCABC", "ABC"));
    }

    @Test
    public void divisionButNoFullMatch(){
        assertEquals("AB", gcdOfStrings("ABABAB", "ABAB"));
        //assertEquals("ABC", gcdOfStrings("ABCABC", "ABC"));
    }

}
