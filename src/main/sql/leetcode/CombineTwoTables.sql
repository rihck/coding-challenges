-- https://leetcode.com/problems/combine-two-tables/

SELECT firstName, lastName, city, state
FROM Person p
LEFT JOIN Address a ON (p.perso nId = a.personId);