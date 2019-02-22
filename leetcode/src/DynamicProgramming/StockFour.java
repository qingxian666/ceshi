package DynamicProgramming;

public class StockFour {
	/*������״̬�� global[i][j] ��ʾi��ǰ�����Խ���j�ν��׵�������� local[i][j] ��ʾi��ǰ���
���Խ���j�ν��ף����ڵ�i������˵�j�ν��׵��������״̬ת�Ʒ������£�
local[i][j] = max(global[i-1][j-1] + max(diff,0), local[i-1][j]+diff)
global[i][j] = max(local[i][j], global[i-1][j])
���� global ��״̬ת�Ʒ��̱Ƚϼ򵥣����ϵغ��Ѿ��������local���бȽϣ��Ѵ�ı�����global�С�
���� local ��״̬ת�Ʒ��̣�ȡ��������нϴ��һ����
ȫ��ǰ i-1 ������� j-1 �ν��ף�Ȼ��Ȼ����Ͻ���Ľ��ײ������������׬Ǯ�ͽ��ף���׬Ǯ
�Ͳ����ף�ʲôҲ��������������0��
�ֲ�ǰ i-1 ������� j �ν��ף�Ȼ����Ͻ���Ĳ�ۣ� local[i-1][j] �ǵ� i-1 �������Ľ��ף�
������diff���ɵ� i �����������������ӽ��״��������� diff �������Ǹ���Ҫ���ϣ�����Ͳ���
�� local[i][j] ���������һ�������������ˣ�
ע�⣬�� k ��������Ĵ�Сʱ�������㷨����õ�Ч����ʱ���Ը�Ϊ���޽��״����ķ�ʽ��������ȼ���
"Best Time to Buy and Sell Stock II"��*/
	public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k < 1) return 0;
        if (k >= prices.length) return maxProfit(prices);
        
        final int[][] local = new int[prices.length][k + 1];
        final int[][] global = new int[prices.length][k + 1];
        
        for (int i = 1; i < prices.length; i++) {
            final int diff = prices[i] - prices[i - 1];
         for (int j = 1; j < k+1; j++) {
              local[i][j] = Math.max(
              global[i - 1][j - 1] + Math.max(diff, 0),
              local[i - 1][j] + diff);
              global[i][j] = Math.max(global[i - 1][j], local[i][j]);
        }
    }
        return global[prices.length - 1][k];
}
    
    // Best Time to Buy and Sell Stock II
    public static int maxProfit(final int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
             int diff = prices[i] - prices[i - 1];
                if (diff > 0) sum += diff;
            }
        return sum;
    }
}
