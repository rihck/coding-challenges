package main.datastructures.list;

import main.datastructures.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * https://www.baeldung.com/java-collections-complexity#linkedlist
 */

public class LinkedListDA {

    LinkedList<Person> linkedList;
    Person person1, person2, person3;

    @BeforeEach
    void init(){
        linkedList = new LinkedList<>();
        person1 = new Person(28, "Ricardo");
        person2 = new Person(25, "Rafael");
        person3 = new Person(31, "Giselle");
    }

    ///// -------------- Using LinkedLists with Lists methods, not so useful as a Queue. -------------- \\\\\
    @Test
    @DisplayName("[AsList] -> O(1) - add")
    void add(){
        linkedList.add(person1); //O(1) -> add to the end and only update the tail
        assertEquals(linkedList.size(), 1);
    }

    @Test
    @DisplayName("[AsList] -> O(N) - add (atIndex)")
    void addAtIndex(){
        linkedList.add(0, person1); //O(N) -> Even LinkedLists doesn't shift index while inserting, we need to traverse until N to add in the Middle, that's why it's O(N)
        assertFalse(linkedList.isEmpty());
    }

    @Test
    @DisplayName("[AsList] -> O(n) - get")
    void get(){
        linkedList.add(person1); // We need to traverse from the Head to the tail to get, that's why it's O(n)
        assertEquals(linkedList.get(0), person1);
    }

    @Test
    @DisplayName("[AsList] -> O(N) - indexOf")
    void indexOf(){
        linkedList.add(person1);
        assertEquals(linkedList.indexOf(person1), 0); //O(N) -> It iterates through the internal array and checks each element one by one
    }

    @Test
    @DisplayName("[AsList] -> O(N) - removes")
    void remove(){
        linkedList.add(person1);
        linkedList.add(person2);

        //By index -> Return removed
        Person removedObject = linkedList.remove(0); //O(N) -> In the linkedList we need to traverse until N to find the element

        //By object -> Remove the lowest index found
        boolean wasRemoved = linkedList.remove(person2); //O(N) -> We need to find it iterating over each one checking the equals method

        assertTrue(linkedList.isEmpty());
        assertEquals(person1, removedObject);
        assertTrue(wasRemoved);
    }

    @Test
    @DisplayName("[AsList] -> O(N) - contains")
    void contains(){
        linkedList.add(person1);
        boolean contains = linkedList.contains(person2);

        assertFalse(contains);
    }

    @Test
    @DisplayName("[AsList] -> O(N) - set")
    void set(){
        linkedList.add(person1);
        Person previousElementOnTheIndex = linkedList.set(0, person2); //O(N) -> Shifts indexes

        assertEquals(person1, previousElementOnTheIndex);
    }

    @Test
    @DisplayName("[AsList] -> O(N?) - clone")
    void cloneMethod(){
        linkedList.add(person1);
        LinkedList sec_list = (LinkedList) linkedList.clone(); //Shallow copy, only copies references

        assertEquals(linkedList.get(0), sec_list.get(0));
    }

    @Test
    @DisplayName("[AsList] -> O(N) - addAll")
    void addAll(){
        ArrayList newArrayList = new ArrayList<>(Arrays.asList(person1, person2));
        linkedList.addAll(newArrayList);

        assertEquals(linkedList.size(), 2);
    }

    @Test
    @DisplayName("[AsList] -> O(N) - addAll (atIndex)")
    void addAllAtIndex(){
        ArrayList newArrayList = new ArrayList<>(Arrays.asList(person2));
        linkedList.add(person1);
        linkedList.addAll(0, newArrayList);

        assertEquals(linkedList.size(), 2);
    }


    //Making an anonymous inner class with an instance initializer (also known as an "double brace initialization")
//        ArrayList<Integer> arrayList = new ArrayList<Integer>(){{
//            add(1);
//            add(2);
//        }};
}
