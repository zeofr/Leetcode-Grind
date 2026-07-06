# 1358. Number of Substrings Containing All Three Characters

## 💡 My Approach
1358. Number of Substrings Containing All Three Characters | Medium | Hash Table | String | Sliding Window


In this question i tried using the same atMost() concept at first but that wont work since the logic ```freq[0] > 0 && freq[1] > 0 && freq[2] > 0```
is not preserved inside the loop. So a straight approach is used.

The count += left is used because :
- Since the [left,right] range satisfies the condition, After the while loop:
window [left-1 ... right] was the last valid window.
All starts before that are also valid.

```java

class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int count = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            
            char c = s.charAt(right);
            freq[ c - 'a' ]++;
            
            while(
                freq[0] > 0 &&
                freq[1] > 0 &&
                freq[2] > 0 
            ){
                freq[ s.charAt(left++) - 'a']--;
            }
            count += left;
        }
        return count;
    }
}
```
