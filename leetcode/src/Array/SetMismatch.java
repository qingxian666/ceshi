package Array;

import java.util.Arrays;

public class SetMismatch {
	 public int[] findErrorNums(int[] nums) {
	    	int[] res = new int[2];
	        // 参数检查
	    	if(nums == null || nums.length == 0) {
	    		return res;
	    	}
	    	// 记录nums数组的和
	    	int sum = 0;
	    	int[] temp = new int[nums.length + 1];
	        // 将nums数组中的第i个数nums[i]当作temp的索引
	        // 将nums[i]存入该索引位置
	    	for(int i = 0; i < nums.length; ++i) {
	                // 如果该索引位置没被赋值
	    		if(temp[nums[i]] == 0) {
	                        // 将nums[i]存入该位置
	    			temp[nums[i]] = nums[i];
	                // 如果该索引已经有值了，说明当前的nums[i]为重复值
	    		}else {
	                        // res数组记录该重复值
	    			res[0] = nums[i];
	    		}
	    		// 记录nums数组的和
	    		sum += nums[i];
	    	}
	    	
	    	int n = nums.length;
	        // 求未丢失元素前的数组的和
	    	int nSum = ((1 + n) * n)/2;
	        // 缺少的值等于 未丢失元素前的数组的和 - 现在数组的和 + 重复的值
	    	res[1] = nSum - sum + res[0];
	    	
	    	return res;
	    }
}
