package main.datadog.tree.review;

public class FindValueInTreeRecursive {
    public static void main(String[] args) {

        Node root = Node.createDefaultTree();
        boolean result = findValueInTree(root, "e");
        System.out.println(result);

        boolean result2 = findValueInTree(root, "w");
        System.out.println(result2);
    }

    public static boolean findValueInTree(Node node, String target){
        //         a
//          b              c
//      d      e        f     g

        if (node == null) return false;
        if (node.value.equals(target)) return true;

        return findValueInTree(node.left, target) || findValueInTree(node.right, target);
    }
}
