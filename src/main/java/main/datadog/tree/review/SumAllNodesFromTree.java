package main.datadog.tree.review;

public class SumAllNodesFromTree {
    public static void main(String[] args) {
        Node<Integer> root = Node.createDefaultIntegerTree();
        Integer result = findSumOfAllNodes(root);
        System.out.println(result);
    }

    private static Integer findSumOfAllNodes(Node<Integer> root) {
        if (root == null) return 0;

        return root.value + findSumOfAllNodes(root.left) + findSumOfAllNodes(root.right);
    }

}
