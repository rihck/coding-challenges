package main.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> builtList = new ArrayList<>();

        for(int i = 1; i <= n ; i++){
            if(i % 3 == 0 && i % 5 == 0)
                builtList.add("FizzBuzz");
            else if (i % 3 == 0)
                builtList.add("Fizz");
            else if (i % 5 == 0)
                builtList.add("Buzz");
            else
                builtList.add(String.valueOf(i));
        }

        return builtList;
    }

    @Test
    public void mainTestCases(){
        List<String> expectedOutput = Arrays.asList("1","2","Fizz");
        List<String> output = fizzBuzz(3);

        Assert.assertArrayEquals(expectedOutput.toArray(), output.toArray());
    }
}
