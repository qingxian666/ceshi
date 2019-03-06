package BinaryTree;

import java.util.*;

public class BTRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        traverse(root, 0, result);
        return result;
    }
    
    void traverse(TreeNode root, int level,
                  List<Integer> result) {
        if (root == null) return;

        if (level == result.size()){
            result.add(root.val);
        }

          
        traverse(root.right, level+1, result);
        traverse(root.left, level+1, result);
   
    }
}
