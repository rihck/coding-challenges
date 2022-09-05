package main.datastructures;

import java.util.*;

public class JavaTreesImp {

    static class Person{
        int age;

        public Person(int i) {
            this.age = i;
        }

        @Override
        public String toString() {
            return String.valueOf(age);
        }
    }

    public static void main(String[] args) {
        TreeMap<Person, Person> myMap = new TreeMap<Person, Person>((a, b) -> {
            if (a.age < b.age)
                return  -1;

            if (a.age > b.age)
                return 1;

            return 0;
        }){{
            put(new Person(4), new Person(4));
            put(new Person(1), new Person(1));
            put(new Person(1), new Person(1));
            put(new Person(0), new Person(0));
        }};

        System.out.println("BB" + myMap);



        NavigableMap<Integer, String> map = new TreeMap<Integer, String>(){{
            put(1, "A");
            put(4, "D");
            put(3, "C");
            put(2, "B");
        }};

        map.put(1, "A");
        map.put(4, "D");
        map.put(3, "C");
        map.put(2, "B");

        //System.out.println(map);

        System.out.println(map.headMap(3, true));
        //System.out.println(map.lowerKey(3));


        NavigableSet<Integer> set = new TreeSet<Integer>(){{
            add(1);
            add(4);
            add(2);
            add(3);
        }};

        System.out.println(set.floor(2));
        System.out.println(set.lower(2));

        System.out.println(set.ceiling(2));
        System.out.println(set.higher(2));

    }

}
