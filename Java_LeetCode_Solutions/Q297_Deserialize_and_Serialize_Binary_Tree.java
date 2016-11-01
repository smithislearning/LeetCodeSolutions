/**

 * Definition for a binary tree node.

 * public class TreeNode {

 *     int val;

 *     TreeNode left;

 *     TreeNode right;

 *     TreeNode(int x) { val = x; }

 * }

 */

public class Codec {



    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {

        if(root == null) {

            return "";

        }

        LinkedList<TreeNode> crt = new LinkedList<TreeNode>();

        LinkedList<TreeNode> nxt = new LinkedList<TreeNode>();

        ArrayList<String> list = new ArrayList<String>();

        crt.add(root);

        while(!crt.isEmpty()) {

            TreeNode wrk = crt.remove();

            if(wrk != null) {

                list.add(Integer.toString(wrk.val));

                nxt.add(wrk.left);

                nxt.add(wrk.right);

            } else {

                list.add("null");

            }

            if(crt.isEmpty() && !nxt.isEmpty()) {

                crt = nxt;

                nxt = new LinkedList<TreeNode>();

            }

        }

        while(list.get(list.size() -  1).equals("null")) {

            list.remove(list.size() - 1);

        }

        return list.toString();

    }



    // Decodes your encoded data to tree.

    public TreeNode deserialize(String data) {

        if(data.length() < 3) {

            return null;

        }

        data = data.substring(1, data.length() - 1);

        LinkedList<TreeNode> crt = new LinkedList<TreeNode>();

        LinkedList<TreeNode> nxt = new LinkedList<TreeNode>();

        int idx = 1;

        String[] input = data.split(", ");

        TreeNode root = new TreeNode(Integer.parseInt(input[0]));

        crt.add(root);

        while(!crt.isEmpty() && idx < input.length) {

            TreeNode wrk = crt.remove();

            if(input[idx].equals("null")) {

                wrk.left = null;

            } else {

                wrk.left = new TreeNode(Integer.parseInt(input[idx]));

                nxt.add(wrk.left);

            }

            idx ++;

            if(idx >= input.length) {

                break;

            }

            if(input[idx].equals("null")) {

                wrk.right = null;

            } else {

                wrk.right = new TreeNode(Integer.parseInt(input[idx]));

                nxt.add(wrk.right);

            }

            idx ++;

            if(crt.isEmpty() && !nxt.isEmpty()) {

                crt = nxt;

                nxt = new LinkedList<TreeNode>();

            }

        }

        return root;

    }

}



// Your Codec object will be instantiated and called as such:

// Codec codec = new Codec();

// codec.deserialize(codec.serialize(root));
