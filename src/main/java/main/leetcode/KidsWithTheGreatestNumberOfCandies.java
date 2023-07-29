package main.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 */

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
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
        List<Boolean> output = kidsWithCandies(candies, 3);
        Collections.unmodifiableList(Arrays.asList(true, true, true, false, true));
        Assert.assertEquals(expected, output);

    }

    @Test
    public void oneKidsWithExtraCandies(){
        int[] candies = new int[]{4,2,1,1,2};

        List<Boolean> expected = Stream.of(true,false,false,false,false).collect(Collectors.toList());
        List<Boolean> output = kidsWithCandies(candies, 1);
        Assert.assertEquals(expected, output);

    }
}
