package main.datastructures.queues;

import main.datastructures.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueDA {

    Person person1, person2, person3;
    Queue<Person> priorityQueue;

    @BeforeEach
    void init(){
        priorityQueue = getPriorityQueueOrderByYoungestFirst();
        person1 = new Person(28, "Ricardo");
        person2 = new Person(25, "Rafael");
        person3 = new Person(31, "Giselle");
    }

    @Test
    @DisplayName("Adding comparator to sort the Queue by Priority - Youngest First")
    void addingComparatorToYoungestFirst(){
        priorityQueue = new PriorityQueue<>((p1, p2) -> {
            if (p1.getAge() > p2.getAge())
                return 1;
            else if (p1.getAge() < p2.getAge())
                return -1;

            return 0;
        });

        priorityQueue.addAll(Arrays.asList(person1, person2, person3));

        assertEquals(priorityQueue.poll(), person2);
        assertEquals(priorityQueue.poll(), person1);
        assertEquals(priorityQueue.poll(), person3);
    }

    @Test
    @DisplayName("Adding comparator to sort the Queue by Priority - Oldest First")
    void addingComparatorToOldestFirst(){
        priorityQueue = new PriorityQueue<>((p1, p2) -> {
           if (p1.getAge() > p2.getAge())
               return -1;
           else if (p1.getAge() < p2.getAge()) {
               return 1;
           }

           return 0;
        });

        priorityQueue.addAll(Arrays.asList(person1, person2, person3));

        assertEquals(priorityQueue.poll(), person3);
        assertEquals(priorityQueue.poll(), person1);
        assertEquals(priorityQueue.poll(), person2);
    }


    @Test
    @DisplayName("O(1) - add | addAll [Enqueue]")
    void enqueue(){
        priorityQueue.add(person1);
        priorityQueue.addAll(Arrays.asList(person2, person3));

        assertEquals(priorityQueue.size(), 3);
        assertEquals(priorityQueue.poll(), person2);
    }

    @Test
    @DisplayName("O(1) - poll | remove")
    void dequeue(){
        priorityQueue.addAll(Arrays.asList(person1, person2, person3));

        assertEquals(priorityQueue.size(), 3);
        assertEquals(priorityQueue.poll(), person2); // Poll picks the first element in the Queue and remove it -> Return NULL if queue is empty
        assertEquals(priorityQueue.remove(), person1); // Same as Poll BUT throws NoSuchElementException – if this queue is empty
        assertEquals(priorityQueue.size(), 1);
    }

    @Test
    @DisplayName("O(1) - peek | element")
    void peek(){
        priorityQueue.addAll(Arrays.asList(person1, person2, person3));

        assertEquals(priorityQueue.size(), 3);
        assertEquals(priorityQueue.peek(), person2); // Take a look on the first Queue Element BUT DOES NOT remove it
        assertEquals(priorityQueue.element(), person2); // Same as Peek BUT throws NoSuchElementException – if this queue is empty
        assertEquals(priorityQueue.size(), 3);
    }

    private PriorityQueue<Person> getPriorityQueueOrderByYoungestFirst() {
        return new PriorityQueue<>((p1, p2) -> {
            if (p1.getAge() > p2.getAge())
                return 1;
            else if (p1.getAge() < p2.getAge())
                return -1;

            return 0;

        });
    }

    private PriorityQueue<Person> getPriorityQueueOrderByOldestFirst() {
        return new PriorityQueue<>((p1, p2) -> {
            if (p1.getAge() > p2.getAge())
                return -1;
            else if (p1.getAge() < p2.getAge())
                return 1;

            return 0;

        });
    }
}
