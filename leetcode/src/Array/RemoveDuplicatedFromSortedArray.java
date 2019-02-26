package Array;

public class RemoveDuplicatedFromSortedArray {
	public int removeDuplicates(int[] nums) {
        int m=0;
        for(int i:nums)
            if(m==0||i>nums[m-1]){
                nums[m++]=i;
            }
        
        return m;
    }
}
