-- https://leetcode.com/problems/delete-duplicate-emails/
DELETE p1 from person p1, person p2 where p1.email = p2.email and p1.id > p2.id;

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
    +----+------------------+
    | id | email            |
    +----+------------------+
    | 1  | john@example.com |
    | 2  | bob@example.com  |
    | 3  | john@example.com |
    +----+------------------+
    Output:
    +----+------------------+
    | id | email            |
    +----+------------------+
    | 1  | john@example.com |
    | 2  | bob@example.com  |
    +----+------------------+
    Explanation: john@example.com is repeated two times. We keep the row with the smallest Id = 1.
*/