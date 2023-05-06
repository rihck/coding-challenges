package main.algoexpert;

import java.util.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * competitions = [
 *   HomeTeam | AwayTeam
 *   ["HTML", "C#"],
 *   ["C#", "Python"],
 *   ["Python", "HTML"],
 * ]
 * results = [0, 0, 1]
 * 1 = homeTeam Won
 * 0 = awayTeam Won
 *
 * Output: Python
 */

public class TournamentWinner {
    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        Map<String, Integer> teamsAndPoints = new HashMap<>();
        teamsAndPoints.put("none", 0);
        ArrayList<String> match;
        String homeTeam, awayTeam, winner, highestScoreTeam;
        highestScoreTeam = "none";
        for(int i = 0; i < competitions.size(); i++){
            match = competitions.get(i);

            homeTeam = match.get(0);
            awayTeam = match.get(1);

            winner = results.get(i) == 1 ? homeTeam : awayTeam;

            if (!teamsAndPoints.containsKey(winner))
                teamsAndPoints.put(winner, 0);

            teamsAndPoints.put(winner, teamsAndPoints.get(winner) + 3);

            if (teamsAndPoints.get(winner) > teamsAndPoints.get(highestScoreTeam))
                highestScoreTeam = winner;
        }

        return highestScoreTeam;
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
