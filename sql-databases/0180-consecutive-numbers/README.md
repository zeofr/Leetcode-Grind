# 0180. Consecutive Numbers

## 💡 My Approach
Use double JOIN on the the table to connect rows with 3 consecutive values 
```sql
SELECT DISTINCT l1.num as ConsecutiveNums
FROM Logs l1
    JOIN Logs l2 ON l1.id + 1 = l2.id
    JOIN Logs l3 ON l1.id + 2= l3.id
WHERE
    l1.num = l2.num
    AND l2.num = l3.num;
```

---

_Official problem description unavailable._