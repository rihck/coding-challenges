package main.zerotomastery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseString {


    public static void main(String[] args) {
        String hello = "hello";

        System.out.println(hello.substring(1));
        System.out.println(hello.charAt(0));
    }
    static String iterativeReverse(String word){
        StringBuilder builder = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--){
            builder.append(word.charAt(i));
        }

        return builder.toString();
    }
    static String recursionReverse(String word){
        if (word.isEmpty())
            return "";

        // result + first char
            // result + second char
        return recursionReverse(word.substring(1)) + word.charAt(0);
    }

    @Test
    void testReverse(){
        assertEquals("olleh", iterativeReverse("hello"));

        assertEquals("olleh", recursionReverse("hello"));

    }

}
