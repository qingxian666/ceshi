package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
	 public int eraseOverlapIntervals(Interval[] intervals) {
		    if (intervals.length == 0) {
		        return 0;
		    }
		    /*ʹ��lamba���ʽ�ᵼ������ʱ��䳤���ɸ�Ϊ��ͨ��comparator
		    
		     Arrays.sort(intervals, new Comparator<Interval>() {
             @Override
    		public int compare(Interval o1, Interval o2) {
        	return o1.end - o2.end;
    		}
		});
*/
		    Arrays.sort(intervals, Comparator.comparingInt(o -> o.end));
		    int cnt = 1;
		    int end = intervals[0].end;
		    for (int i = 1; i < intervals.length; i++) {
		        if (intervals[i].start < end) {
		            continue;
		        }
		        end = intervals[i].end;
		        cnt++;
		    }
		    return intervals.length - cnt;
		  }
}

