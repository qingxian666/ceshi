package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBT {
	 public TreeNode invertTree(TreeNode root) {
		 //µÝ¹é£¬ Time Complexity: O(n), Space Complexity: O(n)
	        if (root == null) return root;

	        TreeNode tmp = root.left;
	        root.left = invertTree(root.right);
	        root.right = invertTree(tmp);

	        return root;
	    }
	 
	 public TreeNode invertTree2(TreeNode root) {
		 //²ã´Î±éÀú£¬Time Complexity: O(n), Space Complexity: O(n)
	        Queue<TreeNode> q = new LinkedList<>();
	        if (root != null) q.offer(root);

	        while (!q.isEmpty()) {
	            TreeNode node = q.poll();
	            // swap left and right
	            TreeNode tmp = node.left;
	            node.left = node.right;
	            node.right = tmp;

	            if (node.left != null) q.offer(node.left);
	            if (node.right != null) q.offer(node.right);
	        }
	        return root;
	    }
}
