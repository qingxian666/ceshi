package String;

public class LongestPalindromeSubstrings {
	public int longestPalindromeSubseq(String s) {
		//给定一个字符串s，找到其中最长的回文子序列。
        if (s == null || s.length() == 0) {
           return 0;
       }
       int[][] dp = new int[s.length()][s.length()];

       for (int i = s.length() - 1; i >= 0; --i) {
           dp[i][i] = 1;
           for (int j = i + 1; j < s.length(); ++j) {
               if (s.charAt(j) == s.charAt(i)) {
                   dp[i][j] = dp[i + 1][j - 1] + 2;
               } else {
                   dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
               }
           }
       }

       return dp[0][s.length() - 1];
   }
}
