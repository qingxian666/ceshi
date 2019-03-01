package String;

public class ImplementStrstr {
	 public int strStr(String haystack, String needle) {
		 /*暴力算法的时间复杂度是 O(m*n) ，空间复杂度是O(1)，代码如下。更高效的的算法有KMP算法、Boyer-Mooer算法和Rabin-Karp
算法。面试中暴力算法足够了，一定要写得没有BUG*/
         if (needle.isEmpty()) return 0; // edge case: "",""=>0  "a",""=>0
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length() && haystack.charAt(i + j) == needle.charAt(j); j++)
                if (j == needle.length() - 1) return i;
        }
        return -1;
    }
}
