package DynamicProgramming;

import java.util.Arrays;
//也可用四平方定理
public class PerfectSquares {
	public int numSquares(int n) {
	    int[] dp = new int[n+1];           
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    for(int i=1; i*i<=n; i++) {
	        dp[i*i]=1;
	        for(int j=1; j<=n; j++){
	            int prevVal = j-i*i >=0 && dp[j-i*i] != Integer.MAX_VALUE ? dp[j-i*i]+1 : Integer.MAX_VALUE;
	            dp[j] = Math.min(dp[j],prevVal);    
	        }
	    }
	    return dp[n];
	}
}
