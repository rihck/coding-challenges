package main.javafeatures.java6;

import main.datastructures.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class AnonymousClasses {

    LinkedList<Person> people;
    Person person1, person2;

    @BeforeEach
    void init(){
        people = new LinkedList<>();
        person1 = new Person(28, "Ricardo");
        person2 = new Person(25, "Rafael");
    }

    @Test
    @DisplayName("Sorting using AnonymousClasses")
    void sortAnonymous(){
        people.add(person1);
        people.add(person2);

        /**
            The sort method expects a class that Implements "Comparator". it means the class would need to extend "compare"
            and would know how define 1 object is higher/lower than others. So instead of creating a new class ONLY for this,
            we can create an Anonymous one right here that meet these requirements :mindblow:
         */
        people.sort(new Comparator<Person>() { //O(n log(n))
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        assertEquals(people.peek(), person2);
    }

    //* sortCreatingSortClass
    @Test
    @DisplayName("Sort WITHOUT Anonymous Class, creating Sorting class")
    void sortCreatingSortClass(){
        people.add(person1);
        people.add(person2);

        /**
         * Here we're doing the opposite, we are creating a concrete class in another part of the code to meet the requirements of
         * having a class that extends "Comparator" and overrides the method compare() so the class knows how to say which object is higher/lower than the other
         */
        people.sort(new ComparePerson());

        assertEquals(people.peek(), person2);
    }

    class ComparePerson implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    //sortCreatingSortClass *\\

    @Test
    @DisplayName("Sort with Lambda (Java 8)")
    void sortWithLambda(){
        people.add(person1);
        people.add(person2);

        /**
         * In this case we're also creating an anonymous class BUT with Lambda, that is, Java assumes you're trying to override the Comparator.compare()
         * method because:
         * 1 - Sort method expects a class that implements Comparator
         * 2 - The Interface "Comparator" contain ONLY ONE abstract method (method that NEEDS TO BE implemented), so java assumes that you want to implement this one, without saying
         */
        people.sort((p1, p2) -> {
            return p1.getName().compareTo(p2.getName());
        });

        //You could even make it simpler, you don't need to add "return" for lambdas with 1 Line and Without {}
        people.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
    }
}
