# 1934. Confirmation Rate

## 💡 My Approach
Whenever a problem asks for the percentage, rate, or ratio of rows satisfying a condition, think:

```
AVG(
    CASE
        WHEN condition THEN 1
        ELSE 0
    END
)

```

Examples:

- Confirmation rate
- Pass rate
- Delivery success rate
- Win percentage
- Attendance percentage

This pattern shows up repeatedly in SQL interviews and LeetCode. Once you recognize it, many "percentage" problems become one-liners inside an AVG()

---

_Official problem description unavailable._