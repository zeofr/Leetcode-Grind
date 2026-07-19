class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int glen = g.length,
            slen = s.length,
            gp = 0, 
            sp = 0;
        while( gp < glen && sp < slen ){
            if( s[sp] >= g[gp] ) {
                sp++;
                gp++;
            }
            else sp++;
        }
        return gp;
    }
}
