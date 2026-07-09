# 0626. Exchange Seats

## 💡 My Approach
**One important thing to note. This question already had a column named id and i declared another one in select. In this case the ORDER BY clause will prioritize the one mentioned in select clause. **

Alternative Solution :
```sql
SELECT
    CASE
        WHEN id % 2 = 1
             AND id <> (SELECT MAX(id) FROM Seat)
        THEN id + 1

        WHEN id % 2 = 0
        THEN id - 1

        ELSE id
    END AS id,
    student
FROM Seat
ORDER BY id;
```

This is more concise.

When I look at this problem, I immediately recognize it as a Value Transformation problem.

There are two broad categories:

1. Row Selection Problems

Examples:

First order
Latest price
Highest salary

These require GROUP BY, joins, or window functions.

2. Value Transformation Problems 

Examples:

- Swap IDs
- Change grades
- Replace values
- Convert categories

These usually require:

- CASE
- IF()
- Arithmetic (+1, -1)
- % (modulo)

---

_Official problem description unavailable._