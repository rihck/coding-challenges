-- https://leetcode.com/problems/big-countries/

-- Revisited as part of SQL 50 Study Plan

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

/** Schema
    Table: World

    +-------------+---------+
    | Column Name | Type    |
    +-------------+---------+
    | name        | varchar |
    | continent   | varchar |
    | area        | int     |
    | population  | int     |
    | gdp         | bigint  |
    +-------------+---------+
    name is the primary key column for this table.
    Each row of this table gives information about the name of a country, the continent to which it belongs, its area, the population, and its GDP value.
*/

---------

/** I/O
    Input:
    World table:
    +-------------+-----------+---------+------------+--------------+
    | name        | continent | area    | population | gdp          |
    +-------------+-----------+---------+------------+--------------+
    | Afghanistan | Asia      | 652230  | 25500100   | 20343000000  |
    | Albania     | Europe    | 28748   | 2831741    | 12960000000  |
    | Algeria     | Africa    | 2381741 | 37100000   | 188681000000 |
    | Andorra     | Europe    | 468     | 78115      | 3712000000   |
    | Angola      | Africa    | 1246700 | 20609294   | 100990000000 |
    +-------------+-----------+---------+------------+--------------+
    Output:
    +-------------+------------+---------+
    | name        | population | area    |
    +-------------+------------+---------+
    | Afghanistan | 25500100   | 652230  |
    | Algeria     | 37100000   | 2381741 |
    +-------------+------------+---------+
*/


/** Schema

*/

#---------

/** I/O
    Input:

*/