package main.datadog;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class FindRepeatedCharacter {

    // Count number of repetition in a given string
    public static String countNumberOfRepetitionInAGivenString(String word){

        Map<Character, Integer> repetitionMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++){
            Character current = word.charAt(i);

            if (!repetitionMap.containsKey(current))
                repetitionMap.put(current, 0);

            repetitionMap.put(current, repetitionMap.get(current) + 1);
        }

        Set<Map.Entry<Character, Integer>> entries = repetitionMap.entrySet();
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
            builder.append(entry.getKey()).append(entry.getValue());
        }

        return builder.toString();
    }

    @Test
    public void emptyOrNullString(){
        assertEquals("a4b3", countNumberOfRepetitionInAGivenString("aaaabbb"));
    }

}
