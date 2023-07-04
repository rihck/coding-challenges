-- https://leetcode.com/problems/rising-temperature/

--## Self Join using DateDiff to compare: records that has 1 day difference betweem them selecting the one with higher temperature
SELECT w1.id,
FROM Weather w1
INNER JOIN Weather w2 ON (DATEDIFF(w1.recordDate, w2.recordDate) = 1 AND w1.temperature > w2.temperature)

-- Self Join using DATE_ADD to basically add 1 day to the that to JOIN previous+next day records AND them selecting the one with higher temperature [doing self-join without ON INNER JOIN for testing]
SELECT w1.id #, w1.recordDate, w2.id, w2.recordDate
FROM Weather w1
         INNER JOIN Weather w2 ON (w1.recordDate = DATE_ADD(w2.recordDate, INTERVAL 1 DAY) )
    #WHERE DATE_ADD(w2.recordDate, INTERVAL 1 DAY) = w1.recordDate
WHERE w1.temperature > w2.temperature

--    # Some observations:
--    ## Subdate (subdate(w1.recordDate, 1)) function that subtracts X days from that Date
--    ## DATE_ADD(w2.recordDate, INTERVAL 1 DAY) function that ADDs intervals to the date (DAY / MONTH / YEAR)

/** Schema
    Table: Weather

    +---------------+---------+
    | Column Name   | Type    |
    +---------------+---------+
    | id            | int     |
    | recordDate    | date    |
    | temperature   | int     |
    +---------------+---------+
    id is the primary key for this table.
    This table contains information about the temperature on a certain day.
*/

---------

/** I/O
    Input:
    Weather table:
    +----+------------+-------------+
    | id | recordDate | temperature |
    +----+------------+-------------+
    | 1  | 2015-01-01 | 10          |
    | 2  | 2015-01-02 | 25          |
    | 3  | 2015-01-03 | 20          |
    | 4  | 2015-01-04 | 30          |
    +----+------------+-------------+
    Output:
    +----+
    | id |
    +----+
    | 2  |
    | 4  |
    +----+
    Explanation:
    In 2015-01-02, the temperature was higher than the previous day (10 -> 25).
    In 2015-01-04, the temperature was higher than the previous day (20 -> 30).
*/