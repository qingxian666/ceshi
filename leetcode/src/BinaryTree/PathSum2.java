package BinaryTree;

import java.util.*;

public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer>  cur = new ArrayList<>(); // �м���
        pathSum(root, sum, cur, result);
        return result;
    }
    private static void pathSum(TreeNode root, int gap, ArrayList<Integer> cur,
                                List<List<Integer>> result) {
        if (root == null) return;

        cur.add(root.val);

        if (root.left == null && root.right == null) { // leaf
            if (gap == root.val)
                result.add(new ArrayList<>(cur));
        }
        pathSum(root.left, gap - root.val, cur, result);
        pathSum(root.right, gap - root.val, cur, result);

        cur.remove(cur.size() - 1);
    }
}
