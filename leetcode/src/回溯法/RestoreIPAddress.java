package ���ݷ�;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		List<String> ip = new ArrayList<>();; // ����м���
		dfs(s, ip, result, 0);
		return result;
		}
		/**
		* �����ַ���
		* @param[in] s �ַ�������������
		* @param[out] ip ����м���
		* @param[out] result ������п��ܵ�IP��ַ
		* @param[in] start ��ǰ���ڴ���� index
		* @return ��
		*/
		private static void dfs(String s, List<String> ip,List<String> result, int start) {
		if (ip.size() == 4 && start == s.length()) { // �ҵ�һ���Ϸ���
			result.add(ip.get(0) + '.' + ip.get(1) + '.' + ip.get(2) + '.' + ip.get(3));
			return;
		}
		
		if (s.length() - start > (4 - ip.size()) * 3)
			return; // ��֦
		
		if (s.length() - start < (4 - ip.size()))
			return; // ��֦
		
		int num = 0;
		for (int i = start; i < start + 3 && i < s.length(); i++) {
			num = num * 10 + (s.charAt(i) - '0');
			if (num < 0 || num > 255) continue; // ��֦
			
			ip.add(s.substring(start, i + 1));
			dfs(s, ip, result, i + 1);
			ip.remove(ip.size() - 1);
			
			if (num == 0) break; // ������ǰ׺0����������0
		 }
		}
		public static void main(String[] args) {
			RestoreIPAddress s = new RestoreIPAddress();
			s.restoreIpAddresses("1111");
		}
}
