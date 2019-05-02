import java.util.*;
 
public class Meituan13 {
    public static void main(String[] args) {
    	//Ó²±Ò¶Ò»»
        Scanner sc = new Scanner(System.in);
        long[] coins = new long[] {1, 2, 5, 10, 20, 50, 100};
        long[] preSum = new long[9];
        for (int i=1; i!=8; i++) {
            preSum[i] = coins[i-1] + preSum[i-1];
        }
        preSum[8] = Long.MAX_VALUE;
        long in = sc.nextLong();
        int i = 0;
        for (i=1; i!=8; i++) {
            if (preSum[i] > in) {
                break;
            }
        }
        System.out.printf("%d %d\n", i-1, in - preSum[i-1] + i-1);
    }
}
