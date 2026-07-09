# 0550. Game Play Analysis IV

## 💡 My Approach
# IMPORTANT QUESTION 

Okay I made some mistakes earlier by thinking this question was referring to players who had 2 consecutive logins but then re-read it.

Question Flow : 
- Get the table of players along with their first login
- Perform JOIN on it with the base Activity to see if player logged In the other day after first login

```sql
SELECT 
    ROUND(
        COUNT(*) / ( SELECT COUNT(DISTINCT(player_id)) FROM Activity )
    ,2) as fraction
FROM (
    SELECT 
        player_id,
        MIN(event_date) as event_date
    FROM Activity
    GROUP BY player_id
) a1
JOIN Activity a2
    ON DATE_ADD(a1.event_date, INTERVAL 1 DAY) = a2.event_date
    AND a1.player_id = a2.player_id

```


---

_Official problem description unavailable._