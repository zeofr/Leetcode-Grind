# Write your MySQL query statement below
SELECT( 
    FROM (
        SELECT *,
            DENSE_RANK() OVER (
                ORDER BY salary DESC
            ) as rnk
        FROM Employee
    ) x
    WHERE rnk = 2
    SELECT salary
) as SecondHighestSalary
