# 0196. Delete Duplicate Emails

## 💡 My Approach
DELETE Patterns You Should Know

Delete duplicates

```
DELETE p1
FROM Person p1
JOIN Person p2
ON p1.email = p2.email
AND p1.id > p2.id;
```

Delete using WHERE

```
DELETE
FROM Employees
WHERE salary < 5000
```
Delete using EXISTS

```
DELETE
FROM Employees e
WHERE EXISTS
(
SELECT *
FROM FiredEmployees f
WHERE e.id = f.id
);
```

Delete using IN

```
DELETE
FROM Employees
WHERE department_id IN
(
SELECT id
FROM ClosedDepartments
);
```

---

_Official problem description unavailable._