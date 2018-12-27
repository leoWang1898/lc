/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Solution {
	//递归
	public List<Integer> inorderTraversalRecursion(TreeNode root) {
		List<Integer> result = new ArrayList();
		inorder(result, root);
		return result;
	}
	private void inorder(List list, TreeNode node) {
		if(node == null) return;
		inorder(list, node.left);
		list.add(node.val);
		inorder(list, node.right);
	}

	//stack + 迭代
	public List<Integer> inorderTraversalIteration(TreeNode root) {
		List<Integer> result = new ArrayList();
		if(root == null) return result;
		Stack<TreeNode> s = new Stack();
		while(root != null || !s.isEmpty()) {
			while(root != null) {
				s.push(root);
				root = root.left;
			}
			if(!s.isEmpty()) {
				root = s.pop();
				result.add(root.val);
				root = root.right;
			}
		}
		return result;
	}

	//Morris + 迭代
	public List<Integer> inorderTraversalMorrise(TreeNode root) {
		List<Integer> result = new ArrayList<>();

		while(root != null){
			if(root.left == null){
				result.add(root.val);
				root = root.right;
			}
			else{
				TreeNode node = root.left;
				while(node.right != null && node.right != root){
					node = node.right;
				}
				if(node.right == null){
					node.right = root;
					root = root.left;
				}
				else{
					result.add(root.val);
					node.right = null;
					root = root.right;
				}
			}
		}
		return result;
	}
}