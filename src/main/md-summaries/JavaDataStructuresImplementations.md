### Summary and explanations about the Concrete Classes on Java that uses some DataStructures Concepts

https://stackoverflow.com/questions/559839/big-o-summary-for-java-collections-framework-implementations

---
# Lists
Ordered DA and allow duplicates

## ArrayList

|           | get  | add  | contains | next | remove(0) | iterator.remove |
|-----------|------|------|----------|------|-----------|-----------------|
| ArrayList | O(1) | O(1) | O(n)     | O(1) | O(n)      | O(n)            |

 Indexed list, where each array has an index and by manipulating the elements, may case index shifting in all elements performing a O(n) operation. But access is easier considered they're indexed.


--

## LinkedList

|            | get  | add  | contains | next | remove(0) | iterator.remove |
|------------|------|------|----------|------|-----------|-----------------|
| LinkedList | O(n) | O(1) | O(n)     | O(1) | O(1)      | O(1)            |

Not indexed, each element keep reference to the previous/next so delete doesn't require O(n), it just needs to update the references. **But** as it's not indexed, while search for a element, we'll need to go over all List elements `O(n)`

---

# Sets

Not ordered and **doesn't allow duplicates**

## HashSet

|         | add  | contains | next   | notes                   |
|---------|------|----------|--------|-------------------------|
| HashSet | O(1) | O(1)     | O(h/n) | h is the table capacity |

- Doesn't allow duplicated,
- Ordered by **the hash**

--

## LinkedHashSet

|               | add  | contains | next |
|---------------|------|----------|------|
| LinkedHashSet | O(1) | O(1)     | O(1) |

- Doesn't allow duplicated 
- Ordered by **insertion order** AND 
- Each element knows the <u>next</u> element since it's a Linked collection and **each element holds the reference to the next** item.

--

## TreeSet

- Doesn't allow duplicated 
- Ordered by Comparator/Comparable (I): You should tell how the Tree will be ordered. My implements "Comparable" or creating a "Comparator"
- It's organized in a "Tree way", ordered considering right/left rules (lower, greater) and that's why all the operations are `log n`, because the worst case it will go through all tree nodes.

|         | add      | contains | next     |
|---------|----------|----------|----------|
| TreeSet | O(log n) | O(log n) | O(log n) |

--

### TreeSet Methods
```java8
NavigableSet<Integer> set = new TreeSet<Integer>(){{
        add(1);
        add(4);
        add(2);
        add(3);
}}; //Output: [1, 2, 3, 4]
```

PS: As it's a tree structure, we have "tree search methods" implemented in this collection, like:
- `lower`: `<` Find the **lower closest** in the tree (**DOES NOT CONSIDER** the element passed as parameter)
```java8
    set.lower(3); // Output: 2
```

- `floor`: `<=` Find the **lower closest** in the tree (**DOES CONSIDER** the element passed as parameter)
```java8
    set.floor(3); // Output: 3
```

- `higher`: `>` Find the **higher closed** Element in the tree (**DOES NOT CONSIDER** the element passed as parameter)
```java8
    set.higher(3); // Output: 4
```

- `ceiling`: `>=` Find the **higher closed** Element in the tree (**DOES CONSIDER** the element passed as parameter)
```java8
    set.ceiling(3); // Output: 3
```


---

# Maps

Key-value collections that **doesn't allow duplicates KEYS**

## TreeMap

Same thing as "**TreeSet**", the rules applies to the Key (ordering, using Comparator or Comparable) and have **similar methods**:


### TreeMap Methods

```java8
NavigableMap<Integer, String> map = new TreeMap<Integer, String>(){{
    put(1, "A");
    put(4, "D");
    put(3, "C");
    put(2, "B");
}}; //Output: {1 : "A"}, {2: "B"}, {3: "C"}, {4: "D"}
```

- `headMap`: `<=` all elements that are lower (ordered before) that element
  - **headMap(toKey)**: **All elements** before and **DOES NOT include** the key parameter itself
  - **headMap(toKey, true)**: **All elements** before and **DOES INCLUDE** the key parameter itself
```java8
    System.out.println(map.headMap(3)); //Output: {1 : "A"}, {2: "B"}
    System.out.println(map.headMap(3, true)); //Output: {1 : "A"}, {2: "B"}, {3: "C"}
```

- `lowerKey` / `loweEntry`: `<` Find the **lower closest** in the tree -> Method to return only the key or the entry itself  (**DOES NOT CONSIDER** the element passed as parameter)
```java8
    map.lowerKey(3); // Output: 2
    map.loweEntry(3); // Output: {2: "B"}
```

- `floorKey` / `floorEntry`: `<=` Find the **lower closest** in the tree -> Method to return only the key or the entry itself  (**DOES CONSIDER** the element passed as parameter)
```java8
    map.floorKey(3); // Output: 3
    map.floorEntry(3); // Output: {3: "C"}
```

- `higherKey` / `higherEntry`: `>` Find the **higher closed** Element in the tree -> Method to return only the key or the entry itself (**DOES NOT CONSIDER** the element passed as parameter)
```java8
    map.higherKey(3); // Output: 4
    map.higherEntry(3); // Output: {4: "D"}
```

- `ceilingKey` / `ceilingEntry`: `>=` Find the **higher closed** Element in the tree -> Method to return only the key or the entry itself  (**DOES CONSIDER** the element passed as parameter)
```java8
    map.ceilingKey(3); // Output: 3
    map.ceilingEntry(3); // Output: {3: "C"}
```


