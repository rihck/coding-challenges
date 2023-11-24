package main.datadog.tree.review;

import java.util.Stack;

public class FindValueInTreeRecursive {
    public static void main(String[] args) {

        // Recursive
        Node root = Node.createDefaultStringTree();
        boolean result = findValueInTree(root, "e");
        System.out.println(result);

        boolean result2 = findValueInTree(root, "w");
        System.out.println(result2);

        // Iterative
        boolean result3 = findValueInTreeUsingStack(root, "e");
        System.out.println(result3);

        boolean result4 = findValueInTreeUsingStack(root, "w");
        System.out.println(result4);

    }

    public static boolean findValueInTree(Node node, String target){
        //         a
//          b              c
//      d      e        f     g

        if (node == null) return false;
        if (node.value.equals(target)) return true;

        return findValueInTree(node.left, target) || findValueInTree(node.right, target);
    }

    public static boolean findValueInTreeUsingStack(Node node, String target) {
        Stack<Node> nodes = new Stack<>();
        nodes.push(node);

        while (!nodes.empty()) {
            Node current = nodes.pop();

            if (current.value.equals(target)) return true;

            if (current.right != null) nodes.push(current.right);
            if (current.left != null) nodes.push(current.left);
        }

        return false;
    }
}
