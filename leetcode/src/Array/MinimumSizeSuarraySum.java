package Array;

public class MinimumSizeSuarraySum {
	public int minSubArrayLen(int s, int[] a) {
	     if (a == null || a.length == 0)
	     return 0;
	  
	     int i = 0, j = 0, sum = 0, min = a.length+1;
	  
	     while (j < a.length) {
	    sum += a[j++];
	    while (sum >= s) {
	      min = Math.min(min, j - i);
	      sum -= a[i++];
	    }
	  }
	  
	  return min == a.length+1 ? 0 : min;
	 }
}
