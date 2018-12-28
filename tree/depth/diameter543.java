/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//两层递归，找每个节点的直径取最大
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
		
        int left = depth(root.left);
        int right = depth(root.right);
        
        return Math.max(Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)), left + right);
    }
    
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return 1 + Math.max(left, right);
    }
}

//两个递归函数其实结构很相似，所以合并过来
class Solution {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);

        max = Math.max(left + right, max);
        return 1 + Math.max(left, right);
    }
}