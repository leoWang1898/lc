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
    public List<Integer> preorderTraversalRecursion(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	preorder(result, root);
    	return result;
    }
    private void preorder(List list, TreeNode node) {
    	if(node == null) return;
    	list.add(node.val);
    	preorder(list, node.left);
    	preorder(list, node.right);
    }

    //stack + 迭代
    public List<Integer> preorderTraversalIteration(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	if(root == null) return result;
    	Stack<TreeNode> s = new Stack<>();
    	while(!s.isEmpty() || root != null) {
    		while(root != null){
    			result.add(root.val);
    			s.push(root);
    			root = root.left;
    		}
    		if(!s.isEmpty()) {
    			root = s.pop();
    			root = root.right;
    		}
    	}
    	return result;
    }

    //Morris + 迭代 + Space O(1)
    public List<Integer> preorderTraversalMorris(TreeNode root) {
    	List<Integer> result = new ArrayList<>();

    	while(root != null){
    		if(root.left == null) {
    			result.add(root.val);
    			root = root.right;
    		}
    		else {
    			TreeNode node = root.left;
    			while(node.right != null && node.right != root){
    				node = node.right;
    			}
    			if(node.right == null){
    				result.add(root.val);
    				node.right = root;
    				root = root.left;
    			}
    			else{
    				node.right = null;
    				root = root.right;
    			}
    		}
    	}
    	return result;
    }
}