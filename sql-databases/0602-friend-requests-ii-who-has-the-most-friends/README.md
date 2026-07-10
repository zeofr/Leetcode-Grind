# 0602. Friend Requests II: Who Has the Most Friends

## 💡 My Approach
ngl I am very Big brain for this one.

Instead of counting requesters and accepters separately:

```
requester_id
accepter_id

```

Flatten them into a single column:

```
SELECT requester_id AS id
FROM RequestAccepted

UNION ALL

SELECT accepter_id AS id
FROM RequestAccepted

```
Now every friendship is represented as:

```
id
--
1
2
1
3
2
3
...
```

Then simply count:

```
GROUP BY id
COUNT(*)
```
## Why UNION ALL?

Use UNION ALL, not UNION.

UNION removes duplicates.

UNION ALL keeps every friendship occurrence, which is exactly what we need.

## Ranking Needed?

No.

Since the problem guarantees only one answer:

```
ORDER BY num DESC
LIMIT 1
```

---

_Official problem description unavailable._