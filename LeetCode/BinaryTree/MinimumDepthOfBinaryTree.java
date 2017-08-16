// Minimum Depth of Binary Tree
// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
// 递归法
// 复杂度
// 时间 O(N) 空间 O(H) 递归栈空间

// 思路
// 当求最大深度时，我们只要在左右子树中取较大的就行了，然而最小深度时，如果左右子树中有一个为空会返回0，这时我们是不能算做有效深度的。所以分成了三种情况，左子树为空，右子树为空，左右子树都不为空。当然，如果左右子树都为空的话，就会返回1。

// 代码
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        if(root.left != null && root.right != null){
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            depth = Math.min(left, right);
        } else if (root.left != null){
            depth = minDepth(root.left);
        } else if (root.right != null){
            depth = minDepth(root.right);
        }
        return depth + 1;
    }
}
// 广度优先搜索
// 复杂度
// 时间 O(N) 空间 O(B)

// 思路
// 递归解法本质是深度优先搜索，但因为我们是求最小深度，并不一定要遍历完全部节点。如果我们用广度优先搜索，是可以在遇到第一个叶子节点时就终止并返回当前深度的。

// 代码
public class Solution {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root!=null) queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left == null && curr.right == null){
                    return depth;
                }
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }
        return depth;
    }
}

// 迭代加深有限深度优先搜索
// 复杂度
// 时间 O(N) 空间 O(D)

// 思路
// 英文名是Iterative Deepening Depth Limited Search.然而，广度优先搜索有一个致命缺陷就是，一旦分支变多，消耗空间就太大。这里我们还有改进的余地，就是用迭代加深的有限深度优先搜索。该算法每次迭代是一次有限深度优先搜索，如果本轮迭代没有发现目标（这题的目标是第一个叶子结点），则增加深度上限重新进行有限深度优先搜索。读者可能觉得这样会带来很多重复计算，但实际上经过数学证明后可以发现，该算法的时间复杂度和广度优先搜索是在一个数量级的，并没有太大的增加，而他的空间消耗仅仅是限制的深度。详情请翻阅Artificial Intelligence : A Modern Approach。

// 代码
public int minDepth(TreeNode root) {
    if(root==null) return 0;
    return iterativeDeepeningDFS(root);
}
private boolean depthLimitedSearch(TreeNode root,int depth){
    boolean left = false;
    boolean right = false;
    if(depth>0){
        if(root.left==null&&root.right==null){
            return true;
        }
        if(root.left!=null) {
            left = depthLimitedSearch(root.left, depth-1);
        }
        if(root.right!=null) {
            right = depthLimitedSearch(root.right, depth-1);
        }
        return left||right;
    } else {
        return false;
    }
}
private int iterativeDeepeningDFS(TreeNode root){
    int thisDepth = 1;
    boolean foundMin = false;
    while(true){
        foundMin = depthLimitedSearch(root,thisDepth);
        if(foundMin){
            return thisDepth;
        } else {
            thisDepth++;
        }
    }
}