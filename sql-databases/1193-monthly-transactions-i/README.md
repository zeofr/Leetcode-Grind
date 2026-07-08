# 1193. Monthly Transactions I

## 💡 My Approach
### **Main Concepts**

* **`DATE_FORMAT()`** → Groups transactions by **Year-Month** (`YYYY-MM`).
* **`GROUP BY`** → Creates one row per **month + country**.
* **`COUNT(*)`** → Counts total transactions.
* **`SUM(CASE WHEN ...)`** → Performs **conditional aggregation** to count or sum only rows satisfying a condition.

---

### **Patterns to Remember**

#### 1. Group by Month

```sql
DATE_FORMAT(trans_date, '%Y-%m')
```

Example:

```
2024-01-15 → 2024-01
2024-01-30 → 2024-01
```

Both belong to the same group.

---

#### 2. Conditional Count

```sql
SUM(
    CASE
        WHEN condition THEN 1
        ELSE 0
    END
)
```

Counts only rows matching the condition.

Example:

```sql
SUM(
    CASE
        WHEN state = 'approved' THEN 1
        ELSE 0
    END
)
```

= Number of approved transactions.

---

#### 3. Conditional Sum

```sql
SUM(
    CASE
        WHEN condition THEN value
        ELSE 0
    END
)
```

Sums only the values satisfying the condition.

Example:

```sql
SUM(
    CASE
        WHEN state = 'approved' THEN amount
        ELSE 0
    END
)
```

= Total approved transaction amount.

---

### **General Template**

```sql
SELECT
    grouping_columns,
    COUNT(*) AS total_rows,
    SUM(CASE WHEN condition THEN 1 ELSE 0 END) AS conditional_count,
    SUM(value) AS total_value,
    SUM(CASE WHEN condition THEN value ELSE 0 END) AS conditional_value
FROM table
GROUP BY grouping_columns;
```

---

### **LeetCode Pattern Recognition**

Whenever a problem asks for:

* Monthly reports
* Approved/Rejected counts
* Success/Failure counts
* Revenue from completed orders
* Sales from delivered products
* Statistics by category/month/country

Think of this pattern:

```sql
GROUP BY ...
COUNT(*)
SUM(CASE WHEN ... THEN 1 ELSE 0 END)
SUM(value)
SUM(CASE WHEN ... THEN value ELSE 0 END)
```

---

_Official problem description unavailable._