package Array;

public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
	    int max = 0, cur = 0;
	    for (int x : nums) {
	        cur = x == 0 ? 0 : cur + 1;
	        max = Math.max(max, cur);
	    }
	    return max;
	}
}
