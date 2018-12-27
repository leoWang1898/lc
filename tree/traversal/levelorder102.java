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
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int count = q.size();
			List<Integer> l = new ArrayList();
			while(count > 0) {
				TreeNode temp = q.poll();
				l.add(temp.val);
				if(temp.left != null) q.offer(temp.left);
				if(temp.right != null) q.offer(temp.right);
				count--;
			}
			result.add(l);
		}
		return result;
	}
}