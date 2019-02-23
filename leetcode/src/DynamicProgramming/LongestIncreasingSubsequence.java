package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
/*这是一个多阶段决策问题，求最长，是一个最优化问题，用 BFS, 贪心或DP。
如果用BFS，首先用数组中的所有元素作为根节点，形成n颗树，每棵树开始往下扩展，出现逆序则终止，
最后计算每棵树的高度，取最大，就是最终结果。算法复杂度为 O(n!) 。
本题中，一个节点往下扩展的时候，没有一个确定的准则，让你走哪些边，本题不具有贪心选择性质，因
此不能用贪心法。
我们来尝试用DP来解决这题。最重要的是要定义出状态。首先从状态扩展这方面看，对于数组中的一个元
素，它往后走，凡是比它大的元素，都可以作为下一步，因此这里找不到突破口。
我们换一个角度，从结果来入手，我们要求的最长递增子序列，一个递增子序列，肯定是有首尾两个端点
的，假设我们定义 f[i] 为以第 i 个元素为起点的最长递增子序列，那么 f[i] 和 f[j] 之间没有必然联
系，这个状态不好用。
假设定义 f[i] 为以第 i 个元素为终点的最长递增子序列，那么如果 i<j 且 nums[i]<nums[j] ，
则 f[i] 一定是 f[j] 的前缀。这个状态能表示子问题之间的关系，可以接着深入下去。
现在正式开始定义，我们定义状态 f[i] 为第 i 个元素为终点的最长递增子序列的长度，那么状态转移方
程是
f[j] = max{f[i], 0 <= i < j && f[i] < f[j]} + 1
*/
	 public int lengthOfLIS(int[] nums) {
		    if (nums == null || nums.length == 0) return 0;
		    
		    // f[i]表示以i结尾的最长递增子序列的长度
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
 /*本题最后有一个进阶问题，能不能 O(n log n) 解决？有。
维护一个单调递增序列，遍历数组，二分查找每一个数在单调序列中的位置，然后替换之。
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
