package main.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/battleships-in-a-board/
 * TYPICAL Graph Problem, it's all about traversing a Graph, understanding this will help you in the future.
 */
public class BattleshipsInABoard {

    public int countBattleships(char[][] board) {
        int countBattleShipsFound = 0;
        for (int l = 0; l < board.length; l++){
            for (int c = 0; c < board[l].length; c++){

                // If we are in a Period we don't care
                if (board[l][c] == '.')
                    continue;

                // If the cell above us is an X means we're still counting the same battleship in the VERTICAL
                // We check "l > 0" to make sure we're not on the first line, and we can actually check on our TOP
                if (l > 0 && board[l -1][c] == 'X')
                    continue;

                // If the cell on our left is an X means we're still counting the same battleship in the HORIZONTAL
                // We check if "c > 0" to make sure we're not on the first column and we can actually check on our LEFT
                if (c > 0 && board[l][c -1] == 'X')
                    continue;

                // If none of these statements are true means that we found our FIRST X of our battleship and we can count it
                countBattleShipsFound++;
            }
        }

        return countBattleShipsFound;
    }

    public int countBattleshipsRecursivelyTraversingGraph(char[][] board) {
        int battleShipsFound = 0;

        for (int l = 0; l < board.length; l++){
            for (int c = 0; c < board[l].length; c++){
                char value = board[l][c];

                if (value == 'X'){
                    battleShipsFound++;

                    // Once we found an X, we visit the neighbors horizontally and vertically replacing the X's by "."
                    replaceNeighbors(board, l, c);
                }
            }
        }

        return battleShipsFound;
    }

    private void replaceNeighbors(char[][] board, int l, int c) {
        // The condition to stop the recursion, basically first 4 conditions checking we don't go out of Bound
        // And the Last One IF we found an "."
        if (l < 0 || l >= board.length || c < 0 || c >= board[l].length || board[l][c] != 'X')
            return;

        board[l][c] = '.';
        replaceNeighbors(board, l, c + 1);
        replaceNeighbors(board, l + 1, c);

        // These lines can be removed
        // Because a previous "replaceNeighbors" would have be removed considering the way we're traversing
        replaceNeighbors(board, l, c - 1);
        replaceNeighbors(board, l - 1, c);
    }

    @Test
    public void twoBattleShipsOnTheBoard(){
        /**
         * X . . X
         * . . . X
         * . . . X
         * . . . .
         */

        char[][] input = new char[4][4];
        input[0][0] = 'X';
        input[0][1] = '.';
        input[0][2] = '.';
        input[0][3] = 'X';

        input[1][0] = '.';
        input[1][1] = '.';
        input[1][2] = '.';
        input[1][3] = 'X';

        input[2][0] = '.';
        input[2][1] = '.';
        input[2][2] = '.';
        input[2][3] = 'X';

        input[3][0] = '.';
        input[3][1] = '.';
        input[3][2] = '.';
        input[3][3] = '.';

        int returnBetterSolution = countBattleships(input);
        assertEquals(2, returnBetterSolution);

        int returnedRecursiveSolution = countBattleshipsRecursivelyTraversingGraph(input);
        assertEquals(2, returnedRecursiveSolution);
    }

    public static void main(String[] args) {
        List<List<String>> matrixList = new ArrayList<>();
        List<String> line1 = new ArrayList<>();
        matrixList.add(line1);

        matrixList.get(0).add("1");
        matrixList.get(0).add("2");
        matrixList.get(0).add("3");

        System.out.println(matrixList.get(0));

        char matrix[][] = new char[3][3];
        matrix[0][0] = '1';
        matrix[0][1] = '2';
        matrix[0][2] = '3';

        System.out.println(matrix[0]);

        matrix[1][0] = '4';
        matrix[1][1] = '5';
        matrix[1][2] = '6';

        matrix[2][0] = '7';
        matrix[2][1] = '8';
        matrix[2][2] = '9';

//        System.out.println(matrix);
//        System.out.println(matrix[0]);

        for (int line = 0; line < matrix.length; line++){
            for (int colunm = 0; colunm < matrix[line].length; colunm++){
                //System.out.println(matrix[line][colunm]);
            }
        }
    }

}
