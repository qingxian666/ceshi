package DynamicProgramming;

public class OnesAndZeros {
/*建立一个二维的DP数组，其中dp[i][j]表示有i个0和j个1时能组成的最多字符串的个数，
 * 而对于当前遍历到的字符串，我们统计出其中0和1的个数为zeros和ones，
 * 然后dp[i - zeros][j - ones]表示当前的i和j减去zeros和ones之前能拼成字符串的个数，
 * 那么加上当前的zeros和ones就是当前dp[i][j]可以达到的个数，我们跟其原有数值对比取较大值即可，所以递推式如下：
  dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1);
  */
	 public int findMaxForm(String[] strs, int m, int n) {
	        if (strs == null || strs.length == 0) {
	        return 0;
	    }
	    int[][] dp = new int[m + 1][n + 1];
	    for (String s : strs) {    // 每个字符串只能用一次
	        int ones = 0, zeros = 0;
	        for (char c : s.toCharArray()) {
	            if (c == '0') {
	                zeros++;
	            } else {
	                ones++;
	            }
	        }
	        for (int i = m; i >= zeros; i--) {
	            for (int j = n; j >= ones; j--) {
	                dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
	            }
	        }
	    }
	    return dp[m][n];
	    }
}
