package main.algoexpert;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateSubsequence {

    public boolean validateSubSequence(List<Integer> array, List<Integer> sequence){
        int indexSubSequence = 0;
        boolean isSubSequence = false;
        for(int i = 0; i < array.size(); i++){
            if (array.get(i) == sequence.get(indexSubSequence)){
                indexSubSequence++;
            }

            if (indexSubSequence >= sequence.size()){
                isSubSequence = true;
                break;
            }
        }

        return isSubSequence;
    }

    public boolean validateSubSequenceWithQueue(List<Integer> array, List<Integer> sequence){
        Queue<Integer> sequenceQueue = new LinkedList<>();
        for (int i = 0; i < sequence.size(); i++){
            sequenceQueue.add(sequence.get(i));
        }

        for(int i = 0; i < array.size(); i++){
            if (array.get(i) == sequenceQueue.peek()){
                sequenceQueue.poll();
            }
        }

        return sequenceQueue.isEmpty();
    }

    @Test
    @DisplayName("Contains Partial Sub Sequence")
    public void containsPartialSubSequence(){
        assertTrue(validateSubSequenceWithQueue(Arrays.asList(1, 7, -1, 10), Arrays.asList(1, -1)));
    }

    @Test
    @DisplayName("Contains Sub Sequence but last match in last element")
    public void containsSubSequenceButInLastElement(){
        assertFalse(validateSubSequence(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10), Arrays.asList(1, 6, -1, 10)));
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
