-- https://leetcode.com/problems/swap-salary/description/

-- First approach
UPDATE Salary set sex =
CASE sex
  WHEN 'm' THEN 'f'
  ELSE 'm'
END;

-- My approach (more performance)
UPDATE Salary
SET sex = IF(sex='m', 'f', 'm');

/** Schema
    Table: Salary

    +-------------+----------+
    | Column Name | Type     |
    +-------------+----------+
    | id          | int      |
    | name        | varchar  |
    | sex         | ENUM     |
    | salary      | int      |
    +-------------+----------+
    id is the primary key for this table.
    The sex column is ENUM value of type ('m', 'f').
    The table contains information about an employee.
*/

#---------

/** I/O
    Input:
    Salary table:
    +----+------+-----+--------+
    | id | name | sex | salary |
    +----+------+-----+--------+
    | 1  | A    | m   | 2500   |
    | 2  | B    | f   | 1500   |
    | 3  | C    | m   | 5500   |
    | 4  | D    | f   | 500    |
    +----+------+-----+--------+
    Output:
    +----+------+-----+--------+
    | id | name | sex | salary |
    +----+------+-----+--------+
    | 1  | A    | f   | 2500   |
    | 2  | B    | m   | 1500   |
    | 3  | C    | f   | 5500   |
    | 4  | D    | m   | 500    |
    +----+------+-----+--------+
    Explanation:
    (1, A) and (3, C) were changed from 'm' to 'f'.
    (2, B) and (4, D) were changed from 'f' to 'm'.

*/