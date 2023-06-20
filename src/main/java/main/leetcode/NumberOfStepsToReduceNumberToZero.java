package main.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfStepsToReduceNumberToZero {
    public int numberOfSteps(int num) {
        int steps = 0;

        while(num > 0){
            if(num % 2 == 0)
                num = num / 2;
            else
                num = num -1;

            steps++;
        }

        return steps;
    }

    @Test
    public void mainTestCases(){
        Assert.assertEquals(6, numberOfSteps(14));
        Assert.assertEquals(4, numberOfSteps(8));
    }
}
