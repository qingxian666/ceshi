package BinaryTree;

import java.util.*;

public class BTPreOrderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		//��������
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
