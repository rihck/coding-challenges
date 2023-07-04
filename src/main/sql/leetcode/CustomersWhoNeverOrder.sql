-- https://leetcode.com/problems/customers-who-never-order/

-- Mine LEFT JOIN Approach
SELECT c.name Customers
FROM Customers c
-- Left JOIN to bring all from the Order table, even if there's no match
LEFT JOIN Orders o ON (c.id = o.customerId)
-- The ones with no Math will return NULL for Order fields, so we filter here by NULL
WHERE o.customerId IS NULL


-- SubQuery Approach
SELECT c.name Customers
FROM Customers C
WHERE c.id NOT IN (SELECT customerId from Orders)

/** Schema
    +-------------+---------+
    | Column Name | Type    |
    +-------------+---------+
    | id          | int     |
    | name        | varchar |
    +-------------+---------+
    id is the primary key column for this table.
    Each row of this table indicates the ID and name of a customer.
*/

---------

/** I/O
    +-------------+------+
    | Column Name | Type |
    +-------------+------+
    | id          | int  |
    | customerId  | int  |
    +-------------+------+
    id is the primary key column for this table.
    customerId is a foreign key of the ID from the Customers table.
    Each row of this table indicates the ID of an order and the ID of the customer who ordered it.
*/