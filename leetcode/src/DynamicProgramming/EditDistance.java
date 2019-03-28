package DynamicProgramming;

public class EditDistance {
	/*
	 * ��״̬Ϊ f[i][j] ����ʾ A[0,i] �� B[0,j] ֮�����С�༭���롣�� A[0,i] ����ʽ�� str1c �� B[0,j] ����ʽ�� str2d ��
1. ��� c==d ���� f[i][j]=f[i-1][j-1] ��
2. ��� c!=d ��
i. �����c�滻��d���� f[i][j]=f[i-1][j-1]+1 ��
ii. �����c�������һ��d���� f[i][j]=f[i][j-1]+1 ��
iii. �����cɾ������ f[i][j]=f[i-1][j]+1 ��
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
