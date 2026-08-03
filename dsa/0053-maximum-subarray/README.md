# 0053. Maximum Subarray

## 💡 My Approach
Kadane's Algorithm is an efficient algorithm used to find the maximum sum of a contiguous subarray in an array.

It solves the problem in:

```
Time: O(n)
Space: O(1)
Problem

```
Given:

```
[-2,1,-3,4,-1,2,1,-5,4]
```

Find the contiguous subarray with the maximum sum.

Answer:

```
[4,-1,2,1]
```

Sum:

```
6
```
The Main Idea

As you traverse the array, ask yourself:

"Is it better to extend the current subarray or start a new one?"

At each element:

If the previous sum is negative, it only hurts the current sum.
So, start a new subarray from the current element.
Otherwise, extend the current subarray.
Algorithm

Maintain two variables:

```
currentSum → maximum subarray sum ending at the current index.
maxSum → maximum subarray sum found so far.

```
For every number:

```
currentSum = max(current element,
                 currentSum + current element)

maxSum = max(maxSum, currentSum)
```

---

_Official problem description unavailable._