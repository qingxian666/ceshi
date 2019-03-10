package Sort;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		/*堆排序，维护一个k大小的小根堆，将数组中的每个元素与堆顶元素进行比较，
		 * 如果比堆顶元素大，则删除堆顶元素并添加该元素，
		 * 如果比堆顶元素小，则什么也不做，继续下一个元素。
		 * 时间复杂度O(nlogk)，空间复杂度O(k)。*/
        final Queue<Integer> q = new PriorityQueue<>();

        for (int x : nums) {
            if (q.size() < k) {
                q.offer(x);
            } else {
                final int top = q.peek();
                if (x > top) {
                    q.poll();
                    q.offer(x);
                }
            }
        }
        return q.peek();
    }
}
