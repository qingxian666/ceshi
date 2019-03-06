package BinaryTree;

import java.util.*;

public class BTInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		//����
	    List<Integer> list = new ArrayList<Integer>();

	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode cur = root;

	    while(cur!=null || !stack.empty()){
	        while(cur!=null){
	            stack.add(cur);
	            cur = cur.left;
	        }
	        cur = stack.pop();
	        list.add(cur.val);
	        cur = cur.right;
	    }

	    return list;
	}
	public List inorderTraversal2(TreeNode root) {
		//Morris�������
        ArrayList result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                prev = cur;
                cur = cur.right;
            } else {
                /* ����ǰ�� */
                TreeNode node = cur.left;
                while (node.right != null && node.right != cur)
                    node = node.right;

                if (node.right == null) { /* ��û���������������� */
                    node.right = cur;
                    /* prev = cur; ��������䣬cur��û�б����� */
                    cur = cur.left;
                } else {    /* �Ѿ�������������ʽڵ㣬��ɾ������  */
                    result.add(cur.val);
                    node.right = null;
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        return result;
    }
}
