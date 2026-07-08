# 1280. Students and Examinations

## 💡 My Approach
Main Concept : `CROSS JOIN`

The question itself is very direct but you need a good understanding of how each clause works like for example the difference b/w `COUNT(*)` , `COUNT(e.subject_name)` and `COUNT(sub.subject_name)`

```sql
SELECT 
    stu.student_id,
    stu.student_name,
    sub.subject_name,
    COUNT(e.subject_name) as attended_exams
FROM Students stu
CROSS JOIN Subjects sub
LEFT JOIN Examinations e
    ON stu.student_id = e.student_id
    AND sub.subject_name = e.subject_name
GROUP BY
    stu.student_id,
    stu.student_name,
    sub.subject_name
ORDER BY
    stu.student_id ASC,
    stu.student_name ASC,
    sub.subject_name ASC
```



---

_Official problem description unavailable._