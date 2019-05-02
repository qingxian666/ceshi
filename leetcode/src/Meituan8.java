import java.util.*;
 

public class Meituan8 {
	public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        int sum=0, max=0;
        for(int i = 0 ; i < n; i++){
            nums[i] = sc.nextInt();
            sum += nums[i];
            if (nums[i] > max) max = nums[i];
        }
        System.out.println(max > sum - max ? "No" : "Yes");
    }
}
