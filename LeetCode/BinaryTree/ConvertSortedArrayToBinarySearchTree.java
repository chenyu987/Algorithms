// Convert Sorted Array to Binary Search Tree
// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
// 递归法
// 复杂度
// 时间 O(N) 空间 O(H)

// 思路
// 和用链表建树的思路相似，实现更加简单，因为数组支持随机查询，我们可以直接访问中点而无须遍历链表。

// 代码

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        // 先递归的计算左子树
        TreeNode left = buildTree(nums, start, mid - 1);
        // 创造根节点
        TreeNode root = new TreeNode(nums[mid]);
        // 最后递归的计算右子树
        TreeNode right = buildTree(nums, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}