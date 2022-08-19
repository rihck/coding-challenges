package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Factorial {

    public static void main(String[] args) {
        int factorialFrom = recursiveFindFactorialFrom(3);
        int forFindFactorialFrom = forFindFactorialFrom(3);

        System.out.println(factorialFrom);
        System.out.println(forFindFactorialFrom);
    }

    static int recursiveFindFactorialFrom(int number){
        if (number != 1)
            return number * recursiveFindFactorialFrom(number-1);

        return 1;
    }

    static int forFindFactorialFrom(int number){
        int result = 1;

        // Opt 1 - From 1 to number
        for (int i = 2; i <= number; i++){
            result = result * i;
        }

        result = 1;
        //Opt 2 - Backwards
        for (int i = number; i >= 2; i--){
            result = result * i;
        }

        return result;
    }

    @Test
    void testFactorial(){
        assertEquals(6, recursiveFindFactorialFrom(3));
        assertEquals(6, forFindFactorialFrom(3));
    }
}
