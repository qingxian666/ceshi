
import java.util.*;

public class Pdd1 {
	//leetcode 628,此题需注意数组类型为long不是int
	public static void main(String[] args){
        Scanner  sc = new Scanner(System.in);
        int  n = sc.nextInt();
        long[] nums = new long[n];
        for(int i = 0; i< n;i++){
        	nums[i] = sc.nextInt();
        }
        long result=maximumProduct(nums);
        System.out.println(result);
	}

	public static long maximumProduct(long[] nums) {
        long max1 = Integer.MIN_VALUE;
		long max2 = Integer.MIN_VALUE;
		long max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (long n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
