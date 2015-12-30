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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        inorder(root, rst);
        return rst;
    }
    private void inorder(TreeNode r, List<Integer> list) {
        if(r == null) {
            return;
        }
        inorder(r.left, list);
        list.add(r.val);
        inorder(r.right, list);
    }
}