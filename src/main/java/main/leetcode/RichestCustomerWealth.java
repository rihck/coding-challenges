package main.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.Math.max;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for(int i = 0; i < accounts.length; i++){
            int currentWealth = 0;
            for (int j = 0; j < accounts[i].length; j++){
                //1
                currentWealth+= accounts[i][j];
            }

            maxWealth = Math.max(maxWealth, currentWealth);
        }

        return maxWealth;
    }

    @Test
    public void mainTestCases(){
        int [][] input = new int[][]{{1,5},
                                     {7,3},
                                     {3,5}};

        Assert.assertEquals(10, maximumWealth(input));


        int [][] input2 = new int[][]{
                                    {1,2,3},
                                    {3,2,1}
        };

        Assert.assertEquals(6, maximumWealth(input2));
    }
}
