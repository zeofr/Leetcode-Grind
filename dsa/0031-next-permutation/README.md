# 0031. Next Permutation

## 💡 My Approach
```
class Solution {
    public void nextPermutation(int[] nums) {
        int ind = -1, n = nums.length;
        
        // This is to find the pivot point where a number is smaller than all numbers to its right
        // If no pivot index is found it will be -1
        // When it is -1 then just reverse the array and return as that will be smallest permutation
        for(int i = n-2; i>=0; i--){
            if (nums[i] < nums[i+1] ){ 
                ind = i;
                break;
            }
        }

        // When a pivot is found, look for the least bigger element to swap it with
        // Since all elements to the right of pivot are a decreasing array, comparing one at a time from right to left gives it

        if(ind != -1){
            for(int i = n-1; i > ind; i --){
                if(nums[ind] < nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[ind];
                    nums[ind] = temp;
                    break;
                }
            }
            // Once both are swapped, reverse the array right to pivot to get the smallest possible number
            // This is because the right part is decreasing order which means it will be largest subarray atm.
            rev(nums, ind+1, n-1);
        }

        // When pivot index is -1
        else{
            rev(nums, ind+1, n-1);
        }

    }
     // Function to reverse an array
    public void rev(int[] nums, int l,int r){
        while(l<r){
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}
```

---

_Official problem description unavailable._