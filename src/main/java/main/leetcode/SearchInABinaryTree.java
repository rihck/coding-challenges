package main.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInABinaryTree {

    /*
        Time Complexity : O(N)
        Space Complexity :O(1)
     */
    public TreeNode searchInBstIterative(TreeNode root, int val){
        if (root == null) return null;

        while (root != null && root.val != val){ //Tree is not empty and root value is not equals to val
            if (val > root.val)
                root = root.right;
            else if (val < root.val)
                root = root.left;
        }

        return root;
    }

    /*
        Time Complexity : O(N)
        Space Complexity :O(N)
    */
    public TreeNode searchBSTRecursive(TreeNode root, int val) {
        if(root == null)
            return null;

        if (root.val == val)
            return root;

        if (val < root.val)
             return searchBSTRecursive(root.left, val);

        return searchBSTRecursive(root.right, val);
    }

    @Test
    public void test(){
        TreeNode nodeV1 = new TreeNode(1);
        TreeNode nodeV3 = new TreeNode(3);

        TreeNode nodeV2 = new TreeNode(2, nodeV1, nodeV3);

        TreeNode nodeV7 = new TreeNode(7);

        TreeNode nodeV4 = new TreeNode(4, nodeV2, nodeV7);

        assertEquals(nodeV2, searchBSTRecursive(nodeV4, 2));
        assertEquals(nodeV2, searchInBstIterative(nodeV4, 2));

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
