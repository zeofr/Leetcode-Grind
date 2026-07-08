# 1211. Queries Quality and Percentage

## 💡 My Approach
Simple enough

Just revise this code :

```sql
SELECT 
    query_name,
    ROUND(AVG(rating/position),2) as quality,
    ROUND(
        AVG(
            CASE
                WHEN rating < 3 THEN 100
                ELSE 0
            END
        )    
    ,2) as poor_query_percentage
FROM Queries
GROUP BY query_name
```

---

_Official problem description unavailable._