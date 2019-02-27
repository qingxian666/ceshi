package Array;

import java.util.TreeSet;

public class ContainDuplicateThree {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            final int x = nums[i];
            final Integer floor = set.floor(x);
            final Integer ceiling = set.ceiling(x);
            if ((floor != null && x <= floor + t) || (ceiling != null && x >= ceiling -t))
                return true;

            set.add(x);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}
