package Search;

public class HIndex2 {
	/*�����鳤��Ϊn����ôn-i�������ô������ڵ���nums[i]����������
	 * ���nums[i]<n-i��˵��i����Ч��H-Index, 
	 * ���һ������H-Index����ô����H-Indexһ���������棨��Ϊ������ģ����������Ϳ��Խ��ж��������ˡ�*/
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
