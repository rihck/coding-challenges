-- https://leetcode.com/problems/duplicate-emails/

-- My Solution
SELECT DISTINCT(p1.email) Email
FROM Person p1
INNER JOIN Person p2 ON (p1.email = p2.email and p1.id <> p2.id)

--Other people sulition using group by
SELECT Email
FROM Person
GROUP BY Email HAVING count(Email) > 1

/** Schema
    Table: Person

    +-------------+---------+
    | Column Name | Type    |
    +-------------+---------+
    | id          | int     |
    | email       | varchar |
    +-------------+---------+
    id is the primary key column for this table.
    Each row of this table contains an email. The emails will not contain uppercase letters.
*/

---------

/** I/O
    Input:
    Person table:
    +----+---------+
    | id | email   |
    +----+---------+
    | 1  | a@b.com |
    | 2  | c@d.com |
    | 3  | a@b.com |
    +----+---------+
    Output:
    +---------+
    | Email   |
    +---------+
    | a@b.com |
    +---------+
    Explanation: a@b.com is repeated two times.
*/