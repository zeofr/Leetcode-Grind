# Write your MySQL query statement below
SELECT
    ROUND(
        AVG(
            CASE
                WHEN order_date = customer_pref_delivery_date THEN 100
                ELSE 0
            END
        ),
    2) AS immediate_percentage
FROM Delivery d
WHERE order_date = (
    SELECT MIN(order_date)
    FROM Delivery
    WHERE customer_id = d.customer_id
);
# filter first orders of each customer -> calculate % of immediate first orders
