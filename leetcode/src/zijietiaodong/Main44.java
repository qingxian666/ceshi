package zijietiaodong;

import java.util.Scanner;

public class Main44 {
	public static void main(String[] args) {
	      Scanner in = new Scanner(System.in);
	      int n=in.nextInt();
	      int[][] dp= new int[n][n];
	      for(int i=0;i<n;i++){
	    	  for(int j=0;j<n;j++){
	    		  dp[i][j]=in.nextInt();
	    	  }
	    	}
	      findCircleNum(dp);
	     // System.out.println(x);
	   }
	public static int findCircleNum(int[][] M) {
	    int m = M.length;
	    int circleNum = 0;
	    boolean[] hasVisited = new boolean[m];
	    for (int i = 0; i < m; i++) {
	        if (!hasVisited[i]) {
	            dfs(M, i, hasVisited);
	            
	        }
	    }
	    return circleNum;
	}

	private static void dfs(int[][] M, int i, boolean[] hasVisited) {
	    hasVisited[i] = true;
	    int m = M.length;
	    int circleNum = 0;
	    for (int k = 0; k < m; k++) {
	        if (M[i][k] == 1 && !hasVisited[k]) {
	            dfs(M, k, hasVisited);
	            circleNum+=M[i][k];
	        }
	    }
	}
}
