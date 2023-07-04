-- https://leetcode.com/problems/big-countries/

-- Basic solution
SELECT name, population, area
FROM World
WHERE area >= 3000000 OR population >= 25000000


-- Using Union (faster)
SELECT name, population, area
FROM World
WHERE area > 3000000

UNION

SELECT name, population, area
FROM World
WHERE population > 25000000

/* Explanation source: https://leetcode.com/problems/big-countries/solutions/103561/union-and-or-and-the-explanation/
 Why Union is faster than OR?

Strictly speaking, Using UNION is faster when it comes to cases like scan two different column like this.

(Of course using UNION ALL is much faster than UNION since we don't need to sort the result. But it violates the requirements)

Suppose we are searching population and area, Given that MySQL usually uses one one index per table in a given query, so when it uses the 1st index rather than 2nd index, it would still have to do a table-scan to find rows that fit the 2nd index.

When using UNION, each sub-query can use the index of its search, then combine the sub-query by UNION.

 */