package main.zerotomastery;

import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class FirstRecurringCharacter {

    //Google Question
    //Given an array = [2,5,1,2,3,5,1,2,4]:
    //It should return 2

    //Given an array = [2,1,1,2,3,5,1,2,4]:
    //It should return 1

    //Given an array = [2,3,4,5]:
    //It should return undefined

    /**
     * Time complexity: O(n) Solution -> Due to Array Loop
     * Space complexity: O(n) Because we're adding N elements to the Set (every loop)
     * @param list
     * @return
     */
    static Integer returnFirstRecurring(List<Integer> list){
        Integer firstRecurring = null;
        Set<Integer> pastNumbers = new HashSet<>();

        for(int i = 0; i < list.size(); i++){ //Time Complexity: O(n) -> For
            int currentNumber = list.get(i);

            //Time Complexity: O(1) -> HashTable Related Operations
            if (pastNumbers.contains(currentNumber) ){
                firstRecurring = currentNumber;
                break;
            }

            pastNumbers.add(currentNumber); // Space complexity: O(n)
        }

        return firstRecurring;
    }

    /**
     * Find X recurring: first, second or third...
     *     //Given = [2,5,5,2,3] and 2:
     *     //It should return 2 because it's the 2nd number that repeats
     *
     *     //Given an array = [2,5,5,2,3,3] and 3:
     *     //It should return 3
     */
    static Integer returnXRecurring(List<Integer> list, int numRecurring){
        Integer foundRecurring = null;
        Set<Integer> pastNumbers = new HashSet<>();
        int timesOccurred = 0;

        for(int i = 0; i < list.size(); i++){ //Time Complexity: O(n) -> For
            int currentNumber = list.get(i);

            //Time Complexity: O(1) -> HashTable Related Operations
            if (pastNumbers.contains(currentNumber) ){
                timesOccurred++;

                if (timesOccurred == numRecurring) {
                    foundRecurring = currentNumber;
                    break;
                }
            }

            pastNumbers.add(currentNumber); // Space complexity: O(n)
        }

        return foundRecurring;
    }


    @Test
    void findFirstRecurring(){
        List<Integer> input1 = Arrays.asList(2,5,1,2,3,5,1,2,4);
        List<Integer> input2 = Arrays.asList(2,1,1,2,3,5,1,2,4);
        List<Integer> input3 = Arrays.asList(2,3,4,5);


        assertEquals(returnFirstRecurring(input1), 2);
        assertEquals(returnFirstRecurring(input2), 1);
        assertNull(returnFirstRecurring(input3));
    }

    @Test
    void findXRecurring(){
        List<Integer> input1 = Arrays.asList(2,5,5,2,3);
        List<Integer> input2 = Arrays.asList(2,5,5,2,3,3);
        List<Integer> input3 = Arrays.asList(2,3,4,5);


        assertEquals(returnXRecurring(input1, 2), 2);
        assertEquals(returnXRecurring(input2, 3), 3);
        assertNull(returnXRecurring(input3, 1));
    }

    public static void main(String[] args) {
        Integer result = returnFirstRecurring(Arrays.asList(2,5,5,2,3,5,1,2,4));

        System.out.println(result);
    }
}
