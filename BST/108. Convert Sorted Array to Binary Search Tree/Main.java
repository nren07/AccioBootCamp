class Solution {
    public TreeNode solve(int []arr, int l, int r){
        if(l>r) return null;
        int mid=(l+r)/2;
        int val=arr[mid];
        TreeNode me=new TreeNode(val);
        me.left=solve(arr,l,mid-1);
        me.right=solve(arr,mid+1,r);
        return me;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums,0,nums.length-1);
    }
}