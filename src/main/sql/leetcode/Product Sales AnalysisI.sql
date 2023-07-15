-- https://leetcode.com/problems/product-sales-analysis-i/

/** Schema
    Table: Sales

    +-------------+-------+
    | Column Name | Type  |
    +-------------+-------+
    | sale_id     | int   |
    | product_id  | int   |
    | year        | int   |
    | quantity    | int   |
    | price       | int   |
    +-------------+-------+
    (sale_id, year) is the primary key of this table.
    product_id is a foreign key to Product table.
    Each row of this table shows a sale on the product product_id in a certain year.
    Note that the price is per unit.
*/

#---------

/** I/O

*/