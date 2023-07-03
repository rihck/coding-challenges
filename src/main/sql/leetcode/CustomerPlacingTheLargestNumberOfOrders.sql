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