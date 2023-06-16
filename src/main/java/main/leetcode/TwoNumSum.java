package main.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoNumSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> previousNumbers = new HashMap<>();
        int[] resultIndexes = new int[2];

        // nums = [2,7,11,15], target = 9
        for(int i =0; i < nums.length; i++){
            int neededNumber = target - nums[i];
            if (previousNumbers.containsKey(neededNumber)){
                resultIndexes[0] = previousNumbers.get(neededNumber);
                resultIndexes[1] = i;
                return resultIndexes;
            }

            previousNumbers.put(nums[i], i);
        }

        return resultIndexes;
    }

    @Test
    void mainTestCases(){
        int[] arr = new int[]{2, 7, 11, 15};
        int[] result = twoSum(arr, 9);
        Assertions.assertTrue(result[0] == 0 || result[1] == 1);

        int[] arr2 = new int[]{3,2,4};
        int[] result2 = twoSum(arr2, 6);
        Assertions.assertTrue(result2[0] == 1 || result2[1] == 2);

        int[] arr3 = new int[]{3,3};
        int[] result3 = twoSum(arr3, 6);
        Assertions.assertTrue(result3[0] == 0 || result3[1] == 1);
    }
}
