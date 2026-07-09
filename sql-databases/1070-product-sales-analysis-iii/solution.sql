SELECT
    product_id,
    `year` as first_year,
    quantity,
    price
FROM (
    SELECT
        product_id,
        year,
        (
            rank() OVER( partition by product_id Order by year )
        ) as rnk,
        quantity,
        price
    FROM Sales
) t
where rnk = 1;
