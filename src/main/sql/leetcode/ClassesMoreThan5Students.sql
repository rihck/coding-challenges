-- https://leetcode.com/problems/classes-more-than-5-students/

-- Group by solution:
SELECT class
FROM Courses
GROUP BY class
HAVING count(*) > 5