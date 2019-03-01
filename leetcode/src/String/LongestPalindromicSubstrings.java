package String;

public class LongestPalindromicSubstrings {
	/*马拉车算法
	 * http://www.cnblogs.com/bitzhuwei/p/Longest-Palindromic-Substring-Part-II.html*/
        
public String longestPalindrome(String s) {
	
        // 字符串穿插"#"，同时加头加尾防止越界
        StringBuilder sb = new StringBuilder("@#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        sb.append("$");
        
        int[] len = new int[sb.length()];
        int maxCenter = 0;  // 记录最大回文子串的中心位置
        int maxLength = 0;  // 记录最大回文子串的半径
        int id = 0;  // 记录当前计算过的右边界所属的回文子串中心
        int mx = 0;  // 记录当前计算过的右边界
        
        for (int i = 1; i < sb.length() - 1; i++) {
            len[i] = i < mx ? Math.min(len[2 * id - i], mx - i + 1) : 1;
            while (sb.charAt(i - len[i]) == sb.charAt(i + len[i]))
                len[i]++;
                
            if (mx < i + len[i] - 1) {
                mx = i + len[i] - 1;
                id = i;
            }
            if (maxLength < len[i]) {
                maxLength = len[i];
                maxCenter = i;
            }
        }
        return s.substring((maxCenter - maxLength) / 2, (maxCenter - maxLength) / 2 + maxLength - 1);
    }

/*动态规划*/
public String longestPalindromeDP(String s) {
	 
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    String res = "";
    for (int i = 0; i < n; i++){
        for (int j = 0; j <= i; j++){
            dp[j][i] = (j+1 > i-1 || dp[j+1][i-1]) && s.charAt(j) == s.charAt(i);
            if (dp[j][i] && res.length() < i - j + 1){
                res = s.substring(j, i+1);
            }
        }
    }
    return res;
}
}
