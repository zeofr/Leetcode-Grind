# 1527. Patients With a Condition

## 💡 My Approach
Both of these do the same thing


```sql 
SELECT patient_id, patient_name, conditions
FROM Patients
WHERE conditions REGEXP '(^| )DIAB1';
```

```sql
SELECT patient_id, patient_name, conditions
FROM Patients
WHERE conditions LIKE 'DIAB1%'
   OR conditions LIKE '% DIAB1%';
```

---

_Official problem description unavailable._