package BinaryTree;

import java.util.*;

public class BTLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		//递归版
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
    
    
    
    //迭代版
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        //queue.offer       添加一个元素并返回true       如果队列已满，则返回false
        //queue.poll        移除并返问队列头部的元素         如果队列为空，则返回null
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                subList.add(node.val);
            }                
            wrapList.add(subList);
        }
        return wrapList;
    }
}
