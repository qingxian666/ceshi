package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBallons {
	//计算不重叠的区间个数，不过和 Non-overlapping Intervals 的区别在于，[1, 2] 和 [2, 3] 在本题中算是重叠区间
	public int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int cnt=1;
        int end =points[0][1];
        for(int i=0;i<points.length; i++){
            if(points[i][0]<=end){
                 continue;
            }
            end=points[i][1];
            cnt++;
        }
        return cnt;
    }
}
