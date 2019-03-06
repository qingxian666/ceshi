package BinaryTree;

import java.util.*;

public class BTInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		//迭代
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
		//Morris中序遍历
        ArrayList result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                prev = cur;
                cur = cur.right;
            } else {
                /* 查找前驱 */
                TreeNode node = cur.left;
                while (node.right != null && node.right != cur)
                    node = node.right;

                if (node.right == null) { /* 还没线索化，则建立线索 */
                    node.right = cur;
                    /* prev = cur; 不能有这句，cur还没有被访问 */
                    cur = cur.left;
                } else {    /* 已经线索化，则访问节点，并删除线索  */
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
