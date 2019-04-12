package BinaryTree;

import java.util.*;

public class KthSmallestElementInABST {
	public int kthSmallest(TreeNode root, int k) {
		//ÖÐÐò±éÀú
	     Stack<TreeNode> stack = new Stack<>();
	     while(root != null || !stack.isEmpty()) {
	         while(root != null) {
	             stack.push(root);    
	             root = root.left;   
	         } 
	         root = stack.pop();
	         if(--k == 0) break;
	         root = root.right;
	     }
	     return root.val;
	 }
}
