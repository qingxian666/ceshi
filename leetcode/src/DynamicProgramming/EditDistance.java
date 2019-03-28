package DynamicProgramming;

public class EditDistance {
	/*
	 * 设状态为 f[i][j] ，表示 A[0,i] 和 B[0,j] 之间的最小编辑距离。设 A[0,i] 的形式是 str1c ， B[0,j] 的形式是 str2d ，
1. 如果 c==d ，则 f[i][j]=f[i-1][j-1] ；
2. 如果 c!=d ，
i. 如果将c替换成d，则 f[i][j]=f[i-1][j-1]+1 ；
ii. 如果在c后面添加一个d，则 f[i][j]=f[i][j-1]+1 ；
iii. 如果将c删除，则 f[i][j]=f[i-1][j]+1 ；
*/
	
	public int minDistance(String word1, String word2) {
	    if (word1 == null || word2 == null) {
	        return 0;
	    }
	    int m = word1.length(), n = word2.length();
	    int[][] dp = new int[m + 1][n + 1];
	    for (int i = 1; i <= m; i++) {
	        dp[i][0] = i;
	    }
	    for (int i = 1; i <= n; i++) {
	        dp[0][i] = i;
	    }
	    for (int i = 1; i <= m; i++) {
	        for (int j = 1; j <= n; j++) {
	            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
	                dp[i][j] = dp[i - 1][j - 1];
	            } else {
	                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
	            }
	        }
	    }
	    return dp[m][n];
	}
}
