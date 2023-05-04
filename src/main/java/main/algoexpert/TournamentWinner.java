package main.algoexpert;

import java.util.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class TournamentWinner {
    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        Map<String, Integer> teamsAndPoints = new HashMap<>();
        ArrayList<String> match;
        for(int i = 0; i < competitions.size(); i++){
            match = competitions.get(i);

            // First Team
            if(!teamsAndPoints.containsKey(match.get(0)))
                teamsAndPoints.put(match.get(0), 0);

            int whoWon = results.get(i); //O(1)
            int pointsToAdd = whoWon == 1 ? 3 : 0;
            teamsAndPoints.put(match.get(0), teamsAndPoints.get(match.get(0)) + pointsToAdd);

            // Second Team
            if(!teamsAndPoints.containsKey(match.get(1)));
                teamsAndPoints.put(match.get(1), 0);

            pointsToAdd = whoWon == 0 ? 3 : 0;
            teamsAndPoints.put(match.get(1), teamsAndPoints.get(match.get(1)) + pointsToAdd);
        }

        // Loop through all elements checking the highest score
        Iterator<String> iterator = teamsAndPoints.keySet().iterator();
        int max = 0;
        String winner = null;
        while(iterator.hasNext()){
            String team = iterator.next();

            if (teamsAndPoints.get(team) > max){
                max = teamsAndPoints.get(team);
                winner = team;
            }
        }

        return winner;
    }

    @Test
    @DisplayName("Main Test Case")
    public void mainTestCase(){
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>(){{
            add(new ArrayList<String>(){{
                add("HTML");
                add("C#");
            }});

            add(new ArrayList<String>(){{
                add("C#");
                add("Python");
            }});

            add(new ArrayList<String>(){{
                add("Python");
                add("HTML");
            }});
        }};

        ArrayList<Integer> results = new ArrayList<>();
        results.addAll(Arrays.asList(0, 0, 1));

        String winner = tournamentWinner(competitions, results);
        assertEquals("Python", winner);
    }
}
