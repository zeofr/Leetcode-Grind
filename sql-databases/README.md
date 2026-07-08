# MySQL Date Functions Cheat Sheet

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

# Cheat Sheet
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
