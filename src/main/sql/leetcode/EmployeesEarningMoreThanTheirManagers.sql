-- https://leetcode.com/problems/employees-earning-more-than-their-managers/

SELECT e.name as "Employee"
FROM Employee e
INNER JOIN Employee e1 ON (e.managerId = e1.id AND e.salary > e1.salary)