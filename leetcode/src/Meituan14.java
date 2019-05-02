import java.io.IOException;
import java.util.*;
 
public class Meituan14 {
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        System.out.println(generate(s));
        sc.close();
    }
 
    private static String generate(int s) {
        StringBuilder sb = new StringBuilder();
        if (s % 3 == 1) sb.append(1);
        for (int i = 0; i < s / 3; i++) sb.append("21");
        if (s % 3 == 2) sb.append(2);
        return sb.toString();
    }
}

