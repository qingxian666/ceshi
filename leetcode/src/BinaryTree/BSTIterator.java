package BinaryTree;

import java.util.*;

public class BSTIterator {
	/*����ǵݹ���������������Ȿ������дһ������������������ĵ�������
	 * �ڲ�����һ��ջ����ʼ����ʱ�򣬴洢�Ӹ��ڵ㵽����Ҷ�ӽڵ��·����
	 * �ڱ����Ĺ����У�ÿ�δ�ջ�е���һ��Ԫ�أ���Ϊ��ǰ�ķ��ؽ����
	 * ͬʱ̽��һ�µ�ǰ�ڵ��Ƿ�����Һ��ӣ�����У�������Һ��ӣ����ѴӸ��Һ��ӵ�����Ҷ�ӽڵ�����нڵ���ջ��*/
	public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        final TreeNode node = stack.pop();
        if (node.right != null) {
            TreeNode p = node.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

        }
        return node.val;
    }
    private Stack<TreeNode> stack;
}
