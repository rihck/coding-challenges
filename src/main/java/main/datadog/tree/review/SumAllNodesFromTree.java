package main.datadog.tree.review;

import java.util.Stack;

public class SumAllNodesFromTree {
    public static void main(String[] args) {
        Node<Integer> root = Node.createDefaultIntegerTree();
        Integer result = findSumOfAllNodes(root);
        System.out.println(result);

        Integer result2 = findSumOfAllNodesIterative(root);
        System.out.println(result2);
    }

    private static Integer findSumOfAllNodes(Node<Integer> root) {
        if (root == null) return 0;

        return root.value + findSumOfAllNodes(root.left) + findSumOfAllNodes(root.right);
    }

    private static Integer findSumOfAllNodesIterative(Node<Integer> root) {
        Stack<Node<Integer>> nodesStack = new Stack<>();
        nodesStack.push(root);

        int sum = 0;
        while (!nodesStack.empty()) {
            Node<Integer> current = nodesStack.pop();
            sum += current.value;

            if (current.right != null) nodesStack.push(current.right);
            if (current.left != null) nodesStack.push(current.left);
        }

        return sum;
    }

}
