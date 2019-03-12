package math;

public class CountPrimes {
	public int countPrimes(int n) {
	    boolean[] notPrimes = new boolean[n + 1];
	    int count = 0;
	    for (int i = 2; i < n; i++) {
	        if (notPrimes[i]) {
	            continue;
	        }
	        count++;
	        // �� i * i ��ʼ����Ϊ��� k < i����ô k * i ��֮ǰ���Ѿ���ȥ������
	        for (long j = (long) (i) * i; j < n; j += i) {
	            notPrimes[(int) j] = true;
	        }
	    }
	    return count;
	    }
}
