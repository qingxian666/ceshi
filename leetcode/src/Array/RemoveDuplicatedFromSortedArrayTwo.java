package Array;

public class RemoveDuplicatedFromSortedArrayTwo {
	int removeDuplicates(int nums[]) {
        int m=0;
        for(int i:nums)
            if(m==0||m==1||i>nums[m-2]){
                nums[m++]=i;
            }
        
        return m;
    }
}
