/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         sb = new StringBuilder();
         construct(root,sb);
         System.out.println(sb);
         return sb.toString();
        
    }

    public void construct(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        // if(root.left == null) {
        //     sb.append("N,");
        // }else{
            construct(root.left,sb);
        // }
        // if(root.right == null) {
        //     sb.append("N,");
        // }else{
            construct(root.right,sb);
        // }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] nodes = data.split(",");
        int [] idx = {0};
        TreeNode root = construct(nodes,idx);
        return root;
    }

    public TreeNode construct(String [] arr, int [] idx) {
        if(arr[idx[0]].equals("N")) {
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx[0]++]));
        root.left = construct(arr,idx);
        root.right = construct(arr,idx);
        return root;
    }
}
