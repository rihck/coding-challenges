-- https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/?envType=study-plan-v2&envId=top-sql-50

/** Schema
    Table: Visits

    +-------------+---------+
    | Column Name | Type    |
    +-------------+---------+
    | visit_id    | int     |
    | customer_id | int     |
    +-------------+---------+
    visit_id is the column with unique values for this table.
    This table contains information about the customers who visited the mall.


    Table: Transactions

    +----------------+---------+
    | Column Name    | Type    |
    +----------------+---------+
    | transaction_id | int     |
    | visit_id       | int     |
    | amount         | int     |
    +----------------+---------+
    transaction_id is column with unique values for this table.
    This table contains information about the transactions made during the visit_id.
 */

