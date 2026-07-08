# 0570. Managers with at Least 5 Direct Reports

## 💡 My Approach
Main Concept : `GROUP BY` , `HAVING`

alternate solution : 

```sql
SELECT name
FROM Employee
WHERE id IN (
    SELECT managerId
    FROM Employee
    GROUP BY managerId
    HAVING COUNT(*) >= 5
);
```

---

_Official problem description unavailable._