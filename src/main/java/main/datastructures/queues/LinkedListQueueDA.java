package main.datastructures.queues;

import main.datastructures.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * https://www.baeldung.com/java-collections-complexity#linkedlist
 */

public class LinkedListQueueDA {

    LinkedList<Person> linkedList;
    Person person1, person2, person3;

    @BeforeEach
    void init(){
        linkedList = new LinkedList<>();
        person1 = new Person(28, "Ricardo");
        person2 = new Person(25, "Rafael");
        person3 = new Person(31, "Giselle");
    }

    ///// -------------- Using LinkedLists with Queue methods -------------- \\\\\
    @Test
    @DisplayName("[AsQueue] -> O(1) - peek / peekFirst / peekLast")
    void peek(){
        linkedList.add(person1);
        linkedList.add(person2);

        assertEquals(person1, linkedList.peek()); // Retrieves, but does not remove, the head (first element
        assertEquals(linkedList.peekFirst(), person1); // Same as peek
        assertEquals(linkedList.peekLast(), person2); // Retrieves, but does not remove, the tail (last element)
        assertEquals(linkedList.size(), 2);
    }

    @Test
    @DisplayName("[AsQueue] -> O(1) - addFirst and addLast")
    void addFirstLast(){
        linkedList.addFirst(person1);
        linkedList.addLast(person2);

        assertEquals(linkedList.peekFirst(), person1);
        assertEquals(linkedList.peekLast(), person2);
        assertEquals(linkedList.size(), 2);
    }

    @Test
    @DisplayName("[AsQueue] -> O(1) - poll / poolFirst / poolLast")
    void poll(){
        linkedList.add(person1);
        linkedList.add(person2);
        linkedList.add(person3);

        assertEquals(person1, linkedList.poll()); // Retrieves and removes the head (first element)
        assertEquals(person3, linkedList.pollLast()); // Retrieves and removes the tail (last element)
        assertEquals(person2, linkedList.pollFirst()); // Equivalent to poll() retrieve and removes the head
    }

    @Test
    @DisplayName("[AsQueue] -> O(1) - pop")
    void pop(){
        linkedList.add(person1);

        assertEquals(person1, linkedList.pop()); // Equals to poll BUT IF NO ELEMENTS, this one THROWS NoSuchElementException

        //pop THROWS Exception
        assertThrows(NoSuchElementException.class, () -> {
            linkedList.pop();
        });

        //poll DOES NOT throw Exception
        assertEquals(null, linkedList.poll());
    }

    @Test
    @DisplayName("[AsQueue] -> O(1) - push")
    void push(){
        // Inverse of add(), it will put the element at the top (as the head element)
        linkedList.push(person1);
        linkedList.push(person2);

        assertEquals(person2, linkedList.peek());
    }
}
