package main.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/battleships-in-a-board/
 * TYPICAL Graph Problem, it's all about traversing a Graph, understanding this will help you in the future.
 */
public class BattleshipsInABoard {
    public int countBattleshipsRecursivelyTraversingGraph(char[][] board) {
        int battleShipsFound = 0;

        for (int l = 0; l < board.length; l++){
            for (int c = 0; c < board[l].length; c++){
                char value = board[l][c];

                if (value == 'X'){
                    battleShipsFound++;
                    replaceNeighbors(board, l, c);
                }
            }
        }

        return battleShipsFound;
    }

    private void replaceNeighbors(char[][] board, int l, int c) {
        if (l < 0 || l >= board.length || c < 0 || c >= board[l].length || board[l][c] != 'X')
            return;

        board[l][c] = '.';
        replaceNeighbors(board, l, c + 1);
        replaceNeighbors(board, l, c - 1);
        replaceNeighbors(board, l + 1, c);
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

        int returned = countBattleshipsRecursivelyTraversingGraph(input);
        Assert.assertEquals(2, returned);
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
