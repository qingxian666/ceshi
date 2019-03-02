package String;

import java.util.*;

public class SimplifyPath {
	/*������Ҫ���Ǽ�һ��Unix����µ��ļ��ľ���·����

�ַ�����������".."�Ƿ����ϼ�Ŀ¼������Ǹ�Ŀ¼�򲻴�������˿��Կ�����ջ��¼·�������Ա��ڴ�����Ҫע�⼸��ϸ�ڣ�

�ظ��������ֵ�'/'��ֻ��1�������������ظ��������ֵ�'/'��
���·������"."���򲻴���
���·������".."������Ҫ��ջ�����ջΪ�գ���������
���·����Ϊ�����ַ�������ջ��
��������ȡ��ջ��Ԫ�أ����ѱ����·����������'/'�ָ�����������������Ҫע��˳���ϡ�
˼·��

1. ���ַ�������/�����֣��������顣

2. ����������ַ�����ջ�����������..�����ջ��

3. ���ջ��ʣ���ַ�����"/"���ӣ������ء�δ��Ĭ�Ϸ��ء�/��*/
	// Simplify Path
	// ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(n)
	    public String simplifyPath(String path) {
	        Stack<String> dirs = new Stack<>();

	        for (int i = 0; i < path.length();) {
	            ++i;

	            int j = path.indexOf('/', i);
	            if (j < 0) j = path.length();
	            final String dir = path.substring(i, j);

	            // �������� '///'ʱ��dir Ϊ��
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
