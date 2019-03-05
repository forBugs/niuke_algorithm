package org.leetcode;

class Solution91 {
    // time O(n),space O(n)
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;

        int n = s.length();

        int[] dp = new int[n+1];

        dp[0]=1;
        dp[1]=1;

        for(int i=2; i<=n; i++){

            if(s.charAt(i-1) > '0' ) {
                dp[i] = dp[i-1];
                if(s.charAt(i-2) > '0' && Integer.valueOf(s.substring(i-2,i)) <= 26) dp[i] += dp[i-2];

            }else if(s.charAt(i-1) == '0'){

                if(s.charAt(i-2) > '0' && s.charAt(i-2) <= '2') dp[i] = dp[i-2];

            }




        }
        return dp[n];

    }

    public static void main(String[] args) {
        Solution91 solution91 = new Solution91();
        int i = solution91.numDecodings("12");
        System.out.println(i);
    }
}