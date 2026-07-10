# 0185. Department Top Three Salaries

## 💡 My Approach
## 📝 Revision Note — Understanding `DENSE_RANK()`

### 🔑 Core Idea

`DENSE_RANK()` **does not rank a column**.

It **ranks rows** based on the order specified in the `OVER(ORDER BY ...)` clause.

❌ Incorrect

```sql
DENSE_RANK(salary)
```

✅ Correct

```sql
DENSE_RANK() OVER (
    ORDER BY salary DESC
)
```

---

## How `DENSE_RANK()` Works

### Step 1: Sort the rows

```sql
ORDER BY salary DESC
```

Example:

| Employee | Salary |
| -------- | ------ |
| Alice    | 9000   |
| Bob      | 9000   |
| Carol    | 8000   |
| David    | 7000   |
| Eve      | 7000   |

---

### Step 2: Walk through the sorted rows

* First row → Rank = 1
* Same ORDER BY value → Same rank
* Different ORDER BY value → Rank + 1

Result:

| Salary | Dense Rank |
| ------ | ---------- |
| 9000   | 1          |
| 9000   | 1          |
| 8000   | 2          |
| 7000   | 3          |
| 7000   | 3          |

Notice:

* Equal values share the same rank.
* No ranks are skipped.

---

## What Determines the Rank?

Not the function itself.

The **`ORDER BY` inside `OVER()`** determines the ranking.

```sql
DENSE_RANK() OVER (
    ORDER BY salary DESC
)
```

Change the ordering:

```sql
DENSE_RANK() OVER (
    ORDER BY age ASC
)
```

Now rows are ranked by age instead of salary.

---

## `PARTITION BY`

`PARTITION BY` resets the ranking for each group.

```sql
DENSE_RANK() OVER (
    PARTITION BY departmentId
    ORDER BY salary DESC
)
```

SQL performs:

```
Department A
-------------
9000 → Rank 1
8000 → Rank 2
7000 → Rank 3

Department B
-------------
10000 → Rank 1
9500  → Rank 2
```

Each department gets its own ranking.

---

## Comparison of Ranking Functions

Given:

| Salary |
| ------ |
| 9000   |
| 9000   |
| 8000   |
| 7000   |

| Salary | ROW_NUMBER | RANK | DENSE_RANK |
| ------ | ---------: | ---: | ---------: |
| 9000   |          1 |    1 |          1 |
| 9000   |          2 |    1 |          1 |
| 8000   |          3 |    3 |          2 |
| 7000   |          4 |    4 |          3 |

### Use Cases

* `ROW_NUMBER()` → Every row gets a unique number.
* `RANK()` → Competition ranking (1,1,3,4).
* `DENSE_RANK()` → Consecutive ranking (1,1,2,3).

---

## Aggregate Functions vs Ranking Functions

Aggregate functions operate on **values**.

```sql
SUM(salary)
AVG(salary)
MAX(salary)
```

Ranking functions operate on **ordered rows**.

```sql
ROW_NUMBER() OVER(...)
RANK() OVER(...)
DENSE_RANK() OVER(...)
```

That's why ranking functions **take no arguments**.

---

## Mental Model

Imagine SQL doing:

```
Sort the rows
      ↓
Start Rank = 1
      ↓
Same ORDER BY value?
      ↓
Yes → Keep same rank
No  → Increase rank
```

---

## 🎯 Pattern Recognition

Whenever a problem asks:

* Top K salaries
* Highest N scores
* Ranking within each group
* Top N per category

Think:

```sql
<Ranking Function>() OVER (
    PARTITION BY group_column
    ORDER BY value DESC
)
```

Then filter:

```sql
WHERE rank <= K
```

---

### ⭐ One-Line Memory Trick

> **Aggregate functions work on columns (`SUM(salary)`), while ranking functions work on ordered rows (`DENSE_RANK() OVER (ORDER BY salary)`).**


---

_Official problem description unavailable._