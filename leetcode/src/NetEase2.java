import java.util.*;
public class NetEase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner  sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []nums = new int[n];
		for(int i =0 ; i < n ; i ++){
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		if(n <= 2) System.out.println("Possible");
		int []d = new int[n-1];
		for(int i =1 ; i < n ; i ++){
			 d[i-1] =nums[i] - nums[i-1];
		}
		int dd = d[0];
		boolean b = true;
		for(int i =0 ; i < n-1 ; i ++){
			 if(d[i]!= dd){
				 b=false;
				 break;
			 }
		}
		if(b==false) System.out.println("Impossible");
		if(b==true)	System.out.println("Possible");
		
	}

}
