import java.io.IOException;
import java.util.*;
 

public class Meituan12 {
		public static void main(String[] args) throws IOException {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	 
	        boolean[] flag = new boolean[n + 1];
	        LinkedList<Integer> stack = new LinkedList<>();
	        for (int i = 0; i < m; i++) {
	            int k = sc.nextInt();
	            stack.push(k);
	            flag[k] = true;
	        }
	        sc.close();
	        boolean[] visited = new boolean[n + 1];
	        StringBuilder sb = new StringBuilder();
	        while (!stack.isEmpty()) {
	            int k = stack.pop();
	            if (!visited[k]) sb.append(k).append("\n");
	            visited[k] = true;
	        }
	        for (int i = 1; i <= n; i++) {
	            if (!flag[i]) sb.append(i).append("\n");
	        }
	        System.out.print(sb);
	    }
}