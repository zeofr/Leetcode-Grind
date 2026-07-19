# 0860. Lemonade Change

## 💡 My Approach
```
five = 0
ten = 0

For each bill

    if bill == 5
        five++

    else if bill == 10

        if five == 0
            return false

        five--
        ten++

    else

        if ten > 0 && five > 0

            ten--
            five--

        else if five >= 3

            five -= 3

        else

            return false

return true
```

---

_Official problem description unavailable._