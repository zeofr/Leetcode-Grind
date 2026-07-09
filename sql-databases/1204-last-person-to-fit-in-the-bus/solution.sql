# Write your MySQL query statement below
SELECT person_name
FROM (
    SELECT 
        person_name,
        SUM(weight) 
) x
WHERE total_weight <= 1000
ORDER BY turn DESC
        turn,
            OVER (ORDER BY turn) as total_weight
    FROM Queue
LIMIT 1
