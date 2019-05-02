import java.util.*;

public class Meituan9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nums[] = new int[n];
		for(int i = 0 ; i < n ;i++){
			nums[i] = sc.nextInt();
		//	System.out.println(nums[i]);
		}
		int res = 1;
		int cur = nums[0];
		for(int i = 0 ; i < n ;i++){
			if(nums[i] == cur) continue;
			res++;
			cur = nums[i];
		}
		System.out.println(res);
	}

}
