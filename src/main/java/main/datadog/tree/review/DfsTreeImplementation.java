package main.datadog.tree.review;

import java.util.*;

public class DfsTreeImplementation {
    static class Node{
        String value;
        Node right;
        Node left;

        public Node(String value){
            this.value = value;
        }

        public Node(String value, Node left, Node right){
            this.value = value;
            this.right = right;
            this.left = left;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", right=" + right +
                    ", left=" + left +
                    '}';
        }
    }

    public static void main(String[] args) {
//                 a
//          b              c
//      d      e        f     g

        Node d = new Node("d");
        Node e = new Node("e");

        Node f = new Node("f");
        Node g = new Node("g");

        Node b = new Node("b", d, e);
        Node c = new Node("c", f, g);

        Node a = new Node("a", b, c);

        List<String> resultDfsI = dfsIterative(a);
        System.out.println(resultDfsI);

        List<String> resultDfsR = dfsRecursive(a);
        System.out.println(resultDfsR);
    }

    private static List<String> dfsIterative(Node root) {
        List<String> result = new ArrayList<>();
        Stack<Node> treeStack = new Stack<>();
        treeStack.add(root);
        while (!treeStack.empty()) {
            Node current = treeStack.pop();
            System.out.println(current);
            result.add(current.value);

            if (current.right != null) treeStack.push(current.right);
            if (current.left != null) treeStack.push(current.left);
        }

        return result;
    }

    //             a
//          b              c
//      d      e        f     g

    private static List<String> dfsRecursive(Node root){
        if (root == null) return Collections.emptyList();
        System.out.println(root.value);

        List<String> returnLeft = dfsRecursive(root.left); // b d e
        List<String> returnRight = dfsRecursive(root.right); // c f g

        List<String> result = new ArrayList<>();
        result.add(root.value);
        result.addAll(returnLeft);
        result.addAll(returnRight);
        return result;
    }


}
