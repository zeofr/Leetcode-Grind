    contest_id,
    ROUND(
        COUNT(user_id) * 100 /
        (
            SELECT COUNT(*)
            FROM Users
GROUP BY contest_id
ORDER BY percentage DESC, contest_id ASC;
SELECT
        ),
FROM Register
    2) AS percentage
