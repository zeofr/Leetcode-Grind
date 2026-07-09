        p1.product_id,
        p1.new_price
    FROM Products p1
    JOIN
    (
        SELECT
            product_id,
            MAX(change_date) AS latest_date
        FROM Products
        WHERE change_date <= '2019-08-16'
        GROUP BY product_id
    ) t
    ON p1.product_id = t.product_id
    AND p1.change_date = t.latest_date
) x
ON p.product_id = x.product_id;
