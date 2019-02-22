package DynamicProgramming;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
	    int sum = computeArraySum(nums);
	    if (sum % 2 != 0) {
	        return false;
	    }
	    int W = sum / 2;
	    boolean[] dp = new boolean[W + 1];
	    dp[0] = true;
	    for (int num : nums) {                 // 0-1 ����һ����Ʒֻ����һ��
	        for (int i = W; i >= num; i--) {   // �Ӻ���ǰ���ȼ��� dp[i] �ټ��� dp[i-num]
	            dp[i] = dp[i] || dp[i - num];
	        }
	    }
	    return dp[W];
	}

	private int computeArraySum(int[] nums) {
	    int sum = 0;
	    for (int num : nums) {
	        sum += num;
	    }
	    return sum;
	}
}
