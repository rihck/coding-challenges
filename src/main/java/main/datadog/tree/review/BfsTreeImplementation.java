package main.datadog.tree.review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsTreeImplementation {

    public static void main(String[] args) {
        Node<String> root = Node.createDefaultStringTree();

        Queue<Node<String>> queue = new LinkedList<>();
        queue.add(root);

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()){
            Node<String> current = queue.poll();
            result.add(current.value);

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        System.out.println(result);
    }

}
