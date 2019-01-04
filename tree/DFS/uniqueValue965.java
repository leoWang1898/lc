/*
A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 传值，搜索到时记录下来
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        boolean[] result = new boolean[]{true};
        dfs(root.left, root.val, result);
        dfs(root.right, root.val, result);
        return result[0];
    }
    private void dfs(TreeNode node, int n, boolean[] result){
        if(node == null) return;
        if(node.val != n) result[0] = false;
        else{
            if(result[0]) dfs(node.left, n, result); 
            if(result[0]) dfs(node.right, n, result);
        }
    }
}