package main.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchInABinaryTree {

    public TreeNode searchBSTRecursive(TreeNode root, int val) {
        if(root == null)
            return null;

        if (root.val == val)
            return root;

        if (val < root.val)
             return searchBSTRecursive(root.left, val);

        else
            return searchBSTRecursive(root.right, val);
    }

    @Test
    public void test(){
        TreeNode nodeV1 = new TreeNode(1);
        TreeNode nodeV3 = new TreeNode(3);

        TreeNode nodeV2 = new TreeNode(2, nodeV1, nodeV3);

        TreeNode nodeV7 = new TreeNode(7);

        TreeNode nodeV4 = new TreeNode(4, nodeV2, nodeV7);

        searchBSTRecursive(nodeV4, 2);
        Assertions.assertEquals(nodeV2, searchBSTRecursive(nodeV4, 2));
    }

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }
}


}
