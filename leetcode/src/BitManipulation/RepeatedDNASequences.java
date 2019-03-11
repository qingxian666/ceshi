package BitManipulation;

import java.util.*;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		//滑动窗口+Set不能添加重复元素的特性
        Set seen = new HashSet(), repeated = new HashSet();
        for (int i = 0; i + 9 < s.length(); i++) {
        String ten = s.substring(i, i + 10);
        if (!seen.add(ten))
          repeated.add(ten);
      }
  return new ArrayList(repeated);
  }
}
