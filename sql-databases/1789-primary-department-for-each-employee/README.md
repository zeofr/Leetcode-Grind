# 1789. Primary Department for Each Employee

## 💡 My Approach
(Important)
Code Used : 

```sql
SELECT
    employee_id,
    department_id
FROM (
    SELECT *,
           COUNT(*) OVER (PARTITION BY employee_id) AS cnt
    FROM Employee
) t
WHERE primary_flag = 'Y'
   OR cnt = 1;
```

A more simple code would be : 
```sql
SELECT
    employee_id,
    department_id
FROM Employee
WHERE primary_flag = 'Y'
   OR employee_id IN (
        SELECT employee_id
        FROM Employee
        GROUP BY employee_id
        HAVING COUNT(*) = 1
   );
```

`WHERE` vs `HAVING`

This problem is a great reminder of the difference.

Use `WHERE` when filtering rows before grouping:

`WHERE primary_flag = 'Y'`

Use `HAVING` when filtering groups after aggregation:

```
GROUP BY employee_id
HAVING COUNT(*) = 1
Memory Trick
WHERE → individual rows
HAVING → grouped rows (aggregates like COUNT, SUM, AVG)

```
If your condition doesn't use an aggregate function (COUNT, SUM, AVG, etc.), it usually belongs in WHERE, not HAVING.

---

_Official problem description unavailable._