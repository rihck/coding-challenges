-- https://leetcode.com/problems/find-customer-referee/

-- Basic Approach
SELECT name
FROM Customer
WHERE IFNULL(referee_id, 0) != 2
-- -- IF the Bonus is NULL, it's "converted" to 0 than the competition part is done


-- Replacing IF NULL
SELECT name
FROM Customer
WHERE referee_id != 2 OR referee_id IS NULL


-- SubQuery Approach
SELECT name
FROM Customer
WHERE id NOT IN (
    SELECT id
    FROM Customer
    WHERE referee_id = 2
)