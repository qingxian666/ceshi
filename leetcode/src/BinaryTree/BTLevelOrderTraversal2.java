package BinaryTree;

import java.util.*;

public class BTLevelOrderTraversal2 {
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
		// �ݹ�棬ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(n)
		//����һ�� Binary Tree Level Order Traversal �Ļ����ϣ�reverse()һ�¼��ɡ�
         List<List<Integer>> result = new ArrayList<>();
        traverse(root, 1, result);
        Collections.reverse(result);
        return result;
    }
    void traverse(TreeNode root, int level,List<List<Integer>> result) {
        if (root == null) return;

        if (level > result.size()){
            result.add(new ArrayList<>());
        }

        result.get(level-1).add(root.val);    
        traverse(root.left, level+1, result);
        traverse(root.right, level+1, result);
   
    }
    
    
    //������
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
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
       Collections.reverse(wrapList); 
       return wrapList;
   }
}
