class Solution {
    public int removeDuplicates(int[] nums) {
        int inplace = 1;

        for(int i = 1; i < nums.length; i++){
            if( nums[i] == nums[i-1] ) continue;
            nums[inplace++] = nums[i];
        }
        return (inplace);
    }
    
}
