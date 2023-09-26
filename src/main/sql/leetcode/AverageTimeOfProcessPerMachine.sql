-- https://leetcode.com/problems/average-time-of-process-per-machine/description/?envType=study-plan-v2&envId=top-sql-50

-- SelfJoin solution
SELECT a1.machine_id, round(avg(a2.timestamp-a1.timestamp), 3) as processing_time
FROM Activity a1
 INNER JOIN Activity a2 ON
     (a2.machine_id = a1.machine_id AND a1.process_id = a2.process_id) AND
     (a1.activity_type = 'start' AND a2.activity_type = 'end')
GROUP BY a1.machine_id;

-- SubQuery Solution
SELECT a.machine_id,
    round(
                (SELECT avg(a1.timestamp) FROM Activity a1 WHERE a1.activity_type = 'end' AND a1.machine_id = a.machine_id) -
                (SELECT avg(a1.timestamp) FROM Activity a1 WHERE a1.activity_type = 'start' AND a1.machine_id = a.machine_id)
        ,3) as processing_time
FROM Activity a
GROUP BY a.machine_id

/** Schema

  Table: Activity

    +----------------+---------+
    | Column Name    | Type    |
    +----------------+---------+
    | machine_id     | int     |
    | process_id     | int     |
    | activity_type  | enum    |
    | timestamp      | float   |
    +----------------+---------+
    The table shows the user activities for a factory website.
    (machine_id, process_id, activity_type) is the primary key (combination of columns with unique values) of this table.
    machine_id is the ID of a machine.
    process_id is the ID of a process running on the machine with ID machine_id.
    activity_type is an ENUM (category) of type ('start', 'end').
    timestamp is a float representing the current time in seconds.
    'start' means the machine starts the process at the given timestamp and 'end' means the machine ends the process at the given timestamp.
    The 'start' timestamp will always be before the 'end' timestamp for every (machine_id, process_id) pair.

 */

 /** I/O

   Example 1:
    Input:
    Activity table:
    +------------+------------+---------------+-----------+
    | machine_id | process_id | activity_type | timestamp |
    +------------+------------+---------------+-----------+
    | 0          | 0          | start         | 0.712     |
    | 0          | 0          | end           | 1.520     |
    | 0          | 1          | start         | 3.140     |
    | 0          | 1          | end           | 4.120     |
    | 1          | 0          | start         | 0.550     |
    | 1          | 0          | end           | 1.550     |
    | 1          | 1          | start         | 0.430     |
    | 1          | 1          | end           | 1.420     |
    | 2          | 0          | start         | 4.100     |
    | 2          | 0          | end           | 4.512     |
    | 2          | 1          | start         | 2.500     |
    | 2          | 1          | end           | 5.000     |
    +------------+------------+---------------+-----------+
    Output:
    +------------+-----------------+
    | machine_id | processing_time |
    +------------+-----------------+
    | 0          | 0.894           |
    | 1          | 0.995           |
    | 2          | 1.456           |
    +------------+-----------------+
    Explanation:
    There are 3 machines running 2 processes each.
    Machine 0's average time is ((1.520 - 0.712) + (4.120 - 3.140)) / 2 = 0.894
    Machine 1's average time is ((1.550 - 0.550) + (1.420 - 0.430)) / 2 = 0.995
    Machine 2's average time is ((4.512 - 4.100) + (5.000 - 2.500)) / 2 = 1.456

  */