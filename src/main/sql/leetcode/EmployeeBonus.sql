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

/** Schema
    Table: Employee
    +-------------+---------+
    | Column Name | Type    |
    +-------------+---------+
    | empId       | int     |
    | name        | varchar |
    | supervisor  | int     |
    | salary      | int     |
    +-------------+---------+
    empId is the primary key column for this table.
    Each row of this table indicates the name and the ID of an employee in addition to their salary and the id of their manager.

    Table: Bonus
    +-------------+------+
    | Column Name | Type |
    +-------------+------+
    | empId       | int  |
    | bonus       | int  |
    +-------------+------+
    empId is the primary key column for this table.
    empId is a foreign key to empId from the Employee table.
    Each row of this table contains the id of an employee and their respective bonus.

  */

---------

/** I/O
    Input:
    Employee table:
    +-------+--------+------------+--------+
    | empId | name   | supervisor | salary |
    +-------+--------+------------+--------+
    | 3     | Brad   | null       | 4000   |
    | 1     | John   | 3          | 1000   |
    | 2     | Dan    | 3          | 2000   |
    | 4     | Thomas | 3          | 4000   |
    +-------+--------+------------+--------+
    Bonus table:
    +-------+-------+
    | empId | bonus |
    +-------+-------+
    | 2     | 500   |
    | 4     | 2000  |
    +-------+-------+
    Output:
    +------+-------+
    | name | bonus |
    +------+-------+
    | Brad | null  |
    | John | null  |
    | Dan  | 500   |
    +------+-------+
*/