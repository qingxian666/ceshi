package String;

public class ValidPalindrome {
	 public boolean isPalindrome(String s) {
		 /*����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
			˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���*/
	        if (s.isEmpty()) {
	        	return true;
	        }
	        int head = 0, tail = s.length() - 1;
	        char cHead, cTail;
	        while(head <= tail) {
	        	cHead = s.charAt(head);
	        	cTail = s.charAt(tail);
	        	//IsLetterOrDigit(Char) ָʾָ���� Unicode ��Ԫ�Ƿ����Ϊ����ĸ˳�����е���ĸ��ʮ��λ����
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
