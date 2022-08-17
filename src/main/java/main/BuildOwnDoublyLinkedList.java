package main;

import java.util.ArrayList;
import java.util.List;

// Build the following LinkedList: 10 -> 5 -> 16
public class BuildOwnDoublyLinkedList {
    public static void main(String[] args) {

        LinkedListt linkedList = new LinkedListt(10);
        linkedList.append(5);
        linkedList.append(16);

        linkedList.prepend(1);

        // 1 -> 9 -> 10 -> 5 -> 16
        linkedList.insert(9, 1);

        linkedList.printList();
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
            newNode.previous = tail;
            this.tail = newNode;
            this.length++;
        }

        public void prepend(int value){
            Node newNode = new Node(value, this.head);

            this.head.previous = newNode;
            newNode.next = this.head;
            this.head = newNode;
            this.length++;
        }
        //10 -> 5 -> 16
        public void insert(int value, int index){
            Node newNode = new Node(value, null);

            Node currentNode = this.head;
            Node previousNode = this.head;
            boolean added = false;
            int currentIndex = 0;
            //1 -> 9 -> 10 -> 5 -> 16
            while (currentNode != null && !added){

                if (currentIndex == index){
                    previousNode.next = newNode;
                    currentNode.previous = newNode;
                    newNode.next = currentNode;
                    newNode.previous = previousNode;
                    added = true;
                }

                previousNode = currentNode;
                currentNode = currentNode.next;
                currentIndex++;
            }

            this.length++;
        }

        public void printList(){
            Node currentNode = this.head;
            int currentIndex = 0;
            List<Integer> list = new ArrayList<>();

            while (currentNode != null ){
                list.add(currentNode.value);
                currentNode = currentNode.next;
                currentIndex++;
            }

            for (Integer value: list) {
                System.out.println(value);
            }

        }
    }
    static class Node{
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

        public Node(int value, Node next, Node previous){
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(int value){
            this.value = value;
        }

        public int value;
        public Node next = null;
        public Node previous = null;
    }

}
