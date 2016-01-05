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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            List<TreeNode> rst = new ArrayList<TreeNode>();
            return rst;
        }
        return buildTrees(1, n);
    }
    private List<TreeNode> buildTrees(int init, int end) {
        List<TreeNode> rst = new ArrayList<TreeNode>();
        
        if(init > end) {
            rst.add(null);
            return rst;
        }
        
        for(int i = init; i < end + 1; i++) {
            List<TreeNode> left = buildTrees(init, i - 1);
            List<TreeNode> right = buildTrees(i + 1, end);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode wrk = new TreeNode(i);
                    wrk.left = l;
                    wrk.right = r;
                    rst.add(wrk);
                }
            }
        }
        return rst;
    }
}