package main.datadog.tree.review;

import java.util.Stack;

public class MaxRootToLeaftPathSum {
    public static void main(String[] args) {
        Node<Integer> root = Node.createIntegerTreeToCalculateRootToLeaft();

        System.out.println(maxRootToLeaf(root));
        System.out.println(maxRootToLeaftStack(root));
    }

    public static Integer maxRootToLeaf(Node<Integer> node){
        if (node == null) return -Integer.MAX_VALUE;
        if (node.right == null && node.left == null) return node.value;
        return node.value + Math.max(maxRootToLeaf(node.left), maxRootToLeaf(node.right));
    }

    public static Integer maxRootToLeaftStack(Node<Integer> node) {
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
