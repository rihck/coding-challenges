package main;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HasPairWithSum {
    public static void main(String[] args) {


        boolean resultWithoutMatch = hasPairWithSumOrdered(Arrays.asList(1, 2, 3, 9), 8);
        boolean resultWithMatch = hasPairWithSumOrdered(Arrays.asList(1, 2, 4, 4), 8);

        System.out.println(resultWithMatch);
        System.out.println(resultWithoutMatch);
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
    void testDefault(){
        boolean resultWithoutMatch = hasPairWithSumOrdered(Arrays.asList(1, 2, 3, 9), 8);
        boolean resultWithMatch = hasPairWithSumOrdered(Arrays.asList(1, 2, 4, 4), 8);

        assertTrue(resultWithMatch);
        assertFalse(resultWithoutMatch);
    }


}
