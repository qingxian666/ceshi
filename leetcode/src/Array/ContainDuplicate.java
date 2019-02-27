package Array;

import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {
	 public boolean containsDuplicate(int[] nums) {
	        final Set<Integer> existed = new HashSet<>();
	        for (int x : nums) {
	            if (existed.contains(x)) {
	                return true;
	        } else {
	            existed.add(x);
	        }
	    }
	        return false;
	    }
}
