-- https://leetcode.com/problems/actors-and-directors-who-cooperated-at-least-three-times/

-- Did not work after adding the HAVING at the end.
SELECT actor_id, director_id
FROM ActorDirector
WHERE actor_id = director_id
GROUP by actor_id
HAVING count(*) > 2



/** Schema
    Table: ActorDirector

    +-------------+---------+
    | Column Name | Type    |
    +-------------+---------+
    | actor_id    | int     |
    | director_id | int     |
    | timestamp   | int     |
    +-------------+---------+
    timestamp is the primary key column for this table.
*/

#---------

/** I/O
    Input:
    ActorDirector table:
    +-------------+-------------+-------------+
    | actor_id    | director_id | timestamp   |
    +-------------+-------------+-------------+
    | 1           | 1           | 0           |
    | 1           | 1           | 1           |
    | 1           | 1           | 2           |
    | 1           | 2           | 3           |
    | 1           | 2           | 4           |
    | 2           | 1           | 5           |
    | 2           | 1           | 6           |
    +-------------+-------------+-------------+
    Output:
    +-------------+-------------+
    | actor_id    | director_id |
    +-------------+-------------+
    | 1           | 1           |
    +-------------+-------------+
    Explanation: The only pair is (1, 1) where they cooperated exactly 3 times.
*/