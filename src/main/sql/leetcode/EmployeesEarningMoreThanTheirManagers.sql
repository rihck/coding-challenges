-- https://leetcode.com/problems/employees-earning-more-than-their-managers/

SELECT e.name as "Employee"
FROM Employee e
INNER JOIN Employee e1 ON (e.managerId = e1.id AND e.salary > e1.salary)

/** Schema
    Table: Employee

    +-------------+---------+
    | Column Name | Type    |
    +-------------+---------+
    | id          | int     |
    | name        | varchar |
    | salary      | int     |
    | managerId   | int     |
    +-------------+---------+
    id is the primary key column for this table.
    Each row of this table indicates the ID of an employee, their name, salary, and the ID of their manager.
*/

---------

/** I/O
    Input:
    Employee table:
    +----+-------+--------+-----------+
    | id | name  | salary | managerId |
    +----+-------+--------+-----------+
    | 1  | Joe   | 70000  | 3         |
    | 2  | Henry | 80000  | 4         |
    | 3  | Sam   | 60000  | Null      |
    | 4  | Max   | 90000  | Null      |
    +----+-------+--------+-----------+
    Output:
    +----------+
    | Employee |
    +----------+
    | Joe      |
    +----------+
    Explanation: Joe is the only employee who earns more than his manager.
*/