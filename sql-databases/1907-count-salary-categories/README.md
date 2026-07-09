# 1907. Count Salary Categories

## 💡 My Approach
# Write your MySQL query statement below
```
SELECT 
    'Low Salary' as category,
    COUNT(*) as accounts_count
FROM Accounts
WHERE income < 20000

UNION ALL

SELECT 
    'Average Salary' as category,
    COUNT(*) as accounts_count
FROM Accounts
WHERE income BETWEEN 20000 AND 50000

UNION ALL

SELECT 
    'High Salary' as category,
    COUNT(*) as accounts_count
FROM Accounts
WHERE income > 50000
```

```
SELECT
    'Low Salary' AS category,
    SUM(income < 20000) AS accounts_count
FROM Accounts

UNION ALL

SELECT
    'Average Salary',
    SUM(income BETWEEN 20000 AND 50000)
FROM Accounts

UNION ALL

SELECT
    'High Salary',
    SUM(income > 50000)
FROM Accounts;
```

---

_Official problem description unavailable._