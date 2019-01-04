/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//The most important property of a BST is the inorder traversal of it is an ascending sorted array
//This is easy, just scan the tree, < val, right; > val, left.
//迭代
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null){
            if(root.val == val) return root;
            else if(root.val > val) root = root.left;
            else root = root.right;
        }
        return null;
    }
}

//递归 + 无返回值
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode[] result = new TreeNode[]{root};//不能传TreeNode进去
        dfs(root, val, result);
        return result[0];
    }
    private void dfs(TreeNode root, int val, TreeNode[] result) {
        if(root == null) {
            result[0] = root;
            return;
        }
        if(root.val == val) result[0] = root;
        else if(root.val > val) dfs(root.left, val, result);
        else dfs(root.right, val, result);
    }
}

//递归 + 有返回值
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        
        if(root.val == val) return root;
        else if(root.val < val) return searchBST(root.right, val);
        else{
            return searchBST(root.left, val);
        }
    }
}