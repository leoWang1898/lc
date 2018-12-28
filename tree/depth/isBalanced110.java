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
	public boolean isBlanced (TreeNode root) {
		if(root == null) return true;

		int left = depth(root.left);
		int right = depth(root.right);

		if(Math.abs(left - right) > 1) return false;

		return isBlanced(root.left) && isBlanced(root.right);
	}

	private int depth(TreeNode node) {
		if(root == null) retrun 0;
		int left = depth(root.left);
		int right = depth(root.right);
		return 1 + Math.max(left, right);
	}
}