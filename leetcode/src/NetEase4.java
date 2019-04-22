import java.util.Scanner;

public class NetEase4 {
	public static void main(String[] args){
        Scanner  sc = new Scanner(System.in);
        int n=sc.nextInt();
        int []nums = new int[n];
        for(int i=0; i < n; i++){
        	nums[i] = sc.nextInt();
        }
        sc.close();
        
        if(n%2==0){
        	even(nums);
        } else {
        	odd(nums);
        }
        
	}

	private static void odd(int[] nums) {
		// TODO Auto-generated method stub
		int n =nums.length;
		int res[] = new int[n];
		int i=0,j=n-1;
		while(i<(n/2+1)){
			res[i] = nums[j];
			i++;
			j -= 2;
		}
		int k = n/2+1, l = 1;
		while(k < n){
			res[k] = nums[l];
			k++;
			l += 2;
		}
		for(int num : res){
        	System.out.print(num + " ");
        }
	}

	private static void even(int[] nums) {
		// TODO Auto-generated method stub
		int n =nums.length;
		int res[] = new int[n];
		int i=0,j=n-1;
		while(i<n/2){
			res[i] = nums[j];
			i++;
			j -= 2;
		}
		int k = n/2, l = 0;
		while(k < n){
			res[k] = nums[l];
			k++;
			l += 2;
		}
		for(int num : res){
        	System.out.print(num + " ");
        }
	}
}
