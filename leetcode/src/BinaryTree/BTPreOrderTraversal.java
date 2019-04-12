package BinaryTree;

import java.util.*;

public class BTPreOrderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		//迭代方法
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root != null) s.push(root);

        while (!s.isEmpty()) {
            final TreeNode p = s.pop();
            result.add(p.val);

            if (p.right != null) s.push(p.right);
            if (p.left != null) s.push(p.left);
        }
        return result;
    }
	public List<Integer> preorderTraversal2(TreeNode root) {
		//递归方法
		List<Integer> pre = new LinkedList<Integer>();
		if(root==null) return pre;
		pre.add(root.val);
		pre.addAll(preorderTraversal(root.left));
		pre.addAll(preorderTraversal(root.right));
		return pre;
	}
	
	public List preorderTraversal3(TreeNode root) {
		//Morris先序遍历
        ArrayList result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                prev = cur; /* cur刚刚被访问过 */
                cur = cur.right;
            } else {
                /* 查找前驱 */
                TreeNode node = cur.left;
                while (node.right != null && node.right != cur)
                    node = node.right;

                if (node.right == null) { /* 还没线索化，则建立线索 */
                    result.add(cur.val); /* 仅这一行的位置与中序不同 */
                    node.right = cur;
                    prev = cur; /* cur刚刚被访问过 */
                    cur = cur.left;
                } else {    /* 已经线索化，则删除线索  */
                    node.right = null;
                    /* prev = cur; 不能有这句，cur已经被访问 */
                    cur = cur.right;
                }
            }
        }
        return result;
    }
}
