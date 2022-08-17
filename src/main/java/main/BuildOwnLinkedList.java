package main;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Build the following LinkedList: 10 -> 5 -> 16
public class BuildOwnLinkedList {
    public static void main(String[] args) {

        LinkedListt linkedList = new LinkedListt(10);
        linkedList.append(5);
        linkedList.append(16);

        System.out.println(linkedList);
    }

    static class LinkedListt{
        Node head;
        Node tail;
        int length;
        public LinkedListt(int firstValue){
            Node newNode = new Node(firstValue, null);
            this.head = newNode;
            this.tail = newNode;
            this.length++;
        }

        //10 -> 5 -> 16
        public void append(int value){
            Node newNode = new Node(value, null);

            this.tail.next = newNode;
            this.tail = newNode;
            this.length++;
        }
    }
    static class Node{
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

        public int value;
        public Node next = null;

        public Node append(int value){return  null;}


    }

}
