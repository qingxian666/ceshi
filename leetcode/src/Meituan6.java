import java.util.Scanner;

public class Meituan6 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int []a = new int[n];
        for(int i = 0 ; i< n;i++){
        	a[i] = sc.nextInt();
        }
        double p = P / 100.0, q = Q / 100.0;
        sc.close();
        double[][] dp = new double[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = a[i];
            if (i < n - 1) {
                dp[i][i + 1] = p * a[i] + (1 - p) * a[i + 1];
            }
        }
 
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = p * (q * dp[i + 2][j] + (1 - q) * dp[i + 1][j - 1] + a[i])
                        + (1 - p) * (q * dp[i + 1][j - 1] + (1 - q) * dp[i][j - 2] + a[j]);
            }
        }
        System.out.printf("%.3f\n", dp[0][n-1]);
    }
}
