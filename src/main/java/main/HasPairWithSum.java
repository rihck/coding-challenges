package main;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HasPairWithSum {
    public static void main(String[] args) {


        boolean resultWithoutMatch = hasPairWithSumOrdered(Arrays.asList(1, 2, 3, 9), 8);
        boolean resultWithMatch = hasPairWithSumOrdered(Arrays.asList(1, 2, 4, 4), 8);

        System.out.println(resultWithMatch);
        System.out.println(resultWithoutMatch);
    }

    static boolean hasPairWithSumNotOrdered(List<Integer> ordered, int sumTarget){

        Set<Integer> previousElementsSum = new HashSet<>();

        for (int i = 0; i < ordered.size(); i++){
            if (previousElementsSum.contains(ordered.get(i)))
                return true;

            previousElementsSum.add(sumTarget - ordered.get(i));
        }

        return false;
    }

    static boolean hasPairWithSumOrdered(List<Integer> ordered, int sumTarget){
        int low = 0;
        int high = ordered.size() - 1;


        while (low < high){
            int sum = ordered.get(low) + ordered.get(high);

            if (sum == sumTarget)
                return true;

            if (sum > sumTarget)
                high--;

            if (sum < sumTarget)
                low++;
        }

        return false;
    }

    @Test
    void testAssumingOrdered(){
        boolean resultWithoutMatch = hasPairWithSumOrdered(Arrays.asList(1, 2, 3, 9), 8);
        boolean resultWithMatch = hasPairWithSumOrdered(Arrays.asList(1, 2, 4, 4), 8);

        assertTrue(resultWithMatch);
        assertFalse(resultWithoutMatch);
    }

    @Test
    void testAssumingNotOrdered(){
        boolean resultWithoutMatch = hasPairWithSumNotOrdered(Arrays.asList(1, 2, 3, 9), 8);
        boolean resultWithMatch = hasPairWithSumNotOrdered(Arrays.asList(1, 2, 4, 4), 8);

        assertTrue(resultWithMatch);
        assertFalse(resultWithoutMatch);
    }

}
