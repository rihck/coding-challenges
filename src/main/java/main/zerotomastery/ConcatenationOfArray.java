package main.zerotomastery;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/concatenation-of-array/
public class ConcatenationOfArray {
    public static int[] getConcatenation(int[] nums) {
        int[] output = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++){
            output[i] = nums[i];
            output[i + nums.length] = nums[i];
        }

        return output;
    }

    @Test
    void defaultCase(){
        int[] input = {1, 2, 1};
        int[] output = {1, 2, 1, 1, 2, 1};

        int[] concatenation = getConcatenation(input);

        assertArrayEquals(concatenation, output);
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 1};
        int[] output = new int[input.length * 2];

        for (int i = 0; i < input.length; i++){
            output[i] = input[i];
            output[i] = input[i + input.length -1];
        }

    }
}
