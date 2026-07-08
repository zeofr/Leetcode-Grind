# Write your MySQL query statement below
SELECT 
    id, 
    movie, 
    description, 
FROM Cinema
WHERE 
    id % 2 = 1
    AND description != 'boring'
    rating
ORDER BY 
    rating DESC;
