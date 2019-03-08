package BinaryTree;

import java.util.*;

public class SymmetricTree {
	 public boolean isSymmetric(TreeNode root) {
		 //递归版，时间复杂度O(n)，空间复杂度O(logn)
	        if (root == null) return true;
	        return isSymmetric(root.left, root.right);
	    }
	    private static boolean isSymmetric(TreeNode p, TreeNode q) {
	        if (p == null && q == null) return true;   // 终止条件
	        if (p == null || q == null) return false;  // 终止条件
	        return p.val == q.val      // 三方合并
	                && isSymmetric(p.left, q.right)
	                && isSymmetric(p.right, q.left);
	    }
	    
	    public boolean isSymmetric2 (TreeNode root) {
	    	//迭代版，时间复杂度O(n)，空间复杂度O(logn)
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
