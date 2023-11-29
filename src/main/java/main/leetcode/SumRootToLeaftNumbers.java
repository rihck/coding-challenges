package main.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
public class SumRootToLeaftNumbers {

    static int total = 0;
    public static int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return total;
    }

    public static int sumNumbersStack(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        nodeStack.push(root);
        sumStack.push(0);
        int totalSum = 0;

                /*
                  1
               /    \
             2       3
           /   \      \
          4     5      6

         */
        while (!nodeStack.empty()) {
            TreeNode currentNode = nodeStack.pop(); //2
            Integer currentSum = sumStack.pop(); // 1

            currentSum = currentSum * 10; // 10
            currentSum = currentSum + currentNode.val; // 12

            if (currentNode.left == null && currentNode.right == null){ // false
                totalSum += currentSum;
            }

            if (currentNode.right != null){
                sumStack.push(currentSum);
                nodeStack.push(currentNode.right);
            }
            if (currentNode.left != null){
                sumStack.push(currentSum);
                nodeStack.push(currentNode.left);
            }
        }

        return totalSum;
    }

    private static void dfs(TreeNode node, int sum) {
        if (node == null) return;

        sum = sum * 10;
        sum = sum + node.val;

        if (node.right == null && node.left == null) {
            total += sum;
        }

        dfs(node.left, sum);
        dfs(node.right, sum);
    }

    @Test
    public void simpleTestCase(){
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1, two, three);

        int result = sumNumbers(one);
        Assert.assertEquals(25, result);
    }

    @Test
    public void treeLevelTree() {
        /*
                  1
               /    \
             2       3
           /   \      \
          4     5      6

         */

        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode nine = new TreeNode(9, five, one);

        TreeNode zero = new TreeNode(0);

        TreeNode four = new TreeNode(4, nine, zero);

        Assert.assertEquals(1026, sumNumbers(four));
        Assert.assertEquals(1026, sumNumbersStack(four));
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }


 }
}
