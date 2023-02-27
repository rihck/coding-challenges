package main.datastructures.set;

import main.datastructures.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class HashSetDA {

    Set<Person> peopleSet;
    Person person1, person2, person3;

    @BeforeEach
    void setup(){
        peopleSet = new HashSet<>();
        person1 = new Person(28, "Ricardo");
        person2 = new Person(25, "Rafael");
        person3 = new Person(31, "Giselle");
    }

    @Test
    @DisplayName("O(1) - add")
    void add(){
        peopleSet.add(person1);

        assertEquals(peopleSet.size(), 1);
    }

    @Test
    @DisplayName("O(1) - contains")
    void contains(){
        peopleSet.add(person3);

        assertTrue(peopleSet.contains(person3));
        assertFalse(peopleSet.contains(person1));
    }

    @Test
    @DisplayName("O(1) - remove")
    void remove(){
        peopleSet.add(person2);
        assertEquals(peopleSet.size(), 1);

        peopleSet.remove(person2);
        assertEquals(peopleSet.size(), 0);
    }

    @Test
    @DisplayName("O(N) - Next / Iterator [Loop thru set]")
    void iterator(){
        /**
         * PS: Some places say that the cost is:
         * O(h/n) ->  h is the table capacity
         * But I'm logically assuming O(N)
         */

        peopleSet.add(person1);
        Iterator<Person> iterator = peopleSet.iterator();
        assertTrue(iterator.hasNext());
        while (iterator.hasNext()){
            assertEquals(person1, iterator.next());
        }

        assertFalse(iterator.hasNext());

        //PS: You can also loop through ForEach
        for(Person person : peopleSet){
            person.getAge();
        }
        peopleSet.forEach(Person::getAge);
    }

    @Test
    @DisplayName("O(1) - clear")
    void clear(){
        peopleSet.addAll(Arrays.asList(person1, person2, person3));
        assertEquals(peopleSet.size(), 3);

        peopleSet.clear();
        assertEquals(peopleSet.size(), 0);
    }

}
