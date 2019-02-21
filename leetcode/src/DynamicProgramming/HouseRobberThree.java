package DynamicProgramming;

public class HouseRobberThree {
	 public int rob(TreeNode root) {
	        return dfs(root)[0];
	    }
	    
	    public static int[] dfs(TreeNode root){
	        int [] dp = new int [] {0,0};
	        if(root!=null){
	            int [] dpL=dfs(root.left);
	            int [] dpR=dfs(root.right);
	            dp[1]=dpL[0]+dpR[0];
	            dp[0]=Math.max(dp[1],dpL[1]+dpR[1]+root.val);            
	        }
	        return dp;
	    }
}
