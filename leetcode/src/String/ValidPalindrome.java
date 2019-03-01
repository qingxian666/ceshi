package String;

public class ValidPalindrome {
	 public boolean isPalindrome(String s) {
		 /*给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
			说明：本题中，我们将空字符串定义为有效的回文串。*/
	        if (s.isEmpty()) {
	        	return true;
	        }
	        int head = 0, tail = s.length() - 1;
	        char cHead, cTail;
	        while(head <= tail) {
	        	cHead = s.charAt(head);
	        	cTail = s.charAt(tail);
	        	//IsLetterOrDigit(Char) 指示指定的 Unicode 字元是否分类为依字母顺序排列的字母或十进位数字
	        	if (!Character.isLetterOrDigit(cHead)) {
	        		head++;
	        	} else if(!Character.isLetterOrDigit(cTail)) {
	        		tail--;
	        	} else {
	        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
	        			return false;
	        		}
	        		head++;
	        		tail--;
	        	}
	        }
	        
	        return true;
	    }
}
