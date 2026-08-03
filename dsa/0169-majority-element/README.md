# 0169. Majority Element

## 💡 My Approach
If the problem does not guarantee that a majority element exists, Boyer-Moore needs a second pass to verify the candidate:

```java
int freq = 0;
for (int num : nums) {
    if (num == candidate) {
        freq++;
    }
}

return freq > nums.length / 2 ? candidate : -1;
```

---

_Official problem description unavailable._