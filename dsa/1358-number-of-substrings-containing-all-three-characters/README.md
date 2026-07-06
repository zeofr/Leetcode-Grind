# 1358. Number of Substrings Containing All Three Characters

## 💡 My Approach
992. Subarrays with K Different Integers | Hard | 2 Pointers | HashMap

- Given an integer array nums and an integer k, return the number of good subarrays of nums.
- A good array is an array where the number of different integers in that array is exactly k.
- For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
- A subarray is a contiguous part of an array.

Ez question, solved using atMost concept.

```java
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k){
        
        if(k < 0) return 0;

        int left = 0;
        int freq = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int right = 0; right < nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while( map.size() > k ){
                map.put( nums[left], map.getOrDefault(nums[left], 0) - 1);

                if(map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                
                left++;
            }

            count += right - left + 1;

        }
        return count;
    }
}
```

---

DescriptionDescription