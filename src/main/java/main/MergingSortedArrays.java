package main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MergingSortedArrays {

    // Input: [0, 3, 4, 31] / [4, 6, 30]
    // Output: [0, 3, 4, 4, 6, 30, 31]
    public static List<Integer> getSorted(List<Integer> input1, List<Integer> input2) {
        List<Integer> merged = new ArrayList<>();

        int firstIndex = 0;
        int secondIndex = 0;
        Integer array1Element = input1.get(firstIndex);
        Integer array2Element = input2.get(secondIndex);


        // Comparing each element of both arrays
        while (firstIndex < input1.size() && secondIndex < input2.size()) {
            array1Element = input1.get(firstIndex);
            array2Element = input2.get(secondIndex);

            if (array1Element < array2Element){
                merged.add(array1Element);
                firstIndex++;
            }
            else {
                merged.add(array2Element);
                secondIndex++;
            }
        }

        //When one of the arrays is smaller, we still need to add the rest of the bigger array to the merged array (the ones that were not compared <)

        //When first array is bigger than the second
        while (firstIndex < input1.size()){
            merged.add(input1.get(firstIndex));
            firstIndex++;
        }


        //When second array is bigger than the first
        while (secondIndex < input2.size()){
            merged.add(input2.get(secondIndex));
            secondIndex++;
        }

        return merged;
    }

    @Test
    void defaultCase(){
        List<Integer> input1 = Arrays.asList(0, 3, 4, 31);
        List<Integer> input2 = Arrays.asList(4, 6, 30);

        List<Integer> expectedOutput = Arrays.asList(1, 2, 1, 1, 2, 1);

        List<Integer> result = getSorted(input1, input2);

        //assertArrayEquals(expectedOutput, result);
    }

    public static void main(String[] args) {
        List<Integer> input1 = Arrays.asList(0, 3, 4, 31);
        List<Integer> input2 = Arrays.asList(4, 6, 30);

        List<Integer> expectedOutput = Arrays.asList(0, 3, 4, 4, 6, 30, 31);

        List<Integer> result = getSorted(input1, input2);

        System.out.println(result);


    }
}
