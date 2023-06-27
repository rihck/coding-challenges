-- https://leetcode.com/problems/duplicate-emails/

-- My Solution
SELECT DISTINCT(p1.email) Email
FROM Person p1
INNER JOIN Person p2 ON (p1.email = p2.email and p1.id <> p2.id)

--Other people sulition using group by
SELECT Email
FROM Person
GROUP BY Email HAVING count(Email) > 1