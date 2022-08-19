package main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an index find the related value on the Fibonacci sequence
 * Fibonacci: 0, 1, 1, 2, 3, 5, 8, 13, 21 ...
 */

public class Fibonacci {

    public static void main(String[] args) {

    }

    static int recursiveFibonacci(int index){
        if (index < 2){
            return index;
        }

        return recursiveFibonacci(index-1) + recursiveFibonacci(index-2);
    }

    static int iterativeFibonacci(int index){ // 3
        List<Integer> fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(0);
        fibonacciSequence.add(1);

        if (index < 2){
            return fibonacciSequence.get(index);
        }

        for(int i = 2; i <= index; i++){
            int previousElementsSum = fibonacciSequence.get(i-1) + fibonacciSequence.get(i-2);

            fibonacciSequence.add(previousElementsSum);
        }

        return fibonacciSequence.get(index);
    }

    @Test
    void testFactorial(){
        assertEquals(2, recursiveFibonacci(3));
        assertEquals(21, recursiveFibonacci(8));

        assertEquals(2, iterativeFibonacci(3));
        assertEquals(21, iterativeFibonacci(8));
    }
}
