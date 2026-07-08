# 1251. Average Selling Price

## 💡 My Approach
**Main Concepts** : Weighted Average Pattern, `IFNULL(main_calculation, value_when_null)`, `BETWEEN`

Whenever different values contribute unequally, use a weighted average.

Formula:

```
Weighted Average =
Σ(value × weight)
-----------------
Σ(weight)

```

In this problem:

Value = price
Weight = units

So:

SUM(price * units)
/
SUM(units)


SQL Pattern
```
SELECT
    id,
    SUM(value * weight) / SUM(weight)
FROM table
GROUP BY id;
```

In case when a date has to follow in a range, instead of using :

```sql
u.purchase_date <= p.end_date
AND
u.purchase_date >= p.start_date
```

Use this :
```sql
u.purchase_date BETWEEN p.start_date AND p.end_date
```

---

_Official problem description unavailable._