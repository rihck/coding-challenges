-- https://leetcode.com/problems/employee-bonus/description/

-- LEFT JOIN filtering by NULL and < 1000
SELECT e.name name, b.bonus bonus
FROM Employee e
LEFT JOIN Bonus b ON (e.empId = b.empId)
WHERE (b.bonus IS NULL OR b.bonus < 1000)

