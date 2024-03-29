package main.algoexpert;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.algoexpert.io/questions/two-number-sum
 *
     Write a function that takes in a non-empty array of distinct integers and an
     integer representing a target sum. If any two numbers in the input array sum
     up to the target sum, the function should return them in an array, in any
     order. If no two numbers sum up to the target sum, the function should return
     an empty array.
 */
public class TwoNumberSum {
    List<Integer> twoNumberSum(List<Integer> input, int totalSum){
        Set<Integer> asSet = new HashSet<>();
        for(Integer num : input){
            asSet.add(num);
        }

        for(int i = 0; i < input.size(); i++){
            Integer lookFor = totalSum - input.get(i);
            if (asSet.contains(lookFor) && lookFor != input.get(i))
                return Arrays.asList(input.get(i), lookFor);
        }

        return new ArrayList<>();
    }

    public int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> asSet = new HashSet<>();
        for (int i = 0; i < array.length; i++){
            asSet.add(array[i]);
        }

        for (int i = 0; i < array.length; i++){
            int lookFor = targetSum - array[i];
            if (asSet.contains(lookFor) && lookFor != array[i])
                return new int[]{array[i], lookFor};
        }

        return new int[0];
    }

    @Test
    @DisplayName("Happy Path")
    public void happyPath(){
        List<Integer> result = twoNumberSum(Arrays.asList(3, 4, 7, 6), 10);
        int[] resultInArray = twoNumberSum(new int[]{3, 4, 7, 6}, 10);

        assertEquals(2, result.size());
        assertEquals(2, resultInArray.length);
    }

    @Test
    @DisplayName("Happy Path - Containing number that added to itself gives the sum")
    public void containingNumberAddedToItselfGivesTheSum(){
        List<Integer> result = twoNumberSum(Arrays.asList(4, 7, 8, 5, -1, 11), 10);
        assertEquals(2, result.size());
        assertArrayEquals(Arrays.asList(-1, 11).toArray(), result.toArray()); //Not the best way but works.
        assertEquals(-1, result.get(0));
        assertEquals(11, result.get(1));

        int[] resultInArray = twoNumberSum(new int[]{4, 7, 8, 5, -1, 11}, 10);
        assertEquals(2, resultInArray.length);
        assertArrayEquals(new int[]{-1, 11}, resultInArray);
    }

    @Test
    @DisplayName("No match")
    public void noMatch(){
        List<Integer> result = twoNumberSum(Arrays.asList(3, 4, 4, 8), 10);
        int[] resultInArray = twoNumberSum(new int[]{3, 4, 4, 8 }, 10);

        assertEquals(0, result.size());
        assertEquals(0, resultInArray.length);
    }

}
