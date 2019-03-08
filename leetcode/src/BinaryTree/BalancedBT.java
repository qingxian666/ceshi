package BinaryTree;

public class BalancedBT {
	public boolean isBalanced (TreeNode root) {
		// ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(logn)
        return balancedHeight (root) >= 0;
    }

    /**
     * Returns the height of `root` if `root` is a balanced tree,
     * otherwise, returns `-1`.
     */
    private static int balancedHeight (TreeNode root) {
        if (root == null) return 0;  // ��ֹ����

        int left = balancedHeight (root.left);
        int right = balancedHeight (root.right);

        if (left < 0 || right < 0 || Math.abs(left - right) > 1) return -1;  // ��֦

        return Math.max(left, right) + 1; // �����ϲ�
    }
}
