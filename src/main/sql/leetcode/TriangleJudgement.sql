-- https://leetcode.com/problems/triangle-judgement/

-- The rule for Triangle line is: we need to check if the sum of any two sides is greater than the third side. If this condition holds true for all three combinations of sides, then we can say that a triangle can be formed
SELECT *, IF(x+y>z AND y+z>x AND z+x>y, "Yes", "No") as Triangle
FROM Triangle

/** Schema

*/

    ---------

/** I/O
    Input:

*/