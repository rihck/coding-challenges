-- https://leetcode.com/problems/biggest-single-number/description/

-- GroupBy Approach
-- PS: the SELECT statement outside enclosing the search query is a approach to return NULL in case the query doesn't return anything (Refer to: https://stackoverflow.com/questions/17250243/how-to-return-null-when-result-is-empty)


select (
   SELECT MAX(num) num
   FROM MyNumbers
   GROUP by num
   HAVING count(*) <= 1
   ORDER BY num DESC
   LIMIT 1
) as num

/** Schema
    Table: MyNumbers

    +-------------+------+
    | Column Name | Type |
    +-------------+------+
    | num         | int  |
    +-------------+------+
    There is no primary key for this table. It may contain duplicates.
    Each row of this table contains an integer.
*/

#---------


/** I/O
   Example 1:
    Input:
    MyNumbers table:
    +-----+
    | num |
    +-----+
    | 8   |
    | 8   |
    | 3   |
    | 3   |
    | 1   |
    | 4   |
    | 5   |
    | 6   |
    +-----+
    Output:
    +-----+
    | num |
    +-----+
    | 6   |
    +-----+
    Explanation: The single numbers are 1, 4, 5, and 6.
    Since 6 is the largest single number, we return it.

  Example 2:
    Input:
    MyNumbers table:
    +-----+
    | num |
    +-----+
    | 8   |
    | 8   |
    | 7   |
    | 7   |
    | 3   |
    | 3   |
    | 3   |
    +-----+
    Output:
    +------+
    | num  |
    +------+
    | null |
    +------+
    Explanation: There are no single numbers in the input table so we return null.

*/