package main.datadog.tree.review;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class MaxRootToLeafPathSum {
    public static void main(String[] args) {
        Node<Integer> root = Node.createIntegerTreeToCalculateRootToLeaft();

        System.out.println(maxRootToLeaf(root));
        System.out.println(maxRootToLeafStack(root));
    }

    @Test
    public void test() {
                /*
                   5
           11            3
        4     2      null   1
      */
        Node<Integer> root = Node.createIntegerTreeToCalculateRootToLeaft();

        assertEquals(20, maxRootToLeaf(root));
        assertEquals(20, maxRootToLeafStack(root));
    }

    public static int maxRootToLeaf(Node<Integer> node){
        if (node == null) return -Integer.MAX_VALUE;
        if (node.right == null && node.left == null) return node.value;
        return node.value + Math.max(maxRootToLeaf(node.left), maxRootToLeaf(node.right));
    }

    public static int maxRootToLeafStack(Node<Integer> node) {
        Stack<Node<Integer>> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        nodeStack.push(node);
        sumStack.push(node.value);
        int maxSum = 0;

        while (!nodeStack.empty()) {
            Node<Integer> currentNode = nodeStack.pop();
            Integer currentSum = sumStack.pop();

            if (currentNode.right == null && currentNode.left == null)
                maxSum = Math.max(maxSum, currentSum);

            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                sumStack.push(currentSum + currentNode.right.value);
            }

            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                sumStack.push(currentSum + currentNode.left.value);
            }

        }

        return maxSum;
    }
}
