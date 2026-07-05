            
            char c = s.charAt(right);
            freq[ c - 'a' ]++;
            
            while(
                freq[0] > 0 &&
                freq[1] > 0 &&
                freq[2] > 0 
            ){
                freq[ s.charAt(left++) - 'a']--;
            }
            count += left;
        }
        for(int right = 0; right < s.length(); right++){

        int left = 0;
        int count = 0;
        int[] freq = new int[3];
    public int numberOfSubstrings(String s) {
class Solution {
