# 1321. Restaurant Growth

## 💡 My Approach
## Moving Average / Rolling Window Pattern

**Step 1: Aggregate to the required granularity (daily, monthly, etc.).**

```
SELECT
    visited_on,
    SUM(amount) AS amount
FROM Customer
GROUP BY visited_on;

```
**Step 2: Apply a window function.**

```
SUM(amount) OVER(
    ORDER BY visited_on
    ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
)
```

6 PRECEDING → previous 6 rows.
CURRENT ROW → include today's row.
Total window size = 7 rows.

Similarly,

`AVG(amount) OVER(...)`

computes the moving average directly.

Mental connection: This is the SQL equivalent of the Sliding Window technique in DSA. Instead of maintaining a running sum manually, the database engine maintains the window for you.

**Why 100000?**

It could have been:

`LIMIT 999999`

or

`LIMIT 1000000000`

It doesn't matter as long as it's larger than the maximum possible remaining rows.

It's just a convenient "very large number."

---

_Official problem description unavailable._