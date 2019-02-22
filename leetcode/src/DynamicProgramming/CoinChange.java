package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
	    if (coins == null || coins.length == 0) {
	        return 0;
	    }
	    int[] dp = new int[amount + 1];
	    Arrays.fill(dp, amount + 1);
	    dp[0] = 0;
	    Arrays.sort(coins);
	    for (int i = 1; i <= amount; i++) {
	        for (int j = 0; j < coins.length && coins[j] <= i; j++) {
	            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
	        }
	    }
	    return dp[amount] > amount ? -1 : dp[amount];
	}
}
