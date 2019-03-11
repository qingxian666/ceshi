package »ØËİ·¨;

import java.util.*;

public class Combinations {
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		backtrack(list, new ArrayList<Integer>(), 1, n, k);
		return list;
	}
	public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int start, int n, int k) {
		if(k==0) {
			list.add(new ArrayList<Integer>(tempList));
			return;
		}
		for(int i=start;i<=n;i++) {
			tempList.add(i);
			backtrack(list, tempList, i+1, n, k-1);
			tempList.remove(tempList.size()-1);
		}
	}
}
