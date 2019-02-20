package DynamicProgramming;

public class FibonacciNumber {
	public int fib(int N) {
        if(N<1) return 0;
       int[] fibonacci = new int[2];
       fibonacci[0] = 1;
       fibonacci[1] = 1;
       N-=2;
       while(N>0){
           int temp = fibonacci[0]+fibonacci[1];
           fibonacci[0] = fibonacci[1];
           fibonacci[1] = temp;
           N--;
       }
       return fibonacci[1];
   }
}
