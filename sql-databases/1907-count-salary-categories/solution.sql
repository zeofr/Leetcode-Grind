    'Low Salary' as category,
    COUNT(*) as accounts_count
FROM Accounts
WHERE income < 20000

UNION ALL

SELECT 
    'Average Salary' as category,
    COUNT(*) as accounts_count
FROM Accounts
WHERE income BETWEEN 20000 AND 50000

UNION ALL

SELECT 
    'High Salary' as category,
    COUNT(*) as accounts_count
SELECT 
# Write your MySQL query statement below
