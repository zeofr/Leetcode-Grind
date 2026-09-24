            while (k > 0 &&
                   st.length() > 0 &&
                   st.charAt(st.length() - 1) > digit) {

                st.deleteCharAt(st.length() - 1);
                k--;
            }

            st.append(digit);
        }
        while (k > 0) {
            st.deleteCharAt(st.length() - 1);
            k--;
        }
        int i = 0;
        while (i < st.length() && st.charAt(i) == '0') {
            i++;
        for (char digit : num.toCharArray()) {

        StringBuilder st = new StringBuilder();

    public String removeKdigits(String num, int k) {
class Solution {
        }
        String result = st.substring(i);

        return result.isEmpty() ? "0" : result;
    }
}
