import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
 

public class meituan1 {
	//��������
    //��Ⱦ�����ĵ�Ϊtrue, δ��Ⱦ��Ϊfalse
    static boolean[] infected;
    static ArrayList<Integer>[] graph;
    static int n, m, k, t;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        infected = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
         
        //��ͼ
        for (int i = 0; i < m; i++) {
            strs = br.readLine().split(" ");
            int u = Integer.parseInt(strs[0]), v = Integer.parseInt(strs[1]);
            graph[u].add(v);
            graph[v].add(u);
        }
 
        strs = br.readLine().split(" ");
        k = Integer.parseInt(strs[0]);
        t = Integer.parseInt(strs[1]);
        for (String s : br.readLine().split(" ")) {
            infected[Integer.parseInt(s)] = true;
        }
 
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (infected[i] && bfs(i)) {
                System.out.print((res++ > 0 ? " " : "") + i);
            }
        }
        System.out.println((res == 0) ? "-1" : "");
    }
 
    //��xΪ��㴫��t��Ľ����ʵ�ʽ���Ƚ��Ƿ���ͬ
    private static boolean bfs(int x) {
        //ÿ���㱻��Ⱦ��Ҫ��ʱ��, Ϊ0����û�б���Ⱦ
        int[] cost = new int[n + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        cost[x] = 1;
        queue.offer(x);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cost[cur] > t) break;
            for (Integer e : graph[cur]) {
                if (cost[e] == 0) {
                    cost[e] = cost[cur] + 1;
                    queue.offer(e);
                }
            }
        }
 
        for (int i = 1; i <= n; i++) {
            if (!infected[i] && cost[i] != 0) return false;
            if (infected[i] && cost[i] == 0) return false;
        }
        return true;
    }
}