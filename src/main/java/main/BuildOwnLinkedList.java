package main;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Build the following LinkedList: 10 -> 5 -> 16
public class BuildOwnLinkedList {
    public static void main(String[] args) {

        LinkedListt linkedList = new LinkedListt(10);
        linkedList.append(5);
        linkedList.append(16);

        linkedList.prepend(1);

        // Oringinal: 1 -> 10 -> 5 -> 16
        // Expected:  1 -> 9 -> 10 -> 5 -> 16
        linkedList.insert(9, 1);


        // Oringinal: 1 -> 9 -> 10 -> 5 -> 16
        // Expected:  1 -> 9 -> 5 -> 16
        linkedList.remove(2);
        linkedList.printList();


        // Oringinal: 1 -> 9 -> 5 -> 16
        // Expected:  16 -> 5 -> 9 -> 1
        System.out.println("Reversed: ");
        linkedList.reverse();
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

        public void prepend(int value){
            Node newNode = new Node(value, this.head);

            this.head = newNode;
            this.length++;
        }

        public void insert(int value, int index){
            if (index >= this.length){
                this.append(value);
            }

            Node newNode = new Node(value);
            Node nodeBeforeInsert = traverseToIndex(index-1);

            Node nodeAfterInsert = nodeBeforeInsert.next;
            nodeBeforeInsert.next = newNode;
            newNode.next = nodeAfterInsert;

        }

        public void remove(int index){
            Node nodeBeforeInsert = traverseToIndex(index-1);

            nodeBeforeInsert.next = nodeBeforeInsert.next.next;

            this.length--;
        }

        private Node traverseToIndex(int index){
            Node currentNode = this.head;
            int currentIndex = 0;

            while (currentIndex != index){
                currentNode = currentNode.next;
                currentIndex++;
            }

            return currentNode;
        }

        public void insertOld(int value, int index){
            if (index >= this.length){
                this.append(value);
            }

            Node newNode = new Node(value, null);
            Node currentNode = this.head;
            Node previousNode = this.head;
            boolean added = false;
            int currentIndex = 0;

            while (currentNode != null && !added){

                if (currentIndex == index){
                    previousNode.next = newNode;
                    newNode.next = currentNode;
                    added = true;
                }

                previousNode = currentNode;
                currentNode = currentNode.next;
                currentIndex++;
            }

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

        // Original: 1 -> 9 -> 5 -> 16
        // Expected:  16 -> 5 -> 9 -> 1

        /* 1 Loop
            9 -> 1 (second.next = first)
            first = 9 (first = second)
            second = 5 (second = temp)
         */

        /* 2 Loop
            5 -> 9 (second.next = first)
            first = 5 (first = second)
            second = 16 (second = temp)
         */

        /* 3 Loop
            16 -> 5
            first = 16
            second = null
         */

        // Output: 16 -> 5 -> 9 -> 1 -> 9 (Head still points to old Next [9], we assign it to null outside the loop)
        // Expect: 16 -> 5 -> 9 -> 1
        public void reverse(){
            if (this.head.next == null)
                return;

            Node first = this.head;
            Node second = first.next;

            while (second != null){
                Node temp = second.next;
                second.next = first;
                first = second;
                second = temp;
            }

            this.tail = head;

            //Head still points to old Next [9], we assign it to null outside the loop
            this.head.next = null;
            this.head = first;
        }

        public void reverseOld(){
            Node currentNode = this.head;
            List<Integer> list = new ArrayList<>();

            while (currentNode != null ){
                list.add(currentNode.value);
                currentNode = currentNode.next;
            }

            for (int i = list.size() -1; i >= 0; i--){
                System.out.println(list.get(i));
            }

        }
    }
    static class Node{
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

        public Node(int value){
            this.value = value;
        }

        public int value;
        public Node next = null;
    }

}
