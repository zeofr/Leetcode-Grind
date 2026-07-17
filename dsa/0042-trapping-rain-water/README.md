# 0042. Trapping Rain Water

## 💡 My Approach
# 42. Trapping Rain Water (Hard)

## Problem

Given an array `height[]` representing the elevation map where the width of each bar is `1`, calculate how much rainwater can be trapped after raining.

Example:

```text
Input:
height = [4,2,0,3,2,5]

Output:
9
```

---

# Key Observation

Water can only be trapped if there is:

- A wall on the **left**
- A wall on the **right**

The amount of water above any index depends on the **smaller** of these two walls.

For every index `i`:

```text
Water at i =
min(Max height on left,
    Max height on right)
- height[i]
```

or

```text
water[i] = min(leftMax[i], rightMax[i]) - height[i]
```

---

# Brute Force Approach

For every index:

1. Find the tallest bar on the left.
2. Find the tallest bar on the right.
3. Calculate trapped water.

```java
water = Math.min(leftMax, rightMax) - height[i];
```

### Time Complexity

```text
O(n²)
```

### Space Complexity

```text
O(1)
```

---

# Better Approach (Prefix & Suffix Arrays)

Precompute:

- `leftMax[i]`
- `rightMax[i]`

Example:

```text
height

4 2 0 3 2 5
```

Left Maximum

```text
4 4 4 4 4 5
```

Right Maximum

```text
5 5 5 5 5 5
```

Now

```text
water[i] =
min(leftMax[i], rightMax[i])
-
height[i]
```

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(n)
```

---

# Optimal Two Pointer Approach

Instead of storing two arrays, store only:

```text
maxLeft
maxRight
```

Use two pointers:

```text
left = 0
right = n - 1
```

---

# Core Intuition

Suppose

```text
height[left] <= height[right]
```

Example

```text
2 .......... 7
↑            ↑
L            R
```

Since the right side is already taller,

we know there exists a wall on the right that is at least as tall as the current left wall.

Therefore,

the water trapped at the left pointer depends only on the **highest wall seen from the left**.

So we can safely process the left pointer.

Similarly,

if

```text
height[right] < height[left]
```

we process the right pointer.

---

# Why Does This Work?

The water formula is

```text
water =
min(leftMax, rightMax)
```

When

```text
height[left] <= height[right]
```

the right boundary is already high enough.

The limiting factor becomes

```text
leftMax
```

So

```text
water = leftMax - height[left]
```

if

```text
leftMax > height[left]
```

Otherwise,

no water can be trapped.

---

# Algorithm

Initialize

```text
left = 0
right = n-1

maxLeft = 0
maxRight = 0

answer = 0
```

While

```text
left <= right
```

### Case 1

If

```text
height[left] <= height[right]
```

Update

```text
maxLeft = max(maxLeft, height[left])
```

If

```text
height[left] < maxLeft
```

Water trapped

```text
maxLeft - height[left]
```

Move

```text
left++
```

---

### Case 2

Else

Update

```text
maxRight = max(maxRight, height[right])
```

If

```text
height[right] < maxRight
```

Water trapped

```text
maxRight - height[right]
```

Move

```text
right--
```

---

# Dry Run

Example

```text
height

4 2 0 3 2 5
```

Initial

```text
left = 0
right = 5

maxLeft = 0
maxRight = 0

water = 0
```

---

### Step 1

```text
4 2 0 3 2 5
L         R
```

```
height[left] <= height[right]
```

Update

```text
maxLeft = 4
```

Move

```text
left++
```

---

### Step 2

Current

```text
2
```

Maximum left

```text
4
```

Water

```text
4 - 2 = 2
```

Total

```text
2
```

---

### Step 3

Current

```text
0
```

Water

```text
4 - 0 = 4
```

Total

```text
6
```

---

### Step 4

Current

```text
3
```

Water

```text
4 - 3 = 1
```

Total

```text
7
```

---

### Step 5

Current

```text
2
```

Water

```text
4 - 2 = 2
```

Total

```text
9
```

Move

```text
left++
```

Pointers meet.

Answer

```text
9
```

---

# Code Walkthrough

```java
int left = 0;
int right = height.length - 1;
```

Two pointers.

---

```java
int maxLeft = 0;
int maxRight = 0;
```

Highest walls seen so far from both ends.

---

```java
int res = 0;
```

Stores total trapped water.

---

```java
while (left <= right)
```

Process until pointers meet.

---

```java
if (height[left] <= height[right])
```

The left side is guaranteed to have a valid right boundary.

So process the left pointer.

---

```java
if (height[left] >= maxLeft)
```

Found a taller wall.

Update

```java
maxLeft = height[left];
```

---

Otherwise

```java
res += maxLeft - height[left];
```

The difference is the water trapped.

---

Move

```java
left++;
```

---

Else

```java
if (height[right] >= maxRight)
```

Update the tallest wall on the right.

---

Otherwise

```java
res += maxRight - height[right];
```

---

Move

```java
right--;
```

---

# Correctness Intuition

At every step:

- If the left bar is shorter, the left side is the limiting side.
- If the right bar is shorter, the right side is the limiting side.
- The opposite side is already guaranteed to have a wall tall enough.

Therefore, we never need to know the exact future maximum on the opposite side.

This allows us to compute the answer in one pass.

---

# Complexity Analysis

| Operation | Complexity |
|-----------|------------|
| Time | **O(n)** |
| Space | **O(1)** |

### Why O(n)?

Each pointer moves only inward.

```text
left → moves at most n times

right → moves at most n times
```

No index is visited more than once.

Therefore

```text
Time = O(n)
```

---

# Important Formula

```text
Water at index i

=
min(maxLeft, maxRight)
-
height[i]
```

---

# Key Takeaways

- Water is trapped only between two taller walls.
- The water level is determined by the **smaller** boundary.
- Maintain only the tallest wall seen from each side.
- Always process the pointer with the **smaller current height**.
- No extra arrays are needed.
- One pass is sufficient.

---

# Similar Problems

- 11. Container With Most Water
- 84. Largest Rectangle in Histogram
- 42. Trapping Rain Water (Stack Solution)
- 407. Trapping Rain Water II (2D)
- 1762. Buildings With an Ocean View

---

_Official problem description unavailable._