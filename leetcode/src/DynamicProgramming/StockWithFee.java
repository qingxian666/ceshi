package DynamicProgramming;

public class StockWithFee {
	 public int maxProfit(int[] prices, int fee) {
	        if(prices.length==0)  return 0;
	        int hold[]=new int[prices.length];
	        int sold[]=new int[prices.length];
	        hold[0] = -prices[0];
	        for (int i = 1; i < prices.length; ++i) {
	            sold[i] = Math.max(sold[i - 1], hold[i - 1] + prices[i] - fee);
	            hold[i] = Math.max(hold[i - 1], sold[i - 1] - prices[i]);
	        }
	        return sold[prices.length-1];
	    }
}
