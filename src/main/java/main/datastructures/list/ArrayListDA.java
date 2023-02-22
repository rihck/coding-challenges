package main.datastructures.list;

import main.datastructures.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * https://www.baeldung.com/java-collections-complexity#arraylist
 */
public class ArrayListDA {

    ArrayList<Person> arrayList;
    Person person1, person2;

    @BeforeEach
    void init(){
        arrayList = new ArrayList<>();
        person1 = new Person(28, "Ricardo");
        person2 = new Person(25, "Rafael");
    }
    /* TODO:
        - Reinforce Comparator conditionals (-1 and 1) + write integ Tests
        - Reinforce TreeSet methods + write integTests
    */
    @Test
    @DisplayName("O(1) - add")
    void add(){
        arrayList.add(person1); //O(1) -> because always add to the end, not index shifting
        assertEquals(arrayList.size(), 1);
    }

    @Test
    @DisplayName("O(N) - add (atIndex)")
    void addAtIndex(){
        arrayList.add(0, person1); //O(N) -> Shifts indexes
        assertFalse(arrayList.isEmpty());
    }

    @Test
    @DisplayName("O(1) - get")
    void get(){
        arrayList.add(person1);
        assertEquals(arrayList.get(0), person1);
    }

    @Test
    @DisplayName("O(N) - indexOf")
    void indexOf(){
        arrayList.add(person1);
        assertEquals(arrayList.indexOf(person1), 0); //O(N) -> It iterates through the internal array and checks each element one by one
    }

    @Test
    @DisplayName("O(N) - removes")
    void remove(){
        arrayList.add(person1);
        arrayList.add(person2);

        //By index -> Return removed
        Person removedObject = arrayList.remove(0); //O(N) -> Because even passing the index, we need to perform index shifting after removing

        //By object -> Remove the lowest index found
        boolean wasRemoved = arrayList.remove(person2); //O(N) -> Because we need to iterate one by one checking equals() and after that, perform index shifting

        assertTrue(arrayList.isEmpty());
        assertEquals(person1, removedObject);
        assertTrue(wasRemoved);
    }

    @Test
    @DisplayName("O(N) - contains")
    void contains(){
        arrayList.add(person1);
        boolean contains = arrayList.contains(person2);

        assertFalse(contains);
    }

    @Test
    @DisplayName("O(N) - set")
    void set(){
        arrayList.add(person1);
        Person previousElementOnTheIndex = arrayList.set(0, person2); //O(N) -> Shifts indexes

        assertEquals(person1, previousElementOnTheIndex);
    }

    @Test
    @DisplayName("O(N?) - clone")
    void cloneMethod(){
        arrayList.add(person1);
        ArrayList sec_list = (ArrayList) arrayList.clone(); //Shallow copy, only copies references

        assertEquals(arrayList.get(0), sec_list.get(0));
    }

    @Test
    @DisplayName("O(N) - addAll")
    void addAll(){
        ArrayList newArrayList = new ArrayList<>(Arrays.asList(person1, person2));
        arrayList.addAll(newArrayList);

        assertEquals(arrayList.size(), 2);
    }

    @Test
    @DisplayName("O(N) - addAll (atIndex)")
    void addAllAtIndex(){
        ArrayList newArrayList = new ArrayList<>(Arrays.asList(person2));
        arrayList.add(person1);
        arrayList.addAll(0, newArrayList);

        assertEquals(arrayList.size(), 2);
    }

    @Test
    @DisplayName("O(n log (n)) - sort")
    void sort(){
        ArrayList newArrayList = new ArrayList<>(Arrays.asList(person1, person2));
        newArrayList.sort(Comparator.naturalOrder());

        assertEquals(arrayList.size(), 2);
    }


    //Making an anonymous inner class with an instance initializer (also known as an "double brace initialization")
//        ArrayList<Integer> arrayList = new ArrayList<Integer>(){{
//            add(1);
//            add(2);
//        }};
}
