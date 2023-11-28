package main.datadog.tree.review;

public class MaxRootToLeaftPathSum {
    public static void main(String[] args) {
        Node<Integer> root = Node.createIntegerTreeToCalculateRootToLeaft();

        System.out.println(maxRootToLeaft(root));
    }

    public static Integer maxRootToLeaft(Node<Integer> node){
        if (node == null) return -Integer.MAX_VALUE;
        if (node.right == null && node.left == null) return node.value;

        return node.value + Math.max(maxRootToLeaft(node.left), maxRootToLeaft(node.right));
    }
}
