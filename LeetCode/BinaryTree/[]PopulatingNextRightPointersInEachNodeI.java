Populating Next Right Pointers in Each Node I
Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If thereis no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.For example, Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL
Note:

You may only use constant extra space. You may assume that it is a
perfect binary tree (ie, all leaves are at the same level, and every
parent has two children).
原题链接

广度优先搜索
复杂度
时间 O(N) 空间 O(N)

思路
相当于是Level Order遍历二叉树。通过一个Queue来控制每层的遍历，注意处理该层最后一个节点的特殊情况。此方法同样可解第二题。

代码
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        if(root!=null) q.offer(root);
        while(!q.isEmpty()){
            //记录本层节点的个数
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeLinkNode curr = q.poll();
                //最后一个节点的next是null，不做处理
                if(i < size - 1){
                    TreeLinkNode next = q.peek();
                    curr.next = next;
                }
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
        }
    }
}
递归法
复杂度
时间 O(N) 空间 O(N) 递归栈空间

思路
由于父节点多了next指针，我们不用记录父节点的父节点就能直到它相邻的节点。对于左子节点来说，其next节点就是父节点的右节点。对于右子节点来说i，其next节点就是父节点的next节点的左子节点。以此递归。

代码
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        //左子节点的next是右子节点
        if(root.left != null) root.left.next = root.right;
        if(root.right != null){
        //右子节点的next是父节点的next的左子节点
            root.right.next = root.next == null? null:root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
双指针法 Two Pointers
复杂度
时间 O(N) 空间 O(1)

思路
上述两种方法都会使用额外空间。实际上，我们可以用一个指针记录当前层内遍历到的节点，另一个指针记录下一层第一个节点，来省去空间开销。这样，我们可以基于上一层的next指针进行横向遍历，同时遍历到该层尽头时又能使用记录下的下一层第一个节点的指针来直接跳转到下一层。

代码
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        //记录该层当前节点的指针，也叫做父节点，我们通过遍历父节点，来连接它们的子节点
        TreeLinkNode p = root;
        //记录下层第一个节点的指针
        TreeLinkNode first = null;
        while(p != null){
            //当first为空时，说明刚跳转到新的一层，需要设置下一层的第一个节点了
            if(first == null){
                first = p.left;
            }
            //如果有左子节点，则其next是右子节点，如果没有，则遍历结束
            //因为我们实际上是将下一层的节点用next指针连接，所以当遍历到叶子结点时已经没有下一层
            if(p.left != null){
                p.left.next = p.right; 
            } else {
                break;
            }
            //如果父节点有next，则next的左子节点是父节点的右子节点的next，如果没有，说明这层遍历完了，转入下一层
            if(p.next != null){
                p.right.next = p.next.left;
                p = p.next;
            } else {
                p = first;
                first = null;
            }
        }
    }
}

层次递进法
复杂度
时间 O(N) 空间 O(1)

思路
因为我们确定的知道每个非叶子节点都有左右节点，所以我们可以一层一层链接。只要根据当前层的next指针形成的链表，将下一层的左右左右连起来就行了。

代码
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        while(head != null){
            // 记录当层第一个节点
            TreeLinkNode tmpHead = head;
            // 开始链接下一层
            while(head != null){
                //链接左节点
                if(head.left != null) head.left.next = head.right;
                //链接右节点
                if(head.right != null) head.right.next = head.next != null ? head.next.left : null;
                head = head.next;
            }
            // 跳到下一层第一个节点
            head = tmpHead.left;
        }
    }
}

