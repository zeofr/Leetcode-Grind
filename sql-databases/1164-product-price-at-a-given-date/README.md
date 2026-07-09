# 1164. Product Price at a Given Date

## 💡 My Approach
## Whenever you hear

- latest before X
- price on date X
- salary on date X
- status on date X

Think

```
Latest row
WHERE date <= target_date
```sql
How do we get the latest row?

For each product:

`MAX(change_date)`

subject to

`change_date <= '2019-08-16'`

The subquery becomes


```sql
SELECT
    product_id,
    MAX(change_date) AS latest_date
FROM Products
WHERE change_date <= '2019-08-16'
GROUP BY product_id;

```
Result:

product	latest_date
1	2019-08-16
2	2019-08-14

**Notice**

Product 3 is missing.

Now join back

```sql
SELECT
    p.product_id,
    p.new_price
FROM Products p
JOIN (

    SELECT
        product_id,
        MAX(change_date) AS latest_date
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
) t
ON p.product_id = t.product_id
AND p.change_date = t.latest_date;

```
Result

product	price
1	35
2	50

**Still missing Product 3.

How do we get Product 3?**

Need every product.

So start from

```sql
SELECT DISTINCT product_id
FROM Products
```

Then LEFT JOIN the latest prices.

If no row exists

`NULL`

replace with

`10`

using

`IFNULL(new_price,10)`

## Complete solution
```sql
SELECT
    p.product_id,
    IFNULL(x.new_price, 10) AS price
FROM
(
    SELECT DISTINCT product_id
    FROM Products
) p
LEFT JOIN
(
    SELECT
        p1.product_id,
        p1.new_price
    FROM Products p1
    JOIN
    (
        SELECT
            product_id,
            MAX(change_date) AS latest_date
        FROM Products
        WHERE change_date <= '2019-08-16'
        GROUP BY product_id
    ) t
    ON p1.product_id = t.product_id
    AND p1.change_date = t.latest_date
) x
ON p.product_id = x.product_id;
```
## Easier solution (Window Function)

If window functions are allowed:

```sql
SELECT
    product_id,
    new_price AS price
FROM
(
    SELECT *,
           ROW_NUMBER() OVER(
               PARTITION BY product_id
               ORDER BY change_date DESC
           ) rn
    FROM Products
    WHERE change_date <= '2019-08-16'
) t
WHERE rn = 1

UNION

SELECT
    product_id,
    10
FROM Products
GROUP BY product_id
HAVING MIN(change_date) > '2019-08-16';
```

---

_Official problem description unavailable._