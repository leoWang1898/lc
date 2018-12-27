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
	//递归
	public List<Integer> postorderRecursion(Node root) {
		List<Integer> result = new ArrayList<>();
		post(result, root);
		return result;
	}
	private void post(List list, Node node){
		if(node == null) return;
		for(Node n : node.children){
			post(list, n);
		}
		list.add(node.val);
	}

	//stack + 迭代
	public List<Integer> postorderIteration(Node root) {
		List<Integer> result = new LinkedList<>();
		if(root == null) return result;
		Stack<Node> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()) {
			Node temp = s.pop();
			result.add(0, temp.val);
			for(Node n : temp.children){
				s.push(n);
			}
		}
		return result;
	}
}