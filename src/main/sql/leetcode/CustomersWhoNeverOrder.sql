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