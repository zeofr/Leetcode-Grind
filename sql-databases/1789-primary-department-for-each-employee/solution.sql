SELECT
    employee_id,
    department_id
FROM (
    SELECT *,
           COUNT(*) OVER (PARTITION BY employee_id) AS cnt
) t
WHERE primary_flag = 'Y'
   OR cnt = 1;
    FROM Employee
