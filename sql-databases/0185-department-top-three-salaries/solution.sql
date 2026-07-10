# Write your MySQL query statement below
SELECT 
    d.name as Department,
    x.name as Employee,
    x.salary
FROM (
    SELECT
        *,
        DENSE_RANK() OVER (
    FROM Employee
) x
JOIN Department d
    ON x.departmentId = d.id
            partition by departmentId 
            ORDER BY salary DESC) as rnk
WHERE rnk <= 3
