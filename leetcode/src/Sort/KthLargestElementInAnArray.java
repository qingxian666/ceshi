package Sort;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		/*������ά��һ��k��С��С���ѣ��������е�ÿ��Ԫ����Ѷ�Ԫ�ؽ��бȽϣ�
		 * ����ȶѶ�Ԫ�ش���ɾ���Ѷ�Ԫ�ز���Ӹ�Ԫ�أ�
		 * ����ȶѶ�Ԫ��С����ʲôҲ������������һ��Ԫ�ء�
		 * ʱ�临�Ӷ�O(nlogk)���ռ临�Ӷ�O(k)��*/
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
