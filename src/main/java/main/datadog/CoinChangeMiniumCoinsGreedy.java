package main.datadog;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CoinChangeMiniumCoinsGreedy {


    public static int findCoinChangeMinimumCoinsSecond(int[] coins, int value){
        List<Integer> coinChange = new ArrayList<>();

        int coinPointer = coins.length - 1;
        while (value != 0 && coinPointer >= 0){
            int currentCoin = coins[coinPointer];

            if (value >= currentCoin){
                coinChange.add(currentCoin);
                value -= currentCoin;
            }
            else {
                coinPointer--;
            }
        }

        return coinChange.size();
    }

    public static int findCoinChangeMinimumCoinsFirst(int[] coins, int value){
        List<Integer> coinChange = new ArrayList<>();

        for (int i = coins.length -1; i >= 0;){
            int currentCoin = coins[i];

            if (value >= currentCoin){
                value-=currentCoin;
                coinChange.add(currentCoin);
            }
            else i--;

            System.out.println(currentCoin);
        }

        return coinChange.size();
    }

    @Test
    public void emptyOrNullString(){
        int[] coins = {1, 2, 5, 10, 20,
                50, 100, 500, 1000};

        //assertEquals(2, findCoinChangeMinimumCoinsFirst(coins, 70));
        assertEquals(2, findCoinChangeMinimumCoinsSecond(coins, 70));

        assertEquals(2, findCoinChangeMinimumCoinsFirst(new int[]{1, 2, 5, 10, 20, 50, 100, 500, 1000}, 40));
        assertEquals(2, findCoinChangeMinimumCoinsSecond(new int[]{1, 2, 5, 10, 20, 50, 100, 500, 1000}, 40));

        assertEquals(3, findCoinChangeMinimumCoinsFirst(new int[]{5, 10, 20, 25}, 70));
        assertEquals(3, findCoinChangeMinimumCoinsSecond(new int[]{5, 10, 20, 25}, 70));

        assertEquals(5, findCoinChangeMinimumCoinsFirst(new int[]{5, 10, 20, 25, 50}, 140));
        assertEquals(5, findCoinChangeMinimumCoinsSecond(new int[]{5, 10, 20, 25, 50}, 140));
    }


}
