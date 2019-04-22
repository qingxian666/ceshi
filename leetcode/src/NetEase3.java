import java.util.Arrays;
import java.util.Scanner;

public class NetEase3 {
	public static void main(String[] args){
        Scanner  sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int []nums = new int[n];
        char []c = s.toCharArray();
        for(int i =0; i<c.length; i++){
        	nums[i]= c[i]-'0';
        }
        int lo=0, hi=0,res=0;
        for(int i=0; i< n-1; i++){
        	if(nums[i]+nums[i+1]==1) {hi++;}
        	else {lo = hi;hi++;	}
        	res=Math.max(res, hi-lo);
        }
        if(res==(n-1)) res++;
        System.out.println(res);
	}
}
