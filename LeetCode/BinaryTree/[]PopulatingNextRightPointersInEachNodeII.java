Populating Next Right Pointers in Each Node II
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previoussolution still work?

Note:

You may only use constant extra space. For example, Given thefollowing binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7 
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL
原题链接

递归法
复杂度
时间 O(N) 空间 O(N) 递归栈空间

思路
由于父节点多了next指针，我们不用记录父节点的父节点就能直到它相邻的节点。对于左子节点来说，其next节点就是父节点的右节点。对于右子节点来说i，其next节点就是父节点的next节点的左子节点。以此递归。

代码
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        if(root.left != null) root.left.next = root.right;
        if(root.right != null){
            root.right.next = root.next == null? null:root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
三指针法 Three Pointers
复杂度
时间 O(N) 空间 O(1)

思路
当不是完全二叉树时，左子节点或者右子节点都有可能为空，每个叶子节点的深度也不一定相同，所以退出循环的条件、每层头节点的确定方法以及next指针的赋值都要改变。首先，next指针不再是分左右子节点来直接赋值，而是对记录下来的上个节点的next赋当前操作的节点。其次，退出循环不能再像上一题一样到最后一层就可以退出，因为当前节点会不断更新，只有当前节点为空时才能退出。最后头节点可能是左子节点，也可能是右子节点。

代码
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode p = root;
        TreeLinkNode first = null;
        //上一个节点，我们给上一个节点的next赋值，然后再更新上一个节点为它的next
        TreeLinkNode last = null;
        while(p != null){
            //下一层的头节点有可能是左子节点也有可能是右子节点
            if(first == null){
                if(p.left != null){
                    first = p.left;
                } else if(p.right != null){
                    first = p.right;
                }
            }
            //更新last和last的next
            if(p.left != null){
                if(last != null){
                    last.next = p.left;
                }
                last = p.left;
            }
            if(p.right != null){
                if(last != null){
                    last.next = p.right;
                }
                last = p.right;
            }
            //如果当前节点没有next，则该层结束，转入下一层，否则就继续
            if(p.next != null){
                p = p.next;
            } else {
                p = first;
                first = null;
                last = null;
            }
            
        }
    }
}

层次递进法
复杂度
时间 O(N) 空间 O(1)

思路
第一问层次递进的延伸。上一问中我们不需要一个额外的指针来控制我们一层中链接的节点，因为我们知道肯定是左右左右的顺序，而这题中左右节点可能不存在，所有我们要用一个指针记录这一层中我们链接到了哪个节点，方便我们链接下一个节点。

代码

public class Solution {
    public void connect(TreeLinkNode root) {
        // head是上一层的节点，我们用上一层节点的next形成链表，来链接当前这层
        TreeLinkNode head = root;
        while(head != null){
            // 记录链接到哪个节点的额外指针
            TreeLinkNode curr = new TreeLinkNode(0);
            // tmp指向该层的第一节点
            TreeLinkNode tmp = curr;
            while(head != null){
                // 尝试链接左节点
                if(head.left != null){
                    curr.next = head.left;
                    curr = curr.next;
                }
                // 尝试链接右节点
                if(head.right != null){
                    curr.next = head.right;
                    curr = curr.next;
                }
                head = head.next;
            }
            // 将head移动到当前这层的的第一个，准备链接下一层
            head = tmp.next;
        }
    }
}