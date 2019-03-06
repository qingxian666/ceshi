package BinaryTree;

import java.util.*;

public class BTPreOrderTraversal {
	public List<Integer> preorderTraversal(TreeNode node) {
		//��������
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> rights = new Stack<TreeNode>();
		while(node != null) {
			list.add(node.val);
			if (node.right != null) {
				rights.push(node.right);
			}
			node = node.left;
			if (node == null && !rights.isEmpty()) {
				node = rights.pop();
			}
		}
	    return list;
	}
	public List<Integer> preorderTraversal2(TreeNode root) {
		//�ݹ鷽��
		List<Integer> pre = new LinkedList<Integer>();
		if(root==null) return pre;
		pre.add(root.val);
		pre.addAll(preorderTraversal(root.left));
		pre.addAll(preorderTraversal(root.right));
		return pre;
	}
	
	public List preorderTraversal3(TreeNode root) {
		//Morris�������
        ArrayList result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                prev = cur; /* cur�ոձ����ʹ� */
                cur = cur.right;
            } else {
                /* ����ǰ�� */
                TreeNode node = cur.left;
                while (node.right != null && node.right != cur)
                    node = node.right;

                if (node.right == null) { /* ��û���������������� */
                    result.add(cur.val); /* ����һ�е�λ��������ͬ */
                    node.right = cur;
                    prev = cur; /* cur�ոձ����ʹ� */
                    cur = cur.left;
                } else {    /* �Ѿ�����������ɾ������  */
                    node.right = null;
                    /* prev = cur; ��������䣬cur�Ѿ������� */
                    cur = cur.right;
                }
            }
        }
        return result;
    }
}
