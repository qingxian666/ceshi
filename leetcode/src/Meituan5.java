import java.util.*;

public class Meituan5 {
	public static void main(String[] args)  {
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + p[i];
 
        int res = 0;
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if ((sum[i] - sum[j]) % k == 0) {
                    res = Math.max(res, i - j);
                    break;
                }
            }
            if (res >= i - 1) break;
        }
        System.out.println(res);
    }
}
