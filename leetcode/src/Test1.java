import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test1 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
	    String s = in.nextLine();
	    int res= myAtoi(s); 
	    
	    System.out.println(res); 
	} 
	public static int myAtoi(String str) {
	    int index = 0, sign = 1, total = 0;

	if(str.length() == 0 )  return 0;
	if(str.charAt(index) == '+' || str.charAt(index) == '-'){
        sign = str.charAt(index) == '+' ? 1 : -1;
        index ++;
    }
	while(index < str.length()){
	    int digit = str.charAt(index) - '0';
	    if(digit < 0 || digit > 9) break;
	    if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
	        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	    total = 10 * total + digit;
	    index ++;
	}
	//System.out.println(sign);
	return total * sign; 
	}
}