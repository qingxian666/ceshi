package ���ݷ�;

import java.util.*;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();  // һ��partition����
        dfs(s, path, result, 0);
        return result;
    }
    // ����������s[start]��ͷ��partition����
    private static void dfs(String s, List<String> path,
                            List<List<String>> result, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) { // ��iλ�ÿ�һ��
                path.add(s.substring(start, i+1));
                dfs(s, path, result, i + 1);  // �������¿�
                path.remove(path.size() - 1); // ����������
            }
        }
    }
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end && s.charAt(start) == s.charAt(end)) {
            ++start;
            --end;
        }
        return start >= end;
    }
}
