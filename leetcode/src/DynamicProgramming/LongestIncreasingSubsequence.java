package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
/*����һ����׶ξ������⣬�������һ�����Ż����⣬�� BFS, ̰�Ļ�DP��
�����BFS�������������е�����Ԫ����Ϊ���ڵ㣬�γ�n������ÿ������ʼ������չ��������������ֹ��
������ÿ�����ĸ߶ȣ�ȡ��󣬾������ս�����㷨���Ӷ�Ϊ O(n!) ��
�����У�һ���ڵ�������չ��ʱ��û��һ��ȷ����׼����������Щ�ߣ����ⲻ����̰��ѡ�����ʣ���
�˲�����̰�ķ���
������������DP��������⡣����Ҫ����Ҫ�����״̬�����ȴ�״̬��չ�ⷽ�濴�����������е�һ��Ԫ
�أ��������ߣ����Ǳ������Ԫ�أ���������Ϊ��һ������������Ҳ���ͻ�ƿڡ�
���ǻ�һ���Ƕȣ��ӽ�������֣�����Ҫ�������������У�һ�����������У��϶�������β�����˵�
�ģ��������Ƕ��� f[i] Ϊ�Ե� i ��Ԫ��Ϊ��������������У���ô f[i] �� f[j] ֮��û�б�Ȼ��
ϵ�����״̬�����á�
���趨�� f[i] Ϊ�Ե� i ��Ԫ��Ϊ�յ������������У���ô��� i<j �� nums[i]<nums[j] ��
�� f[i] һ���� f[j] ��ǰ׺�����״̬�ܱ�ʾ������֮��Ĺ�ϵ�����Խ���������ȥ��
������ʽ��ʼ���壬���Ƕ���״̬ f[i] Ϊ�� i ��Ԫ��Ϊ�յ������������еĳ��ȣ���ô״̬ת�Ʒ�
����
f[j] = max{f[i], 0 <= i < j && f[i] < f[j]} + 1
*/
	 public int lengthOfLIS(int[] nums) {
		    if (nums == null || nums.length == 0) return 0;
		    
		    // f[i]��ʾ��i��β������������еĳ���
		        int[] f = new int[nums.length];
		        Arrays.fill(f, 1);
		        int global = 1;
		        for (int j = 1; j < nums.length; ++j) {
		            for (int i = 0; i < j; ++i) {
		                if (nums[i] < nums[j]) {
		                    f[j] = Math.max(f[j], f[i] + 1);
		                }
		            }
		        global = Math.max(global, f[j]);
		     }
		        return global;
		  }
 /*���������һ���������⣬�ܲ��� O(n log n) ������С�
ά��һ�������������У��������飬���ֲ���ÿһ�����ڵ��������е�λ�ã�Ȼ���滻֮��
*/
	 public int lengthOfLISInsertPosition(int[] nums) {
		    int n = nums.length;
		    int[] tails = new int[n];
		    int len = 0;
		    for (int num : nums) {
		        int index = binarySearch(tails, len, num);
		        tails[index] = num;
		        if (index == len) {
		            len++;
		        }
		    }
		    return len;
		}

		private int binarySearch(int[] tails, int len, int key) {
		    int l = 0, h = len;
		    while (l < h) {
		        int mid = l + (h - l) / 2;
		        if (tails[mid] == key) {
		            return mid;
		        } else if (tails[mid] > key) {
		            h = mid;
		        } else {
		            l = mid + 1;
		        }
		    }
		    return l;
		}
}
