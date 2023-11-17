package main.aubay;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FindRepetitionsInStringArray {

    private int[] findRepetitionsOnWordsComplexWithoutMap(String[] words) {
        Arrays.sort(words, Comparator.naturalOrder());
        List<Integer> repetitions = new ArrayList<>();

        String lastString = words[0];
        int currentRepetition = 1;
        for (int i = 1; i < words.length; i++) {
            String current = words[i];

            if (lastString.equals(current)) {
                currentRepetition++;
            }
            if (!lastString.equals(current) || i +1 == words.length){
                repetitions.add(currentRepetition);
                currentRepetition = 1;
            }

            lastString = current;
        }

        return repetitions.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[] findRepetitionsOnWordsComplexWithMap(String[] words) {
        Arrays.sort(words, Comparator.naturalOrder());
        Map<String, Integer> count = new LinkedHashMap<>();

        for (String current : words){
            if (!count.containsKey(current)){
                count.put(current, 0);
            }

            Integer currentCount = count.get(current);
            count.put(current, ++currentCount);
        }

        return count.values().stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void withRepetitins(){
        String[] words = new String[]{"the", "dog", "got", "the", "bone"};
        int[] expectedResult = new int[] {1, 1, 1, 2};

        int[] result2 = findRepetitionsOnWordsComplexWithMap(words);
        assertArrayEquals(expectedResult, result2);

        int[] result = findRepetitionsOnWordsComplexWithoutMap(words);
        assertArrayEquals(expectedResult, result);
    }

}
