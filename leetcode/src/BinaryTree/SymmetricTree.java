package BinaryTree;

import java.util.*;

public class SymmetricTree {
	 public boolean isSymmetric(TreeNode root) {
		 //�ݹ�棬ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(logn)
	        if (root == null) return true;
	        return isSymmetric(root.left, root.right);
	    }
	    private static boolean isSymmetric(TreeNode p, TreeNode q) {
	        if (p == null && q == null) return true;   // ��ֹ����
	        if (p == null || q == null) return false;  // ��ֹ����
	        return p.val == q.val      // �����ϲ�
	                && isSymmetric(p.left, q.right)
	                && isSymmetric(p.right, q.left);
	    }
	    
	    public boolean isSymmetric2 (TreeNode root) {
	    	//�����棬ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(logn)
	        if (root == null) return true;

	        Stack<TreeNode> s = new Stack<>();
	        s.push(root.left);
	        s.push(root.right);

	        while (!s.isEmpty()) {
	            TreeNode p = s.pop ();
	            TreeNode q = s.pop ();

	            if (p == null && q == null) continue;
	            if (p == null || q == null) return false;
	            if (p.val != q.val) return false;

	            s.push(p.left);
	            s.push(q.right);

	            s.push(p.right);
	            s.push(q.left);
	        }

	        return true;
	    }
}
