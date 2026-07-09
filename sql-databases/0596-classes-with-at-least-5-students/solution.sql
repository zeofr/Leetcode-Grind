SELECT class 
FROM Courses c
GROUP BY class
HAVING COUNT(*) > 4;
