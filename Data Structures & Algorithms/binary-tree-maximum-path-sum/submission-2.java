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

class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }

    public int findMax(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            maxSum = Math.max(maxSum, root.val);
            return root.val;
        }
        int leftSum = findMax(root.left);
        int rightSum = findMax(root.right);
        // int currSum = root.val;
        int leftMax = 0, rightMax = 0;
        if(leftSum + root.val >= root.val) {
            // currSum += leftSum;
            leftMax+= leftSum;
        }
        if(rightSum + root.val >= root.val) {
            // currSum += rightSum;
            rightMax += rightSum;
        }
        // System.out.println(root.val+" : leftSum = "+leftSum+", rightSum = "+rightSum);
        maxSum = Math.max(maxSum,leftMax+rightMax+root.val);
        // System.out.println("Max with "+root.val+" is "+maxSum);
        return Math.max(leftMax,rightMax)+root.val;
    }
}
