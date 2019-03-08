package BinaryTree;

public class FlattenBTToLinkedlist {
	public void flatten(TreeNode root) {
		//时间复杂度O(n)，空间复杂度O(logn)
        //可递归为先将左右子树都化为一条链，接着把左子树链放在右子树的位置，再将原右子树拼接在原左子树的后面。
        if (root == null) return;  // 终止条件

        flatten(root.left);
        flatten(root.right);

        if (root.left == null) return;

        // 三方合并，将左子树所形成的链表插入到root和root->right之间
        TreeNode p = root.left;
        while(p.right != null) { p = p.right; }//寻找左链表最后一个节点
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}
