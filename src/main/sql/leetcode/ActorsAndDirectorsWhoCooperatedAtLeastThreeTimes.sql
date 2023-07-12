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

*/