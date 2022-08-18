package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Build BST structure and have the following structure
 *            9
 *      4           20
 *   1    6      15    170
 */
public class BuildBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);

        tree.traverse(tree.root);
        System.out.println(tree);
    }

    static class BinarySearchTree{
        Node root;

        Node insert(int valueToInsert){
            Node newNode = new Node(valueToInsert);
            if (root == null){
                this.root = newNode;
                return newNode;
            }

            Node currentNode = this.root;

            while (true){
                int currentNodeValue = currentNode.value;

                //PS: It's up to us if we want to put equal values on LEFT or RIGHT
                if (valueToInsert > currentNodeValue){
                    //Right
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        break;
                    }

                    currentNode = currentNode.right;
                }

                else { //valueToInsert <= currentNodeValue
                    //Left
                    if(currentNode.left == null){
                        currentNode.left = newNode;
                        break;
                    }

                    currentNode = currentNode.left;
                }
            }

            return newNode;
        }

        void traverse(Node node){
            System.out.println(node.value);

            if (node.right != null){
                traverse(node.right);
            }

            if (node.left != null) {
                traverse(node.left);
            }
        }
    }
    static class Node{
        Node left;
        Node right;
        int value;

        Node(int value){
            this.value = value;
        }
    }

}
