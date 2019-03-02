package String;

public class ValidAnagrams {
	public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        final int[] map = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            ++map[s.charAt(i) - 'a'];
            --map[t.charAt(i) - 'a'];
        }
        for (int x : map) {
            if (x != 0) return false;
        }
        return true;
    }
}
