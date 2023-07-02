-- https://leetcode.com/problems/employee-bonus/description/

-- LEFT JOIN filtering by NULL and < 1000
SELECT e.name name, b.bonus bonus
FROM Employee e
LEFT JOIN Bonus b ON (e.empId = b.empId)
WHERE (b.bonus IS NULL OR b.bonus < 1000)


-- IF Null Approach (instead of IS NULL)
SELECT e.name name, b.bonus bonus
FROM Employee e
LEFT JOIN Bonus b ON (e.empId = b.empId)
WHERE IFNULL(bonus, 0) < 1000
-- IF the Bonus is NULL, it's "converted" to 0 than the competition part is done