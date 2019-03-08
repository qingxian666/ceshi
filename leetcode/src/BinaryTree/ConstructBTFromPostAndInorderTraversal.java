package BinaryTree;

import java.util.HashMap;

public class ConstructBTFromPostAndInorderTraversal {
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
		    if (inorder == null || postorder == null || inorder.length != postorder.length)
			    return null;
		    HashMap<Integer,Integer> map = new HashMap();        
		    for(int i=0;i<inorder.length;i++){
		      map.put(inorder[i],i);
		    }
		    return buildBinaryTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
		    
		}


		public TreeNode buildBinaryTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd, HashMap<Integer,Integer> map){
		    
		    if(postorderStart > postorderEnd || inorderStart > inorderEnd ) return null;
		    
		    TreeNode node = new TreeNode(postorder[postorderEnd]);
		    int rootIndex = map.get(postorder[postorderEnd]);
		    TreeNode leftChild = buildBinaryTree(inorder, inorderStart,rootIndex -1 , postorder, postorderStart, postorderStart + rootIndex - inorderStart - 1, map);
		    TreeNode rightChild = buildBinaryTree(inorder, rootIndex + 1,inorderEnd, postorder, postorderStart+rootIndex - inorderStart, postorderEnd - 1, map);
		    node.left = leftChild;
		    node.right = rightChild;
		    return node;
		    
		   }
}
