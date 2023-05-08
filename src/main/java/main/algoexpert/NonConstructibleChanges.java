package main.algoexpert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NonConstructibleChanges {

    public int nonConstructibleChange(int[] coins) {
        coins = Arrays.stream(coins).sorted().toArray();

        int currentChange = 0;
        for (int coin: coins) {
            if(coin > currentChange + 1)
                return currentChange+1;

            currentChange+=coin;
        }

        return currentChange+1;
    }

    public int nonConstructibleChangeConvertingToList(int[] coins) {
        List<Integer> coinsAsList = Arrays.stream(coins).boxed().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        int currentChange = 0;
        for (Integer coin: coinsAsList) {
            if(coin > currentChange + 1)
                return currentChange+1;

            currentChange+=coin;
        }

        return currentChange+1;
    }

    @Test
    @DisplayName("Main Test Case")
    void mainTestCase(){
        int[] coins = new int[]{5, 7, 1, 1, 2, 3, 22};

        int result = nonConstructibleChange(coins);

        Assertions.assertEquals(20, result);
    }
}
