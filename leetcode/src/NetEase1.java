import java.util.*;

public class NetEase1 {
	public static void main(String[] args){
        Scanner  sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int []nums = new int[26];
        for(int i=0; i < n; i++){
        	nums[s.charAt(i)- 'A'] ++ ;
        }
        int sum=0;
        Arrays.sort(nums);
        for(int i =25; i > 0; i--){
        	if(nums[25] < 2 || nums[23] > 0) {
            	sum=0;
            	break;
            }
        	if(nums[24]==0) {sum = 1;}
            if(nums[24]!=0) {sum = 2;}
        }
          System.out.println(sum);
	}
}
