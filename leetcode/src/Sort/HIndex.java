package Sort;

public class HIndex {
	public int hIndex(int[] citations) {
		//计数排序，因为H-Index最大不可能超过论文综述，所以我们只需要开一个长度为n+1的数组，如果某篇论文的引用数超过了n，就将其当做n
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
