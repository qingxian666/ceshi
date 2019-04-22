import java.util.*;

public class Pdd3 {
	public static void main(String[] args){
		
        Scanner  sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h[] = new int[n];
        for(int i=0; i<n; i++){
        	h[i] = sc.nextInt();
        	
        }
        int m = sc.nextInt();
        int w[] = new int[m];
        for(int i=0; i<m; i++){
        	w[i] = sc.nextInt();
        }
        Arrays.sort(h);
        Arrays.sort(w);
        
       // System.out.println(maxChild(n,h,m,w));
        int res=0;
        int i=0,j=0;
        while(i <n && j<m){
        	if(w[j]>=h[i]){
        		res++;
        		j++;
        		i++;
        	} else{
        		j++;
        	}
        }
        System.out.println(res);
	}
        private static int maxChild(int n, int[] h, int m, int[] w){
            if (n == 0 || m == 0)
                return 0;
            Arrays.sort(h);//对h和w进行从小到达的
            Arrays.sort(w);
            int max = 0;
            int i = 0;  //指向小朋友
            int j = 0;  //指向巧克力
            while(i < n && j < m){
                if(w[j] >= h[i]){
                    max++;
                    i++;
                }
                j++;
            }
            return max;
        }
}
/*import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = sc.nextInt();
        }
        Arrays.sort(h);
        Arrays.sort(w);
        int pos = n - 1;
        int res = 0;
        for (int j = m - 1; j >= 0; j--) {
            for (int i = pos; i >= 0; i--) {
                if (w[j] >= h[i]) {
                    res++;
                    pos = i-1;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}*/
