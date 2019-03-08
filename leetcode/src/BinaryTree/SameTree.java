package BinaryTree;

import java.util.*;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		// �ݹ�棬ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(logn)
        if (p == null && q == null) return true;   // ��ֹ����
        if (p == null || q == null) return false;  // ��֦
        return p.val == q.val      // �����ϲ�
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
	
	 public boolean isSameTree2(TreeNode p, TreeNode q) {
		 //�����棬ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(logn)
	        Stack<TreeNode> s = new Stack<>();
	        s.push(p);
	        s.push(q);

	        while(!s.empty()) {
	            p = s.pop();
	            q = s.pop();

	            if (p == null && q == null) continue;
	            if (p == null || q == null) return false;
	            if (p.val != q.val) return false;

	            s.push(p.left);
	            s.push(q.left);

	            s.push(p.right);
	            s.push(q.right);
	        }
	        return true;
	    }
}
