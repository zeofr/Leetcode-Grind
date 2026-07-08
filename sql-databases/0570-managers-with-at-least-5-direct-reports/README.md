# 0570. Managers with at Least 5 Direct Reports

## 💡 My Approach
Main Concepts : `GROUP BY`, `HAVING`

Alternate solution : 

```sql
SELECT name
FROM Employee
WHERE id IN (
    SELECT managerId
    FROM Employee
    WHERE managerId IS NOT NULL
    GROUP BY managerId
    HAVING COUNT(*) >= 5
);
```

---

_Official problem description unavailable._