package main.javafeatures.java8;

import main.datastructures.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComparatorImp {
    List<Person> people;
    Person person1, person2, person3;

    @BeforeEach
    void init(){
        people = new ArrayList();
        person1 = new Person(28, "Ricardo");
        person2 = new Person(25, "Rafael");
        person3 = new Person(31, "Giselle");

        people.addAll(Arrays.asList(person2, person3, person1));
    }

    /**
     * How I fixed the Compare method Logic. It's always about the first parameters, for example (person1, person2)
     * We ask ourselves what we want to do with the person1?
     * If our method returns 1, we say that we want to move him *1 position* to the END (Right)
     * If our methods returns -1, we say that we want to move him *1 position* to the beginning (Left)
     * If our method returns 0, it means we don't want to move it anywhere.
     *
     * Considering we always receive 2 objects, we can build our logic based on the 2 objects comparison, and decide to where we are going to move the first object. (Examples bellow)
     */

    @Test
    @DisplayName("Sort by Youngest First")
    void sortByYoungest(){
        people.sort((p1, p2) -> { //O(n log (n))
            if (p1.getAge() > p2.getAge())
                return 1;
            else if (p1.getAge() < p2.getAge())
                return -1;

            return 0;
        });

        assertEquals(person2, people.get(0));
        assertEquals(person1, people.get(1));
        assertEquals(person3, people.get(2));
    }

    @Test
    @DisplayName("Sort by Oldest First")
    void sortByOldest(){
        people.sort((p1, p2) -> { //O(n log (n))
            if(p1.getAge() > p2.getAge())
                return -1;
            else if (p1.getAge() < p2.getAge())
                return 1;

            return 0;
        });

        assertEquals(person3, people.get(0));
        assertEquals(person1, people.get(1));
        assertEquals(person2, people.get(2));
    }

    @Test
    @DisplayName("Sort by Alphabetical Name [lexicographically] ")
    void sortByName(){
        people.sort((p1, p2) -> {
            return p1.getName().compareTo(p2.getName());
        });

        //Inbuilt existing comparator for this case
        people.sort(Comparator.comparing(person -> person.getName()));
        people.sort(Comparator.comparing(Person::getName));

        assertEquals(person3, people.get(0));
        assertEquals(person2, people.get(1));
        assertEquals(person1, people.get(2));

    }

}
