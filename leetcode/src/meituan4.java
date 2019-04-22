import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
public class meituan4 {
    static boolean[][] arrive;
    static int[] out;
    static int[] in;
    static ArrayList<Integer>[] graph;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]), m = Integer.parseInt(strs[1]);
        arrive = new boolean[n + 1][n + 1];
        out  = new int[n + 1];
        in = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
  
        for (int i = 0; i < m; i++) {
            strs = br.readLine().split(" ");
            int u = Integer.parseInt(strs[0]), v = Integer.parseInt(strs[1]);
            graph[u].add(v);
        }
  
        for (int i = 1; i <= n; i++) bfs(i);
         
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arrive[i][j]) {
                    out[i]++;
                    in[j]++;
                }
            }
        }
  
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (in[i] > out[i]) res++;
        }
        System.out.println(res);
    }
  
    private static void bfs(int i) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(i);
        arrive[i][i] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer e : graph[cur]) {
                if (!arrive[i][e]) {
                    arrive[i][e] = true;
                    queue.offer(e);
                }
            }
        }
    }
}