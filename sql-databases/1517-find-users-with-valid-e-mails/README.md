# 1517. Find Users With Valid E-Mails

## 💡 My Approach
Remove this qn bro it took 5 tries </3.
Remember to use REGEXP_LIKE() for case-sensitive comparisons or bad things will happen to your letcode analytics


Use the case-sensitive regex operator REGEXP_LIKE() with the 'c' match type (MySQL 8):

```
SELECT *
FROM Users
WHERE REGEXP_LIKE(
    mail,
    '^[A-Za-z][A-Za-z0-9_.-]*@leetcode\\.com$',
    'c'
);

```
Here:

```
'c' = case-sensitive
'i' = case-insensitive
```

---

_Official problem description unavailable._