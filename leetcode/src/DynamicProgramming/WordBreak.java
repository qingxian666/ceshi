package DynamicProgramming;

import java.util.*;

public class WordBreak {
	public boolean wordBreak(String s, List<String> dict) {
		//涉及顺序的完全背包问题，对物品的迭代应放在最里层
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i=1; i <= s.length(); i++){
            for (String word : dict) {   // 对物品的迭代应该放在最里层
            int len = word.length();
            if (len <= i && word.equals(s.substring(i - len, i))) {
                dp[i] = dp[i] || dp[i - len];
            }
        }
    }
        
        return dp[s.length()];
    }
}
