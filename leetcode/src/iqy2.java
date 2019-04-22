import java.util.Scanner;

public class iqy2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        int l1 = LongestRepeatSting("A",s);
        int l2 = LongestRepeatSting("C",s);
        int l3 = LongestRepeatSting("G",s);
        int l4 = LongestRepeatSting("T",s);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println(l4);
        sc.close();
    }

	private static int LongestRepeatSting(String s1, String s2) {
		// TODO Auto-generated method stub
		int lo =0;
		int hi= 0;
		int n = s2.length();
		int res = 0;
		while(hi < n){
			if(s2.charAt(hi) == s1.charAt(0)){
				res = hi-lo+1;
				hi++;
			} else{
				hi++;
				lo = hi;
			}
				
		}
		return res;
	}
}
