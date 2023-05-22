package main.algoexpert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class FindClosestInBST {
    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBstHelper(tree, target, Integer.MAX_VALUE);
    }

    public static int findClosestValueInBstHelper(BST tree, int target, int closestValue){
        if(tree == null){
            return closestValue;
        }

        int closestDiff = Math.abs(closestValue - target);
        int currentDiff = Math.abs(tree.value - target);

        if(currentDiff < closestDiff)
            closestValue = tree.value;

        if(target < tree.value){
            return findClosestValueInBstHelper(tree.left, target, closestValue);
        }
        else if (target > tree.value){
            return findClosestValueInBstHelper(tree.right, target, closestValue);
        }
        else{
            return closestValue;
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
