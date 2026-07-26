class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0,d=0,n=0,dummy = x;
        if(x < 0) return false;
        while(dummy > 0){
            d = dummy % 10;
            rev = rev*10 + d;
            dummy = dummy/10;

        }
        return rev == x ? true : false ;
    }
}
