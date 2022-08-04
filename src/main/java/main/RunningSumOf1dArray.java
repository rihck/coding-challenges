package main;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class RunningSumOf1dArray {

    public int[] solution(int[] input){
        int[] output = new int[input.length];

        for(int i = 0; i < input.length; i++){
            if (i == 0){
                output[i] = input[0];
                continue;
            }

            output[i] = output[i -1] + input[i];
        }

        System.out.println(Arrays.toString(output));

        return output;
    }

    @Test
    void testDefault(){
        int[] input = new int[]{1, 2, 3, 4};
        int[] expected = {1, 3, 6, 10};

        int[] output = solution(input);

        assertArrayEquals(expected, output);

    }

}
