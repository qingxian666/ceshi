import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class meituan2 {
    static ArrayList<Integer>[] graph;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]), m = Integer.parseInt(strs[1]);
        graph = new ArrayList[n + m + 1];
 
        //��ͼ, �������������һ��վ��, ֻ��¼����������Ӧվ��ı�
        for (int i = 1; i <= m; i++) {
            strs = br.readLine().split(" ");
            graph[i + n] = new ArrayList<>();
            for (int j = 1; j < strs.length; j++) {
                int station = Integer.parseInt(strs[j]);
                if (graph[station] == null) graph[station] = new ArrayList<>();
                graph[station].add(i + n);
                graph[i + n].add(station);
            }
        }
 
        //bfs�����·, 
        int res = bfs(1, n, m);
        //��Ϊ�����˳����,����������Ϊ1,����ÿ����ľ�����ʵ�ʾ����������һ
        System.out.println(res == 0 ? "-1" : res / 2);
    }
 
    private static int bfs(int x, int n, int m) {
        int[] dist = new int[n + m + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        dist[x] = 1;
        queue.offer(x);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer e : graph[cur]) {
                if (dist[e] == 0) {
                    dist[e] = dist[cur] + 1;
                    queue.offer(e);
                }
            }
        }
        return dist[n];
    }
}
