package BinaryTree;

public class FlattenBTToLinkedlist {
	public void flatten(TreeNode root) {
		//ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(logn)
        //�ɵݹ�Ϊ�Ƚ�������������Ϊһ���������Ű���������������������λ�ã��ٽ�ԭ������ƴ����ԭ�������ĺ��档
        if (root == null) return;  // ��ֹ����

        flatten(root.left);
        flatten(root.right);

        if (root.left == null) return;

        // �����ϲ��������������γɵ�������뵽root��root->right֮��
        TreeNode p = root.left;
        while(p.right != null) { p = p.right; }//Ѱ�����������һ���ڵ�
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}
