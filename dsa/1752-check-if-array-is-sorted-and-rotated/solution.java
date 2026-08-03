class Solution {
    public boolean check(int[] nums) {
        int i,n=nums.length;
        for(i = 0 ; i < n-1 ; i++){
            if(nums[i]>nums[i+1]) break;
        }

        if(i==n-1) return true;

        for(int j = i+1 ; j< n-1 ; j++){
            if(nums[j]>nums[j+1]) return false;
        }
        if (nums[n - 1] > nums[0]) {
            return false;
        }

        return true;

    }
}
