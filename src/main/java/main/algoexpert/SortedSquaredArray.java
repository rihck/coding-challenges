package main.algoexpert;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
public class SortedSquaredArray {

    /**
     * O(N)
     * @param array
     * @return
     */
    public int[] sortedSquaredArrayQueue(int[] array){
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0; i < array.length; i++){
            int squared = array[i] * array[i];
            queue.add(squared);
        }

        int[] arrayOutput = new int[queue.size()];
        int count = 0;
        while (queue.peek() != null){
            arrayOutput[count++] = queue.poll();
        }

        return arrayOutput;
    }

    /**
     * O(n log (n))
     * @param array
     * @return
     */
    public int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int[] outputArray = new int[array.length];

        for (int i=0; i < array.length; i++){
            outputArray[i] = array[i] * array[i];
        }

        // PS: Need to sort because negative numbers doesn't stay in order after calculating square. Test case 11 for example.
        // Not good -> O(n log (n))
        outputArray = Arrays.stream(outputArray).sorted().toArray();

        return outputArray;
    }

    @Test
    @DisplayName("Happy Path")
    public void happyPath(){
        int[] returnArray = sortedSquaredArray(new int[]{1, 2, 3, 5, 6, 8, 9});
        assertArrayEquals(new int[]{1, 4, 9, 25, 36, 64, 81}, returnArray);

        int[] returnArray2 = sortedSquaredArrayQueue(new int[]{1, 2, 3, 5, 6, 8, 9});
        assertArrayEquals(new int[]{1, 4, 9, 25, 36, 64, 81}, returnArray2);
    }

    @Test
    @DisplayName("Negative Numbers")
    public void negativeNumbers(){
        int[] returnArray = sortedSquaredArray(new int[]{-10, -5, 0, 5, 10});
        assertArrayEquals(new int[]{0, 25, 25, 100, 100}, returnArray);

        int[] returnArray2 = sortedSquaredArrayQueue(new int[]{-10, -5, 0, 5, 10});
        assertArrayEquals(new int[]{0, 25, 25, 100, 100}, returnArray2);
    }

    @Test
    @DisplayName("Another Happy Path")
    public void anotherHappyPath(){
        int[] returnArray = sortedSquaredArray(new int[]{-7, -3, 1, 9, 22, 30});
        assertArrayEquals(new int[]{1, 9, 49, 81, 484, 900}, returnArray);

        int[] returnArray2 = sortedSquaredArrayQueue(new int[]{-7, -3, 1, 9, 22, 30});
        assertArrayEquals(new int[]{1, 9, 49, 81, 484, 900}, returnArray2);
    }

}
