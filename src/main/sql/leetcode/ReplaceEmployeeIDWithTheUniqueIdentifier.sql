-- https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/?envType=study-plan-v2&envId=top-sql-50

SELECT unique_id, name
FROM Employees e
LEFT JOIN EmployeeUNI eu ON (e.id = eu.id)

/**
  Schema

  Table: Employees

    +---------------+---------+
    | Column Name   | Type    |
    +---------------+---------+
    | id            | int     |
    | name          | varchar |
    +---------------+---------+
    In SQL, id is the primary key for this table.
    Each row of this table contains the id and the name of an employee in a company.


    Table: EmployeeUNI

    +---------------+---------+
    | Column Name   | Type    |
    +---------------+---------+
    | id            | int     |
    | unique_id     | int     |
    +---------------+---------+
    In SQL, (id, unique_id) is the primary key for this table.
    Each row of this table contains the id and the corresponding unique id of an employee in the company.


 */

/**
  I/O
    Example 1:

    Input:
    Employees table:
    +----+----------+
    | id | name     |
    +----+----------+
    | 1  | Alice    |
    | 7  | Bob      |
    | 11 | Meir     |
    | 90 | Winston  |
    | 3  | Jonathan |
    +----+----------+
    EmployeeUNI table:
    +----+-----------+
    | id | unique_id |
    +----+-----------+
    | 3  | 1         |
    | 11 | 2         |
    | 90 | 3         |
    +----+-----------+
    Output:
    +-----------+----------+
    | unique_id | name     |
    +-----------+----------+
    | null      | Alice    |
    | null      | Bob      |
    | 2         | Meir     |
    | 3         | Winston  |
    | 1         | Jonathan |
    +-----------+----------+
    Explanation:
    Alice and Bob do not have a unique ID, We will show null instead.
    The unique ID of Meir is 2.
    The unique ID of Winston is 3.
    The unique ID of Jonathan is 1.


 */