package String;

public class ImplementStrstr {
	 public int strStr(String haystack, String needle) {
		 /*�����㷨��ʱ�临�Ӷ��� O(m*n) ���ռ临�Ӷ���O(1)���������¡�����Ч�ĵ��㷨��KMP�㷨��Boyer-Mooer�㷨��Rabin-Karp
�㷨�������б����㷨�㹻�ˣ�һ��Ҫд��û��BUG*/
         if (needle.isEmpty()) return 0; // edge case: "",""=>0  "a",""=>0
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length() && haystack.charAt(i + j) == needle.charAt(j); j++)
                if (j == needle.length() - 1) return i;
        }
        return -1;
    }
}
