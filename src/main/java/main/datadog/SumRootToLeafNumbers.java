package main.datadog;

import main.datadog.tree.review.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumRootToLeafNumbers {
    int totalSum = 0;
    public void sumRootToLeafNumbers(Node<Integer> root) {
                /*
                   5
           7            3
        4     2      null   1
      */

        dfs(root, 0);
    }

    private void dfs(Node<Integer> node, int sum) {
        if (node == null) return;

        // 5
        // 5 + 11 = 16
        //
        sum = sum * 10;
        sum += node.value;

        if (node.left == null && node.right == null)
            totalSum += sum;

        dfs(node.left, sum);
        dfs(node.right, sum);
    }

    @Test
    public void test() {
                /*
                   5
           7            3
        4     2      null   1
      */
        Node<Integer> root = Node.createInt2LevelNumbers1to3();
        sumRootToLeafNumbers(root);

        assertEquals(25, totalSum);
    }
}
