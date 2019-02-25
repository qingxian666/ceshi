package greedy;

public class ContainWithMostWater {
	public int maxArea(int[] height) {
        int mostArea = 0;
        int i = 0;
        int j = height.length - 1;
        while(i < j){
            if(height[i] <= height[j]){
                mostArea = Math.max(mostArea,(j - i)*height[i]);
                i++;
            }else{
                mostArea = Math.max(mostArea,(j - i)*height[j]);
                j--;
            }
        }
        return mostArea;
    }
}
