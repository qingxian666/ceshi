package DynamicProgramming;

import java.util.*;

public class WordBreak {
	public boolean wordBreak(String s, List<String> dict) {
		//�漰˳�����ȫ�������⣬����Ʒ�ĵ���Ӧ���������
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i=1; i <= s.length(); i++){
            for (String word : dict) {   // ����Ʒ�ĵ���Ӧ�÷��������
            int len = word.length();
            if (len <= i && word.equals(s.substring(i - len, i))) {
                dp[i] = dp[i] || dp[i - len];
            }
        }
    }
        
        return dp[s.length()];
    }
}
