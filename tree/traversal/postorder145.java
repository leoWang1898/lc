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
	public List<Integer> postorderTraversalRecursion(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		postorder(result, root);
		return result;
	}
	private void postorder(List list, TreeNode node) {
		if(node == null) return;
		postorder(list, node.left);
		postorder(list, node.right);
		list.add(node.val);
	}
	
	//stack + 迭代
	public List<Integer> postorderTraversalIteration(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		Stack<TreeNode> s = new Stack<>();
		TreeNode last = root;
		while(root != null || !s.isEmpty()) {
			while(root != null){
				s.push(root);
				root = root.left;
			}
			root = s.peek();
			if(root.right == null || root.right == last) {
				result.add(root.val);
				s.pop();
				last = root;
				root = null;
			}
			else{
				root = root.right;
			}
		}
		return result;
	}
}