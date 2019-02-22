package DynamicProgramming;

public class StocksWithCooldown {
	 public int maxProfit(int[] prices) {
	        if (prices == null || prices.length == 0) return 0;
	        int cursell = 0;
	        int presell = 0;
	       
	        int buy = -prices[0];
	        for (int i = 1; i < prices.length; ++i) {
	            final int temp =cursell;
	            cursell = Math.max(cursell, buy + prices[i]);
	            buy = Math.max(buy, (i > 1 ? presell : 0) - prices[i]);
	            presell=temp;
	            }
	        return cursell;
	    }
}

