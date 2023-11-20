package main.datadog;

import java.util.*;
import java.util.stream.Collectors;

public class FindRepeatedCharacter {

    // Count number of repetition in a given string
    public static List<String> findRepeatedCharacter(String word){

        Map<Character, Integer> stringCount = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            Character currentChar = word.charAt(i);
            if(!stringCount.containsKey(currentChar)){
                stringCount.put(currentChar, 0);
            }

            stringCount.put(currentChar, stringCount.get(currentChar) + 1);
        }

        return stringCount.entrySet().stream().map(e -> e.getKey() + "" + e.getValue()).collect(Collectors.toList());
    }

    public static String findFirstRepeatedCharacter(String word){
        Map<Character, Integer> count = new LinkedHashMap<>();

        for(int i = word.length()-1; i >= 0; i--){
            Character currentChar = word.charAt(i);
            if(!count.containsKey(currentChar)){
                count.put(currentChar, 0);
            }

            count.put(currentChar, count.get(currentChar) + 1);
        }

        return count.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .findFirst()
                .map(e -> String.valueOf(e.getKey()))
                .orElse(null);
    }

    public static String findFirstRepeatedCharacterUsingSet(String word){
        Set<Character> count = new HashSet<>();

        for(int i = word.length()-1; i >= 0; i--){
            Character currentChar = word.charAt(i);

            if(count.contains(currentChar))
                return String.valueOf(currentChar);

            count.add(currentChar);
        }

        return null;
    }

//    @Test
//    public void emptyOrNullString(){
//        assertEquals("a4b3", countNumberOfRepetitionInAGivenString("aaaabbb"));
//    }

}
