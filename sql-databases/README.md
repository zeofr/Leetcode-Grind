# MySQL for LeetCode & Interviews - Complete Notes

## Table of Contents

1. [SELECT Basics](#1-select-basics)
2. [WHERE, ORDER BY, LIMIT](#2-where-order-by-limit)
3. [Aggregate Functions](#3-aggregate-functions)
4. [GROUP BY & HAVING](#4-group-by--having)
5. [JOINs](#5-joins)
6. [NULL Handling](#6-null-handling)
7. [String Functions](#7-string-functions)
8. [Date Functions](#8-date-functions)
9. [CASE WHEN](#9-case-when)
10. [Subqueries](#10-subqueries)
11. [Common Table Expressions (CTEs)](#11-cte)
12. [Window Functions](#12-window-functions)
13. [UNION vs UNION ALL](#13-union)
14. [EXISTS vs IN](#14-exists-vs-in)
15. [Common LeetCode Patterns](#15-common-leetcode-patterns)
16. [SQL Clause Order](#16-sql-clause-order)
17. [SQL Execution Order](#17-sql-execution-order)
18. [Quick Cheat Sheet](#18-quick-cheat-sheet)

---
---------------------------------------------------------------------

# 1. SELECT Basics

``` sql
SELECT column1, column2
FROM table;
```

Aliases:

``` sql
SELECT salary AS employee_salary
FROM Employees;
```

DISTINCT

``` sql
SELECT DISTINCT department
FROM Employees;
```

LIMIT

``` sql
SELECT *
FROM Employees
LIMIT 5;
```

------------------------------------------------------------------------

# 2. WHERE, ORDER BY, LIMIT

Operators

-   =

-   !=

-   \<\>

-   

-   \<

-   =

-   \<=

-   BETWEEN

-   IN

-   LIKE

-   IS NULL

-   IS NOT NULL

Examples

``` sql
WHERE salary > 50000
WHERE age BETWEEN 20 AND 30
WHERE city IN ('Delhi','Mumbai')
WHERE name LIKE 'A%'
WHERE email IS NULL
```

Sorting

``` sql
ORDER BY salary DESC
ORDER BY age ASC
```

------------------------------------------------------------------------

# 3. Aggregate Functions

COUNT()

SUM()

AVG()

MIN()

MAX()

Examples

``` sql
SELECT COUNT(*) FROM Employees;

SELECT AVG(salary)
FROM Employees;
```

------------------------------------------------------------------------

# 4. GROUP BY & HAVING

``` sql
SELECT department,
COUNT(*)
FROM Employees
GROUP BY department;
```

HAVING filters groups.

``` sql
SELECT department,
COUNT(*)
FROM Employees
GROUP BY department
HAVING COUNT(*) > 5;
```

Difference

-   WHERE → before grouping
-   HAVING → after grouping

------------------------------------------------------------------------

# 5. JOINs

## INNER JOIN

Returns only matching rows.

``` sql
SELECT *
FROM A
JOIN B
ON A.id=B.id;
```

## LEFT JOIN

Returns all rows from left table + matching right rows.

``` sql
SELECT *
FROM A
LEFT JOIN B
ON A.id=B.id;
```

Find missing rows

``` sql
SELECT *
FROM A
LEFT JOIN B
ON A.id=B.id
WHERE B.id IS NULL;
```

## RIGHT JOIN

Returns all right rows.

## CROSS JOIN

Every possible combination.

## SELF JOIN

Join a table with itself.

------------------------------------------------------------------------

# 6. NULL Handling

Never compare NULL using =

Wrong

``` sql
WHERE salary=NULL
```

Correct

``` sql
WHERE salary IS NULL
```

Useful

``` sql
IFNULL(column,0)

COALESCE(a,b,c)
```

------------------------------------------------------------------------

# 7. String Functions

Length

``` sql
LENGTH(str)
```

Characters

``` sql
CHAR_LENGTH(str)
```

Upper

``` sql
UPPER(name)
```

Lower

``` sql
LOWER(name)
```

Concat

``` sql
CONCAT(first,last)
```

Substring

``` sql
SUBSTRING(name,2,3)
```

Replace

``` sql
REPLACE(name,'a','x')
```

Trim

``` sql
TRIM(name)
```

Left

``` sql
LEFT(name,3)
```

Right

``` sql
RIGHT(name,3)
```

Position

``` sql
LOCATE('a',name)
```

------------------------------------------------------------------------

# 8. Date Functions

## DATE_ADD()

Adds a time interval to a date.

``` sql
DATE_ADD(date, INTERVAL value unit)
```

Examples:

``` sql
SELECT DATE_ADD('2025-06-15', INTERVAL 1 DAY);
SELECT DATE_ADD('2025-06-15', INTERVAL 2 MONTH);
SELECT DATE_ADD('2025-06-15', INTERVAL 3 YEAR);
```

Common units: - DAY - WEEK - MONTH - YEAR - HOUR - MINUTE - SECOND

------------------------------------------------------------------------

## DATE_SUB()

Subtracts a time interval.

``` sql
DATE_SUB(date, INTERVAL value unit)
```

Example:

``` sql
SELECT DATE_SUB('2025-06-15', INTERVAL 1 DAY);
```

### Why not `date - 1`?

Avoid:

``` sql
recordDate - 1
```

It performs numeric arithmetic on the date representation and fails
across month/year boundaries.

Use:

``` sql
DATE_SUB(recordDate, INTERVAL 1 DAY)
```

------------------------------------------------------------------------

## DATEDIFF()

Returns the difference in days.

``` sql
DATEDIFF(date1, date2)
```

Example:

``` sql
SELECT DATEDIFF('2025-06-15', '2025-06-10');
-- 5
```

------------------------------------------------------------------------

## CURDATE()

Returns today's date.

``` sql
SELECT CURDATE();
```

------------------------------------------------------------------------

## NOW()

Returns current date and time.

``` sql
SELECT NOW();
```

Difference:

  Function    Returns
  ----------- -------------
  CURDATE()   Date only
  NOW()       Date + Time

------------------------------------------------------------------------

## Extract Parts of a Date

``` sql
YEAR(date)
MONTH(date)
DAY(date)
DAYNAME(date)
MONTHNAME(date)
WEEKDAY(date)
```

Examples:

``` sql
SELECT YEAR('2025-06-15');
SELECT MONTH('2025-06-15');
SELECT DAYNAME('2025-06-15');
```

------------------------------------------------------------------------

## LAST_DAY()

Returns the last day of the month.

``` sql
SELECT LAST_DAY('2025-02-10');
```

------------------------------------------------------------------------

## DATE()

Extracts only the date from a DATETIME.

``` sql
SELECT DATE('2025-06-15 12:30:45');
```

------------------------------------------------------------------------

## TIME()

Extracts only the time.

``` sql
SELECT TIME('2025-06-15 12:30:45');
```

------------------------------------------------------------------------

## DATE_FORMAT()

Formats a date.

``` sql
SELECT DATE_FORMAT('2025-06-15', '%d/%m/%Y');
```

Useful specifiers:

  Specifier   Meaning
  ----------- --------------
  %d          Day
  %m          Month
  %Y          4-digit year
  %y          2-digit year
  %M          Month name
  %W          Weekday

------------------------------------------------------------------------

# Common Interview Patterns

### Yesterday

``` sql
DATE_SUB(CURDATE(), INTERVAL 1 DAY)
```

### Tomorrow

``` sql
DATE_ADD(CURDATE(), INTERVAL 1 DAY)
```

### Last 7 Days

``` sql
WHERE order_date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)
```

### Next 30 Days

``` sql
WHERE event_date <= DATE_ADD(CURDATE(), INTERVAL 30 DAY)
```

### Compare with Previous Day

``` sql
SELECT w1.id
FROM Weather w1
JOIN Weather w2
ON DATE_SUB(w1.recordDate, INTERVAL 1 DAY) = w2.recordDate
WHERE w1.temperature > w2.temperature;
```

### Difference Between Dates

``` sql
SELECT DATEDIFF(end_date, start_date);
```

------------------------------------------------------------------------

### Cheat Sheet
```
  Function        Purpose
  --------------- ---------------------
  DATE_ADD()      Add interval
  DATE_SUB()      Subtract interval
  DATEDIFF()      Difference in days
  CURDATE()       Current date
  NOW()           Current date & time
  YEAR()          Extract year
  MONTH()         Extract month
  DAY()           Extract day
  DAYNAME()       Weekday name
  MONTHNAME()     Month name
  LAST_DAY()      Last day of month
  DATE()          Extract date
  TIME()          Extract time
  DATE_FORMAT()   Format dates
```

------------------------------------------------------------------------

# 9. CASE WHEN

``` sql
SELECT
CASE
WHEN salary>100000 THEN 'High'
WHEN salary>50000 THEN 'Medium'
ELSE 'Low'
END
FROM Employees;
```

------------------------------------------------------------------------

# 10. Subqueries

Scalar

``` sql
SELECT *
FROM Employees
WHERE salary>(
SELECT AVG(salary)
FROM Employees);
```

IN

``` sql
WHERE id IN(
SELECT employee_id
FROM Orders)
```

Correlated

``` sql
SELECT *
FROM Employees e
WHERE salary>(
SELECT AVG(salary)
FROM Employees
WHERE department=e.department);
```

------------------------------------------------------------------------

# 11. CTE

``` sql
WITH temp AS
(
SELECT *
FROM Employees
)
SELECT *
FROM temp;
```

Useful for readability.

------------------------------------------------------------------------

# 12. Window Functions

ROW_NUMBER()

``` sql
ROW_NUMBER() OVER(
PARTITION BY department
ORDER BY salary DESC)
```

RANK()

Same rank, gaps.

DENSE_RANK()

Same rank, no gaps.

LAG()

Previous row.

``` sql
LAG(salary)
OVER(ORDER BY salary)
```

LEAD()

Next row.

Running Total

``` sql
SUM(salary)
OVER(
ORDER BY id)
```

------------------------------------------------------------------------

# 13. UNION

UNION removes duplicates.

UNION ALL keeps duplicates.

------------------------------------------------------------------------

# 14. EXISTS vs IN

EXISTS

Stops after first match.

IN

Compares against list.

Generally EXISTS is faster for large correlated queries.

------------------------------------------------------------------------

# 15. Common LeetCode Patterns

Find rows missing

``` sql
LEFT JOIN
...
WHERE right.id IS NULL
```

Highest salary

``` sql
ORDER BY salary DESC
LIMIT 1
```

Nth highest

``` sql
LIMIT 1 OFFSET n-1
```

Duplicate values

``` sql
GROUP BY email
HAVING COUNT(*)>1
```

Compare previous day

``` sql
DATE_SUB(date,INTERVAL 1 DAY)
```

Consecutive rows

Use

LAG()

or self join.

Top salary per department

ROW_NUMBER()

Customers with no orders

LEFT JOIN + IS NULL

------------------------------------------------------------------------

# 16. SQL Clause Order

Logical writing order

SELECT

FROM

JOIN

ON

WHERE

GROUP BY

HAVING

ORDER BY

LIMIT

------------------------------------------------------------------------

# 17. SQL Execution Order

FROM

JOIN

ON

WHERE

GROUP BY

HAVING

SELECT

DISTINCT

ORDER BY

LIMIT

------------------------------------------------------------------------

# 18. Quick Cheat Sheet

JOIN: - INNER -\> matching - LEFT -\> all left - RIGHT -\> all right -
CROSS -\> cartesian

NULL: - IS NULL - IS NOT NULL

Aggregates: COUNT SUM AVG MIN MAX

Windows: ROW_NUMBER RANK DENSE_RANK LAG LEAD

Dates: DATE_ADD DATE_SUB DATEDIFF CURDATE NOW

Strings: LENGTH CHAR_LENGTH CONCAT SUBSTRING REPLACE TRIM UPPER LOWER

Grouping: WHERE before GROUP BY HAVING after GROUP BY

Execution: FROM -\> WHERE -\> GROUP BY -\> HAVING -\> SELECT -\> ORDER
BY -\> LIMIT
