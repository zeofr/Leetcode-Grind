class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k){
        
        if(k < 0) return 0;

        int left = 0;
        int freq = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int right = 0; right < nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while( map.size() > k ){
                map.put( nums[left], map.getOrDefault(nums[left], 0) - 1);

