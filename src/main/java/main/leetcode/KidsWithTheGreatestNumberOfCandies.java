package main.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 */

public class KidsWithTheGreatestNumberOfCandies {

    /**
     * Other possible approaches I'm thinking of:
     * 1) Convert the value in a BST so the search will be faster inside the inner loop
     * 2) Keep reference of the first greatest value (and maybe second) and compare each element on the for with the greatest/second greatest
     *
     *
     */

    // Still Bad performance (O(log(n)) -> BST Search inside a O(N) Loop
    public List<Boolean> kidsWithCandiesBst(int[] candies, int extraCandies) {
        List<Boolean> output = new ArrayList<>();
        TreeSet<Integer> orderedValues = new TreeSet<>(Comparator.naturalOrder());

        for(int i = 0; i < candies.length; i++){
            Integer current = candies[i];
            orderedValues.add(current);
        }

        for(int i = 0; i < candies.length; i++){
            Integer currentPlusExtraCandies = candies[i] + extraCandies;

            Integer higherFound = orderedValues.higher(currentPlusExtraCandies);
            if (higherFound == null)
                output.add(true);
            else
                output.add(false);
        }

        return output;
    }

    public List<Boolean> kidsWithCandiesBruteforce(int[] candies, int extraCandies) {
        List<Boolean> output = new ArrayList<>();
        for(int i = 0; i < candies.length; i++){
            Integer currentPlusExtraCandies = candies[i] + extraCandies;

            boolean currentIsGreatThanAllAddingExtraCandies = true;
            for (int j = 0; j < candies.length; j++){
                Integer comparingTo = candies[j];
                if (comparingTo > currentPlusExtraCandies){
                    currentIsGreatThanAllAddingExtraCandies = false;
                    break;
                }
            }

            output.add(currentIsGreatThanAllAddingExtraCandies);
        }

        return output;
    }

    @Test
    public void threeKidsWithExtraCandies(){
        int[] candies = new int[]{2,3,5,1,3};

        List<Boolean> expected = Stream.of(true, true, true, false, true).collect(Collectors.toList());
        List<Boolean> output = kidsWithCandiesBst(candies, 3);
        Collections.unmodifiableList(Arrays.asList(true, true, true, false, true));
        Assert.assertEquals(expected, output);

    }

    @Test
    public void oneKidsWithExtraCandies(){
        int[] candies = new int[]{4,2,1,1,2};

        List<Boolean> expected = Stream.of(true,false,false,false,false).collect(Collectors.toList());
        List<Boolean> output = kidsWithCandiesBruteforce(candies, 1);
        Assert.assertEquals(expected, output);

    }
}
