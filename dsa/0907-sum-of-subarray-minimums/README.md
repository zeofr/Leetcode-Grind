# 0907. Sum of Subarray Minimums

## 💡 My Approach
Brute Force :
```java
class Solution {
    public int sumSubarrayMins(int[] arr) {
        if(arr.length == 1) return arr[0];
        if(arr.length == 0) return 0;

        int sum = 0;

        for(int l = 0; l < arr.length ; l++){
            int min = Integer.MAX_VALUE;
            for(int r = l ; r < arr.length; r++){
                min = Math.min(min, arr[r]);
                sum = (sum + min) % 1000000007;
            }
        }
        return sum;
    }
}
```
# 907. Sum of Subarray Minimums (Medium)

## Problem

Given an integer array `arr`, return the **sum of the minimum element of every contiguous subarray**.

Since the answer can be very large, return it modulo **10⁹ + 7**.

---

## Example

```text
Input:
arr = [3,1,2,4]

Subarrays

[3]
[1]
[2]
[4]
[3,1]
[1,2]
[2,4]
[3,1,2]
[1,2,4]
[3,1,2,4]

Minimums

3
1
2
4
1
1
2
1
1
1

Sum = 17
```

---

# Brute Force Approach

Generate every subarray and keep track of its minimum.

```java
for(int l = 0; l < n; l++) {
    int min = Integer.MAX_VALUE;

    for(int r = l; r < n; r++) {
        min = Math.min(min, arr[r]);
        answer += min;
    }
}
```

### Time Complexity

```text
O(n²)
```

Although the minimum is maintained efficiently, there are still **O(n²)** subarrays.

For

```text
n = 30000
```

This results in nearly

```text
9 × 10⁸
```

operations and causes **TLE**.

---

# Key Insight

Instead of asking

> **What is the minimum of every subarray?**

Ask

> **For each element, in how many subarrays is it the minimum?**

This completely changes the solution.

---

# Contribution Technique

Every element contributes to the final answer.

Contribution of an element

```text
Element Value
×

Number of subarrays where it is the minimum
```

---

## Example

```text
arr

3 1 2 4
```

### Element = 3

Minimum in

```text
[3]
```

Contribution

```text
3 × 1 = 3
```

---

### Element = 1

Minimum in

```text
[1]

[3,1]

[1,2]

[1,2,4]

[3,1,2]

[3,1,2,4]
```

Count

```text
6
```

Contribution

```text
1 × 6 = 6
```

---

### Element = 2

Minimum in

```text
[2]

[2,4]
```

Contribution

```text
2 × 2 = 4
```

---

### Element = 4

Minimum in

```text
[4]
```

Contribution

```text
4 × 1 = 4
```

---

Total

```text
3 + 6 + 4 + 4 = 17
```

---

# Counting Contributions

Suppose

```text
5 4 2 6 8
    ^
```

Current element

```text
2
```

How many subarrays can use `2` as their minimum?

We need to know

- How far can it extend to the left?
- How far can it extend to the right?

without encountering a smaller element.

---

# Previous Smaller Element (PSE)

Find the nearest element on the left that is **strictly smaller**.

Example

```text
5 4 2 6 8
    ^
```

There is no smaller element.

Previous Smaller Index

```text
-1
```

Left choices

```text
i - prev

=

2 - (-1)

=

3
```

Possible left boundaries

```text
[2]

[4,2]

[5,4,2]
```

---

# Next Smaller Element (NSE)

Find the nearest element on the right that is

**smaller or equal**.

Example

```text
5 4 2 6 8
    ^
```

No smaller element.

Next Smaller Index

```text
5
```

Right choices

```text
next - i

=

5 - 2

=

3
```

Possible right boundaries

```text
[2]

[2,6]

[2,6,8]
```

---

# Total Subarrays

Every left choice can combine with every right choice.

```text
Left Choices × Right Choices

=

3 × 3

=

9
```

Therefore

```text
Contribution

=

2 × 9
```

---

# General Formula

For every index

```text
left = i - prev[i]

right = next[i] - i
```

Contribution

```text
arr[i]

×

left

×

right
```

Answer

```text
Σ(arr[i] × left × right)
```

---

# Why Multiplication?

Example

```text
5 4 2 6 8
    ^
```

Left choices

```text
[2]

[4,2]

[5,4,2]
```

Three choices.

---

Right choices

```text
[2]

[2,6]

[2,6,8]
```

Three choices.

Every left choice can combine with every right choice.

```text
3 × 3 = 9
```

possible subarrays.

---

# Finding Previous Smaller

Use a **Monotonic Increasing Stack**.

Traverse

```text
Left → Right
```

While

```java
arr[stack.peek()] > arr[i]
```

pop.

The remaining top is the previous smaller element.

---

Example

```text
arr

3 1 2 4
```

Previous Smaller Index

```text
[-1,-1,1,2]
```

---

# Finding Next Smaller

Traverse

```text
Right → Left
```

While

```java
arr[stack.peek()] >= arr[i]
```

pop.

The remaining top is the next smaller element.

---

Example

```text
arr

3 1 2 4
```

Next Smaller Index

```text
[1,4,4,4]
```

---

# Why Different Comparisons?

This is the trickiest part.

Suppose

```text
2 2
```

Subarray

```text
[2,2]
```

Should belong to

- First 2
- Second 2

It cannot belong to both.

Otherwise it gets counted twice.

---

Therefore we break ties consistently.

## Previous Smaller

Use

```java
>
```

Meaning

Stop at a **strictly smaller** element.

---

## Next Smaller

Use

```java
>=
```

Meaning

Stop at a **smaller or equal** element.

This ensures each duplicate contributes exactly once.

---

# Algorithm

## Step 1

Compute

```text
Previous Smaller Index
```

using a monotonic increasing stack.

---

## Step 2

Compute

```text
Next Smaller Index
```

using another monotonic increasing stack.

---

## Step 3

For every element

```text
left = i - prev[i]

right = next[i] - i

Contribution

=

arr[i] × left × right
```

Add contribution to the answer.

Take modulo.

---

# Java Implementation

```java
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        int[] prev = new int[n];
        int[] next = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Smaller
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller or Equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;

            ans = (ans + (long) arr[i] * left * right) % MOD;
        }

        return (int) ans;
    }
}
```

---

# Dry Run

```text
arr

3 1 2 4
```

Previous Smaller

```text
[-1,-1,1,2]
```

Next Smaller

```text
[1,4,4,4]
```

|Index|Value|Left|Right|Contribution|
|-----:|----:|---:|----:|-----------:|
|0|3|1|1|3|
|1|1|2|3|6|
|2|2|1|2|4|
|3|4|1|1|4|

Answer

```text
3 + 6 + 4 + 4 = 17
```

---

# Complexity Analysis

## Previous Smaller

```text
O(n)
```

---

## Next Smaller

```text
O(n)
```

---

## Contribution Calculation

```text
O(n)
```

---

## Total

| Complexity | Value |
|------------|-------|
| Time | **O(n)** |
| Space | **O(n)** |

---

# Pattern to Remember

Whenever a problem asks

- Sum of subarray minimums
- Sum of subarray maximums
- Sum of subarray ranges
- Maximum subarray min-product
- Total strength of wizards

Don't think

> "Find the minimum of every subarray."

Instead think

> **"For how many subarrays is each element the minimum?"**

Then compute

```text
Contribution

=

Element Value

×

Left Choices

×

Right Choices
```

using **Previous Smaller** and **Next Smaller** with a **Monotonic Increasing Stack**.

---

# Related Problems

- **2104. Sum of Subarray Ranges**
- **84. Largest Rectangle in Histogram**
- **1856. Maximum Subarray Min-Product**
- **2281. Sum of Total Strength of Wizards**
- **907. Sum of Subarray Minimums**

---

_Official problem description unavailable._