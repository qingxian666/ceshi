import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.*;
 

public class Meituan11 {
    public static void main(String[] args) throws IOException {
    		        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		        int n = Integer.parseInt(br.readLine());
    		 
    		        TreeMap<String, Integer> map = new TreeMap<>();
    		        for (int i = 0; i < n; i++) {
    		            String[] strs = br.readLine().split(" ");
    		            int x = Integer.parseInt(strs[1]), y = Integer.parseInt(strs[2]);
    		            double rate = 1.0 * y / x;
    		            if (rate <= 0.3) map.put(strs[0], 5);
    		            else if (rate <= 0.6) map.put(strs[0], 4);
    		            else map.put(strs[0], 3);
    		        }
    		 
    		        for (Map.Entry<String, Integer> entry : map.entrySet()) {
    		            System.out.println(entry.getKey() + " " + entry.getValue());
    		        }
    	}
}