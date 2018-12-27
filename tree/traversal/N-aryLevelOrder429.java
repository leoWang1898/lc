/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.empty()) {
			int count = q.size();
			List<Integer> l = new ArrayList();
			while(count > 0) {
				TreeNode temp = q.poll();
				l.add(temp.val);
				if(q.left != null) q.offer(temp.left);
				if(q.right != null) q.offer(temp.right);
				count--;
			}
			result.add(l);
		}
		return result;
	}