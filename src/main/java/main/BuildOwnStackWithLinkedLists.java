package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Build Stack to Store Visited Sites and perform Stack operations: pop/push/peek
 * Discord
 * Udemy
 * Google
 */
public class BuildOwnStackWithLinkedLists {
    public static void main(String[] args) {

        Stack myStack = new Stack();
        myStack.push("Google");
        myStack.push("Udemy");
        myStack.push("Discord");

        System.out.println(myStack);

        myStack.pop();
        System.out.println();
    }

    static class Stack{
        Node bottom = null;
        Node top = null;
        int size = 0;

        Node pop(){
            if(this.top == null)
                return null;

            if (this.bottom == this.top)
                this.bottom = null;

            Node nodeToPop = this.top;

            this.top = this.top.next;
            this.size--;

            return nodeToPop;
        }

        Node peek(){
            return this.top;
        }

        Node push(String value){
            Node newNode = new Node(value);

            if (this.size == 0){
                this.top = newNode;
                this.bottom = newNode;
                return newNode;
            }

            Node oldTop = this.top;
            this.top = newNode;

            // If reference is maintained on the previous (doesn't make sense considering Pop would be O(n))
            //oldTop.next = newNode;

            //If reference is maintained on actual -> Makes sense because Pop becomes O(1) considering the
            // last elements keeps reference to the penultimate
            newNode.next = oldTop;

            this.size++;

            return this.top;
        }
    }
    static class Node{
        Node next = null;
        String value;

        Node(String value){
            this.value = value;
        }

        Node (String value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    @Test
    void testPush(){
        Stack myStack = new Stack();
        myStack.push("Google");
        myStack.push("Udemy");
        myStack.push("Discord");

        assertEquals("Discord", myStack.top.value);
    }

    @Test
    void testPeek(){
        Stack myStack = new Stack();
        myStack.push("Google");
        myStack.push("Udemy");

        myStack.peek();

        assertEquals("Udemy", myStack.top.value);
    }

    @Test
    void testPop(){
        Stack myStack = new Stack();
        myStack.push("Google");
        myStack.push("Udemy");

        myStack.pop();

        assertEquals("Google", myStack.top.value);
    }

}
