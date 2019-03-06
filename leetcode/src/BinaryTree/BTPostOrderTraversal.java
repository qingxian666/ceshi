package BinaryTree;

import java.util.*;

public class BTPostOrderTraversal {
	 public List postorderTraversal(TreeNode root) {
		 //Morris����
	        ArrayList result = new ArrayList<>();
	        TreeNode dummy = new TreeNode(-1);
	        dummy.left = root;
	        TreeNode cur = dummy;
	        TreeNode prev = null;

	        while (cur != null) {
	            if (cur.left == null) {
	                prev = cur; /* ����Ҫ�� */
	                cur = cur.right;
	            } else {
	                TreeNode node = cur.left;
	                while (node.right != null && node.right != cur)
	                    node = node.right;

	                if (node.right == null) { /* ��û���������������� */
	                    node.right = cur;
	                    prev = cur; /* ����Ҫ�� */
	                    cur = cur.left;
	                } else { /* �Ѿ�������������ʽڵ㣬��ɾ������  */
	                    visit_reverse(cur.left, prev, result);
	                    prev.right = null;
	                    prev = cur; /* ����Ҫ�� */
	                    cur = cur.right;
	                }
	            }
	        }
	        return result;
	    }
	    // ��ת·��
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

	    // ������ת���·���ϵ����н��
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
