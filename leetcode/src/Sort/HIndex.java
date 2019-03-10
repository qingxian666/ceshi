package Sort;

public class HIndex {
	public int hIndex(int[] citations) {
		//����������ΪH-Index��󲻿��ܳ���������������������ֻ��Ҫ��һ������Ϊn+1�����飬���ĳƪ���ĵ�������������n���ͽ��䵱��n
        final int n = citations.length + 1;
        final int[] histogram = new int[n+1];

        for (int x : citations) {
            ++histogram[x > n ? n : x];
        }

        int sum = 0; // current number of papers
        for (int i = n; i > 0; --i) {
            sum += histogram[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
