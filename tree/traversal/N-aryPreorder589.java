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
	public List<Integer> preorderRecursion(Node root) {
		List<Integer> result = new ArrayList<>();
		pre(result, root);
		return result;
	}
	private void pre(List list, Node node){
		if(node == null) return;
		list.add(node.val);
		for(Node n : node.children){
			pre(list, n);
		}
	}

	//stack + 迭代
	public List<Integer> preorder(Node root) {
		List<Integer> result = new LinkedList<>();
		if(root == null) return result;
		Stack<Node> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()) {
			root = s.pop();
			result.add(root.val);
			for(int i = root.children.size() - 1; i > -1; i--){
                s.push(root.children.get(i));
            }
		}
		return result;
	}
}