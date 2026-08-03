class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0 , maxSum = Integer.MIN_VALUE;
        for(int x : nums){
            currentSum = Math.max( currentSum + x , x );
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
