package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBallons {
	//���㲻�ص������������������ Non-overlapping Intervals ���������ڣ�[1, 2] �� [2, 3] �ڱ����������ص�����
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
