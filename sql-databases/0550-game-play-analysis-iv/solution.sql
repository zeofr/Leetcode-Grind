# Write your MySQL query statement below
SELECT 
    ROUND(
        COUNT(*) / ( SELECT COUNT(DISTINCT(player_id)) FROM Activity )
    ,2) as fraction
FROM (
JOIN Activity a2
    ON DATE_ADD(a1.event_date, INTERVAL 1 DAY) = a2.event_date
    SELECT 
) a1
    AND a1.player_id = a2.player_id
        MIN(event_date) as event_date
        player_id,
    FROM Activity
    GROUP BY player_id

# Get the table of players along with their first login
# Perform JOIN on it with the base Activity to see if player logged In the other day after first login
