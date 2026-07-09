# 0619. Biggest Single Number

## 💡 My Approach
Used MAX() to handle cases where all numbers duplicated values.

Query that doesnt work :

```sql
SELECT num
FROM MyNumbers
GROUP BY num
HAVING COUNT(*) = 1
ORDER BY num DESC
LIMIT 1; 
```

Why doesn't LIMIT 1 work?

LIMIT 1 says:

Give me the first row.

If there are no rows, SQL simply returns nothing.

It doesn't invent a row with NULL.

---

_Official problem description unavailable._