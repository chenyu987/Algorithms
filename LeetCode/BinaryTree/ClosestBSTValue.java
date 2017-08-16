Closest Binary Search Tree Value I
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note: Given target value is a floating point. You are guaranteed to have only one unique value in the BST that is closest to the target.


public class ClosestBinarySearchTreeValue {
  public int closestValue(TreeNode root, double target) {
    int closest = root.val;
    while (root != null) {
        if (root.val > target && root.left != null) {
            root = root.left;
        } 
        if (root.val < target && root.right != null) {
            root = root.right;
        }
        int subCloest = Math.abs(root.val - target);
        if (subCloest < Math.abs(closest - target)) {
            closest = root.val;
        }
    }
    return closest;
  }
}

public Solution {
	int result;
	double min = Double.MAX_VALUE;

	public int closestBSTValue(TreeNode root, double target) {
		while (root != null) {
			double diff = Math.abs(root.val - target);
			if (diff < min) {
				min = Math.min(min, diff);
				result = root.val;
			}
			if (target > root.val) {
				root = root.right;
			}
			if (target < root.val) {
				root = root.left;
			}
			else {
				return root.val;
			}
		}
		return result;
	}
}



public class ClosestBinarySearchTreeValue {
  public int closestValue(TreeNode root, double target) {
    TreeNode subRoot = null;
  // pick up one of subtrees
    if (target < root.val) {
    subRoot = root.left;
  } else {
    subRoot = root.right;
  }  
  // no children -> recursion hits leaf
    if (subRoot == null) {
      return root.val;
    }
  // find closest val recursively
    int closest = closestValue(subRoot, target);
 
    double diffToRoot = Math.abs(root.val - target);
    double diffToSubRoot = Math.abs(closest - target);
    if (diffToRoot < diffToSubRoot) {
      return root.val;
    } else {
      return closest;
    }  
  }
} 

