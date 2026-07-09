    (
            CASE
                WHEN 
                    id % 2 = 1 
                    AND id <> ( SELECT MAX(id) FROM Seat )
                THEN id + 1
                WHEN id % 2 = 0
                THEN id - 1
                ELSE id 
    FROM
        SELECT
            END as id,
            student
        FROM Seat
    ) x
ORDER BY id
    student
    id,
SELECT
# Write your MySQL query statement below
