/*
Given a binary tree, find the leftmost value in the last row of the tree.
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
//1.level oreder traversal from right to left
class Solution {
    
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int count = q.size();
            while(count > 0) {
                TreeNode node = q.poll();
                if(node.right != null) q.offer(node.right);
                if(node.left != null) q.offer(node.left);
                if(q.isEmpty()) result = node.val;
                count--;
            }
        }
        return result;
    }
}

//Recursion find the depth first then find the last row using count
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int depth = findDepth(root);
        return dfs(root, depth, 1, new int[]{0,0});
    }
    
    private int findDepth(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(findDepth(node.left), findDepth(node.right));
    }
    
    private int dfs(TreeNode node, int depth, int count, int[] result) {
        if(node.left == null && node.right == null) {
            if(count == depth){
                result[1] = 1;
                result[0] = node.val;
            }  
        }
        else{
            if(node.left != null  && result[1] == 0) dfs(node.left, depth, count + 1, result);
            if(node.right != null  && result[1] == 0) dfs(node.right, depth, count + 1, result);
        }
        return result[0];
    }
}

//A more elegant way
class Solution {
    
    public int findBottomLeftValue(TreeNode root) {
        int[] result = new int[]{0,0};
        dfs(root, 1, result);
        return result[0];
    }
    private void dfs(TreeNode node, int depth, int[] result) {
        if(result[1] < depth) {
            result[0] = node.val;
            result[1] = depth;
        }
        if(node.left != null) dfs(node.left, depth + 1, result);
        if(node.right != null) dfs(node.right, depth + 1, result);
    }
}