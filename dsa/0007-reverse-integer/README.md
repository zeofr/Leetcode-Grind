# 0007. Reverse Integer

## 💡 My Approach
# LeetCode 7 - Reverse Integer

## Problem
Given a signed 32-bit integer `x`, reverse its digits.

If the reversed integer overflows the range:

```text
[-2^31, 2^31 - 1]
```

return `0`.

---

## Key Idea

Build the reversed number one digit at a time.

Example:

```text
x = 123

rev = 0

digit = 3 → rev = 3
digit = 2 → rev = 32
digit = 1 → rev = 321
```

---

## Algorithm

1. Extract the last digit using `% 10`.
2. Remove the last digit using `/ 10`.
3. Check if adding the digit will overflow.
4. Append the digit.
5. Repeat until `x == 0`.

---

## Important Operations

### Get last digit

```java
int digit = x % 10;
```

Examples:

```text
123 % 10 = 3
-123 % 10 = -3
```

---

### Remove last digit

```java
x /= 10;
```

Examples:

```text
123 → 12
12 → 1
1 → 0

-123 → -12
```

---

### Build reversed number

```java
rev = rev * 10 + digit;
```

Example:

```text
rev = 32
digit = 1

rev = 32 * 10 + 1
    = 321
```

---

## Overflow Check

### Maximum Integer

```text
Integer.MAX_VALUE = 2147483647
```

Before appending the next digit:

```java
if (rev > Integer.MAX_VALUE / 10 ||
    (rev == Integer.MAX_VALUE / 10 && digit > 7))
    return 0;
```

Reason:

```text
2147483647 ✓
2147483648 ✗
```

Only digits `0-7` are safe when:

```text
rev = 214748364
```

---

### Minimum Integer

```text
Integer.MIN_VALUE = -2147483648
```

Check:

```java
if (rev < Integer.MIN_VALUE / 10 ||
    (rev == Integer.MIN_VALUE / 10 && digit < -8))
    return 0;
```

Reason:

```text
-2147483648 ✓
-2147483649 ✗
```

Only digits `0` to `-8` are safe when:

```text
rev = -214748364
```

---

## Why Not Convert Negative to Positive?

Avoid:

```java
x = -x;
```

Fails for:

```text
x = Integer.MIN_VALUE
```

because

```text
-(-2147483648)
=
2147483648
```

which is outside the `int` range, causing overflow.

Instead, process negative numbers directly.

---

## Java Solution

```java
class Solution {
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (rev > Integer.MAX_VALUE / 10 ||
                (rev == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;

            if (rev < Integer.MIN_VALUE / 10 ||
                (rev == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;

            rev = rev * 10 + digit;
        }

        return rev;
    }
}
```

---

## Complexity

- **Time:** `O(log₁₀ n)`
- **Space:** `O(1)`

---

## Key Takeaways

- Use `% 10` to extract the last digit.
- Use `/ 10` to remove the last digit.
- Check for overflow **before** `rev = rev * 10 + digit`.
- Never convert negative numbers to positive (`Integer.MIN_VALUE` edge case).
- Works for both positive and negative integers without extra logic.

---

_Official problem description unavailable._