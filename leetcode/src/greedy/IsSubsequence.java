package greedy;

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
	    int index = -1;
	    for (char c : s.toCharArray()) {
	    	/*int indexOf(String str, int fromIndex): 
	    	 * ���ش� fromIndex λ�ÿ�ʼ����ָ���ַ����ַ����е�һ�γ��ִ���������������ַ�����û���������ַ����򷵻� -1��*/
	        index = t.indexOf(c, index + 1);
	        if (index == -1) {
	            return false;
	        }
	    }
	    return true;
	}
}
