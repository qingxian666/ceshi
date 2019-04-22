import java.util.*;

public class NetEase7 {
	public static void main(String[] args){
		Scanner  sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []nums = new int[n];
		for(int i =0 ; i < n ; i ++){
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		int sum = 0;
		int min = nums[0];      // ��һ�μ�������е��Ǹ���Сֵ
        int max = nums[n - 1];  // ��һ�μ�������е��Ǹ����ֵ
        int diff = max - min;
        int minIndex = 1;       // δ��������е���Сֵ����
        int maxIndex = n - 2;   // δ��������е����ֵ����
        while (minIndex < maxIndex) {
            diff += max - nums[minIndex];
            diff += nums[maxIndex] - min;
            min = nums[minIndex++];
            max = nums[maxIndex--];
        }
        // ԭ���������һ���� minIndex == maxIndex�������ŵ����ʵ�λ����
        diff += Math.max(nums[maxIndex] - min, max - nums[minIndex]);
        System.out.println(diff);
	}
}
