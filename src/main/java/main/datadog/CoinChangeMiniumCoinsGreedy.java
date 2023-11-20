package main.datadog;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CoinChangeMiniumCoinsGreedy {

    public static List<Integer> firstVariationInfiniteCoins(List<Integer> coins, int value){
        // 10, 20, 50, 100
        // 70
        List<Integer> result = new ArrayList<>();
        for(int i = coins.size() -1; i >= 0;){
            Integer currentCoin = coins.get(i);
            if(value >= currentCoin){
                value-=currentCoin;
                result.add(currentCoin);
                continue;
            }

            i--;
        }

        System.out.println(result);
        return result;
    }

    public static int secondVariationNotInfiniteCoins(List<Integer> coins, int value){

        int result = 0;
        for(int i = coins.size() - 1; i >= 0; i--){
            if(value >= coins.get(i)){
                value-=coins.get(i);
                result++;
            }
        }

        return result;
    }

    public static int[] thirdVariationPrimitives(int[] coins, int value){

        List<Integer> returned = new ArrayList<>();
        for(int i = coins.length - 1; i >= 0;){
            if(value >= coins[i]){
                value-=coins[i];
                returned.add(coins[i]);
                continue;
            }

            i--;
        }

        return returned.stream().mapToInt(i -> i.intValue()).toArray();
    }

//    @Test
//    public void emptyOrNullString(){
//        int[] coins = {1, 2, 5, 10, 20,
//                50, 100, 500, 1000};
//
//        assertEquals(2, firstVariationInfiniteCoins(coins, 70));
//        assertEquals(2, findCoinChangeMinimumCoinsSecond(coins, 70));
//
//        assertEquals(2, firstVariationInfiniteCoins(new int[]{1, 2, 5, 10, 20, 50, 100, 500, 1000}, 40));
//        assertEquals(2, findCoinChangeMinimumCoinsSecond(new int[]{1, 2, 5, 10, 20, 50, 100, 500, 1000}, 40));
//
//        assertEquals(3, firstVariationInfiniteCoins(new int[]{5, 10, 20, 25}, 70));
//        assertEquals(3, findCoinChangeMinimumCoinsSecond(new int[]{5, 10, 20, 25}, 70));
//
//        assertEquals(5, firstVariationInfiniteCoins(new int[]{5, 10, 20, 25, 50}, 140));
//        assertEquals(5, findCoinChangeMinimumCoinsSecond(new int[]{5, 10, 20, 25, 50}, 140));
//    }


}
