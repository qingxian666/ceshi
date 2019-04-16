package kuaishou;

import java.util.*;
import java.math.BigInteger;
public class Main2 {
	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();        
        int count=firstNonZero(n);
        System.out.println(count);
        BigInteger tail=bigNumber(n);
        System.out.println(tail);
        BigInteger b=new BigInteger("10");
        while(count!=0){
        	tail=tail.divide(b);
        	count--;
        }
        
        BigInteger[] bis = tail.divideAndRemainder(b);
		System.out.println(bis[1]);
     }

	
	private static int firstNonZero(int n) {
		// TODO Auto-generated method stub
		return n == 0 ? 0 : n / 5 + firstNonZero(n / 5); 
	}
	
	public static synchronized BigInteger bigNumber(int num){
		 
        ArrayList l = new ArrayList();
        l.add(BigInteger.valueOf(1));
        for (int i = l.size(); i <= num; i++) {
            BigInteger sofarhere = (BigInteger) l.get(i - 1);
            BigInteger next = sofarhere.multiply(BigInteger.valueOf(i));
            l.add(next);
        }
        return (BigInteger) l.get(num);
}
}
