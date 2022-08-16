package main;

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

    static Integer returnFirstRecurring(List<Integer> list){
        Integer firstRecurring = null;
        Set<Integer> pastNumbers = new HashSet<>();

        for(int i = 0; i < list.size(); i++){
            int currentNumber = list.get(i);

            if (pastNumbers.contains(currentNumber)){
                firstRecurring = currentNumber;
                break;
            }

            pastNumbers.add(currentNumber);
        }

        return firstRecurring;
    }


    @Test
    void findRecurring(){
        List<Integer> input1 = Arrays.asList(2,5,1,2,3,5,1,2,4);
        List<Integer> input2 = Arrays.asList(2,1,1,2,3,5,1,2,4);
        List<Integer> input3 = Arrays.asList(2,3,4,5);


        assertEquals(returnFirstRecurring(input1), 2);
        assertEquals(returnFirstRecurring(input2), 1);
        assertNull(returnFirstRecurring(input3));
    }

    public static void main(String[] args) {
        Integer result = returnFirstRecurring(Arrays.asList(2,1,1,2,3,5,1,2,4));

        System.out.println(result);
    }
}
