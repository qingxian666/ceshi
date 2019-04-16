package String;

public class LongestPalindromeSequence {
	public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
           return 0;
       }
       int[][] dp = new int[s.length()][s.length()];
       
       for(int i = 0; i < s.length(); i++){
           dp[i][i] = 1;
       }

       for (int i = 1; i < s.length(); i++) {
           
           for(int j = i - 1; j >= 0; j--){
               if (s.charAt(j) == s.charAt(i)) {
                   if(j == i-1){
                       dp[i][j] = 2;
                   } else{
                       dp[i][j] = dp[i - 1][j + 1] + 2;
                   }
                   
               } else {
                   dp[i][j] = Math.max(dp[i -1][j], dp[i][j + 1]);
               }
           }
       }

       return dp[s.length()-1][0];
   }
}
