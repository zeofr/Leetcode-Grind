# Write your MySQL query statement below
SELECT( 
    SELECT salary
    FROM (
        SELECT DISTINCT salary,
            DENSE_RANK() OVER (
                ORDER BY salary DESC
            ) as rnk
        FROM Employee
    ) x
    WHERE rnk = 2
) as SecondHighestSalary
