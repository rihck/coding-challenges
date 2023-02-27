package main.datastructures.set;

import main.datastructures.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TreeSetDA {

    TreeSet<Person> peopleSet;
    Person person1, person2, person3, person4;

    @BeforeEach
    void setup(){
        peopleSet = new TreeSet<>();
        person1 = new Person(28, "Ricardo");
        person2 = new Person(25, "Rafael");
        person3 = new Person(31, "Giselle");
        person4 = new Person(32, "Renato");
    }

    @Test
    @DisplayName("O(log n) - add")
    void add(){
        peopleSet = getTreeSetComparatorByYoungerFirst();
        peopleSet.add(person1);

        assertEquals(peopleSet.size(), 1);
    }

    @Test
    @DisplayName("O(log n) - contains")
    void contains(){
        peopleSet = getTreeSetComparatorByYoungerFirst();
        peopleSet.add(person3);

        assertTrue(peopleSet.contains(person3));
        assertFalse(peopleSet.contains(person2));
    }

    @Test
    @DisplayName("O(log n) - higher")
    void higher(){
        peopleSet = getTreeSetComparatorByYoungerFirst();
        peopleSet.add(person2);
        peopleSet.add(person1);

        /**
         * Fetches the next higher -> DOES NOT consider the parameter value itself, we can translate as ">"
         * */
        Person higherThanPerson2 = peopleSet.higher(person2);
        assertEquals(higherThanPerson2, person1);
    }

    @Test
    @DisplayName("O(log n) - ceiling")
    void ceiling(){
        peopleSet = getTreeSetComparatorByYoungerFirst();
        peopleSet.add(person2);
        peopleSet.add(person1);

        /**
         * Same as higher BUT consider the parameter value itself, we can translate as ">="
         */
        Person ceilingPerson2 = peopleSet.ceiling(person2);
        assertEquals(ceilingPerson2, person2);
    }

    @Test
    @DisplayName("O(log n) - lower")
    void lower(){
        peopleSet = getTreeSetComparatorByYoungerFirst();
        peopleSet.add(person1);
        peopleSet.add(person2);
        peopleSet.add(person3);

        /**
         * Fetches the next Lowest, BUT does not consider the parameter value itself, we could translate as "<"
         */
        Person lowerPerson3 = peopleSet.lower(person3);
        assertEquals(lowerPerson3, person1);
    }

    @Test
    @DisplayName("O(log n) - floor")
    void floor(){
        peopleSet = getTreeSetComparatorByYoungerFirst();
        peopleSet.add(person1);
        peopleSet.add(person2);
        peopleSet.add(person3);

        Person floorPerson3 = peopleSet.floor(person3);
        assertEquals(floorPerson3, person3);
    }

    @Test
    @DisplayName("O(log n) - remove")
    void remove(){
        peopleSet = getTreeSetComparatorByYoungerFirst();
        peopleSet.add(person1);
        assertEquals(peopleSet.size(), 1);

        peopleSet.remove(person1);
        assertEquals(peopleSet.size(), 0);
    }

    @Test
    @DisplayName("O(log n) - first / first")
    void firstLast(){
        // I thought the cost was O(1) but that's not true. The code shows "while" in left node.

        peopleSet = getTreeSetComparatorByYoungerFirst();
        peopleSet.addAll(Arrays.asList(person1, person2, person3));

        assertEquals(peopleSet.first(), person2);
        assertEquals(peopleSet.last(), person3);
        assertEquals(peopleSet.size(), 3);
    }

    @Test
    @DisplayName("O(log n) - pollFirst / pollLast ")
    void pollFirstLast(){
        peopleSet = getTreeSetComparatorByYoungerFirst();
        peopleSet.addAll(Arrays.asList(person1, person2, person3));

        /** Same as First/Last BUT removes the element from the collection */
        assertEquals(peopleSet.pollFirst(), person2);
        assertEquals(peopleSet.size(), 2);

        assertEquals(peopleSet.pollLast(), person3);
        assertEquals(peopleSet.size(), 1);
    }

    @Test
    @DisplayName("O(log n) - headSet | headSet+Inclusive")
    void headSet(){
        peopleSet = getTreeSetComparatorByYoungerFirst();
        peopleSet.addAll(Arrays.asList(person1, person2, person3));

        /**
         * Starting from the Head, is return the element until the parameter, DOES NOT consider the parameter itself, so it is ">"
         */
        SortedSet<Person> peopleSetUntilPerson3 = peopleSet.headSet(person3);
        assertEquals(peopleSetUntilPerson3.size(), 2); //person3 not included

        /**
         * You can pass a boolean as parameter to include the parameter itself, but it returns another kind of set, so it is ">="
         */
        NavigableSet<Person> peopleSetUntilPerson3Inclusive = peopleSet.headSet(person3, true);
        assertEquals(peopleSetUntilPerson3Inclusive.size(), 3);
    }

    @Test
    @DisplayName("O(log n) - tailSet | tailSet+Inclusive")
    void tailSet(){
        peopleSet = getTreeSetComparatorByYoungerFirst();
        peopleSet.addAll(Arrays.asList(person1, person2, person3, person4));

        /**
         * Opposite from headSet, starting from the tail, select elements until parameter, BUT DIFFERENT FROM headSet CONSIDER the parameter itself, "<="
         */
        SortedSet<Person> peopleTailSetUntilPerson1 = peopleSet.tailSet(person1);
        assertEquals(3, peopleTailSetUntilPerson1.size());

        /**
         * Pass boolean parameters to NOT INCLUDE the parameter
         */
        NavigableSet<Person> peopleTailSetUntilPerson1Inclusive = peopleSet.tailSet(person1, false);
        assertEquals(2, peopleTailSetUntilPerson1Inclusive.size());
    }

    @Test
    @DisplayName("O(log n) - subSet")
    void subSet(){
        /**
         * Returns new set considering beginning and end as parameters, and you can also decide to INCLUDE both or not in the return.
         */

        peopleSet = getTreeSetComparatorByYoungerFirst();
        peopleSet.addAll(Arrays.asList(person1, person2, person3, person4));

        /**
         * Default subSet with no parameters is:
         * Inclusive head (first param) = true / Inclusive tail (last param) = false
         */
        assertEquals(peopleSet.subSet(person2, person3).size(), 2);

        NavigableSet<Person> subSetWithBothInclusiveAll = peopleSet.subSet(person2, true, person4, true);
        assertEquals( 4, subSetWithBothInclusiveAll.size());

        NavigableSet<Person> subSetWithTailInclusiveOnly = peopleSet.subSet(person2, false, person4, true);
        assertEquals( 3, subSetWithTailInclusiveOnly.size());

        NavigableSet<Person> subSetWithNoInclusive = peopleSet.subSet(person2, false, person4, false);
        assertEquals(2, subSetWithNoInclusive.size());
    }

    @Test
    @DisplayName("O(?) - comparator")
    void comparator(){
        /**
         * Returns the comparator used for sorting the elements. If the comparator uses natural ordering for sorting, it returns null
         */
        assertNotNull(peopleSet.comparator());
    }

    private TreeSet<Person> getTreeSetComparatorByYoungerFirst() {
        return new TreeSet<>((p1, p2) -> {
            if (p1.getAge() < p2.getAge())
                return -1;
            else if (p1.getAge() > p2.getAge())
                return 1;

            return 0;
        });
    }
}
