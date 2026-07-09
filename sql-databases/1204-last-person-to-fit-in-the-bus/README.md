# 1204. Last Person to Fit in the Bus

## 💡 My Approach
Whenever you see:

```
Running total
Cumulative sum
Prefix sum
Balance after each transaction
```

Think:

```
SUM(column)
OVER(
    ORDER BY ...
)
```

This is a window function.

Running Total

For the example

```
Turn	Name	Weight
1	Alice	250
2	Alex	350
3	John	400
4	Marie	200
```

Running sum becomes

```
Turn	Name	Running Weight
1	Alice	250
2	Alex	600
3	John	1000
4	Marie	1200
```

Now simply keep

`running_weight <= 1000`

The last remaining row is the answer.

---

_Official problem description unavailable._