package BitManipulation;

public class BitWiseANDofNumbersRange {
	 public int rangeBitwiseAnd(int m, int n) {
	        int mask = Integer.MAX_VALUE;

	        while ((m & mask) != (n & mask)) {
	            mask = mask << 1;
	        }
	        return m & mask;
	      
	    }
}
