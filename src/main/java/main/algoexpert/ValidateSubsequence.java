package main.algoexpert;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateSubsequence {

    public boolean validateSubSequence(List<Integer> array, List<Integer> sequence){
        Map<Integer, Integer> valuesAndIndexes = new HashMap<>();
        for(int i = 0; i < array.size(); i++){
            valuesAndIndexes.put(array.get(i), i);
        }

        int lastIndex = -1;
        for (int i = 0; i < sequence.size(); i++){
            if (!valuesAndIndexes.containsKey(sequence.get(i))){
                return false;
            }

            int foundNumberIndex = valuesAndIndexes.get(sequence.get(i));
            if (lastIndex > foundNumberIndex)
                return false;

            lastIndex = foundNumberIndex;
        }

        return true;
    }

    @Test
    @DisplayName("Contains Partial Sub Sequence")
    public void containsPartialSubSequence(){
        assertTrue(validateSubSequence(Arrays.asList(1, 7, -1, 10), Arrays.asList(1, -1)));
    }

    @Test
    @DisplayName("Contains Sub Sequence but not in order")
    public void sadPath(){
        assertFalse(validateSubSequence(Arrays.asList(1, 7, -1, 10), Arrays.asList( 1, -1, 7)));
    }

    @Test
    @DisplayName("Another Sad Path")
    public void anotherSadPath(){
        assertFalse(validateSubSequence(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10), Arrays.asList(1, 6, -1, -1)));
    }

}
