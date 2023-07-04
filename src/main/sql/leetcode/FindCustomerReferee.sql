-- https://leetcode.com/problems/find-customer-referee/

-- Basic Approach
SELECT name
FROM Customer
WHERE IFNULL(referee_id, 0) != 2
-- -- IF the Bonus is NULL, it's "converted" to 0 than the competition part is done


-- Replacing IF NULL
SELECT name
FROM Customer
WHERE referee_id != 2 OR referee_id IS NULL


-- SubQuery Approach
SELECT name
FROM Customer
WHERE id NOT IN (
    SELECT id
    FROM Customer
    WHERE referee_id = 2
)

/** Schema
    Table: Customer

    +-------------+---------+
    | Column Name | Type    |
    +-------------+---------+
    | id          | int     |
    | name        | varchar |
    | referee_id  | int     |
    +-------------+---------+
    id is the primary key column for this table.
    Each row of this table indicates the id of a customer, their name, and the id of the customer who referred them.
*/

---------

/** I/O
    Input:
    Customer table:
    +----+------+------------+
    | id | name | referee_id |
    +----+------+------------+
    | 1  | Will | null       |
    | 2  | Jane | null       |
    | 3  | Alex | 2          |
    | 4  | Bill | null       |
    | 5  | Zack | 1          |
    | 6  | Mark | 2          |
    +----+------+------------+
    Output:
    +------+
    | name |
    +------+
    | Will |
    | Jane |
    | Bill |
    | Zack |
    +------+
*/