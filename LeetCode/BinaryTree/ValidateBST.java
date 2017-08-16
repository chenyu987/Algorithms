// Given a binary tree, determine if it is a valid binary search tree

// public class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return isValid(root, null, null);
//     }
    
//     private isValid(TreeNode root, int max, int min) {
//         if (root == null) return true;
//         if (max != null && root.val >= max) return false;
//         if (min != null && root.val < min) return false;
//         return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
//     }
// }


public class Solution {
    public boolean isValidBST(ListNode root) {
        // 这里换成了最大值最小值， 因为传入null的话应该就会有错误
        return isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isValid(ListNode root, int max, int min) {
        if (root == null) return true;
        if (root.val >= max) return false;
        if (root.val <= min) return false;
        return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
    }
}

// From Liu Zhe
// public class Solution {
//     public boolean isValidBST(ListNode root) {
//         return isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
//     }

//     private boolean isValid(ListNode root, int max, int min) {
//         if (root == null) return true;
//         if (root.val >= max) return false;
//         if (root.val <= min) return false;
//         return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
//     }
// }

// 	public boolean isValidBST(TreeNode root) {
// 		if (root == null) return true;
// 		List<Integer> nodeList = new ArrayList<Integer>();
// 		inOrderTraversal(root, nodeList);
// 		for (int i = 1; i < nodeList.size(); i++) {
// 			if (nodeList.get(i) <= nodeList.get(i-1)) {
// 				return false;
// 			}
// 		}
// 		return true;
// 	}
	
// 	private void inOrderTraversal(TreeNode root, List<Integer> nodeList) {
// 		if (root == null) return;
// 		inOrderTraversal(root.left, nodeList);
// 		nodeList.add(root.val);
// 		inOrderTraversal(root.right, nodeList);
// 	}
// }