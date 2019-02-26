package Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
//����ѡ�� ��ʱ�临�Ӷ� O(N)���ռ临�Ӷ� O(1)
	public int findKthLargest(int[] nums, int k) {
	    k = nums.length - k;
	    int l = 0, h = nums.length - 1;
	    while (l < h) {
	        int j = partition(nums, l, h);
	        if (j == k) {
	            break;
	        } else if (j < k) {
	            l = j + 1;
	        } else {
	            h = j - 1;
	        }
	    }
	    return nums[k];
	}

	private int partition(int[] a, int l, int h) {
	    int i = l, j = h + 1;
	    while (true) {
	        while (a[++i] < a[l] && i < h) ;
	        while (a[--j] > a[l] && j > l) ;
	        if (i >= j) {
	            break;
	        }
	        swap(a, i, j);
	    }
	    swap(a, l, j);
	    return j;
	}

	private void swap(int[] a, int i, int j) {
	    int t = a[i];
	    a[i] = a[j];
	    a[j] = t;
	}
	//������ ��ʱ�临�Ӷ� O(NlogK)���ռ临�Ӷ� O(K)��

public int findKthLargest2(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // С����
    for (int val : nums) {
        pq.add(val);
        if (pq.size() > k)  // ά���ѵĴ�СΪ K
            pq.poll();
    }
    return pq.peek();
}
//���� ��ʱ�临�Ӷ� O(NlogN)���ռ临�Ӷ� O(1)

public int findKthLargest3(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
}
}
