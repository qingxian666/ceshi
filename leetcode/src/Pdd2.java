
import java.util.*;

public class Pdd2 {
	//leetcode 43 
	//https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
	public static void main(String[] args){
        Scanner  sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
       // System.out.println(s1+" "+s2);
        String s3 = multiply(s1,s2);
        System.out.println(s3);
	}

	public static String multiply(String num1, String num2) {
	    int m = num1.length(), n = num2.length();
	    int[] pos = new int[m + n];
	   
	    for(int i = m - 1; i >= 0; i--) {
	        for(int j = n - 1; j >= 0; j--) {
	            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
	            int p1 = i + j, p2 = i + j + 1;
	            int sum = mul + pos[p2];

	            pos[p1] += sum / 10;
	            pos[p2] = (sum) % 10;
	        }
	    }  
	    
	    StringBuilder sb = new StringBuilder();
	    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
	    return sb.length() == 0 ? "0" : sb.toString();
	}
}
