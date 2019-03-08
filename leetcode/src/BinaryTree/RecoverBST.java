package BinaryTree;

import java.util.*;

public class RecoverBST {
	public void recoverTree(TreeNode root) {
		/*
		 * O(logn)�ռ�Ľⷨ�ǣ�����ݹ������������ָ�����ڱ������������������������λ�á�
		����Ҫ��O(1)�ռ䣬ֻ����Morris���������
		*/
        TreeNode[] broken = new TreeNode[2];
        TreeNode prev = null;
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                detect(broken, prev, cur);
                prev = cur;
                cur = cur.right;
            } else {
                TreeNode node = cur.left;

                while (node.right != null && node.right != cur)
                    node = node.right;

                if (node.right == null) {
                    node.right = cur;
                    //prev = cur; ��������䣡��Ϊcur��û�б�����
                    cur = cur.left;
                } else {
                    detect(broken, prev, cur);
                    node.right = null;
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        // swap
        int tmp = broken[0].val;
        broken[0].val = broken[1].val;
        broken[1].val = tmp;
    }

    void detect(TreeNode[] broken, TreeNode prev,
                TreeNode current) {
        if (prev != null && prev.val > current.val) {
            if (broken[0] == null) {
                broken[0] = prev;
            } //������else������ {0,1}���ᵼ����� swapʱsecondΪnullptr��
            //�� Runtime Error
            broken[1] = current;
        }
    }
}
