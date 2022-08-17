package main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Build Stack to Store Visited Sites and perform Stack operations: pop/push/peek
 * Discord
 * Udemy
 * Google
 */
public class BuildOwnStackWithArrays {
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
        ArrayList<String> list = new ArrayList<>();

        void pop(){
            this.list.remove(this.list.size() - 1);
        }

        void peek(){
            this.list.get(this.list.size() - 1);
        }

        void push(String value){
            list.add(value);
        }
    }

    @Test
    void testPush(){
        Stack myStack = new Stack();
        myStack.push("Google");
        myStack.push("Udemy");
        myStack.push("Discord");

        assertEquals("Discord", myStack.list.get(myStack.list.size() - 1));
    }

    @Test
    void testPeek(){
        Stack myStack = new Stack();
        myStack.push("Google");
        myStack.push("Udemy");

        myStack.peek();

        assertEquals("Udemy", myStack.list.get(myStack.list.size() - 1));
    }

    @Test
    void testPop(){
        Stack myStack = new Stack();
        myStack.push("Google");
        myStack.push("Udemy");

        myStack.pop();

        assertEquals("Google", myStack.list.get(myStack.list.size() - 1));
    }

}
