-- https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/

-- Return the customer with most orders (Doesn't handle multiple customers with same highest orders)
SELECT customer_number
FROM Orders
GROUP BY customer_number
ORDER BY COUNT(order_number) DESC
LIMIT 1

-- Return the customerS (HANDLE multiple customers with same highest orders)
SELECT customer_number
FROM Orders
GROUP BY customer_number
HAVING COUNT(order_number) =
       (
           SELECT count(order_number)
           FROM Orders
           GROUP BY customer_number
           ORDER BY COUNT(customer_number) DESC
           LIMIT 1
    )

/** Schema
    Table: Orders

    +-----------------+----------+
    | Column Name     | Type     |
    +-----------------+----------+
    | order_number    | int      |
    | customer_number | int      |
    +-----------------+----------+
    order_number is the primary key for this table.
    This table contains information about the order ID and the customer ID.
*/

 ---------

/** I/O
    Input:
    Orders table:
    +--------------+-----------------+
    | order_number | customer_number |
    +--------------+-----------------+
    | 1            | 1               |
    | 2            | 2               |
    | 3            | 3               |
    | 4            | 3               |
    +--------------+-----------------+
    Output:
    +-----------------+
    | customer_number |
    +-----------------+
    | 3               |
    +-----------------+
    Explanation:
    The customer with number 3 has two orders, which is greater than either customer 1 or 2 because each of them only has one order.
    So the result is customer_number 3.
*/