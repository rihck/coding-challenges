package main;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

        //tree.traverse(tree.root);
        //String jsonOutput = new Gson().toJson(tree.root);

        Node foundNode = tree.lookup(4);
        System.out.println(foundNode);

        System.out.println(tree.bfs());


    }

    static class BinarySearchTree{
        Node root;

        Node lookup(int valueToSearch){
            if (this.root == null)
                return null;

            Node currentNode = this.root;
            while (currentNode != null){
                if (valueToSearch > currentNode.value){
                    currentNode = currentNode.right;
                } else if (valueToSearch < currentNode.value){
                    currentNode = currentNode.left;
                } else{
                    return currentNode;
                }
            }

            return currentNode;
        }

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
                        return newNode;
                    }

                    currentNode = currentNode.right;
                }

                else { //valueToInsert <= currentNodeValue
                    //Left
                    if(currentNode.left == null){
                        currentNode.left = newNode;
                        return newNode;
                    }

                    currentNode = currentNode.left;
                }
            }
        }

        /**
         * Build BST structure and have the following structure
         *            9
         *      4           20
         *   1    6      15    170
         */
        List<Integer> bfs(){
            Node currentNode = this.root;
            List<Integer> listReturn = new ArrayList<>();
            Queue<Node> childNodes = new LinkedList();
            childNodes.add(currentNode);

            while (childNodes.size() > 0){
                currentNode = childNodes.poll();
                listReturn.add(currentNode.value);

                if (currentNode.left != null){
                    childNodes.add(currentNode.left);
                }

                if (currentNode.right != null){
                    childNodes.add(currentNode.right);
                }

            }

            return listReturn;
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
        int value;
        Node left;

        Node right;

        Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
