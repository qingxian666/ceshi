import java.util.*;

public class Meituan7 {
	public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
		    int n=sc.nextInt(), A=sc.nextInt(), B=sc.nextInt(), i, j, maxVal=0;
		    int bagA[]=new int[A+1], bagB[]=new int[B+1], ansA[]=new int [n+2],
		        ansB[]=new int[n+2], v[]=new int[n+1], w[]=new int[n+1];
		    for (i = 1; i <= n; ++i) {
		      v[i] = sc.nextInt();
		      w[i] = sc.nextInt();
		      for (j = A; j >= v[i]; --j)
		        bagA[j] = Math.max(bagA[j], bagA[j-v[i]] + w[i]);
		      ansA[i] = bagA[A];
		    }
		    for (i = n; i > 0; --i) {
		      for (j = B; j >= v[i]; --j)
		        bagB[j] = Math.max(bagB[j], bagB[j-v[i]] + w[i]);
		      ansB[i] = bagB[B];
		    }
		    for (i = 0; i <= n; ++i)
		      maxVal = Math.max(maxVal, ansA[i] + ansB[i+1]);
		    System.out.println(maxVal);
		  }
		
}
