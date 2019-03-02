package String;

import java.util.*;

public class SimplifyPath {
	/*这道题的要求是简化一个Unix风格下的文件的绝对路径。

字符串处理，由于".."是返回上级目录（如果是根目录则不处理），因此可以考虑用栈记录路径名，以便于处理。需要注意几个细节：

重复连续出现的'/'，只按1个处理，即跳过重复连续出现的'/'；
如果路径名是"."，则不处理；
如果路径名是".."，则需要弹栈，如果栈为空，则不做处理；
如果路径名为其他字符串，入栈。
最后，再逐个取出栈中元素（即已保存的路径名），用'/'分隔并连接起来，不过要注意顺序呦。
思路：

1. 将字符串按“/”划分，存入数组。

2. 将有意义的字符串入栈，如果遇到“..”则出栈。

3. 最后将栈中剩余字符串以"/"连接，并返回。未空默认返回“/”*/
	// Simplify Path
	// 时间复杂度O(n)，空间复杂度O(n)
	    public String simplifyPath(String path) {
	        Stack<String> dirs = new Stack<>();

	        for (int i = 0; i < path.length();) {
	            ++i;

	            int j = path.indexOf('/', i);
	            if (j < 0) j = path.length();
	            final String dir = path.substring(i, j);

	            // 当有连续 '///'时，dir 为空
	            if (!dir.isEmpty() && !dir.equals(".")) {
	                if (dir.equals("..")) {
	                    if (!dirs.isEmpty())
	                        dirs.pop();
	                } else {
	                    dirs.push(dir);
	                }
	            }

	            i = j;
	        }

	        StringBuilder result = new StringBuilder();
	        if (dirs.isEmpty()) {
	            result.append('/');
	        } else {
	            for (final String dir : dirs) {
	                result.append('/').append(dir);
	            }
	        }
	        return result.toString();
	    }
	
}
