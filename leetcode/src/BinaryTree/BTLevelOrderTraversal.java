package BinaryTree;

import java.util.*;

public class BTLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 1, result);
        return result;
    }

    void traverse(TreeNode root, int level,
                  List<List<Integer>> result) {
        if (root == null) return;

        if (level > result.size()){
            result.add(new ArrayList<>());
        }

        result.get(level-1).add(root.val);    
        traverse(root.left, level+1, result);
        traverse(root.right, level+1, result);
   
    }
}
