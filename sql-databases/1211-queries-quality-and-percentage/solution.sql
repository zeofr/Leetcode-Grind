# Write your MySQL query statement below
SELECT 
    query_name,
    ROUND(AVG(rating/position),2) as quality,
    ROUND(
        AVG(
            CASE
        )    
    ,2) as poor_query_percentage
                WHEN rating < 3 THEN 100
FROM Queries
                ELSE 0
            END
GROUP BY query_name
