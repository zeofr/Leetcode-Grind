# 1174. Immediate Food Delivery II

## 💡 My Approach
Using a subquery to handle MIN() executions for such related cases 

```sql
SELECT
    ROUND(
        AVG(
            CASE
                WHEN order_date = customer_pref_delivery_date THEN 100
                ELSE 0
            END
        ),
    2) AS immediate_percentage
FROM Delivery d
WHERE order_date = (
    SELECT MIN(order_date)
    FROM Delivery
    WHERE customer_id = d.customer_id
);
```

A better solution using Window functions : 

```sql
WITH FirstOrders AS (
    SELECT *,
           ROW_NUMBER() OVER (
               PARTITION BY customer_id
               ORDER BY order_date
           ) AS rn
    FROM Delivery
)
SELECT
    ROUND(
        AVG(
            CASE
                WHEN order_date = customer_pref_delivery_date THEN 100
                ELSE 0
            END
        ),
        2
    ) AS immediate_percentage
FROM FirstOrders
WHERE rn = 1;
```

---

_Official problem description unavailable._