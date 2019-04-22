import java.util.*;

public class NetEase5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x =sc.nextInt();
		int f =sc.nextInt();
		int d =sc.nextInt();
		int p =sc.nextInt();
		if(d - x * f < 0) System.out.println(d/x);
		else{
			System.out.println((d - x *f)/(x+p)+f);
		}
	}

}
