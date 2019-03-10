package Search;

public class HIndex2 {
	/*设数组长度为n，那么n-i就是引用次数大于等于nums[i]的文章数。
	 * 如果nums[i]<n-i，说明i是有效的H-Index, 
	 * 如果一个数是H-Index，那么最大的H-Index一定在它后面（因为是升序的），根据这点就可以进行二分搜索了。*/
	public int hIndex(int[] citations) {
		//Time complexity: O(logn), Space complexity: O(1)
        int n=citations.length,res=0;
        for(int l=0,r=n-1; l<=r;){
            int mid=l+(r-l)/2;
            if(citations[mid]>=n-mid){
                res=n-mid;
                r=mid-1;
            } else{
                l=mid+1;
            }
        }
       return res; 
    }
}
