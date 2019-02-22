package DynamicProgramming;

public class OnesAndZeros {
/*����һ����ά��DP���飬����dp[i][j]��ʾ��i��0��j��1ʱ����ɵ�����ַ����ĸ�����
 * �����ڵ�ǰ���������ַ���������ͳ�Ƴ�����0��1�ĸ���Ϊzeros��ones��
 * Ȼ��dp[i - zeros][j - ones]��ʾ��ǰ��i��j��ȥzeros��ones֮ǰ��ƴ���ַ����ĸ�����
 * ��ô���ϵ�ǰ��zeros��ones���ǵ�ǰdp[i][j]���Դﵽ�ĸ��������Ǹ���ԭ����ֵ�Ա�ȡ�ϴ�ֵ���ɣ����Ե���ʽ���£�
  dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1);
  */
	 public int findMaxForm(String[] strs, int m, int n) {
	        if (strs == null || strs.length == 0) {
	        return 0;
	    }
	    int[][] dp = new int[m + 1][n + 1];
	    for (String s : strs) {    // ÿ���ַ���ֻ����һ��
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
