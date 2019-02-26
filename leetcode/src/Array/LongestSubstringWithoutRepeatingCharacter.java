package Array;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacter {
	public int lengthOfLongestSubstring(String s) {
	       int res = 0, lo = 0, hi = 0;
	        HashSet<Character> t = new HashSet<Character>();
	        while (hi < s.length()) {
	            if (!t.contains(s.charAt(hi))) {
	                t.add(s.charAt(hi++));
	                res = Math.max(res, t.size());
	            } else {
	                t.remove(s.charAt(lo++));
	            }
	        }
	        return res;
	    }
}
