class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev2 = cost[0];
        int prev1 = cost[1];
        
        for(int i = 2; i <n; i++){
            int curr = cost[i] + Math.min(prev1, prev2);
        }
    }
        return  Math.min(prev1,prev2);
        
        int n = cost.length;

            prev2 = prev1;
            prev1 = curr;
}
