    SUM(amount) OVER (
        ORDER by visited_on
        AND CURRENT ROW
        ROWS BETWEEN 6 PRECEDING
    ) as amount,
    ROUND(
            AVG(amount) OVER (
            ORDER by visited_on
            ROWS BETWEEN 6 PRECEDING
            AND CURRENT ROW
        )
    ,2) as average_amount
FROM Daily
    visited_on,
SELECT 

)
    GROUP BY visited_on
    FROM Customer
LIMIT 100000 OFFSET 6
