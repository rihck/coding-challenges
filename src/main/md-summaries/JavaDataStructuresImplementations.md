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

PS: As it's a tree structure, we have "tree search methods" implemented in this collection, like:
- lower: `<` all elements that are lower in the tree
- floor: `<=` all elements that are lower in the tree OR equal (the element itself included)
- higher: `>` all elements that are higher
- ceiling: `>=` all elements that are higher equal (the element itself included)