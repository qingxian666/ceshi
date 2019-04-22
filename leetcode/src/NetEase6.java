import java.util.*;

public class NetEase6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int X[] = new int[n];
		int Y[] = new int[n];
		for(int i =0; i < n; i++){
			X[i] = sc.nextInt();
		}
		for(int i =0; i < n; i++){
			Y[i] = sc.nextInt();
		}
		int []distance = new int[n];
		int[] result = new int[n];
		for(int i =0; i < n; i++){
			result[i] = Integer.MAX_VALUE;
		}
		for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                for(int k = 0;k< n;k++){
                    distance[k] = Math.abs(X[k] - X[i]) + Math.abs(Y[k] - Y[j]);
                }
                Arrays.sort(distance);
                int temp = 0;
                for(int m = 0;m<n;m++){
                    temp += distance[m];
                    result[m] = Math.min(result[m], temp);
                    
                }
                
            }
        }
		 for(int i = 0;i<n-1;i++)
	            System.out.print(result[i]+" ");
	        	System.out.print(result[n-1]);
	}
}
