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
    public TreeNode sortedArrayToBST(int[] nums) {
        return BuildBST(nums,0,nums.length-1);
    
    }
    public static TreeNode BuildBST(int[] nums,int left,int right){
        if(left > right) return null;

        int mid = left + (right-left)/2;
        TreeNode node = new TreeNode(nums[mid]); 

        node.left = BuildBST(nums,left,mid-1);
        node.right = BuildBST(nums,mid+1,right);

        return node;
    }
}