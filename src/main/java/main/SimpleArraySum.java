package main;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Result {
    /*
     * Complete the 'simpleArraySum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY ar as parameter.
     */

    public static int simpleArraySum(List<Integer> ar) {
        return ar.stream().collect(Collectors.summingInt(Integer::intValue));

//         return ar.stream().reduce(0, (x, y) -> {
//             System.out.println("X = " + x + ", Y = " + y);
//             return x+y;
//             });

    }

    @Test
    void simpleCase(){
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 10, 11);
        int result = Result.simpleArraySum(input);

        assertEquals(31, result);
    }

}

public class SimpleArraySum {
    public static void main(String[] args) {

        List<Integer> ar = Arrays.asList(1, 2, 3, 4, 10, 11);

        int result = Result.simpleArraySum(ar);

        System.out.println(result);
    }
}
