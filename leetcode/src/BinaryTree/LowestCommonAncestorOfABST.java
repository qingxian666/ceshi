package BinaryTree;

public class LowestCommonAncestorOfABST {
	//������
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
        root = p.val < root.val ? root.left : root.right;
    return root;
    }
	//�ݹ��
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
	    return (root.val - p.val) * (root.val - q.val) < 1 ? root :
	           lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
	}
}
