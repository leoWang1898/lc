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

 class Solution {
 	public List<List<Integer>> levelOrder(Node root) {
 		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(!root.isEmpty()) {
			int count = q.size();
			List<Integer> list = new ArrayList<>();
			while(count > 0) {
				Node temp = q.poll();
				list.add(temp.val);
				if(temp.children != null || temp.children.size() != 0) {
					for(Node n : temp.children){
						q.offer(n);
					}
				}
				count--;
			}
			result.add(list);
		}
		return result;
 	}
 }