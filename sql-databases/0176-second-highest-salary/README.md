# 0176. Second Highest Salary

## 💡 My Approach
for handling cases where there is no second highest salary we can use two ways :


Scalar Subquery : 

```sql
SELECT (
    SELECT salary
    FROM (
        SELECT salary,
               DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
        FROM Employee
    ) x
    WHERE rnk = 2
) AS SecondHighestSalary;
```

the classic solution : 

```sql
SELECT
(
    SELECT DISTINCT salary
    FROM Employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary;
```

---

_Official problem description unavailable._