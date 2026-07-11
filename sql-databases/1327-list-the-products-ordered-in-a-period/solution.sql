# Write your MySQL query statement below
SELECT 
    product_name,
    SUM(unit) as unit
FROM Products p
JOIN Orders o
    ON p.product_id = o.product_id
GROUP BY o.product_id
    HAVING SUM(unit) >= 100
WHERE order_date BETWEEN '2020-02-01' AND '2020-02-29'

