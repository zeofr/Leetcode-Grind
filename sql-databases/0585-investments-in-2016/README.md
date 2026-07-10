# 0585. Investments in 2016

## 💡 My Approach
Each policy must satisfy both conditions:

tiv_2015 appears more than once (duplicate investment in 2015).
(lat, lon) appears exactly once (unique location).

This is a perfect use case for window functions because we want to know how many times a value appears without losing individual rows.

✅ Step 1: Count duplicate tiv_2015
COUNT(*) OVER (PARTITION BY tiv_2015) AS tiv_cnt

Example:

```
pid	tiv_2015	tiv_cnt
1	10	3
3	10	3
4	10	3
2	20	1
```

Meaning:

10 occurs 3 times ✅
20 occurs once ❌
✅ Step 2: Count duplicate locations
COUNT(*) OVER (PARTITION BY lat, lon) AS loc_cnt

Example:

```
pid	lat	lon	loc_cnt
1	10	10	1
2	20	20	2
3	20	20	2
4	40	40	1

```
Meaning:

(10,10) is unique ✅
(20,20) is shared ❌
(40,40) is unique ✅
✅ Step 3: Filter rows
WHERE tiv_cnt > 1
AND loc_cnt = 1

Keep only rows satisfying both conditions.

✅ Step 4: Sum the qualifying investments
ROUND(SUM(tiv_2016), 2)
💡 Why Window Functions?

Using

`COUNT(*) OVER(PARTITION BY ...)`

lets you:

Count duplicates
Keep every original row
Filter later using WHERE

If you used GROUP BY, you'd lose row-level information and wouldn't know which specific tiv_2016 values to sum.

🎯 Pattern Recognition

Whenever a problem asks:

"Value appears more than once"
"Unique value"
"Duplicate records"
"Count occurrences but keep every row"

Think:

COUNT(*) OVER(PARTITION BY column)

instead of

GROUP BY column
⚡ Mental Shortcut
Need duplicate/unique information
        +
Need to keep original rows
                ↓
Use Window Function

COUNT(*) OVER(PARTITION BY ...)

Key takeaway:
GROUP BY collapses rows, whereas COUNT() OVER (PARTITION BY ...) annotates each row with its frequency. This distinction is the central concept tested by this problem.

---

_Official problem description unavailable._