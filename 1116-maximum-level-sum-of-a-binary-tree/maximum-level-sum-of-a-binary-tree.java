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
    public int maxLevelSum(TreeNode root) {
        int maxSum =Integer.MIN_VALUE;
        int currLev =0;
        int lev =0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            int sum =0;
            currLev ++;
            for(int i=0;i<s;i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left!= null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(sum > maxSum){
                maxSum = sum;
                lev = currLev;
            }
        }
        return lev;
    }
}