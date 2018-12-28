/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//When root != null, root's depth is 1.
class Solution {
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		//When left or right is null the minimum depth is non-null node's depth
		return (root.left == null || root.right == null) ? 1 + left + right : 1 + Math.min(left, right);
	}
}