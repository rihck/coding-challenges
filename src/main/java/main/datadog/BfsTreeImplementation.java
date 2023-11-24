package main.datadog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsTreeImplementation {

    public static void main(String[] args) {
        Node root = Node.createDefaultTree();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()){
            Node current = queue.poll();
            result.add(current.value);

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        System.out.println(result);
    }

}
