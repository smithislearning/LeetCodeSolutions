/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean validate(TreeNode node, long minVal, long maxVal) {
        if(node == null) {
            return true;
        }
        if(node.val <= minVal || node.val >= maxVal) {
            return false;
        }
        return (validate(node.left, minVal, node.val) && validate(node.right, node.val, maxVal));
    }
}