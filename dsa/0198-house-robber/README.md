# 0198. House Robber

## 💡 My Approach
### Doubt

The main confusion in this problem comes from the initialization:

```java
dp[1] = Math.max(nums[0], nums[1]);
```

Why do we set `dp[1]` to the maximum of `nums[0]` and `nums[1]` instead of just assigning `nums[1]`?

My reasoning is:

- When calculating `dp[2]`, we compare:
  ```java
  pick = nums[2] + dp[0];
  notPick = dp[1];
  ```
- If `nums[1]` is greater than `nums[0] + nums[2]`, then `notPick` (`dp[1]`) will naturally be chosen.
- If `nums[0]` is greater than `nums[1]`, then:
  ```java
  dp[1] = dp[0]
  ```
  since `dp[1]` stores the maximum money that can be robbed from the first two houses.
- In that case, `pick = nums[2] + dp[0]` is still valid because `dp[0]` only includes house `0`, so robbing house `2` does not violate the "no adjacent houses" rule.


---

_Official problem description unavailable._