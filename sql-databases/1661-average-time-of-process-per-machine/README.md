# 1661. Average Time of Process per Machine

## 💡 My Approach
```
SELECT
    a1.machine_id,
    ROUND(AVG( a2.timestamp - a1.timestamp),3) as processing_time
FROM Activity a1
JOIN Activity a2
    ON a1.machine_id = a2.machine_id
    AND a1.process_id = a2.process_id
    AND a1.activity_type = 'start'
    AND a2.activity_type = 'end'
GROUP BY machine_id
```

The whole code introduces some extra complexity in JOIN operation by having multiple join condition but it a simple question

---

_Official problem description unavailable._