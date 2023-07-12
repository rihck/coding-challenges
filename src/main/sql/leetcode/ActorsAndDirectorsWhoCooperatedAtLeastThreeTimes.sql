-- https://leetcode.com/problems/actors-and-directors-who-cooperated-at-least-three-times/

SELECT actor_id, director_id
FROM ActorDirector
WHERE actor_id = director_id
GROUP by actor_id
HAVING count(*) > 2