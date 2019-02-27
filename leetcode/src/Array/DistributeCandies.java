package Array;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
	public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) kinds.add(candy);
        return Math.min(candies.length / 2 , kinds.size()) ;
    }
}
