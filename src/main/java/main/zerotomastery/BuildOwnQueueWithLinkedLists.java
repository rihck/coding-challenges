package main.zerotomastery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Build Queue to Store People in a Queue and perform Stack operations: Queue/Dequeue/Peek
 */
public class BuildOwnQueueWithLinkedLists {
    public static void main(String[] args) {
        Queue myQueue = new Queue();
        myQueue.queue("Ricardo");
        myQueue.queue("Giselle");
        myQueue.queue("Roberta");
    }

    static class Queue {
        Node first = null;
        Node last = null;
        int size = 0;

        Node dequeue(){
            if(this.first == null)
                return null;

            if (this.first == this.last)
                this.last = null;

            Node oldFirst = this.first;
            this.first = oldFirst.next;

            this.size--;

            return oldFirst;
        }

        Node peek(){
            return this.first;
        }

        Node queue(String value){
            Node newNode = new Node(value);

            if (this.size == 0){
                this.last = newNode;
                this.first = newNode;
                this.size++;
                return newNode;
            }

            Node oldLast = this.last;
            oldLast.next = newNode;
            this.last = newNode;

            this.size++;

            return this.last;
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
        Queue myQueue = new Queue();
        myQueue.queue("Ricardo");
        myQueue.queue("Giselle");
        myQueue.queue("Roberta");

        assertEquals("Roberta", myQueue.last.value);
        assertEquals("Ricardo", myQueue.first.value);
    }

    @Test
    void testPeek(){
        Queue myQueue = new Queue();
        myQueue.queue("Ricardo");
        myQueue.queue("Giselle");
        myQueue.queue("Roberta");

        Node nodePeek = myQueue.peek();

        assertEquals("Roberta", myQueue.last.value);
        assertEquals("Ricardo", myQueue.first.value);
        assertEquals("Ricardo", nodePeek.value);
    }

    @Test
    void testPop(){
        Queue myQueue = new Queue();
        myQueue.queue("Ricardo");
        myQueue.queue("Giselle");
        myQueue.queue("Roberta");

        Node nodeDequeued = myQueue.dequeue();

        assertEquals("Roberta", myQueue.last.value);
        assertEquals("Giselle", myQueue.first.value);
        assertEquals("Ricardo", nodeDequeued.value);
    }

}
