package BinaryTree;

import java.util.*;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		// 递归版，时间复杂度O(n)，空间复杂度O(logn)
        if (p == null && q == null) return true;   // 终止条件
        if (p == null || q == null) return false;  // 剪枝
        return p.val == q.val      // 三方合并
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
	
	 public boolean isSameTree2(TreeNode p, TreeNode q) {
		 //迭代版，时间复杂度O(n)，空间复杂度O(logn)
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
