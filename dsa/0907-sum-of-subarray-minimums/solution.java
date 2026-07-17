
        st.clear();

        // Next Smaller or Equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
        }
            st.push(i);
            prev[i] = st.isEmpty() ? -1 : st.peek();
            }
                st.pop();
            long left = i - prev[i];
            long right = next[i] - i;

            ans = (ans + arr[i] * left * right) % MOD;
        }

        return (int) ans;
    }
