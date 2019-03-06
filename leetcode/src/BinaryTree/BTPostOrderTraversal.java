package BinaryTree;

import java.util.*;

public class BTPostOrderTraversal {
	 public List postorderTraversal(TreeNode root) {
		 //Morris遍历
	        ArrayList result = new ArrayList<>();
	        TreeNode dummy = new TreeNode(-1);
	        dummy.left = root;
	        TreeNode cur = dummy;
	        TreeNode prev = null;

	        while (cur != null) {
	            if (cur.left == null) {
	                prev = cur; /* 必须要有 */
	                cur = cur.right;
	            } else {
	                TreeNode node = cur.left;
	                while (node.right != null && node.right != cur)
	                    node = node.right;

	                if (node.right == null) { /* 还没线索化，则建立线索 */
	                    node.right = cur;
	                    prev = cur; /* 必须要有 */
	                    cur = cur.left;
	                } else { /* 已经线索化，则访问节点，并删除线索  */
	                    visit_reverse(cur.left, prev, result);
	                    prev.right = null;
	                    prev = cur; /* 必须要有 */
	                    cur = cur.right;
	                }
	            }
	        }
	        return result;
	    }
	    // 逆转路径
	    private static void reverse(TreeNode from, TreeNode to) {
	        TreeNode x = from;
	        TreeNode y = from.right;
	        TreeNode z = null;
	        if (from == to) return;

	        while (x != to) {
	            z = y.right;
	            y.right = x;
	            x = y;
	            y = z;
	        }
	    }

	    // 访问逆转后的路径上的所有结点
	    private static void visit_reverse(TreeNode from, TreeNode to,
	                                      List result) {
	        TreeNode p = to;
	        reverse(from, to);

	        while (true) {
	            result.add(p.val);
	            if (p == from)
	                break;
	            p = p.right;
	        }

	        reverse(to, from);
	    }
}
