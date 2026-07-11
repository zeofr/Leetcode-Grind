# 1327. List the Products Ordered in a Period

## 💡 My Approach
# LeetCode 1327 - List the Products Ordered in a Period

## Concepts Tested

- `JOIN`
- `WHERE`
- `GROUP BY`
- `SUM()`
- `HAVING`
- Date filtering

---

## SQL Execution Order

```text
FROM
→ JOIN
→ WHERE
→ GROUP BY
→ HAVING
→ SELECT
→ ORDER BY
→ LIMIT
```

**Remember:**

- `WHERE` filters **rows** before grouping.
- `HAVING` filters **groups** after aggregation.

---

## Solution

```sql
SELECT
    product_name,
    SUM(unit) AS unit
FROM Products p
JOIN Orders o
ON p.product_id = o.product_id
WHERE order_date BETWEEN '2020-02-01' AND '2020-02-29'
GROUP BY p.product_id, product_name
HAVING SUM(unit) >= 100;
```

---

## Why Each Clause?

### JOIN

Combine product information with order details.

```sql
JOIN Orders o
ON p.product_id = o.product_id
```

---

### WHERE

Keep only orders placed in **February 2020**.

```sql
WHERE order_date BETWEEN '2020-02-01' AND '2020-02-29'
```

> Always write dates inside **single quotes**.

---

### GROUP BY

Create one group for each product.

```sql
GROUP BY p.product_id, product_name
```

---

### SUM()

Find total units sold in February.

```sql
SUM(unit)
```

---

### HAVING

Keep only products with **at least 100 units** sold.

```sql
HAVING SUM(unit) >= 100
```

Use `>=` because the question says **"at least 100"**.

---

## Common Mistakes

❌ Wrong clause order

```sql
GROUP BY
HAVING
WHERE
```

✅ Correct order

```sql
WHERE
GROUP BY
HAVING
```

---

❌ Unquoted dates

```sql
BETWEEN 2020-02-01 AND 2020-02-29
```

✅ Correct

```sql
BETWEEN '2020-02-01' AND '2020-02-29'
```

---

❌ Using `>` instead of `>=`

```sql
HAVING SUM(unit) > 100
```

This excludes products with exactly **100** units.

Use

```sql
HAVING SUM(unit) >= 100
```

---

## Interview Takeaways

- Use **WHERE** to filter rows **before** aggregation.
- Use **HAVING** to filter aggregated results.
- Aggregate functions like `SUM()`, `COUNT()`, and `AVG()` belong in `HAVING`, not `WHERE`.
- Always quote date literals (`'YYYY-MM-DD'`).
- When selecting non-aggregated columns, include them in the `GROUP BY` (or group by the primary key if functionally dependent).

---

_Official problem description unavailable._