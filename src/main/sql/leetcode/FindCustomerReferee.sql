-- https://leetcode.com/problems/find-customer-referee/

-- Basic Approach
SELECT name
FROM Customer
WHERE IFNULL(referee_id, 0) != 2
-- -- IF the Bonus is NULL, it's "converted" to 0 than the competition part is done

