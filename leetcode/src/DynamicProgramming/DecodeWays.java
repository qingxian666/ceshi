package DynamicProgramming;

public class DecodeWays {
	 public int numDecodings(String s) {
	       if (s.isEmpty() || s.charAt(0) == '0') return 0;
	        int prev = 0;
	        int cur = 1;
	        // ����Ϊn���ַ������� n+1������
	        for (int i = 1; i <= s.length(); ++i) {
	        if (s.charAt(i-1) == '0') cur = 0;
	        if (i < 2 || !(s.charAt(i - 2) == '1' ||
	        (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')))
	        prev = 0;
	        int tmp = cur;
	        cur = prev + cur;
	        prev = tmp;
	        }
	        return cur;
	    }
}
