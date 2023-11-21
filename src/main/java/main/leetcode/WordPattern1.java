package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern1 {

    // Input: pattern = "abba", s = "dog cat cow dog"
    // Output: true
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<Character, String> patternMapping = new HashMap<>();

        // if sizes don't match
        if(words.length != pattern.length())
            return false;

        // looping thru patterns
        for(int i = 0; i < pattern.length(); i++){
            char currentChar = pattern.charAt(i);

            // IF pattern already in Map But trying to map to different value
            // abba / dog cat cat cow
            if(patternMapping.containsKey(currentChar)){
                if(!patternMapping.get(currentChar).equals(words[i]))
                    return false;
            }
            else {
                // If the word is already on the Map BUT mapped to another char
                // abba / dog dog dog dog
                // PS: Improve with 2 maps?
                if(patternMapping.containsValue(words[i]))
                    return false;

                patternMapping.put(currentChar, words[i]);
            }

        }

        return true;
    }
}
