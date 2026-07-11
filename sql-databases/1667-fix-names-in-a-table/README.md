# 1667. Fix Names in a Table

## 💡 My Approach
## **Explanation of Functions**

| Function              | Purpose                                         | Example                           |
| --------------------- | ----------------------------------------------- | --------------------------------- |
| `LEFT(str, n)`        | Returns the first `n` characters                | `LEFT('aLice',1)` → `'a'`         |
| `UPPER(str)`          | Converts to uppercase                           | `UPPER('a')` → `'A'`              |
| `SUBSTRING(str, pos)` | Returns substring starting at `pos` (1-indexed) | `SUBSTRING('aLice',2)` → `'Lice'` |
| `LOWER(str)`          | Converts to lowercase                           | `LOWER('Lice')` → `'lice'`        |
| `CONCAT(a,b)`         | Joins strings                                   | `CONCAT('A','lice')` → `'Alice'`  |


## Alternative Solution (using SUBSTR)

SUBSTR() is an alias for SUBSTRING() in MySQL.

```sql
SELECT
    user_id,
    CONCAT(
        UPPER(SUBSTR(name, 1, 1)),
        LOWER(SUBSTR(name, 2))
    ) AS name
FROM Users
ORDER BY user_id;
```

---

_Official problem description unavailable._