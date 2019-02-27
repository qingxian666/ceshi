package Array;

public class TrapWater {
	public int trap(int[] A) {
	      final int n = A.length;
	      int peak_index = 0; // ��ߵ����ӣ��������Ϊ����
	        for (int i = 0; i < n; i++)
	            if (A[i] > A[peak_index]) peak_index = i;
	                int water = 0;
	        for (int i = 0, left_peak = 0; i < peak_index; i++) {
	            if (A[i] > left_peak) left_peak = A[i];
	            else water += left_peak - A[i];
	            }
	        for (int i = n - 1, right_peak = 0; i > peak_index; i--) {
	            if (A[i] > right_peak) right_peak = A[i];
	            else water += right_peak - A[i];
	            }
	        return water;
	    }
}
