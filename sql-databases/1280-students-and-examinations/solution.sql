    stu.student_name,
    sub.subject_name,
    COUNT(e.subject_name) as attended_exams
FROM Students stu
LEFT JOIN Examinations e
    ON stu.student_id = e.student_id
CROSS JOIN Subjects sub
    AND sub.subject_name = e.subject_name
GROUP BY
    stu.student_id,
    stu.student_name,
    sub.subject_name
ORDER BY
    stu.student_id ASC,
    stu.student_name ASC,
    sub.subject_name ASC
    stu.student_id,
SELECT 
