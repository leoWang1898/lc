/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//两层递归，时间复杂度O(n2)
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return find(root,root,k);
    }
    private boolean find(TreeNode root, TreeNode curr, int k) {
        if(curr == null) return false;
        return dfs(root,curr,k) || find(root, curr.left, k) || find(root, curr.right, k);
    }
    
    private boolean dfs(TreeNode root, TreeNode current, int k) {
        if(root == null) return false;
        if(current.val + root.val == k && current != root) return true;
        else{
            return dfs(root.left, current, k) || dfs(root.right, current, k);
        }
    }
}

//利用BST性质，then twopointer
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        if(list == null || list.size() == 0) return false;
        int low = 0;
        int high = list.size() - 1;
        while(low < high) {
            if(list.get(low) + list.get(high) == k) return true;
            else if(list.get(low) + list.get(high) < k) low++;
            else high--;
        }
        return false;
    }
    
    private void inorder(TreeNode node, List list) {
        if(node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}