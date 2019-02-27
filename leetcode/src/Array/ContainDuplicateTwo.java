package Array;

import java.util.Map;
import java.util.HashMap;

public class ContainDuplicateTwo {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
	       final Map<Integer, Integer> hp = new HashMap<>();
	       int min = Integer.MAX_VALUE;
	        
		        for (int i=0;i<nums.length;i++) {
		            if (hp.containsKey(nums[i])) {
		                final int preIndex = hp.get(nums[i]);
	                    final int gap = i - preIndex;
	                    min = Math.min(min, gap);
		        } 
		            hp.put(nums[i],i);
		       
		    }
		        return min<=k;
		    
	    }
}
