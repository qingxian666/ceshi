package Array;

import java.util.Arrays;

public class SetMismatch {
	 public int[] findErrorNums(int[] nums) {
	    	int[] res = new int[2];
	        // �������
	    	if(nums == null || nums.length == 0) {
	    		return res;
	    	}
	    	// ��¼nums����ĺ�
	    	int sum = 0;
	    	int[] temp = new int[nums.length + 1];
	        // ��nums�����еĵ�i����nums[i]����temp������
	        // ��nums[i]���������λ��
	    	for(int i = 0; i < nums.length; ++i) {
	                // ���������λ��û����ֵ
	    		if(temp[nums[i]] == 0) {
	                        // ��nums[i]�����λ��
	    			temp[nums[i]] = nums[i];
	                // ����������Ѿ���ֵ�ˣ�˵����ǰ��nums[i]Ϊ�ظ�ֵ
	    		}else {
	                        // res�����¼���ظ�ֵ
	    			res[0] = nums[i];
	    		}
	    		// ��¼nums����ĺ�
	    		sum += nums[i];
	    	}
	    	
	    	int n = nums.length;
	        // ��δ��ʧԪ��ǰ������ĺ�
	    	int nSum = ((1 + n) * n)/2;
	        // ȱ�ٵ�ֵ���� δ��ʧԪ��ǰ������ĺ� - ��������ĺ� + �ظ���ֵ
	    	res[1] = nSum - sum + res[0];
	    	
	    	return res;
	    }
}
