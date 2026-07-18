        }

        st.clear();

        // Next Greater or Equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i])
                st.pop();

            st.push(i);
            prev[i] = st.isEmpty() ? -1 : st.peek();

                st.pop();
            while (!st.isEmpty() && nums[st.peek()] < nums[i])
        for (int i = 0; i < n; i++) {
        // Previous Greater
        Stack<Integer> st = new Stack<>();

        int[] next = new int[n];

        int[] prev = new int[n];

    private long sumMax(int[] nums) {
        int n = nums.length;

    }
        return ans;

