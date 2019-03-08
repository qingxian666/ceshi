package BinaryTree;

import java.util.*;

public class BTZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	       List<List<Integer>> result = new ArrayList<>();
	        traverse(root, 1, result, true);
	        return result;
	    }

	    private static void traverse(TreeNode root, int level, List<List<Integer>> result,
	                                 boolean left_to_right) {
	        if (root == null) return;

	        if (level > result.size())
	            result.add(new ArrayList<>());

	        if (left_to_right)
	            result.get(level-1).add(root.val);
	        else
	            result.get(level-1).add(0, root.val);

	        traverse(root.left, level+1, result, !left_to_right);
	        traverse(root.right, level+1, result, !left_to_right);  
	    }
}
